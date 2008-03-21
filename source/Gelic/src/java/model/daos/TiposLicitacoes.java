/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class TiposLicitacoes {

    final static String sqlContaTiposLicitacoes =
            "select count(*) from TIPOSLICITACOES";
    final static String sqlRecuperaTiposLicitacoes =
            "select NOME, SIGLA from TIPOSLICITACOES";
    final static String sqlIncluiTipoLicitacao =
            "insert into TIPOSLICITACOES(NOME,SIGLA) values (?,?)";
    final static String sqlAlteraTipoLicitacao =
            "update TIPOSLICITACOES set NOME= ?, SIGLA=? where NOME= ? ";

    public static int alterar(String nomeAnterior, String novoNome, 
            String novaSigla )
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraTipoLicitacao);


        pstmt.setString(1, novoNome);
        pstmt.setString(2, novaSigla);
        
        pstmt.setString(3, nomeAnterior);
        return pstmt.executeUpdate();
    }

    public static int incluir(String nome, String sigla)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlIncluiTipoLicitacao);

        pstmt.setString(1, nome);
        pstmt.setString(2, sigla);

        return pstmt.executeUpdate();
    }

    static private model.beans.TipoLicitacao criaTipoLicitacao(String nome, 
            String sigla) {
        model.beans.TipoLicitacao tipo = new model.beans.TipoLicitacao();
        tipo.setNome(nome);
        tipo.setSigla(sigla);
        return tipo;
    }

    static public ArrayList<model.beans.TipoLicitacao> recuperar()
            throws SQLException, NamingException {
        ArrayList<model.beans.TipoLicitacao> tipos = null;
        PreparedStatement pstmt;
        int quantidadeTipos;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaTiposLicitacoes);
        rs = pstmt.executeQuery();
        if (rs == null) {
            return null;
        }
        if (!rs.next()) {
            return null;
        }
        quantidadeTipos = rs.getInt(1);
        // rs.close(); precisa?
        pstmt.close(); //precisa?

        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperaTiposLicitacoes);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (tipos == null) {
                tipos = new ArrayList<model.beans.TipoLicitacao>(quantidadeTipos);
            }

            tipos.add(criaTipoLicitacao(rs.getString("NOME"), 
                    rs.getString("SIGLA")));
        }
        return tipos;
    }
}

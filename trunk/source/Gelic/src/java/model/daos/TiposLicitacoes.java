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
            String novaSigla)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraTipoLicitacao);


        pstmt.setString(1, novoNome);
        pstmt.setString(2, novaSigla);

        pstmt.setString(3, nomeAnterior);
        int buffer = pstmt.executeUpdate();
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         * Não fecha o connection por causa do transaction.
         */
        pstmt.close();
       
        return buffer;
    }

    public static int incluir(String nome, String sigla)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlIncluiTipoLicitacao);

        pstmt.setString(1, nome);
        pstmt.setString(2, sigla);
        int buffer = pstmt.executeUpdate();
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         * Não fecha o connection por causa do transaction.
         */
        pstmt.close();
        
        return buffer;
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
        int quantidadeTipos = 0;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaTiposLicitacoes);
        rs = pstmt.executeQuery();
        if (rs != null && rs.next()) {
            /*
             * Para aproveitar a conexão no pool é necessário fechar tudo...
             */
            rs.close();
            pstmt.close();
            quantidadeTipos = rs.getInt(1);
        }
        if (quantidadeTipos < 1) {
            /*
             * Para aproveitar a conexão no pool é necessário fechar tudo...
             */
            gelic.close();
            return null;
        }
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
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         */
        rs.close();
        pstmt.close();
        gelic.close();

        return tipos;
    }
}

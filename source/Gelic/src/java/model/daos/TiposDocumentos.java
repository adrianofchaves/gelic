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
public class TiposDocumentos {

    final static String sqlContaTiposDocumentos =
            "select count(*) from TIPOSDOCUMENTOS";
    final static String sqlRecuperaTiposDocumentos =
            "select NOME from TIPOSDOCUMENTOS";
    final static String sqlIncluiTipoDocumento =
            "insert into TIPOSDOCUMENTOS(NOME) values (?)";
    final static String sqlAlteraTipoDocumento =
            "update TIPOSDOCUMENTOS set NOME= ? where NOME= ? ";

    public static int alterar(String nomeAnterior, String novoNome)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlAlteraTipoDocumento);

        pstmt.setString(1, novoNome);
        pstmt.setString(2, nomeAnterior);
        int buffer = pstmt.executeUpdate();
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         * Não fecha o connection por causa do transaction.
         */
        pstmt.close();
        

        return buffer;
    }

    public static int incluir(String nome)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlIncluiTipoDocumento);

        pstmt.setString(1, nome);
        int buffer = pstmt.executeUpdate();
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         * Não fecha o connection por causa do transaction.
         */
        pstmt.close();
        

        return buffer;
    }

    static private model.beans.TipoDocumento criaTipoDocumento(String nome) {
        model.beans.TipoDocumento tipo = new model.beans.TipoDocumento();
        tipo.setNome(nome);
        return tipo;
    }

    static public ArrayList<model.beans.TipoDocumento> recuperar()
            throws SQLException, NamingException {
        ArrayList<model.beans.TipoDocumento> tipos = null;
        PreparedStatement pstmt;
        int quantidadeTipos = 0;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();

        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaTiposDocumentos);
        rs = pstmt.executeQuery();
        if (rs != null && rs.next()) {
            quantidadeTipos = rs.getInt(1);
            /*
             * Para aproveitar a conexão no pool é necessário fechar tudo...
             */
            rs.close();
            pstmt.close();
        }
        if (quantidadeTipos < 1) {
            /*
             * Para aproveitar a conexão no pool é necessário fechar tudo...
             */
            gelic.close();
            return null;
        }
        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperaTiposDocumentos);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            if (tipos == null) {
                tipos = new ArrayList<model.beans.TipoDocumento>(
                        quantidadeTipos);
            }

            tipos.add(criaTipoDocumento(rs.getString("NOME")));
        }
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         */
        rs.close();
        pstmt.close();
        gelic.close();
        return tipos;
    }
    
  public static int excluir(String nome) throws SQLException, NamingException {
    final String sqlExcluiTipoDocumento = "delete from TIPOSDOCUMENTOS where NOME = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluiTipoDocumento);
    pstmt.setString(1, nome);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
}

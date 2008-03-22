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

    public static int alterar(String nomeAnterior, String novoNome )
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlAlteraTipoDocumento);

        pstmt.setString(1, novoNome);
                
        pstmt.setString(2, nomeAnterior);
        return pstmt.executeUpdate();
    }

    public static int incluir(String nome)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(
                sqlIncluiTipoDocumento);

        pstmt.setString(1, nome);
        
        return pstmt.executeUpdate();
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
        int quantidadeTipos;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaTiposDocumentos);
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
        pstmt = gelic.prepareStatement(sqlRecuperaTiposDocumentos);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (tipos == null) {
                tipos = new ArrayList<model.beans.TipoDocumento>(
                        quantidadeTipos);
            }

            tipos.add(criaTipoDocumento(rs.getString("NOME")));
        }
        return tipos;
    }

}

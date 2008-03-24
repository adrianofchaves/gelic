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
public class Sistemas {
    
    final static String sqlIncluiSistema =
            "insert into SISTEMAS(NOME) values (?)";
    final static String sqlAlteraSistema =
            "update SISTEMAS set NOME = ? where NOME = ? ";
    final static String sqlContaModalidades =
            "select count(*) from SISTEMAS";
    final static String sqlRecuperaSistemas =
            "select NOME from SISTEMAS";
    
    static public int incluir(String nome) 
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiSistema);

        pstmt.setString(1, nome);

        return pstmt.executeUpdate();
    }
    
    static public int alterar(String nomeAnterior,  String nome) 
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraSistema);

        pstmt.setString(1, nome);
        pstmt.setString(2, nomeAnterior);

        return pstmt.executeUpdate();
    }
    
    static private model.beans.Sistema criaSistema( String nome ){
        model.beans.Sistema sistema = new model.beans.Sistema();
        
        sistema.setNome(nome);
        
        return sistema;        
    }
    static public ArrayList<model.beans.Sistema> recuperar() 
            throws SQLException, NamingException{
        ArrayList<model.beans.Sistema> sistemas = null;
        PreparedStatement pstmt;
        int quantidadeSistemas;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaModalidades);
        rs = pstmt.executeQuery();
        if (rs == null) {
            return null;
        }
        if (!rs.next()) {
            return null;
        }
        quantidadeSistemas = rs.getInt(1);
        // rs.close(); precisa?
        pstmt.close(); //precisa?

        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperaSistemas);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (sistemas == null) {
                sistemas = new ArrayList<model.beans.Sistema> (
                        quantidadeSistemas);
            }

            sistemas.add(criaSistema(rs.getString("NOME")));
        }
        return sistemas;
    }


}
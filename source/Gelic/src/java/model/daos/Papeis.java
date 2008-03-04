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
 * @author adriano
 */
public class Papeis {

    public static final String sqlRecuperar = "select ID, NOME from PAPEIS";
    public static final String sqlContaPapeis = "select count(*) from PAPEIS";
    
    static private model.beans.Papel criaPapel(int id, String nome){
         model.beans.Papel papel = new model.beans.Papel();
         papel.setId(id);
         papel.setNome(nome);
         return papel;
    }

    static public ArrayList<model.beans.Papel> recuperar() throws NamingException, SQLException {
        PreparedStatement pstmt;
        int quantidadePapeis;
        ArrayList<model.beans.Papel> papeis = null;
        ResultSet rs;
        
        Connection gelic = model.services.Conexao.getPool().getConnection();
        
        /* Conta quantidade de papéis cadastrados */
        pstmt = gelic.prepareStatement(sqlContaPapeis);
        rs = pstmt.executeQuery();
        if (rs == null) {
            return null;
        }
        if (!rs.next()) {
            return null;
        }
        quantidadePapeis = rs.getInt(1);
        // rs.close(); precisa?
        pstmt.close(); //precisa?

        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperar);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (papeis == null) {
                papeis = new ArrayList<model.beans.Papel>(quantidadePapeis);
            }

            papeis.add(criaPapel(
                    rs.getInt("ID"),
                    rs.getString("NOME")));
        }
        return papeis;
    }
}

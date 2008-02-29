/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 * DAO responsável pelo acesso a tabela de usuário.
 * @author adriano
 */
public class Usuarios {
    public static final String sqlRecuperarLogin = 
            "select PAPEL TIPO, LOGIN, SENHA from USUARIOS where LOGIN containing ?";
    

    /**
     * Recupera um usuário do banco de dados. 
     * @param Login login do usuário.  Se for null a função retornará null.
     * @return model.beans.Usuario
     */
    public static model.beans.Usuario recuperar(String login)
            throws NamingException, SQLException {

        Connection gelic = model.services.Conexao.getPool().getConnection();
        PreparedStatement pstmt = gelic.prepareStatement(
                sqlRecuperarLogin);
        pstmt.setString(1, login);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        model.beans.Usuario usuario = new model.beans.Usuario();
        usuario.setLogin(rs.getString("LOGIN"));
        usuario.setSenha(rs.getString("SENHA"));
        usuario.setTipo(rs.getInt("TIPO"));
        return usuario;
    }
}

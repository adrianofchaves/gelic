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
import model.beans.Usuario;

/**
 * DAO responsável pelo acesso a tabela de usuário.
 * @author adriano
 */
public class Usuarios {

    public static final String sqlRecuperarLogin =
            "select PAPEL TIPO, LOGIN, SENHA from USUARIOS where LOGIN containing ?";
    public static final String sqlRecuperarTodos =
            "select PAPEL TIPO, LOGIN, SENHA from USUARIOS";
    public static final String sqlContaUsuarios =
            "select count(*) from USUARIOS";

    public static ArrayList<Usuario> recuperar()
            throws SQLException, NamingException {
        ArrayList<Usuario> usuarios = null;
        PreparedStatement pstmt;
        int quantidadeUsuarios;
        ResultSet rs;
        model.beans.Usuario usuario;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaUsuarios);
        rs = pstmt.executeQuery();
        if (rs == null) {
            return null;
        }
        if (!rs.next()) {
            return null;
        }
        quantidadeUsuarios = rs.getInt(1);
        // rs.close(); precisa?
        pstmt.close(); //precisa?

        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperarTodos);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (usuarios == null) {
                usuarios = new ArrayList<Usuario>();
            }
            usuario = new model.beans.Usuario();
            usuario.setLogin(rs.getString("LOGIN"));            
            usuario.setTipo(rs.getInt("TIPO"));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    /**
     * Recupera um usuário do banco de dados. 
     * @param Login login do usuário.  Se for null a função retornará null.
     * @return model.beans.Usuario
     */
    public static model.beans.Usuario recuperar(String login)
            throws NamingException, SQLException {

        Connection gelic = model.services.Conexao.getPool().getConnection();
        PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarLogin);
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

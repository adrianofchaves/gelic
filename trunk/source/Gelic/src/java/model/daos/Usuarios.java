/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.security.NoSuchAlgorithmException;
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
            "select PAPEL TIPO, LOGIN, SENHA, PAPEIS.NOME NOMEPAPEL " +
            " from USUARIOS " +
            " inner join PAPEIS on USUARIOS.PAPEL = PAPEIS.ID " +
            " where LOGIN containing ?";
    public static final String sqlRecuperarTodos =
            "select PAPEL TIPO, LOGIN, SENHA, PAPEIS.NOME NOMEPAPEL " +
            " from USUARIOS " +
            " inner join PAPEIS on USUARIOS.PAPEL = PAPEIS.ID ";
    public static final String sqlContaUsuarios =
            "select count(*) from USUARIOS";
    public static final String sqlAlteraUsuario =
            "update USUARIOS " +
            " set " +
            "  LOGIN = ?," +
            "  SENHA = ?," +
            "  PAPEL = ?" +
            " where" +
            "  LOGIN = ?";
    public static final String sqlIncluiUsuario = 
            "insert into USUARIOS(LOGIN, SENHA, PAPEL) value (?,?,?)";
    
    
    /**
     * Altera o registro do usuário identificado pelo parâmetro login.
     * 
     * @param login
     * @param novoLogin
     * @param novaSenha
     * @param novoPapel
     * @return número de registros afetados (deve ser 1)
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
    public static int alterar(
             String login, 
             String novoLogin, 
             String novaSenha, 
             int novoPapel) throws SQLException, NamingException, NoSuchAlgorithmException {
        
        Connection gelic = model.services.Conexao.getConnection();
        
        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraUsuario);
        
        pstmt.setString(1, novoLogin);
        pstmt.setString(2, model.beans.Usuario.criptografaSenha(novaSenha));
        pstmt.setInt(3, novoPapel);
        pstmt.setString(4, login);
        
        return pstmt.executeUpdate();
        
        
    }

    public static int incluir(
            String login, 
            String senha, 
            int papel) 
            throws SQLException, NamingException, NoSuchAlgorithmException {
        
        Connection gelic = model.services.Conexao.getConnection();
        
        PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiUsuario);
        
        pstmt.setString(1, login);
        pstmt.setString(2, model.beans.Usuario.criptografaSenha(senha));
        pstmt.setInt(3, papel);
        
        
        return pstmt.executeUpdate();
    }

    /**
     * Instancia beans de usuários
     * 
     * @param tipo - id do papel ou tipo do usuário.
     * @param nomePapel - nome do papel a que o usuário está relacionado.
     * @param login - login do usuário.
     * @param senha - senha do usuário.
     */
    static private model.beans.Usuario criaUsuario(int tipo, String nomePapel,
            String login, String senha) {
        model.beans.Usuario usuario = new model.beans.Usuario();
        usuario.setPapel(new model.beans.Papel());

        usuario.getPapel().setId(tipo);
        usuario.getPapel().setNome(nomePapel);

        usuario.setLogin(login);
        usuario.setTipo(tipo);
        usuario.setSenha(senha);

        return usuario;
    }

    public static ArrayList<Usuario> recuperar()
            throws SQLException, NamingException {
        ArrayList<Usuario> usuarios = null;
        PreparedStatement pstmt;
        int quantidadeUsuarios;
        ResultSet rs;

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
                usuarios = new ArrayList<Usuario>(quantidadeUsuarios);
            }

            usuarios.add(criaUsuario(
                    rs.getInt("TIPO"),
                    rs.getString("NOMEPAPEL"),
                    rs.getString("LOGIN"),
                    rs.getString("SENHA")));
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
        return criaUsuario(
                rs.getInt("TIPO"),
                rs.getString("NOMEPAPEL"),
                rs.getString("LOGIN"),
                rs.getString("SENHA"));
    }
}

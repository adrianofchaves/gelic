package model.services;
// #[regen=yes,id=DCE.4C280404-F5D8-E997-9B56-B559AAEA5A24]
// </editor-fold> 
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Usuario;

public class Usuarios {

  /**
   * Altera o registro do usuário no banco de dados.
   * @param login - login do usuário (antes de alterar).
   * @param loginUsuario - novo login do usuário
   * @param senhaUsuario - nova senha do usuário
   * @param idPapel - novo papel do usuário
   */
  public static void alterar(
          String login,
          String loginUsuario,
          String senhaUsuario,
          int idPapel)
          throws SQLException, NamingException, NoSuchAlgorithmException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Usuarios.alterar(
            login,
            loginUsuario,
            senhaUsuario,
            idPapel) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static int contaAdministradores() 
          throws SQLException, NamingException {
    ArrayList<model.beans.Usuario> usuarios = recuperar();
    int result = 0;
    for( model.beans.Usuario usuario : usuarios ){
      if( usuario.getPapel().getId() == model.beans.Usuario.ADMINISTRADOR){
        result ++;
      }
    }
    return result;
  }

  /**
   * Exclui o usuário com o login informado
   * @param login
   */
  public static void excluir(String login)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Usuarios.excluir(login) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void incluir(
          String loginUsuario,
          String senhaUsuario,
          int idPapel)
          throws NamingException, SQLException, NoSuchAlgorithmException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Usuarios.incluir(
            loginUsuario,
            senhaUsuario,
            idPapel) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  /**
   * Recupera todos os usuários cadastrados no banco.  Cada item terá seu 
   * papel preenchido.
   * 
   * @return lista de usuários
   */
  public static ArrayList<Usuario> recuperar()
          throws SQLException, NamingException {
    return model.daos.Usuarios.recuperar();
  }

  /**
   * Retorna o bean do usuário carregado do banco a partir do login 
   * 
   * @param login
   * @return bean do usuário com seu Papel preenchido.
   */
  public static Usuario recuperar(String login)
          throws NamingException, SQLException {
    return model.daos.Usuarios.recuperar(login);
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.4DD9DF74-6AB7-439C-D378-2D7EB77AEE4E]
  // </editor-fold> 
  public Usuarios() {
  }
}


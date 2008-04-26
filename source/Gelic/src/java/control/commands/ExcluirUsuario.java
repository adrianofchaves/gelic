/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 * Esse comando é executado quando o usuário clica em excluir (lixeira) no 
 * cadastro de usuários.
 * 
 * @author adriano
 */
public class ExcluirUsuario implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      return control.Usuarios.prepararExclusao(req);
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirUsuario.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirUsuario.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

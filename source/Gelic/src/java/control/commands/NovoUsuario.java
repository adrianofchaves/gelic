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
 *
 * @author Adriano
 */
public class NovoUsuario implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      return control.Usuarios.prepararInclusao(req);
    } catch (NamingException ex) {
      Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }

}

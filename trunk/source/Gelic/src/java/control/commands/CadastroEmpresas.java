/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class CadastroEmpresas  implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
          
          return preparaBrowser(req);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroModalidades.class.getName()).log(
                    Level.SEVERE, null, ex);
             throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(CadastroModalidades.class.getName()).log(
                    Level.SEVERE, null, ex);
             throw new ExcecaoComando(ex.getMessage());
        }
    }

  private String preparaBrowser(HttpServletRequest req) 
          throws NamingException, SQLException {
    view.BrowserEmpresas browser = new view.BrowserEmpresas();

    ArrayList<model.beans.Empresa> empresas = 
            model.services.Empresas.recuperar();

    browser.setEmpresas(empresas);
    req.getSession().setAttribute("browserEmpresas", browser);
    return "/browserEmpresas.jsp";
  }
}
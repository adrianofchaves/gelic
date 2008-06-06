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
public class NovaProposta implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.BrowserPropostas browser = (view.BrowserPropostas) req.getSession().
            getAttribute(view.BrowserPropostas.NOME_ATRIBUTO_DEFAULT);
      view.FormProposta form = new view.FormProposta();
      req.getSession().setAttribute(view.FormProposta.NOME_ATRIBUTO_DEFAULT, form);
      form.setOrigem(browser);
      return form.preparaInclusao();
    } catch (NamingException ex) {
      Logger.getLogger(NovaProposta.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage()) ;
    } catch (SQLException ex) {
      Logger.getLogger(NovaProposta.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage()) ;
    }
  }

}

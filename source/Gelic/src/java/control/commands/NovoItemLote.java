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
public class NovoItemLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.BrowserItensLote browser = (view.BrowserItensLote) req.getSession().
            getAttribute(view.BrowserItensLote.NOME_ATRIBUTO_DEFAULT);
      view.FormItemLote form = new view.FormItemLote();
      req.getSession().setAttribute(view.FormItemLote.NOME_ATRIBUTO_DEFAULT, form);
      form.setOrigem(browser);
      return form.preparaInclusao();
    } catch (NamingException ex) {
      Logger.getLogger(
              NovoItemLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(
              NovoItemLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

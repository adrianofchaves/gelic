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
public class ExcluirLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormLote form = new view.FormLote();
      view.BrowserLotes browser = (view.BrowserLotes) req.getSession().
            getAttribute(view.BrowserLotes.NOME_ATRIBUTO_DEFAULT);
      req.getSession().setAttribute(view.FormLote.NOME_ATRIBUTO_DEFAULT, form);
      form.setOrigem(browser);
      String lote = util.Request.getParameter(req, "lote");
      return form.preparaExclusao(lote);
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }

  }
}

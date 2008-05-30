/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import view.ExcecaoForm;

/**
 *
 * @author Adriano
 */
public class CadastroLotes implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormLicitacao form = (view.FormLicitacao) req.getSession().
            getAttribute(view.FormLicitacao.NOME_ATRIBUTO_DEFAULT);
      view.BrowserLotes browser = new view.BrowserLotes();
      req.getSession().setAttribute(view.BrowserLotes.NOME_ATRIBUTO_DEFAULT, browser);
      browser.setOrigem(form);
      return browser.executar();
    } catch (ExcecaoForm ex) {
      Logger.getLogger(
              CadastroLotes.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

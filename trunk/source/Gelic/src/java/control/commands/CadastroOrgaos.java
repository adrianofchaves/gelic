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
 * @author adriano
 */
public class CadastroOrgaos implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.BrowserOrgaos browser = new view.BrowserOrgaos();
      browser.refresh();
      req.getSession().setAttribute(browser.getNomeAtributo(), browser);
      return browser.getNome();
    } catch (ExcecaoForm ex) {
      Logger.getLogger(CadastroOrgaos.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

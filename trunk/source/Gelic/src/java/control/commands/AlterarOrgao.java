/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;
import view.BrowserOrgaos;

/**
 *
 * @author adriano
 */
public class AlterarOrgao implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.FormOrgao form = new view.FormOrgao();
    view.BrowserOrgaos browser = new view.BrowserOrgaos();
    browser = (BrowserOrgaos) req.getSession().getAttribute(
            browser.getNomeAtributo());
    if( browser != null ){
      form.setOrigem(browser);
    }
    req.getSession().setAttribute(form.getNomeAtributo(), form);
    return form.getNome();
  }

}

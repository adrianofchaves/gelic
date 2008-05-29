/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class NovoLote implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.BrowserLotes browser = (view.BrowserLotes) req.getSession().
            getAttribute(view.BrowserLotes.NOME_ATRIBUTO_DEFAULT);
    
    view.FormLote form = new view.FormLote();
    req.getSession().setAttribute(view.FormLote.NOME_ATRIBUTO_DEFAULT, form);
    form.setOrigem(browser);
    return form.preparaInclusao();
  }

}

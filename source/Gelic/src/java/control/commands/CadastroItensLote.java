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
public class CadastroItensLote implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.FormLote form = (view.FormLote) req.getSession().getAttribute(
            view.FormLote.NOME_ATRIBUTO_DEFAULT);
    view.BrowserItensLote browser = new view.BrowserItensLote();
    req.getSession().setAttribute(view.BrowserItensLote.NOME_ATRIBUTO_DEFAULT,
            browser);
    browser.setOrigem(form);    
    return browser.executar();
  }

}

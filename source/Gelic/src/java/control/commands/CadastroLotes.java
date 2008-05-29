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
public class CadastroLotes implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.FormLicitacao form = (view.FormLicitacao) req.getSession().
            getAttribute(view.FormLicitacao.NOME_ATRIBUTO_DEFAULT);
    view.BrowserLotes browser = new view.BrowserLotes();
    req.getSession().setAttribute(view.BrowserLotes.NOME_ATRIBUTO_DEFAULT, 
            browser);
    browser.setOrigem(form);
    return browser.executar();
  }
}

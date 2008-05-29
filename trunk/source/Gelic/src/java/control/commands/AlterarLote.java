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
public class AlterarLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.FormLote form = new view.FormLote();
    view.BrowserLotes browser = (view.BrowserLotes) req.getSession().
            getAttribute(view.BrowserLotes.NOME_ATRIBUTO_DEFAULT);
    req.getSession().setAttribute(view.FormLote.NOME_ATRIBUTO_DEFAULT, form);
    form.setOrigem(browser);
    String lote = util.Request.getParameter(req, "lote");
    return form.preparaAlteracao(lote);
    
    
  }
}

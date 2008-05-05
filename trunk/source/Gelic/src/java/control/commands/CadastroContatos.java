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
public class CadastroContatos implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    final String comandoEmpresa = "empresa";
    final String comandoOrgao = "orgao";
    final String chaveBrowser = "browserContatos";
    final String uriBrowserContatos = "/" + chaveBrowser + ".jsp";

    String comando;
    /*
     * Contatos de uma empresa
     */
    comando = util.Request.getParameter(req, comandoEmpresa);
    if (comando != null && !comando.isEmpty()) {
      view.FormEmpresa frm = (view.FormEmpresa) 
              req.getSession().getAttribute("formEmpresa");

      view.BrowserContatos browser = new view.BrowserContatos();
      browser.setOrigem(frm);
      browser.setTitulo("Contatos da empresa \"" +
              frm.getEmpresa().getNomeFantasia() + "\"");
      browser.setContatos(frm.getEmpresa().getContatos());
      browser.setOrigem(frm);
      browser.setNome(uriBrowserContatos);

      req.getSession().setAttribute(chaveBrowser, browser);

      return uriBrowserContatos;
    }
    /*
     * Contatos de um órgão público
     */
    comando = util.Request.getParameter(req, comandoOrgao);
    if (comando != null && !comando.isEmpty()) {
      view.FormOrgao frm = new view.FormOrgao();
      frm = (view.FormOrgao) 
              req.getSession().getAttribute(frm.getNomeAtributo());

      view.BrowserContatos browser = new view.BrowserContatos();
      browser.setOrigem(frm);
      browser.setTitulo("Contatos do órgão \"" +
              frm.getOrgao().getApelido() + "\"");
      browser.setContatos(frm.getOrgao().getContatos());
      browser.setOrigem(frm);
      browser.setNome(uriBrowserContatos);

      req.getSession().setAttribute(chaveBrowser, browser);

      return uriBrowserContatos;
    }
    return uriBrowserContatos;
  }
}

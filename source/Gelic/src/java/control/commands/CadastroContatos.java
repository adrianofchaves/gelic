/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;
import view.FormEmpresa;

/**
 *
 * @author Adriano
 */
public class CadastroContatos implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    final String comandoEmpresa = "empresa";    
    final String chaveBrowser = "browserContatos";
    final String uriBrowserContatos = "/" + chaveBrowser + ".jsp";
    final String formEmpresa = "formEmpresa.jsp";
    String comando;
    comando = util.Request.getParameter(req, comandoEmpresa );
    if( comando != null && !comando.isEmpty()){
      /*
       * Contatos da Emrpesa
       */
      view.FormEmpresa frm = (FormEmpresa) 
              req.getSession().getAttribute("formEmpresa");
      
      view.BrowserContatos browser = new view.BrowserContatos();
      
      browser.setTitulo("Contatos da empresa \"" + 
              frm.getEmpresa().getNomeFantasia() + "\"");
      browser.setContatos(frm.getEmpresa().getContatos());
      browser.setOrigem(formEmpresa);
      
      req.getSession().setAttribute(chaveBrowser, browser);
      
      return uriBrowserContatos;      
    }
    return uriBrowserContatos;      
  }

}

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
public class NovoContato implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
      view.BrowserContatos browser = (view.BrowserContatos) 
              req.getSession().getAttribute("browserContatos");
      
      view.FormContato form = new view.FormContato();
      form.setOrigem(browser);
      form.setNome("formContato.jsp");
      form.setExclusao(false);
      form.setInclusao(true);
      form.setAlteracao(false);
      form.atualizaCampos();
      form.setTitulo("Novo contato");      
      req.getSession().setAttribute("formContato", form);
      
      return form.getNome();              
  }

}

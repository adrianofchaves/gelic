/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class ExcluirContato implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      int idContato = new Integer(req.getParameter("id")).intValue();
      view.BrowserContatos browser = (view.BrowserContatos) 
              req.getSession().getAttribute("browserContatos");

      view.FormContato form = new view.FormContato();
      form.setOrigem(browser);
      form.setNome("formContato.jsp");
      form.setContato(model.services.Contatos.recuperar(idContato));
      form.setExclusao(true);
      form.setInclusao(false);
      form.setAlteracao(false);
      form.atualizaCampos();
      form.setTitulo("Excluindo contato");
      req.getSession().setAttribute("formContato", form);
      return form.getNome();
      
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirContato.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirContato.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }

  }
}

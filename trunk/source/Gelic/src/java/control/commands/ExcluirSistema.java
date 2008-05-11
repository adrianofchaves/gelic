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
 * @author Paulo
 */
public class ExcluirSistema implements Comando {
    
          public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      String nome = util.Request.getParameter(req, "nome");
      if (nome == null) {
        throw new ExcecaoComando("Nome inválido (nulo)");
      }
      model.beans.Sistema sistema = model.services.Sistemas.recuperar(nome);
      view.FormSistema frm = new view.FormSistema();
      frm.setSistema(sistema);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setExclusao(true);
      frm.setTitulo("Excluindo sistema");
      req.getSession().setAttribute("formSistema", frm);
      return "/formSistema.jsp";
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirSistema.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirSistema.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }
}
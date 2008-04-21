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
public class ExcluirTipoDocumento implements Comando {
    
          public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      String nome = util.Request.getParameter(req, "nome");
      if (nome == null) {
        throw new ExcecaoComando("Nome inválido (nulo)");
      }
      model.beans.TipoDocumento tipoDocumento = model.services.TiposDocumentos.recuperar(nome);
      view.FormTipoDocumento frm = new view.FormTipoDocumento();
      frm.setTipoDocumento(tipoDocumento);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setExclusao(true);
      frm.setTitulo("Excluindo tipo de documento");
      req.getSession().setAttribute("formTipoDocumento", frm);
      return "/formTipoDocumento.jsp";
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirTipoDocumento.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirTipoDocumento.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }
}

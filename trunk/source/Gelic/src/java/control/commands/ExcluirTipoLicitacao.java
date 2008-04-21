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
public class ExcluirTipoLicitacao implements Comando {
    
      public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      String sigla = util.Request.getParameter(req, "sigla");
      if (sigla == null) {
        throw new ExcecaoComando("Sigla inválido (nulo)");
      }
      model.beans.TipoLicitacao tipolicitacao = model.services.TiposLicitacoes.recuperar(sigla);
      view.FormTipoLicitacao frm = new view.FormTipoLicitacao();
      frm.setTipoLicitacao(tipolicitacao);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setExclusao(true);
      frm.setTitulo("Excluindo tipo de licitacao");
      req.getSession().setAttribute("formTipoLicitacao", frm);
      return "/formTipoLicitacao.jsp";
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirTipoLicitacao.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirTipoLicitacao.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }
}

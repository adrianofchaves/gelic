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
public class GravarSistema implements Comando {

  static final String chaveForm = "formSistema";
  static final String chaveBrowser = "browserSistemas";
  static final String uriForm = "/formSistema.jsp";
  static final String uriBrowser = "/browserSistemas.jsp";
  static final String msgInclusao = "Novo sistema cadastrado.";
  static final String msgExclusao = "Sistema excluído.";
  static final String msgAlteracao = "Sistema alterado.";

  private String executaCancelar(HttpServletRequest req)
          throws SQLException, NamingException {
    return control.Sistemas.preparaBrowser(req);
  }

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      /* Botão cancelar foi acionado */
      if (req.getParameter("cancelar") != null) {
        return executaCancelar(req);
      }
      /* "popula form */

      view.FormSistema frm = (view.FormSistema) req.getSession().
              getAttribute(chaveForm);
      if (!frm.isExclusao()) {
        frm.setNomeSistema(util.Request.getParameter(req, "nomeSistema"));
      }
      /* Executa críticas */
      frm.valida();
      /* Se tem erros sai */
      if (frm.temErros()) {
        return uriForm;
      }
      /* Grava e volta para o browser atualizado */
      //view.BrowserSistemas browser = new view.BrowserSistemas();
      String mensagem = null;
      if (frm.getInclusao()) {
        model.services.Sistemas.incluir(frm.getNomeSistema());
        mensagem = msgInclusao;
      }

      if (frm.isAlteracao()) {
        model.services.Sistemas.alterar(
                frm.getSistema().getNome(),
                frm.getNomeSistema());
        mensagem = msgAlteracao;
      }

      if (frm.isExclusao()) {
        model.services.Sistemas.excluir(frm.getSistema().getNome());
        mensagem = msgExclusao;
      }
      return executaBrowser(req, mensagem);

    } catch (SQLException ex) {
      Logger.getLogger(GravarModalidade.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(GravarModalidade.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }

  }

  private String executaBrowser(HttpServletRequest req, String mensagem)
          throws NamingException, SQLException {
    view.BrowserSistemas browser = new view.BrowserSistemas(
            model.services.Sistemas.recuperar());
    browser.setMensagem(mensagem);
    req.getSession().setAttribute(chaveBrowser, browser);
    return uriBrowser;
  }
}

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
import view.FormEmpresa;

/**
 *
 * @author adriano
 */
public class GravarEmpresa implements Comando {

  static final String chaveForm = "formEmpresa";
  static final String uriForm = "/formEmpresa.jsp";
  static final String uriBrowser = "/browserEmpresas.jsp";
  static final String msgInclusao = "Nova empresa cadastrada.";
  static final String msgExclusao = "Empresa excluída.";
  static final String msgAlteracao = "Empresa alterada.";
  
  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormEmpresa frm = (FormEmpresa) req.getSession().getAttribute(
              chaveForm);
      if (frm == null) {
        frm = new view.FormEmpresa();
      }

      populaForm(frm, req);

      frm.valida();

      if (frm.getErros().size() > 0) {
        return uriForm;
      }
      String mensagem = null;
      if (frm.isInclusao()) {
        incluiEmpresa(frm);
        mensagem = msgInclusao;
      }
      if (frm.isExclusao()) {
        model.services.Empresas.excluir(frm.getEmpresa().getCnpj());
        mensagem = msgExclusao;
      }
      if (frm.isAlteracao()) {
        alteraEmpresa(frm);
        mensagem = msgAlteracao;
      }
      view.BrowserEmpresas browser = new view.BrowserEmpresas(
              model.services.Empresas.recuperar());
      browser.setMensagem(mensagem);
      return uriBrowser;
    } catch (NamingException ex) {
      Logger.getLogger(GravarEmpresa.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(GravarEmpresa.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

  private void alteraEmpresa(FormEmpresa frm) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void incluiEmpresa(FormEmpresa frm) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void populaForm(FormEmpresa frm, HttpServletRequest req) {
    
    throw
     new UnsupportedOperationException("Not yet implemented");
  }
}

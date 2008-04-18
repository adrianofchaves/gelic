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
import view.BrowserContatos;
import view.FormContato;

/**
 *
 * @author Adriano
 */
public class GravarContato implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormContato form = (view.FormContato)
              req.getSession().getAttribute("formContato");
      if (req.getParameter("cancelar") != null) {
        return form.getOrigem().getNome();
      }
      processa(req, form);
      if (form.temErros()) {
        return form.getNome();
      }
      return form.getOrigem().getNome();
    } catch (NamingException ex) {
      Logger.getLogger(GravarContato.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(GravarContato.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }

  private void processa(HttpServletRequest req, FormContato form) 
          throws NamingException, SQLException {
    /* popula form */
    form.setNomeContato(util.Request.getParameter(req, "nomeContato"));
    form.setDdiContato(util.Request.getParameter(req, "ddiContato"));
    form.setDddContato(util.Request.getParameter(req, "dddContato"));
    form.setNumeroTelefoneContato(util.Request.getParameter(req, 
            "numeroTelefoneContato"));
    form.setRamalContato(util.Request.getParameter(req, "ramalContato"));

    form.valida();
    final String msgInclusao = "Contato incluído";
    final String msgExclusao = "Contato excluído";
    final String msgAlteracao = "Contato alterado";

    String mensagem = null;
    if (form.isInclusao()) {
      /* Quando for a inclusão de um novo contato é necessário saber qual sua
       * origem */
      if (form.getOrigem().getOrigem() instanceof view.FormEmpresa) {
        /* Cadastro de contatos de uma empresa */
        view.FormEmpresa formEmpresa = (view.FormEmpresa) 
                form.getOrigem().getOrigem();
        model.beans.Empresa empresa = formEmpresa.getEmpresa();
        model.services.Contatos.incluir(empresa, form.getNomeContato(), 
                form.getDdiContato(), form.getDddContato(), 
                form.getNumeroTelefoneContato(), form.getRamalContato());
      }
      mensagem = msgInclusao;
    }
    if (form.isExclusao()) {
      model.services.Contatos.excluir(form.getContato().getId());
      mensagem = msgExclusao;
    }
    if (form.isAlteracao()) {
      model.services.Contatos.alterar(form.getContato(), form.getNomeContato(), 
              form.getDdiContato(), form.getDddContato(), 
              form.getNumeroTelefoneContato(), form.getRamalContato());
      mensagem = msgAlteracao;
    }
    
            
    form.getOrigem().setMensagem(mensagem);
  }
}

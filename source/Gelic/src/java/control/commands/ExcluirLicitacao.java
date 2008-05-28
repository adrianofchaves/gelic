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
public class ExcluirLicitacao implements Comando{

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.BrowserLicitacoes browser = (view.BrowserLicitacoes) req.getSession().getAttribute("browserLicitacoes");
      String licitacao = util.Request.getParameter(req, "licitacao");
      view.FormLicitacao form = new view.FormLicitacao();
      form.setOrigem(browser);
      req.getSession().setAttribute(view.FormLicitacao.NOME_ATRIBUTO_DEFAULT, form);
      form.preparaExclusao(licitacao);
      form.setTitulo("Excluindo licitação");
      return form.getNome();
    } catch (SQLException ex) {
      Logger.getLogger(
              ExcluirLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(
              ExcluirLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

}

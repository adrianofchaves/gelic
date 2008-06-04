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
 * @author adriano
 */
public class CadastroPropostas implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormLote form = (view.FormLote) req.getSession().getAttribute(
              view.FormLote.NOME_ATRIBUTO_DEFAULT);
      view.BrowserPropostas browser = new view.BrowserPropostas();
      req.getSession().setAttribute(view.BrowserPropostas.NOME_ATRIBUTO_DEFAULT, browser);
      browser.setOrigem(form);
      return browser.executar();
    } catch (NamingException ex) {
      Logger.getLogger(CadastroPropostas.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(CadastroPropostas.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

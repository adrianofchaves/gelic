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
public class ExcluirOrgao implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      final String nomeParametro = "cnpj";

      view.FormOrgao form = new view.FormOrgao();
      req.getSession().setAttribute(form.getNomeAtributo(), form);
      // Preenche origem
      view.BrowserOrgaos browser = new view.BrowserOrgaos();
      browser = (view.BrowserOrgaos) req.getSession().getAttribute(
              browser.getNomeAtributo());
      if (browser != null) {
        form.setOrigem(browser);
      }
      //preenche listas
      form.setEstados(control.UFs.getUFs(req));
      form.setTiposLogradouros(control.Enderecos.getTiposLogradouros(req));
      //executa form
      String cnpj = util.Request.getParameter(req, nomeParametro);
      form.excluir(cnpj);

      return form.getNome();
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirOrgao.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirOrgao.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }

  }
}

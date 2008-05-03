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
import view.ExcecaoForm;

/**
 *
 * @author Adriano
 */
public class GravarOrgao implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {

      view.FormOrgao form = (view.FormOrgao) req.getSession().getAttribute(
              new view.FormOrgao().getNomeAtributo());
      if (req.getParameter("cancelar") != null) {
        form.cancelar();
        return form.getOrigem().getNome();
      }
      // Popula o form
      form.setRazaoSocialOrgao(
              util.Forms.recuperaParametro(req, "razaoSocialOrgao"));
      form.setCnpjOrgao(util.Forms.recuperaParametro(req, "cnpjOrgao"));
      form.setIeOrgao(util.Forms.recuperaParametro(req, "ieOrgao"));
      form.setApelidoOrgao(util.Forms.recuperaParametro(req, "apelidoOrgao"));
      form.setTipoLogradouroOrgao(
              util.Forms.recuperaParametro(req, "tipoLogradouroOrgao"));
      form.setLogradouroOrgao(
              util.Forms.recuperaParametro(req, "logradouroOrgao"));
      form.setNumeroOrgao(util.Forms.recuperaParametro(req, "numeroOrgao"));
      form.setComplementoOrgao(
              util.Forms.recuperaParametro(req, "complementoOrgao"));
      form.setBairroOrgao(util.Forms.recuperaParametro(req, "bairroOrgao"));
      form.setCidadeOrgao(util.Forms.recuperaParametro(req, "cidadeOrgao"));
      form.setEstadoOrgao(util.Forms.recuperaParametro(req, "estadoOrgao"));
      form.setCepOrgao(util.Forms.recuperaParametro(req, "cepOrgao"));
      form.setSiteOrgao(util.Forms.recuperaParametro(req, "siteOrgao"));
      form.setEmailOrgao(util.Forms.recuperaParametro(req, "emailOrgao"));
      form.setDdiOrgao(util.Forms.recuperaParametro(req, "ddiOrgao"));
      form.setDddOrgao(util.Forms.recuperaParametro(req, "dddOrgao"));
      form.setNumeroTelefoneOrgao(
              util.Forms.recuperaParametro(req, "numeroTelefoneOrgao"));
      form.setRamalOrgao(util.Forms.recuperaParametro(req, "ramalOrgao"));
      // executa gravação
      return form.gravar();
    } catch (ExcecaoForm ex) {
      Logger.getLogger(GravarOrgao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(GravarOrgao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(GravarOrgao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }

  }
}

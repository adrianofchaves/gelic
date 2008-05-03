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
public class GravarEmpresa implements Comando {

  static final String chaveForm = "formEmpresa";
  static final String chaveBrowser = "browserEmpresas";
  static final String uriForm = "/formEmpresa.jsp";
  static final String uriBrowser = "/browserEmpresas.jsp";
  static final String msgInclusao = "Nova empresa cadastrada.";
  static final String msgExclusao = "Empresa excluída.";
  static final String msgAlteracao = "Empresa alterada.";

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      if( req.getParameter("cancelar") != null ){
        return executaBrowser(req, null);
      }
      view.FormEmpresa frm = (view.FormEmpresa) req.getSession().getAttribute(
              chaveForm);
      if (frm == null) {
        frm = new view.FormEmpresa();
      }

      populaForm(frm, req);

      frm.valida();

      if (frm.temErros()) {
        return uriForm;
      }
      String mensagem = null;
      if (frm.isInclusao()) {
        model.services.Empresas.incluir( frm.getNomeFantasiaEmpresa(), 
                frm.isEPortadorEmpresa(),
                frm.getRazaoSocialEmpresa(), frm.isEFornecedorEmpresa(),
                frm.getCnpjEmpresa(), frm.getIeEmpresa(), frm.getImEmpresa(),
                frm.getTipoLogradouroEmpresa(), frm.getLogradouroEmpresa(),
                frm.getNumeroEmpresa(), frm.getComplementoEmpresa(),
                frm.getBairroEmpresa(), frm.getCidadeEmpresa(),
                frm.getEstadoEmpresa(), frm.getCepEmpresa(), 
                frm.getSiteEmpresa(), frm.getEmailEmpresa(), 
                frm.getDdiEmpresa(), frm.getDddEmpresa(),
                frm.getNumeroTelefoneEmpresa(), frm.getRamalEmpresa()
                );
        mensagem = msgInclusao;
      }
      if (frm.isExclusao()) {
        model.services.Empresas.excluir(frm.getEmpresa().getCnpj());
        mensagem = msgExclusao;
      }
      if (frm.isAlteracao()) {
        model.services.Empresas.alterar(frm.getEmpresa(),
                frm.getNomeFantasiaEmpresa(), frm.isEPortadorEmpresa(),
                frm.getRazaoSocialEmpresa(), frm.isEFornecedorEmpresa(),
                frm.getCnpjEmpresa(), frm.getIeEmpresa(), frm.getImEmpresa(),
                frm.getTipoLogradouroEmpresa(), frm.getLogradouroEmpresa(),
                frm.getNumeroEmpresa(), frm.getComplementoEmpresa(),
                frm.getBairroEmpresa(), frm.getCidadeEmpresa(),
                frm.getEstadoEmpresa(), frm.getCepEmpresa(), 
                frm.getSiteEmpresa(), frm.getEmailEmpresa(), 
                frm.getDdiEmpresa(), frm.getDddEmpresa(),
                frm.getNumeroTelefoneEmpresa(), frm.getRamalEmpresa());
        mensagem = msgAlteracao;
      }
      
      return executaBrowser(req, mensagem);
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

  private String executaBrowser(HttpServletRequest req, String mensagem) 
          throws NamingException, SQLException {
    view.BrowserEmpresas browser = new view.BrowserEmpresas(
            model.services.Empresas.recuperar());
    browser.setMensagem(mensagem);
    req.getSession().setAttribute(chaveBrowser, browser);
    return uriBrowser;
  }

   private void populaForm(view.FormEmpresa frm, HttpServletRequest req) {

    frm.setNomeFantasiaEmpresa(
            util.Request.getParameter(req, "nomeFantasiaEmpresa"));
    if (req.getParameter("ePortadorEmpresa") != null) {
      frm.setEPortadorEmpresa(true);
    }


    frm.setRazaoSocialEmpresa(
            util.Request.getParameter(req, "razaoSocialEmpresa"));

    if (req.getParameter("eFornecedorEmpresa") != null) {
      frm.setEFornecedorEmpresa(true);
    }

    frm.setCnpjEmpresa(util.Request.getParameter(req, "cnpjEmpresa"));

    frm.setIeEmpresa(util.Request.getParameter(req, "ieEmpresa"));

    frm.setImEmpresa(util.Request.getParameter(req, "imEmpresa"));

    frm.setTipoLogradouroEmpresa(
            util.Request.getParameter(req, "tipoLogradouroEmpresa"));

    frm.setLogradouroEmpresa(
            util.Request.getParameter(req, "logradouroEmpresa"));

    frm.setNumeroEmpresa(util.Request.getParameter(req, "numeroEmpresa"));

    frm.setComplementoEmpresa(
            util.Request.getParameter(req, "complementoEmpresa"));

    frm.setBairroEmpresa(util.Request.getParameter(req, "bairroEmpresa"));

    frm.setCidadeEmpresa(util.Request.getParameter(req, "cidadeEmpresa"));

    frm.setEstadoEmpresa(util.Request.getParameter(req, "estadoEmpresa"));

    frm.setCepEmpresa(util.Request.getParameter(req, "cepEmpresa"));

    frm.setSiteEmpresa(util.Request.getParameter(req, "siteEmpresa"));

    frm.setEmailEmpresa(util.Request.getParameter(req, "emailEmpresa"));

    frm.setDdiEmpresa(util.Request.getParameter(req, "ddiEmpresa"));

    frm.setDddEmpresa(util.Request.getParameter(req, "dddEmpresa"));

    frm.setNumeroTelefoneEmpresa(
            util.Request.getParameter(req, "numeroTelefoneEmpresa"));

    frm.setRamalEmpresa(util.Request.getParameter(req, "ramalEmpresa"));
  }
}

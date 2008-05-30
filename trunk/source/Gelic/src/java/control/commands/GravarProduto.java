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
public class GravarProduto implements Comando {

  static final String chaveForm = "formProduto";
  static final String chaveBrowser = "browserProdutos";
  static final String uriForm = "/formProduto.jsp";
  static final String uriBrowser = "/browserProdutos.jsp";
  static final String msgInclusao = "Novo produto cadastrado.";
  static final String msgExclusao = "Produto excluído.";
  static final String msgAlteracao = "Produto alterado.";

  public String executar(HttpServletRequest req) throws ExcecaoComando {

    try {
      if (req.getParameter("cancelar") != null) {
        return control.Produto.preparaBrowser(req);
      }

      view.FormProduto frm = (view.FormProduto) req.getSession().
              getAttribute(chaveForm);

      if (frm == null) {
        frm = new view.FormProduto();
      }

      /* popula form */
      frm.setCodigoProduto(util.Request.getParameter(req,
              "codigoProduto"));
      frm.setDescricaoProduto(util.Request.getParameter(req,
              "descricaoProduto"));
      try{
      frm.setPrecovendaProduto(Float.parseFloat(
              util.Request.getParameter(req, "precovendaProduto")));
      }catch(NullPointerException ex){
        frm.setPrecovendaProduto(0);
      }catch(NumberFormatException ex){
        frm.setPrecovendaProduto(0);
      }
      try{
      frm.setPrecocompraProduto(Float.parseFloat(
              util.Request.getParameter(req, "precocompraProduto")));
      }catch(NullPointerException ex){
        frm.setPrecovendaProduto(0);
      }catch(NumberFormatException ex){
        frm.setPrecocompraProduto(0);
      }
      
      frm.valida();

      if (frm.temErros()) {
        return uriForm;
      }

      String mensagem = null;

      if (frm.isInclusao()) {
        model.services.Produtos.incluir(
                frm.getCodigoProduto(),
                frm.getDescricaoProduto(),
                frm.getPrecovendaProduto(),
                frm.getPrecocompraProduto());
        mensagem = msgInclusao;
      }

      if (frm.isAlteracao()) {
        model.services.Produtos.alterar(
                frm.getProduto().getCodigo(),
                frm.getCodigoProduto(),
                frm.getDescricaoProduto(),
                frm.getPrecovendaProduto(),
                frm.getPrecocompraProduto());
        mensagem = msgAlteracao;
      }

      if (frm.isExclusao()) {
        model.services.Produtos.excluir(frm.getProduto().getId());
        mensagem = msgExclusao;
      }

      return executaBrowser(req, mensagem);
    } catch (NamingException ex) {
      Logger.getLogger(GravarProduto.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(GravarProduto.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

  private String executaBrowser(HttpServletRequest req, String mensagem)
          throws NamingException, SQLException {
    view.BrowserProdutos browser = new view.BrowserProdutos(model.services.Produtos.recuperar());
    browser.setMensagem(mensagem);
    req.getSession().setAttribute(chaveBrowser, browser);
    return uriBrowser;
  }
}

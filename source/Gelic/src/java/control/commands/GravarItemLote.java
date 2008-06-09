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
import view.FormItemLote;

/**
 *
 * @author Adriano
 */
public class GravarItemLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormItemLote form = (view.FormItemLote) req.getSession().getAttribute(
            view.FormItemLote.NOME_ATRIBUTO_DEFAULT);
      if (req.getParameter("cancelar") != null) {
        return form.cancelar();
      }
      form.apagaErros();
      populaForm(form, req);
      return form.gravar();
    } catch (ExcecaoForm ex) {
      Logger.getLogger(
              GravarItemLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(
              GravarItemLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(
              GravarItemLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

  private void populaForm(FormItemLote form, HttpServletRequest req) {
    String buffer = util.Request.getParameter(req, "numeroItemLote");
    try {
      if (buffer != null) {
        form.setNumeroItemLote(Integer.parseInt(buffer));
      }
    } catch (NumberFormatException ex) {
      form.addErro("Campo número inválido!");
      form.setErroNumeroItemLote("Valor numérico(inteiro) inválido.");
    }
    
    buffer = util.Request.getParameter(req, "produtoItemLote");    
    form.setProdutoItemLote(buffer);

    buffer = util.Request.getParameter(req, "quantidadeItemLote");
    try {
      if (buffer != null) {
        form.setQuantidadeItemLote(Float.parseFloat(buffer));
      }
    } catch (NumberFormatException ex) {
      form.addErro("Campo quantidade inválido!");
      form.setErroNumeroItemLote("Valor numérico(ponto flutuante) inválido.");
    }
    
    buffer = util.Request.getParameter(req, "precoEstimadoItemLote");
    try {
      if (buffer != null) {
        form.setPrecoEstimadoItemLote(Float.parseFloat(buffer));
      }
    } catch (NumberFormatException ex) {
      form.addErro("Campo preço estimado inválido!");
      form.setErroNumeroItemLote("Valor numérico(ponto flutuante) inválido.");
    }

  }
}

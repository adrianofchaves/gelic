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
public class GravarProposta implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormProposta form = (view.FormProposta) req.getSession().
            getAttribute(view.FormProposta.NOME_ATRIBUTO_DEFAULT);
      if (req.getParameter("cancelar") != null) {
        return form.getOrigem().getNome();
      }
      populaForm(req, form);
      return form.gravar();
    } catch (SQLException ex) {
      Logger.getLogger(GravarProposta.class.getName()).
              log(Level.SEVERE, null, ex);
       throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(GravarProposta.class.getName()).
              log(Level.SEVERE, null, ex);
       throw new ExcecaoComando(ex.getMessage());
    } catch (view.ExcecaoForm ex) {
      Logger.getLogger(GravarProposta.class.getName()).
              log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

  private void populaForm(HttpServletRequest req, view.FormProposta form) {    
    form.setEmpresaProposta(util.Request.getParameter(req, "empresaProposta"));
    for (view.ItemFormProposta item : form.getItens()) {
      String buffer = util.Request.getParameter(req, item.getNome());
      try {
        if (buffer != null) {
          item.setValor(Float.parseFloat(buffer));
        }
      } catch (NumberFormatException ex) {
        form.addErro("O preço do item " + 
                Integer.toString(item.getItemLote().getNumero()) + 
                " está inválido!");
        item.setErro("Valor numérico(ponto flutuante) inválido.");
      }
    }
  }
}

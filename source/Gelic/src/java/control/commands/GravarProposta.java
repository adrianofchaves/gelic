/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import javax.servlet.http.HttpServletRequest;
import view.FormProposta;

/**
 *
 * @author Adriano
 */
public class GravarProposta implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    view.FormProposta form = (view.FormProposta) req.getSession().
            getAttribute(view.FormProposta.NOME_ATRIBUTO_DEFAULT);
    if (req.getParameter("cancelar") != null) {
      return form.getOrigem().getNome();
    }
    populaForm(req, form);
    return form.gravar();
  }

  private void populaForm(HttpServletRequest req, FormProposta form) {    
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

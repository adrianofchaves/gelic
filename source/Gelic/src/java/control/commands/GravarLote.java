/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class GravarLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {

    view.FormLote form = (view.FormLote) req.getSession().getAttribute(
            view.FormLote.NOME_ATRIBUTO_DEFAULT);
    if (req.getParameter("cancelar") != null) {
      return form.cancelar();
    }
    populaForm(form,req);
    return form.gravar();    
  }

  private void populaForm(view.FormLote form, HttpServletRequest req) {
    /* popular campos */
    form.apagaErros();
    

    String buffer = util.Request.getParameter(req, "numeroLote");
    try {
      if (buffer != null) {
        form.setNumeroLote(Integer.parseInt(buffer));
      }
    } catch (NumberFormatException ex) {
      form.addErro("Campo número inválido!");
      form.setErroNumeroLote("Valor numérico(inteiro) inválido.");
    }

  }
}

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
public class GravarLote implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {

      view.FormLote form = (view.FormLote) req.getSession().getAttribute(
            view.FormLote.NOME_ATRIBUTO_DEFAULT);
      if (req.getParameter("cancelar") != null) {
        return form.cancelar();
      }
      populaForm(form, req);
      return form.gravar();
    } catch (NamingException ex) {
      Logger.getLogger(GravarLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(GravarLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (ExcecaoForm ex) {
      Logger.getLogger(GravarLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
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
    
    form.setNomeLote(util.Forms.recuperaParametro(req, "nomeLote"));

  }
}

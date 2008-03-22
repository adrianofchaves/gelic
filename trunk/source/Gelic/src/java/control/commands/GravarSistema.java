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
public class GravarSistema implements Comando {
    private String executaCancelar(HttpServletRequest req)
            throws SQLException, NamingException {
        return control.Sistemas.preparaBrowser(req);
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            /* Botão cancelar foi acionado */
            if (req.getParameter("cancelar") != null) {
                return executaCancelar(req);
            }
            /* "popula form */
            view.FormSistema frm = (view.FormSistema) req.getSession().
                    getAttribute("formSistema");
            frm.setNomeSistema(req.getParameter("nomeSistema"));
            
            /* Executa críticas */
            frm.valida();
            /* Se tem erros sai */
            if( frm.temErros()){
                return "/formSistema.jsp";
            }
            /* Grava e volta para o browser atualizado */
            view.BrowserSistemas browser = new view.BrowserSistemas();
            if (frm.getInclusao()) {
                model.services.Sistemas.incluir(frm.getNomeSistema());
                browser.setMensagem("Sistema incluído com sucesso");
            } else {
                model.services.Sistemas.alterar(
                        frm.getSistema().getNome(),
                        frm.getNomeSistema());
                browser.setMensagem("Sistema alterado com sucesso");
            }
            return control.Sistemas.preparaBrowser(req);            
        } catch (SQLException ex) {
            Logger.getLogger(GravarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(GravarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }

    }

}

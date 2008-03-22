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
import view.FormModalidade;

/**
 *
 * @author Adriano
 */
public class GravarModalidade implements Comando {

    private String executaCancelar(HttpServletRequest req)
            throws SQLException, NamingException {
        return control.Modalidades.preparaBrowser(req);
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            /* Botão cancelar foi acionado */
            if (req.getParameter("cancelar") != null) {
                return executaCancelar(req);
            }
            /* "popula form */
            view.FormModalidade frm = (FormModalidade) req.getSession().
                    getAttribute("formModalidade");
            frm.setNomeModalidade(util.Request.getParameter(req,
                    "nomeModalidade"));
            frm.setSiglaModalidade(util.Request.getParameter(req,
                    "siglaModalidade"));
            /* Executa críticas */
            frm.valida();
            /* Se tem erros sai */
            if( frm.temErros()){
                return "/formModalidade.jsp";
            }
            /* Grava e volta para o browser atualizado */
            view.BrowserModalidades browser = new view.BrowserModalidades();
            if (frm.getInclusao()) {
                model.services.Modalidades.incluir(frm.getSiglaModalidade(),
                        frm.getNomeModalidade());
                browser.setMensagem("Modalidade incluída com sucesso");
            } else {
                model.services.Modalidades.alterar(
                        frm.getModalidade().getSigla(),
                        frm.getSiglaModalidade(),
                        frm.getNomeModalidade());
                browser.setMensagem("Modalidade alterada com sucesso");
            }
            return control.Modalidades.preparaBrowser(req);            
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

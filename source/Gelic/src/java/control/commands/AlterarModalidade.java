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
public class AlterarModalidade implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            String sigla = util.Request.getParameter(req,"sigla");
            if (sigla == null) {
                throw new ExcecaoComando("Sigla de Modalidade inválida (nula)");
            }
            model.beans.Modalidade modalidade = 
                    model.services.Modalidades.recuperar(sigla);
            view.FormModalidade frm = new view.FormModalidade();
            frm.setModalidade(modalidade);
            frm.atualizaCampos();
            frm.setInclusao(false);
            req.getSession().setAttribute("formModalidade", frm);
            return "/formModalidade.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(AlterarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(AlterarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }

}

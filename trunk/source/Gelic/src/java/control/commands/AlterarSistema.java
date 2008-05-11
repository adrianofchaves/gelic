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
public class AlterarSistema implements Comando{
    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            String nome = util.Request.getParameter(req,"nome");
            if (nome == null) {
                throw new ExcecaoComando("Nome de sistema inválido (nulo)");
            }
            model.beans.Sistema sistema = 
                    model.services.Sistemas.recuperar(nome);
            view.FormSistema frm = new view.FormSistema();
            frm.setSistema(sistema);
            frm.atualizaCampos();
            frm.setInclusao(false);
            frm.setAlteracao(true);
            req.getSession().setAttribute("formSistema", frm);
            return "/formSistema.jsp";
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

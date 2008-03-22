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
public class AlterarTipoDocumento  implements Comando {

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            String nome = util.Request.getParameter(req, "nome");
            if (nome == null) {
                throw new ExcecaoComando(
                        "Nome de tipo de documento inválido (nula)");
            }
            model.beans.TipoDocumento tipo = model.services.TiposDocumentos.
                    recuperar(nome);
            view.FormTipoDocumento frm = new view.FormTipoDocumento();
            frm.setTipoDocumento(tipo);
            frm.atualizaCampos();
            frm.setInclusao(false);
            req.getSession().setAttribute("formTipoDocumento", frm);
            return "/formTipoDocumento.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(AlterarTipoLicitacao.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(AlterarTipoLicitacao.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }

    
}

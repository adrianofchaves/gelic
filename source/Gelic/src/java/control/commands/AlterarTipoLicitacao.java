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
public class AlterarTipoLicitacao implements Comando {

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            String nome = req.getParameter("nome");
            if (nome == null) {
                throw new ExcecaoComando("Nome de tipo de licitação inválido (nula)");
            }
            model.beans.TipoLicitacao tipo = model.services.TiposLicitacoes.recuperar(nome);
            view.FormTipoLicitacao frm = new view.FormTipoLicitacao();
            frm.setTipoLicitacao(tipo);
            frm.atualizaCampos();
            frm.setInclusao(false);
            req.getSession().setAttribute("formTipoLicitacao", frm);
            return "/formTipoLicitacao.jsp";
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

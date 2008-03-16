/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class TipoLicitacao {

    static public String preparaBrowser(HttpServletRequest req)
            throws NamingException, SQLException {
        view.BrowserTiposLicitacoes browser =
                new view.BrowserTiposLicitacoes(
                model.services.TiposLicitacoes.recuperar());
        req.getSession().setAttribute("browserTiposLicitacoes", browser);
        if( browser.getTiposLicitacoes().isEmpty()){
            return preparaCadastro(req);
        }
        return "/browserTiposLicitacoes.jsp";

    }

    public static String preparaCadastro(HttpServletRequest req) {
        view.FormTipoLicitacao frm = new view.FormTipoLicitacao();
        frm.setInclusao(true);
        req.getSession().setAttribute("formTipoLicitacao", frm);
        return "/formTipoLicitacao.jsp";
    }
}

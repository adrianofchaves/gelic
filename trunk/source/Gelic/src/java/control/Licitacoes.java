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
 * @author Paulo
 */
public class Licitacoes {
    static public String preparaBrowser(HttpServletRequest req)
            throws NamingException, SQLException {
        view.BrowserLicitacoes browser =
                new view.BrowserLicitacoes(
                model.services.Licitacoes.recuperar());
        if( (browser.getLicitacoes() == null) || 
                (browser.getLicitacoes().isEmpty())){
            return preparaCadastro(req);
        }
        req.getSession().setAttribute("browserLicitacoes", browser);
        browser.setNome("/homeComercial.jsp");
        return "/homeComercial.jsp";

    }

    public static String preparaCadastro(HttpServletRequest req) {
        view.FormLicitacao frm = new view.FormLicitacao();
        frm.setInclusao(true);
        req.getSession().setAttribute("FormLicitacao", frm);
        return "/FormLicitacao.jsp";
    }
}

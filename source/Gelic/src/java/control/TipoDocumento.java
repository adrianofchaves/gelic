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
public class TipoDocumento {
    static public String preparaBrowser(HttpServletRequest req)
            throws NamingException, SQLException {
        view.BrowserTiposDocumentos browser =
                new view.BrowserTiposDocumentos(
                model.services.TiposDocumentos.recuperar());
        if( (browser.getTiposDocumentos() == null) || (browser.getTiposDocumentos().isEmpty())){
            return preparaCadastro(req);
        }
        req.getSession().setAttribute("browserTiposDocumentos", browser);
        return "/browserTiposDocumentos.jsp";

    }

    public static String preparaCadastro(HttpServletRequest req) {
        view.FormTipoDocumento frm = new view.FormTipoDocumento();
        frm.setInclusao(true);
        req.getSession().setAttribute("formTipoDocumento", frm);
        return "/formTipoDocumento.jsp";
    }

}

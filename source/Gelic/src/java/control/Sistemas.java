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
public class Sistemas {

    static public String preparaBrowser(HttpServletRequest req)
            throws SQLException, NamingException {
        view.BrowserSistemas browser = new view.BrowserSistemas(
                model.services.Sistemas.recuperar());
        req.getSession().setAttribute("browserSistemas", browser);

        return "/browserSistemas.jsp";
    }
}

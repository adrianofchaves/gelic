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
 * @author adriano
 */
public class Modalidades {

    static public String preparaBrowser(HttpServletRequest req) 
            throws SQLException, NamingException {
        view.BrowserModalidades browser = new view.BrowserModalidades(
                model.services.Modalidades.recuperar());
        req.getSession().setAttribute("browserModalidades", browser);

        return "/browserModalidades.jsp";
    }
}

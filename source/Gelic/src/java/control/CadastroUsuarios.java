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
public class CadastroUsuarios {

    static public String preparar(HttpServletRequest req) 
            throws NamingException, SQLException {
        req.getSession().setAttribute("browserUsuarios",
                new view.BrowserUsuarios(model.services.Usuarios.recuperar()));

        view.FormUsuario frm = new view.FormUsuario();
        frm.setInclusao(true);
        req.getSession().setAttribute("formUsuario", frm);
        
        return "/cadastroUsuarios.jsp";
    }
}

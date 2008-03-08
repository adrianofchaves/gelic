/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Adriano
 */
public class Logout implements Comando {

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        req.getSession().setAttribute("usuario", null);
        return "/login.jsp";
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adriano
 */
public class NovaEmpresa implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormEmpresa frm = new view.FormEmpresa();
        frm.setInclusao(true);
        req.getSession().setAttribute("formEmpresa", frm);
        return "/formEmpresa.jsp";
    }

}

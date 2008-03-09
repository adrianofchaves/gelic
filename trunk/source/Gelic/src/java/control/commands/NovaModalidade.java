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
public class NovaModalidade implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormModalidade frm = new view.FormModalidade();
        frm.setInclusao(true);
        req.getSession().setAttribute("formModalidade", frm);
        return "/formModalidade.jsp";
    }

}

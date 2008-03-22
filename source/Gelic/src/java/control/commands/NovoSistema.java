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
public class NovoSistema implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormSistema frm = new view.FormSistema();
        frm.setInclusao(true);
        req.getSession().setAttribute("formSistema", frm);
        return "/formSistema.jsp";
    }

}

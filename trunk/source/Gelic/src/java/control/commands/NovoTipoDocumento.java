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
public class NovoTipoDocumento  implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormTipoDocumento frm = new view.FormTipoDocumento();
        frm.setInclusao(true);
        req.getSession().setAttribute("formTipoDocumento", frm);
        return "/formTipoDocumento.jsp";
    }

    
}
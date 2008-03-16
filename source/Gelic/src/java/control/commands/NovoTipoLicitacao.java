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
public class NovoTipoLicitacao implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormTipoLicitacao frm = new view.FormTipoLicitacao();
        frm.setInclusao(true);
        req.getSession().setAttribute("formTipoLicitacao", frm);
        return "/formTipoLicitacao.jsp";
    }

}

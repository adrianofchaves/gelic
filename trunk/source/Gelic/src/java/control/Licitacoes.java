/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Paulo
 */
public class Licitacoes {
    

     static String preparaCadastro(HttpServletRequest req) {
        view.FormLicitacao frm = new view.FormLicitacao();
        frm.setInclusao(true);
        req.getSession().setAttribute("FormLicitacao", frm);
        return "/FormLicitacao.jsp";
    }
}

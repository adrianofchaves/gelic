/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Paulo
 */
public class NovoProduto implements Comando{
    
        public String executar(HttpServletRequest req) throws ExcecaoComando {
        view.FormProduto frm = new view.FormProduto();
        frm.setInclusao(true);
        frm.setTitulo("Novo produto");
        req.getSession().setAttribute("formProduto", frm);
        return "/formProduto.jsp";
    }

}

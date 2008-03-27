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
 * @author gustavo
 */
public class Produto {
    static public String preparaBrowser(HttpServletRequest req)
            throws NamingException, SQLException {
        view.BrowserProdutos browser =
                new view.BrowserProdutos(
                model.services.Produtos.recuperar());
        if( (browser.getProdutos() == null) || (browser.getProdutos().isEmpty())){
            return preparaCadastro(req);
        }
        req.getSession().setAttribute("browserProdutos", browser);
        return "/browserProdutos.jsp";

    }

    public static String preparaCadastro(HttpServletRequest req) {
        view.FormProduto frm = new view.FormProduto();
        frm.setInclusao(true);
        req.getSession().setAttribute("formProduto", frm);
        return "/formProduto.jsp";
    }
}

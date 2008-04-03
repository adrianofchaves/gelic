/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Paulo
 */
public class AlterarProduto implements Comando {
    
        public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            String codigo = util.Request.getParameter(req,"codigo");
            if (codigo == null) {
                throw new ExcecaoComando("Código inválido (nulo)");
            }
            model.beans.Produto produto = model.services.Produtos.recuperar(codigo);
            view.FormProduto frm = new view.FormProduto();
            frm.setProduto(produto);
            frm.atualizaCampos();
            frm.setInclusao(false);
            req.getSession().setAttribute("formProduto", frm);
            return "/formProduto.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(AlterarProduto.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(AlterarProduto.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }

}

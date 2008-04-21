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
public class ExcluirProduto implements Comando {
   public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      String id = util.Request.getParameter(req, "id");
      if (id == null) {
        throw new ExcecaoComando("Produto inválido (nulo)");
      }
      model.beans.Produto produto = model.services.Produtos.recuperar(id);
      view.FormProduto frm = new view.FormProduto();
      frm.setProduto(produto);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setExclusao(true);
      frm.setTitulo("Excluindo Produto");
      req.getSession().setAttribute("formProduto", frm);
      return "/formProduto.jsp";
    } catch (SQLException ex) {
      Logger.getLogger(ExcluirProduto.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(ExcluirProduto.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando( ex.getMessage());
    }
  }

}

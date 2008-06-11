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
      int id = Integer.parseInt( util.Request.getParameter(req, "id") );
      
      model.beans.Produto produto = model.services.Produtos.recuperar(id);
      view.FormProduto frm = new view.FormProduto();
      frm.setProduto(produto);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setExclusao(true);
      frm.setTitulo("Excluindo produto");
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

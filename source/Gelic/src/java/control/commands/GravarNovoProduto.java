/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import control.commands.Comando;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Paulo
 */
public class GravarNovoProduto implements Comando {
    
        public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") != null) {
                return control.Produto.preparaBrowser(req);
            }
            /* popula form */
            view.FormProduto frm = (view.FormProduto) req.getSession().
                    getAttribute("formProduto");
            
            frm.setCodigoProduto(util.Request.getParameter(req,
                    "codigoProduto"));
            frm.setDescricaoProduto(util.Request.getParameter(req,
                    "descricaoProduto"));
            /**frm.setPrecovendaProduto(util.Request.getParameter(req,
                    "precovendaProduto"));
            frm.setPrecocompraProduto(util.Request.getParameter(req,
                    "precocompraProduto"));**/
            frm.valida();
            
            if( frm.temErros() ){
                return "/formProduto.jsp";
            }
            
            if(frm.isInclusao()){
                model.services.Produtos.incluir(
                        frm.getCodigoProduto(), 
                        frm.getDescricaoProduto(),
                        frm.getPrecovendaProduto(),
                        frm.getPrecocompraProduto());
            }else{
                model.services.Produtos.alterar(
                        frm.getProduto().getCodigo(),
                        frm.getCodigoProduto(), 
                        frm.getDescricaoProduto(),
                        frm.getPrecovendaProduto(),
                        frm.getPrecocompraProduto());
            }
                
            return control.Produto.preparaBrowser(req);
        } catch (NamingException ex) {
            Logger.getLogger(GravarNovoProduto.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GravarNovoProduto.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }
}
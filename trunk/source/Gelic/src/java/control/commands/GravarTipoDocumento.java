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
 * @author Adriano
 */
public class GravarTipoDocumento implements Comando {
    
  static final String chaveForm = "formTipoDocumento";
  static final String chaveBrowser = "browserTiposDocumentos";
  static final String uriForm = "/formTipoDocumento.jsp";
  static final String uriBrowser = "/browserTiposDocumentos.jsp";
  static final String msgInclusao = "Novo tipo de documento cadastrado.";
  static final String msgExclusao = "Tipo de Documento excluído.";
  static final String msgAlteracao = "Tipo de Documento alterado.";

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") != null) {
                return control.TipoDocumento.preparaBrowser(req);
            }
            view.FormTipoDocumento frm = (view.FormTipoDocumento) 
                    req.getSession().getAttribute(chaveForm);
            if (frm==null){
                frm = new view.FormTipoDocumento();
            }
            /* popula form */
            String nomeTipoDocumento = util.Request.getParameter(req, 
                    "nomeTipoDocumento");
            frm.setNomeTipoDocumento(nomeTipoDocumento);
            
            frm.valida();
            
            if( frm.temErros() ){
                return uriForm;
            }
            String mensagem = null;
            if(frm.isInclusao()){
                model.services.TiposDocumentos.incluir(
                        frm.getNomeTipoDocumento());
                mensagem = msgInclusao;
            }
            if (frm.isAlteracao()){
                model.services.TiposDocumentos.alterar(
                        frm.getTipoDocumento().getNome(),
                        frm.getNomeTipoDocumento());
                mensagem = msgAlteracao;
            }
            if (frm.isExclusao()){
                model.services.TiposDocumentos.excluir(frm.getTipoDocumento().getNome());
                mensagem = msgExclusao;            
            }
            return executaBrowser(req, mensagem);
        } catch (NamingException ex) {
            Logger.getLogger(GravarTipoDocumento.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GravarTipoDocumento.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }

    private String executaBrowser(HttpServletRequest req, String mensagem) 
        throws NamingException, SQLException{
        view.BrowserTiposDocumentos browser = new view.BrowserTiposDocumentos(
            model.services.TiposDocumentos.recuperar());
        browser.setMensagem(mensagem);
        req.getSession().setAttribute(chaveBrowser, browser);
        return uriBrowser;
    }
}


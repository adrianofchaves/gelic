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
 * @author Adriano alterado por Paulo
 */
public class GravarTipoLicitacao implements Comando {
    
  static final String chaveForm = "formTipoLicitacao";
  static final String chaveBrowser = "browserTiposLicitacoes";
  static final String uriForm = "/formTipoLicitacao.jsp";
  static final String uriBrowser = "/browserTiposLicitacoes.jsp";
  static final String msgInclusao = "Novo tipo de licitação cadastrado.";
  static final String msgExclusao = "Tipo de Licitação excluído.";
  static final String msgAlteracao = "Tipo de Licitação alterado.";

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") != null) {
                return control.TipoLicitacao.preparaBrowser(req);
            }

            view.FormTipoLicitacao frm = (view.FormTipoLicitacao) req.getSession().
                    getAttribute(chaveForm);
            
            if (frm==null){
                frm = new view.FormTipoLicitacao();
            }                
            
            /* popula form */            
            frm.setNomeTipoLicitacao(util.Request.getParameter(req,
                    "nomeTipoLicitacao"));
            frm.setSiglaTipoLicitacao(util.Request.getParameter(req,
                    "siglaTipoLicitacao"));
            
            frm.valida();
            
            if( frm.temErros() ){
                return uriForm;
            }
            
            String mensagem = null;
            
            if(frm.isInclusao()){
                model.services.TiposLicitacoes.incluir(
                        frm.getNomeTipoLicitacao(), 
                        frm.getSiglaTipoLicitacao());
                mensagem = msgInclusao;
            }
            
            if (frm.isAlteracao()){
                model.services.TiposLicitacoes.alterar(
                        frm.getTipoLicitacao().getNome(),
                        frm.getNomeTipoLicitacao(),
                        frm.getSiglaTipoLicitacao());
                mensagem = msgAlteracao;
            }
            
            if (frm.isExclusao()){
                model.services.TiposLicitacoes.excluir(frm.getTipoLicitacao().getSigla());
                mensagem = msgExclusao;            
            }
            
            return executaBrowser(req, mensagem);
            
        } catch (NamingException ex) {
            Logger.getLogger(GravarTipoLicitacao.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GravarTipoLicitacao.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }
    
    private String executaBrowser(HttpServletRequest req, String mensagem) 
          throws NamingException, SQLException {
    view.BrowserTiposLicitacoes browser = new view.BrowserTiposLicitacoes(
            model.services.TiposLicitacoes.recuperar());
    browser.setMensagem(mensagem);
    req.getSession().setAttribute(chaveBrowser, browser);
    return uriBrowser;
  }
}
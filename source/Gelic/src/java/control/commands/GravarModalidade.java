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
import view.FormModalidade;

/**
 *
 * @author Adriano alterado por Paulo
 */
public class GravarModalidade implements Comando {
    
  static final String chaveForm = "formModalidade";
  static final String chaveBrowser = "browserModalidades";
  static final String uriForm = "/formModalidade.jsp";
  static final String uriBrowser = "/browserModalidades.jsp";
  static final String msgInclusao = "Nova modalidade cadastrada.";
  static final String msgExclusao = "Modalidade excluída.";
  static final String msgAlteracao = "Modalidade alterada.";
    

    private String executaCancelar(HttpServletRequest req)
            throws SQLException, NamingException {
        return control.Modalidades.preparaBrowser(req);
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            /* Botão cancelar foi acionado */
            if (req.getParameter("cancelar") != null) {
                return executaCancelar(req);
            }
            /* "popula form */
            view.FormModalidade frm = (FormModalidade) req.getSession().
                    getAttribute(chaveForm);
            frm.setNomeModalidade(util.Request.getParameter(req,
                    "nomeModalidade"));
            frm.setSiglaModalidade(util.Request.getParameter(req,
                    "siglaModalidade"));
            /* Executa críticas */
            frm.valida();
            /* Se tem erros sai */
            if( frm.temErros()){
                return uriForm;
            }
            /* Grava e volta para o browser atualizado */
            //view.BrowserModalidades browser = new view.BrowserModalidades();
            String mensagem = null;
            if (frm.isInclusao()){
                model.services.Modalidades.incluir(frm.getSiglaModalidade(),
                        frm.getNomeModalidade());
                mensagem = msgInclusao;
            }
            
            if (frm.isAlteracao()){
                model.services.Modalidades.alterar(
                        frm.getModalidade().getSigla(),
                        frm.getSiglaModalidade(),
                        frm.getNomeModalidade());
                mensagem = msgAlteracao;
            }
            
            if(frm.isExclusao()){
                model.services.Modalidades.excluir(frm.getModalidade().getSigla());
                mensagem = msgExclusao;
            }
            
            return executaBrowser(req,mensagem);
        } catch (SQLException ex) {
            Logger.getLogger(GravarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(GravarModalidade.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }
    private String executaBrowser(HttpServletRequest req, String mensagem) 
          throws NamingException, SQLException {
    view.BrowserModalidades browser = new view.BrowserModalidades(
            model.services.Modalidades.recuperar());
    browser.setMensagem(mensagem);
    req.getSession().setAttribute(chaveBrowser, browser);
    return uriBrowser;
  }    
}

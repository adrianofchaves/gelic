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
 * @author Adriano
 */
public class GravarTipoLicitacao implements Comando {

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") != null) {
                return control.TipoLicitacao.preparaBrowser(req);
            }
            /* popula form */
            view.FormTipoLicitacao frm = (view.FormTipoLicitacao) req.getSession().
                    getAttribute("formTipoLicitacao");
            
            frm.setNomeTipoLicitacao(util.Request.getParameter(req,
                    "nomeTipoLicitacao"));
            frm.setSiglaTipoLicitacao(util.Request.getParameter(req,
                    "siglaTipoLicitacao"));
            
            frm.valida();
            
            if( frm.temErros() ){
                return "/formTipoLicitacao.jsp";
            }
            
            if(frm.isInclusao()){
                model.services.TiposLicitacoes.incluir(
                        frm.getNomeTipoLicitacao(), 
                        frm.getSiglaTipoLicitacao());
            }else{
                model.services.TiposLicitacoes.alterar(
                        frm.getTipoLicitacao().getNome(),
                        frm.getNomeTipoLicitacao(),
                        frm.getSiglaTipoLicitacao());
            }
                
            return control.TipoLicitacao.preparaBrowser(req);
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
}

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

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") != null) {
                return control.TipoDocumento.preparaBrowser(req);
            }
            /* popula form */
            view.FormTipoDocumento frm = (view.FormTipoDocumento) 
                    req.getSession().getAttribute("formTipoDocumento");
            
            frm.setNomeTipoDocumento(req.getParameter("nomeTipoDocumento"));
            
            frm.valida();
            
            if( frm.temErros() ){
                return "/formTipoDocumento.jsp";
            }
            
            if(frm.isInclusao()){
                model.services.TiposDocumentos.incluir(
                        frm.getNomeTipoDocumento());
            }else{
                model.services.TiposDocumentos.alterar(
                        frm.getTipoDocumento().getNome(),
                        frm.getNomeTipoDocumento());
            }
                
            return control.TipoDocumento.preparaBrowser(req);
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
}


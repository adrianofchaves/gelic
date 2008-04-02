/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import model.beans.Papel;

/**
 *
 * @author adriano
 */
public class Usuarios {

    static public String prepararBrowser(HttpServletRequest req) 
            throws NamingException, SQLException {
        req.getSession().setAttribute("browserUsuarios",
                new view.BrowserUsuarios(model.services.Usuarios.recuperar()));

        view.FormUsuario frm = new view.FormUsuario();
        frm.setInclusao(true);
        frm.setPapeis(getPapeis(req));
        req.getSession().setAttribute("formUsuario", frm);
        
        return "/cadastroUsuarios.jsp";
    }
    
    static public ArrayList <model.beans.Papel> getPapeis(
            HttpServletRequest req) throws NamingException, SQLException{
      final String chavePapeis = "Papeis";
      
      ServletContext cntx = req.getSession().getServletContext();
      ArrayList <model.beans.Papel> papeis = (ArrayList<Papel>) 
              cntx.getAttribute(chavePapeis);
      if( papeis == null ){
        papeis = model.services.Papeis.recuperar();
        cntx.setAttribute(chavePapeis, papeis);
      }
      return papeis;
    }
}

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

/**
 * Classe responsável por manter a lista de UF's.  Ela inicialmente é recuperada
 * da tabela do banco (model.services.UFs), sendo guardada no contexto da 
 * aplicação.  A partir daí a lista do contexto é manipulada.
 * @author Adriano
 */
public class UFs {
  
  static public ArrayList<String> getUFs(HttpServletRequest req) 
          throws NamingException, SQLException{
    final String chaveUF = "UFs";
    
    ServletContext cntx = req.getSession().getServletContext();
    ArrayList<String> ufs = (ArrayList<String> ) cntx.getAttribute(chaveUF);
    if( ufs == null ){
      ufs = model.services.UFs.recuperar();
      cntx.setAttribute(chaveUF, ufs);
    }
    return ufs;
  }

}

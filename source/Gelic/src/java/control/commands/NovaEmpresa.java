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
 * @author adriano
 */
public class NovaEmpresa implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormEmpresa frm = new view.FormEmpresa();
      frm.setInclusao(true);
      frm.setTitulo("Nova Empresa");
      frm.setUfs(control.UFs.getUFs(req));     
      frm.setTiposLogradouros(control.Enderecos.getTiposLogradouros(req));
      req.getSession().setAttribute("formEmpresa", frm);
      return "/formEmpresa.jsp";
    } catch (NamingException ex) {
      Logger.getLogger(NovaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(NovaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

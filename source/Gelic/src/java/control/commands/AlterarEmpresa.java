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
public class AlterarEmpresa implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      String cnpj = util.Request.getParameter(req, "cnpj");
      if (cnpj == null) {
        throw new ExcecaoComando("CNPJ inválido (nulo)");
      }
      model.beans.Empresa empresa = model.services.Empresas.recuperar(cnpj);
      view.FormEmpresa frm = new view.FormEmpresa();
      frm.setEmpresa(empresa);
      frm.atualizaCampos();
      frm.setInclusao(false);
      frm.setTitulo("Alterando empresa");
      frm.setUfs(control.UFs.getUFs(req));
      frm.setTiposLogradouros(control.Enderecos.getTiposLogradouros(req));
      req.getSession().setAttribute("formEmpresa", frm);
      return "/formEmpresa.jsp";
    } catch (SQLException ex) {
      Logger.getLogger(AlterarEmpresa.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(AlterarEmpresa.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }
}

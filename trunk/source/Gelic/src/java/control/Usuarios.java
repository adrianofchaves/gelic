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

  public static String prepararExclusao(HttpServletRequest req)
          throws NamingException, SQLException {
    String login = util.Request.getParameter(req, "login").trim();
    view.FormUsuario frm = new view.FormUsuario();
    model.beans.Usuario usuario = model.services.Usuarios.recuperar(
            login);
    frm.setUsuario(usuario);
    frm.atualizaCampos();
    frm.setExclusao(true);
    frm.setPapeis(getPapeis(req));
    req.getSession().setAttribute("formUsuario", frm);
    return "formUsuario.jsp";
  }

  static public String prepararInclusao(HttpServletRequest req)
          throws NamingException, SQLException {
    view.FormUsuario frm = new view.FormUsuario();
    frm.setInclusao(true);
    frm.setPapeis(getPapeis(req));
    req.getSession().setAttribute("formUsuario", frm);
    return "formUsuario.jsp";
  }

  static public String prepararBrowser(HttpServletRequest req)
          throws NamingException, SQLException {
    req.getSession().setAttribute("browserUsuarios",
            new view.BrowserUsuarios(model.services.Usuarios.recuperar()));


    return "/browserUsuarios.jsp";
  }

  static public ArrayList<model.beans.Papel> getPapeis(
          HttpServletRequest req) throws NamingException, SQLException {
    final String chavePapeis = "Papeis";

    ServletContext cntx = req.getSession().getServletContext();
    ArrayList<model.beans.Papel> papeis = (ArrayList<Papel>) cntx.getAttribute(chavePapeis);
    if (papeis == null) {
      papeis = model.services.Papeis.recuperar();
      cntx.setAttribute(chavePapeis, papeis);
    }
    return papeis;
  }
}

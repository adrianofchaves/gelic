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
 *
 * @author adriano
 */
public class Enderecos {

    static public ArrayList<model.beans.TipoLogradouro> getTiposLogradouros(
            HttpServletRequest req) throws NamingException, SQLException {
        final String chaveTipoLogradouro = "TiposLogradouros";

        ServletContext cntx = req.getSession().getServletContext();
        ArrayList<model.beans.TipoLogradouro> tipos =
                (ArrayList<model.beans.TipoLogradouro>) cntx.getAttribute(
                chaveTipoLogradouro);
        if (tipos == null) {
            tipos = model.services.Enderecos.recuperar();
            cntx.setAttribute(chaveTipoLogradouro, tipos);
        }
        return tipos;
    }
}

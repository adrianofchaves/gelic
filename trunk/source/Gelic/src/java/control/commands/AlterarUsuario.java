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
 * Esse comando é executado quando o usuário clica no login do usuário no 
 * cadastro de usuários.  Ele retorna para o JSP com o formulario preenchido.
 * 
 * @author adriano
 */
public class AlterarUsuario implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            /* O cadastro de usuário e formulário de usuário são apresentados
               juntos, então é necessário enviar a lista de usuários 
               cadastrados
             */
            req.setAttribute("browserUsuarios", null);
            view.BrowserUsuarios browser = new view.BrowserUsuarios(
                    model.services.Usuarios.recuperar());
            req.getSession().setAttribute("browserUsuarios", browser );
            
            String login = util.Request.getParameter(req,"login").trim();
            view.FormUsuario frm = new view.FormUsuario();
            frm.setInclusao(false);
            model.beans.Usuario usuario = model.services.Usuarios.recuperar(
                    login);
            frm.setUsuario(usuario);
            frm.atualizaCampos();
            req.getSession().setAttribute("formUsuario", frm);
            
            
            return "/cadastroUsuarios.jsp";
        } catch (NamingException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }

}

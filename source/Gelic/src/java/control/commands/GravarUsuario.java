/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import view.FormUsuario;

/**
 * Esse comando é executado quando o usuário clica no botão submit do form de
 * usuário.  Através do form no request o comando inferirá se é uma inclusão ou
 * alteração.
 * @author adriano
 */
public class GravarUsuario implements Comando {

    private void atualizaBrowser(HttpServletRequest req, String mensagem)
            throws NamingException, SQLException {
        view.BrowserUsuarios browser = new view.BrowserUsuarios(
                model.services.Usuarios.recuperar());
        browser.setMensagem(mensagem);
        req.getSession().setAttribute("browserUsuarios", browser);
    }

    private FormUsuario populaForm(HttpServletRequest req) {

        /* Popula o form: copia valores do parameters para o form */
        view.FormUsuario frm = (view.FormUsuario) req.getSession().getAttribute(
                "formUsuario");
        /* loginUsuario */
        frm.setLoginUsuario(util.Forms.recuperaParametro(req, "loginUsuario"));
        /* senhaUsuario */
        frm.setSenhaUsuario(util.Forms.recuperaParametro(req, "senhaUsuario"));
        /* confirmaSenhaUsuario */
        frm.setConfirmaSenhaUsuario(
                util.Forms.recuperaParametro(req, "confirmaSenhaUsuario"));
        /* papelUsuario*/
        frm.setPapelUsuario(util.Forms.recuperaParametro(req, "papelUsuario"));

        return frm;
    }

    private String processa(HttpServletRequest req)
            throws SQLException, NamingException, NoSuchAlgorithmException {

        /*Popula form*/
        FormUsuario frm = populaForm(req);
        /*Executa críticas*/
        frm.valida();
        /*Atualiza formulário da sessão*/
        req.getSession().setAttribute("formUsuario", frm);
        if (frm.temErros()) {
            /* Se hou erros, volta */
            return "/cadastroUsuarios.jsp";
        }

        /* Efetua gravação no banco */
        if (frm.isInclusao()) {
            /* incluindo */
            model.services.Usuarios.incluir(
                    frm.getLoginUsuario(),
                    frm.getSenhaUsuario(),
                    frm.getIdPapel());

            atualizaBrowser(req, "Usuário incluído com sucesso.");
            ressetaForm(req);
            return "/cadastroUsuarios.jsp";
        }
        /* Alterando */
        model.services.Usuarios.alterar(
                frm.getUsuario().getLogin(),
                frm.getLoginUsuario(),
                frm.getSenhaUsuario(),
                frm.getIdPapel());
        atualizaBrowser(req, "Usuário alterado com sucesso.");
        ressetaForm(req);
        return "/cadastroUsuarios.jsp";
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        try {
            if (req.getParameter("cancelar") == null) {
                return processa(req);
            } else {
                return control.CadastroUsuarios.preparar(req);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GravarUsuario.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GravarUsuario.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(GravarUsuario.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        }
    }

    private void ressetaForm(HttpServletRequest req) {
        view.FormUsuario frm = new view.FormUsuario();
        frm.setInclusao(true);
        req.getSession().setAttribute("formUsuario", frm);
    }
}

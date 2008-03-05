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
import view.FormUsuario;

/**
 * Esse comando é executado quando o usuário clica no botão submit do form de
 * usuário.  Através do form no request o comando inferirá se é uma inclusão ou
 * alteração.
 * @author adriano
 */
public class GravarUsuario implements Comando {

    private void atualizaBrowser(HttpServletRequest req)
            throws NamingException, SQLException {
        req.getSession().setAttribute("browserUsuarios",
                new view.BrowserUsuarios(model.services.Usuarios.recuperar()));
    }

    private FormUsuario populaForm(HttpServletRequest req) {

        /* Popula o form: copia valores do parameters para o form */
        view.FormUsuario frm = (view.FormUsuario) req.getSession().getAttribute(
                "formUsuario");        
        /* loginUsuario */
        frm.setLoginUsuario(recuperaParametro(req, "loginUsuario"));
        /* senhaUsuario */
        frm.setSenhaUsuario(recuperaParametro(req, "senhaUsuario"));
        /* confirmaSenhaUsuario */
        frm.setConfirmaSenhaUsuario(
                recuperaParametro(req, "confirmaSenhaUsuario"));
        /* papelUsuario*/
        frm.setPapelUsuario(recuperaParametro(req, "papelUsuario"));

        return frm;
    }

    private String processa(HttpServletRequest req)
            throws SQLException, NamingException {
        /*Popula form*/
        FormUsuario frm = populaForm(req);
        /*Executa críticas*/
        validaForm(frm);
        /*Atualiza formulário da sessão*/
        req.getSession().setAttribute("formUsuario", frm);


        if (!frm.getErros().isEmpty()) {
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

            atualizaBrowser(req);
            return "/cadastroUsuarios.jsp";
        }
        /* Alterando */
        model.services.Usuarios.alterar(
                frm.getUsuario().getLogin(),
                frm.getLoginUsuario(),
                frm.getSenhaUsuario(),
                frm.getIdPapel());
        atualizaBrowser(req);
        return "/cadastroUsuarios.jsp";
    }

    private String recuperaParametro(HttpServletRequest req, String nome) {
        String parametro = req.getParameter(nome);
        if (parametro == null) {
            parametro = "";
        }
        return parametro;
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            return processa(req);
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

    private void validaForm(FormUsuario frm)
            throws SQLException, NamingException {
        frm.apagaErros();
        /* Executa críticas */
        if (!frm.getSenhaUsuario().equals(frm.getConfirmaSenhaUsuario())) {
            frm.setErroConfirmaSenhaUsuario(
                    "Está diferente da informada em Senha");
            frm.addErro("As senhas informadas são diferentes");
        }
        if (model.services.Papeis.recuperar(frm.getPapelUsuario()) == null) {
            frm.setErroPapelUsuario("Papel inválido.");
            frm.addErro("O papel informado não é válido.");
        }
        if (frm.isInclusao() && model.services.Usuarios.recuperar(
                frm.getLoginUsuario()) != null) {
            frm.setErroLoginUsuario("Login já existe.");
            frm.addErro("Login inválido.");
        }
    }
}

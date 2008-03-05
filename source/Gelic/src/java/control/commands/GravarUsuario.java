/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Esse comando é executado quando o usuário clica no botão submit do form de
 * usuário.  Através do form no request o comando inferirá se é uma inclusão ou
 * alteração.
 * @author adriano
 */
public class GravarUsuario implements Comando {

    private String recuperaParametro(HttpServletRequest req, String nome) {
        String parametro = req.getParameter(nome);
        if (parametro == null) {
            parametro = "";
        }
        return parametro;
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {

        /* Popula o form: copia valores do parameters para o form */
        view.FormUsuario frm = (view.FormUsuario) req.getSession().getAttribute(
                "formUsuario");
        /* loginUsuario */
        frm.setLoginUsuario(recuperaParametro(req, "loginUsuario"));
        /* senhaUsuario */
        frm.setSenhaUsuario(recuperaParametro(req, "senhaUsuario"));
        /* confirmaSenhaUsuario */
        frm.setConfirmaSenhaUsuario(recuperaParametro(req, "confirmaSenhaUsuario"));
        /* papelUsuario*/
        frm.setPapelUsuario(recuperaParametro(req, "papelUsuario"));

        /* Executa críticas */
        if (!frm.getSenhaUsuario().equals(frm.getConfirmaSenhaUsuario())) {
            frm.setErroConfirmaSenhaUsuario(
                    "Está diferente da informada em Senha");
            frm.addErro("As senhas informadas são diferentes");
        }
        if (model.services.Papeis.recuperar(frm.getPapelUsuario()) == null) {
            frm.setPapelUsuario("Papel inválido.");
            frm.addErro("O papel informado não é válido.");            
        }
        
        if( !frm.getErros().isEmpty()){
            return "/cadastroUsuarios.jsp";
        }
        
        /* Efetua gravação no banco */
        if (frm.isInclusao()) {
            /* incluindo */
            model.services.Usuarios.incluir(
                    frm.getLoginUsuario(),
                    frm.getSenhaUsuario(),
                    frm.getIdPapel());
            return "/cadastroUsuarios.jsp";
        }
        /* Alterando */
        model.services.Usuarios.alterar(frm.getUsuario().getLogin(),
                frm.getLoginUsuario(),
                frm.getSenhaUsuario(),
                frm.getIdPapel());
        return "/cadastroUsuarios.jsp";
    }
}

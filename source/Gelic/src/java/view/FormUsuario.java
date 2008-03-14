/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 * Representa a tela de cadastro de usuários contendo os valores de seus campos.
 * 
 * @author adriano
 */
public class FormUsuario extends Form {

    private model.beans.Usuario usuario;
    
    private boolean inclusao = true;
    
    private String loginUsuario;
    private String erroLoginUsuario;

    private String senhaUsuario;
    private String erroSenhaUsuario;
    
    private String confirmaSenhaUsuario;
    private String erroConfirmaSenhaUsuario;

    private String papelUsuario;
    private String erroPapelUsuario;
    private int idPapel;

    protected void apagaErros() {
        super.apagaErros();
        erroConfirmaSenhaUsuario = null;
        erroLoginUsuario = null;
        erroPapelUsuario = null;                
    }
    
    public void valida() throws SQLException, NamingException {
        apagaErros();
        /* Executa críticas */
        if (!getSenhaUsuario().equals(getConfirmaSenhaUsuario())) {
            setErroConfirmaSenhaUsuario("Está diferente da informada em Senha");
            addErro("As senhas informadas são diferentes");
        }
        model.beans.Papel papel = model.services.Papeis.recuperar(
                getPapelUsuario());
        if (model.services.Papeis.recuperar(getPapelUsuario()) == null) {
            setErroPapelUsuario("Papel inválido.");
            addErro("O papel informado não é válido.");
        } else {
            setIdPapel(papel.getId());
        }
        if (isInclusao() && model.services.Usuarios.recuperar(
                getLoginUsuario()) != null) {
            setErroLoginUsuario("Login já existe.");
            addErro("Login inválido.");
        }

    }

    public void atualizaCampos() {
        setLoginUsuario(getUsuario().getLogin());
        setPapelUsuario(getUsuario().getPapel().getNome());
        setIdPapel(getUsuario().getPapel().getId());
    }

    public model.beans.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(model.beans.Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean getInclusao() {
        return isInclusao();
    }

    public boolean isInclusao() {
        return inclusao;
    }

    public void setInclusao(boolean inclusao) {
        this.inclusao = inclusao;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String nome) {
        this.loginUsuario = nome;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getConfirmaSenhaUsuario() {
        return confirmaSenhaUsuario;
    }

    public void setConfirmaSenhaUsuario(String confirmaSenhaUsuario) {
        this.confirmaSenhaUsuario = confirmaSenhaUsuario;
    }

    public String getPapelUsuario() {
        return papelUsuario;
    }

    public void setPapelUsuario(String papelUsuario) {
        this.papelUsuario = papelUsuario;
    }

    public int getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(int idPapel) {
        this.idPapel = idPapel;
    }

    public String getErroPapelUsuario() {
        return erroPapelUsuario;
    }

    private void setErroPapelUsuario(String erroPapelUsuario) {
        this.erroPapelUsuario = erroPapelUsuario;
    }

    public String getErroConfirmaSenhaUsuario() {
        return erroConfirmaSenhaUsuario;
    }

    private void setErroConfirmaSenhaUsuario(String erroConfirmaSenhaUsuario) {
        this.erroConfirmaSenhaUsuario = erroConfirmaSenhaUsuario;
    }

    public String getErroLoginUsuario() {
        return erroLoginUsuario;
    }

    private void setErroLoginUsuario(String erroLoginUsuario) {
        this.erroLoginUsuario = erroLoginUsuario;
    }

    public String getErroSenhaUsuario() {
        return erroSenhaUsuario;
    }

    private void setErroSenhaUsuario(String erroSenhaUsuario) {
        this.erroSenhaUsuario = erroSenhaUsuario;
    }
}

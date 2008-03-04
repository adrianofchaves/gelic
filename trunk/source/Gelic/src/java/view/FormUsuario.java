/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author adriano
 */
public class FormUsuario {
    private model.beans.Usuario usuario;
    private boolean inclusao = false;
    private String nome;
    private String senhaUsuario;
    private String confirmaSenhaUsuario;
    private String papelUsuario;

    public model.beans.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(model.beans.Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isInclusao() {
        return inclusao;
    }

    public void setInclusao(boolean inclusao) {
        this.inclusao = inclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Adriano
 */
public class FormLogin extends Form {

    private String login;
    private String senha;
    private String erroLogin;
    private String erroSenha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getErroLogin() {
        return erroLogin;
    }

    public void setErroLogin(String erroLogin) {
        this.erroLogin = erroLogin;
    }

    public String getErroSenha() {
        return erroSenha;
    }

    public void setErroSenha(String erroSenha) {
        this.erroSenha = erroSenha;
    }
}

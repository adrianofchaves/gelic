/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Esse comando é executado quando o usuário clica no login do usuário no 
 * cadastro de usuários.  Ele retorna para o JSP com o formulario preenchido.
 * 
 * @author adriano
 */
public class AlterarUsuario implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

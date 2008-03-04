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
public class GravarUsuario implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

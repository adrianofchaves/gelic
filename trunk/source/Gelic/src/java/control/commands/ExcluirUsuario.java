/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Esse comando é executado quando o usuário clica em excluir (lixeira) no 
 * cadastro de usuários.
 * 
 * @author adriano
 */
public class ExcluirUsuario implements Comando{

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface para implementação dos comandos dos servlets do aplicativo.  
 * @author adriano
 */
public interface Comando {

    public String executar(HttpServletRequest req) throws  ExcecaoComando;
            
}

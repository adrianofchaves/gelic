/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Comando que não faz nada.  Usado para navegacao.
 * @author adriano
 */
public class Nulo implements Comando {

    private String proxima;

    public Nulo(String proxima) {
        this.proxima = proxima;
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        return proxima;
    }
}

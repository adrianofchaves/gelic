/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.ServletRequest;

/**
 * Rotinas para auxiliar a manipulação de forms.
 * 
 * @author adriano
 */
public class Forms {

    /**
     * Retorna o valor de um parâmetro.  Se o parâmetro não for assinalado 
     * retorna uma String vazia.
     * @param req Request
     * @param nomeParametro Nome do parâmetro
     * @return Valor do parâmetro.  Nunca retornará null.
     */
    static public String recuperaParametro(
            ServletRequest req,
            String nomeParametro) {
        String valor;
        
        if (req != null) {
            valor = req.getParameter(nomeParametro);
        } else {
            valor = "";
        }

        if (valor == null) {
            valor = "";
        }
        return valor;

    }
}

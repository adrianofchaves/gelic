/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import javax.servlet.ServletRequest;

/**
 * Classe contendo rotinas utilitárias para manipulação do request.
 * @author Adriano
 */
public class Request {
    /**
     * Foi verificado que os parâmetros não são convertidos para UTF-8, causando
     * diversos problemas.  Este método lê o parâmetro e converte-o para UTF-8.
     * 
     * @param req - request que será usado para ler o parâmetro antes de 
     * converter
     * @param nomeParametro - nome do parâmetro que será lido.
     * @return - valor do parâmetro em UTF-8
     */
    static public String getParameter(ServletRequest req, 
            String nomeParametro){
        String valor = req.getParameter(nomeParametro);
        valor = StringEncode.toUTF8(valor);
        return valor;
    }
    static public java.sql.Date getDateParameter( ServletRequest req, 
            String nomeParametro) throws ParseException{
      return Forms.parse(getParameter(req, nomeParametro));
    }    
    static public float getFloatParameter(ServletRequest req, 
            String nomeParametro){
      String buffer = getParameter(req, nomeParametro);
      buffer = buffer.replace(',', '.');
      return Float.parseFloat(buffer);
    }
}

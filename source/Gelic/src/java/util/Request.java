/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
      return parse(getParameter(req, nomeParametro));
    }
    final static String DATE_PATTERN = "dd/MM/yyyy";
    static private java.sql.Date parse(String origem) throws ParseException{
      SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
      java.util.Date dt = formatter.parse(origem);      
      java.sql.Date result = new java.sql.Date(dt.getTime());      
      return result;
    }
    
    public static void main(String[] args) throws ParseException{
      System.out.println(parse("21/11/1974"));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletRequest;

/**
 * Rotinas para auxiliar a manipulação de forms.
 * 
 * @author adriano
 */
public class Forms {

  final static String DATE_PATTERN = "dd/MM/yyyy";

  static public java.sql.Date parse(String origem) throws ParseException {
    if(origem == null || origem.isEmpty()){
      return null;
    }
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
    java.util.Date dt = formatter.parse(origem);
    java.sql.Date result = new java.sql.Date(dt.getTime());
    return result;
  }

  public static String formata(Date data) {
    if(data == null){
      return null;
    }
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
    return formatter.format(data);    
  }

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
      valor = util.Request.getParameter(req, nomeParametro);
    } else {
      valor = "";
    }

    if (valor == null) {
      valor = "";
    }
    return valor;

  }
}

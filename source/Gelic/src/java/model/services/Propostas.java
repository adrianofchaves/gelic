/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class Propostas {
  public static void recuperar(model.beans.Lote lote) 
          throws NamingException, SQLException{
    model.daos.Propostas.recuperar(lote); 
  }

}

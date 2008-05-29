/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class Lotes {
  static public model.beans.Lote recuperar(int id) 
          throws NamingException, SQLException{
    return model.daos.Lotes.recuperar(id);
  }

}

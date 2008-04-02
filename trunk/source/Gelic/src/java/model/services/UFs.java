/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class UFs {

  static public ArrayList<String> recuperar() 
          throws NamingException, SQLException {
    return model.daos.UFs.recuperar();
  }
}

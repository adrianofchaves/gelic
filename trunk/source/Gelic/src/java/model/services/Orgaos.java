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
 * @author adriano
 */
public class Orgaos {

  static public ArrayList<model.beans.Orgao> recuperar() 
          throws NamingException, SQLException {
    return model.daos.Orgaos.recuperar();
  }
}

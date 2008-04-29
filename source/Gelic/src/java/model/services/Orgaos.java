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
    ArrayList<model.beans.Orgao> orgaos = model.daos.Orgaos.recuperar();
    
    model.daos.Enderecos.recuperarDeOrgaos(orgaos);
    model.daos.Contatos.recuperarDeOrgaos(orgaos);
    model.daos.Telefones.recuperarDeOrgaos(orgaos);
    
    return orgaos;
  }
}

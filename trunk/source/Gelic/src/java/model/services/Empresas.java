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
public class Empresas {
  public static ArrayList<model.beans.Empresa> recuperar() 
          throws NamingException, SQLException{
    ArrayList<model.beans.Empresa> empresas = model.daos.Empresas.recuperar();
    /* NOTA: como o telefone fica no endereço é necessário fazer essa  
     recuperação nesta ordem */
    model.daos.Enderecos.recuperar(empresas);
    model.daos.Contatos.recuperar(empresas);
    model.daos.Telefones.recuperar(empresas);
    return empresas;
  }

}

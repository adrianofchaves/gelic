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
  public static ArrayList<model.beans.Empresa> recuperar() throws NamingException, SQLException{
    ArrayList<model.beans.Empresa> empresas = model.daos.Empresas.recuperar();
    model.daos.Telefones.recuperar(empresas);
    model.daos.Enderecos.recuperar(empresas);
    // todo: model.daos.Contatos.recuperar(empresas);
    return empresas;
  }

}

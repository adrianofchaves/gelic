/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class Contatos {

  public static void alterar(model.beans.Contato contato, String nomeContato,
          String ddiContato, String dddContato, String numeroTelefoneContato,
          String ramalContato) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Telefones.alterar(contato.getTelefone(), ddiContato, 
              dddContato, numeroTelefoneContato, ramalContato);
      model.daos.Contatos.alterar(contato, nomeContato);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }

  }

  public static void excluir(model.beans.Contato contato) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public static void incluir(model.beans.Empresa empresa, String nomeContato,
          String ddiContato, String dddContato, String numeroTelefoneContato,
          String ramalContato) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public static model.beans.Contato recuperar(int id)
          throws SQLException, NamingException {
    model.beans.Contato contato = model.daos.Contatos.recuperar(id);
    model.daos.Telefones.recuperar(contato);
    return contato;
  }
}

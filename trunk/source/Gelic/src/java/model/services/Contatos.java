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

  public static void excluir(int idContato) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Contatos.excluir(idContato);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }
  }

  public static void incluir(model.beans.Empresa empresa, String nomeContato,
          String ddiContato, String dddContato, String numeroTelefoneContato,
          String ramalContato) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.beans.TipoTelefone telefone = model.daos.Telefones.incluir(
              ddiContato, dddContato, numeroTelefoneContato, ramalContato);
      model.daos.Contatos.incluir(empresa, nomeContato, telefone);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }
  }

  public static model.beans.Contato recuperar(int id)
          throws SQLException, NamingException {
    model.beans.Contato contato = model.daos.Contatos.recuperar(id);
    model.daos.Telefones.recuperar(contato);
    return contato;
  }
  public static void recuperar(model.beans.Empresa empresa) 
          throws SQLException, NamingException {
    model.daos.Contatos.recuperar(empresa);
    /* recupera telefones dos contatos */
    model.daos.Telefones.recuperar(empresa);
  }
}

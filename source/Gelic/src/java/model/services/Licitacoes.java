/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Paulo
 */
public class Licitacoes {

  public static void alterar(String numeroAnterior, String novoNumero,
          int tipolicitacao, int ano, String objeto, String descricao)
          throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Licitacoes.alterar(tipolicitacao, numeroAnterior, novoNumero,
            ano, objeto, descricao) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void incluir(String numero, int tipolicitacao, int ano,
          String objeto, String descricao)
          throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Licitacoes.incluir(tipolicitacao, numero,
            ano, objeto, descricao) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  static public ArrayList<model.beans.Licitacao> recuperar()
          throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = 
            model.daos.Licitacoes.recuperar();
    model.services.TiposLicitacoes.recuperar(licitacoes);
    model.daos.Orgaos.recuperar( licitacoes );   
    model.services.Sistemas.recuperar(licitacoes);
    return licitacoes;
  }

  public static model.beans.Licitacao recuperar(String numero)
          throws SQLException, NamingException {
    return model.daos.Licitacoes.recuperar(numero);
  }
}

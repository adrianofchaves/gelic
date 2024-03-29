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
 * @author Adriano
 */
public class Sistemas {

  static ArrayList<model.beans.Sistema> sistemas = null;

  static public void alterar(String nomeAnterior, String novoNome)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Sistemas.alterar(nomeAnterior, novoNome) == 1) {
      gelic.commit();
      /* apaga cache */
      sistemas = null;
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  static public void incluir(String nome)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Sistemas.incluir(nome) == 1) {
      gelic.commit();
      /* apaga cache */
      sistemas = null;
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  static public ArrayList<model.beans.Sistema> recuperar()
          throws SQLException, NamingException {
    if (sistemas == null) {
      sistemas = model.daos.Sistemas.recuperar();
    }
    return sistemas;
  }

  static public model.beans.Sistema recuperar(String nome)
          throws SQLException, NamingException {
    if (nome == null) {
      return null;
    }
    recuperar();
    for (model.beans.Sistema sistema : sistemas) {
      if (sistema.getNome().equalsIgnoreCase(nome)) {
        return sistema;
      }
    }
    return null;
  }

  static void recuperar(ArrayList<model.beans.Licitacao> licitacoes) 
          throws SQLException, NamingException {
    recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      for (model.beans.Sistema sistema : sistemas) {
        if (licitacao.getIdSistema() == sistema.getId()) {
          licitacao.setSistema(sistema);
        }
      }
    }
  }
    public static void excluir(String nome) throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();
        try {
            model.daos.Sistemas.excluir(nome);
            sistemas = null;
            gelic.commit();
            gelic.close();
            }catch (SQLException e) {
                gelic.rollback();
                gelic.close();
                throw e;
                }
        }
}

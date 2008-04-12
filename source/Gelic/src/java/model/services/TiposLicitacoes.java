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
public class TiposLicitacoes {

  static ArrayList<model.beans.TipoLicitacao> tiposLicitacoes = null;

  public static void alterar(String nomeAnterior, String novoNome,
          String novaSigla)
          throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.TiposLicitacoes.alterar(
            nomeAnterior, novoNome, novaSigla) == 1) {
      gelic.commit();
      /* apaga cache */
      tiposLicitacoes = null;
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void incluir(String nome, String sigla)
          throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.TiposLicitacoes.incluir(nome, sigla) == 1) {
      gelic.commit();
      /* apaga cache */
      tiposLicitacoes = null;
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  static public ArrayList<model.beans.TipoLicitacao> recuperar()
          throws SQLException, NamingException {
    if (tiposLicitacoes == null) {
      tiposLicitacoes = model.daos.TiposLicitacoes.recuperar();
    }
    return tiposLicitacoes;
  }

  public static model.beans.TipoLicitacao recuperar(String nome)
          throws SQLException, NamingException {
    if (tiposLicitacoes == null) {
      recuperar();
      if (tiposLicitacoes == null) {
        return null;
      }
    }

    for (model.beans.TipoLicitacao tipo : tiposLicitacoes) {
      if (tipo.getNome().equalsIgnoreCase(nome)) {
        return tipo;
      }
    }
    return null;
  }

  static void recuperar(ArrayList<model.beans.Licitacao> licitacoes) 
          throws SQLException, NamingException {
    if (tiposLicitacoes == null) {
      recuperar();
      if (tiposLicitacoes == null) {
        return;
      }
    }
    for (model.beans.Licitacao licitacao : licitacoes) {
      for (model.beans.TipoLicitacao tipoLicitacao : tiposLicitacoes ){
        if( licitacao.getIdTipoLicitacao() == tipoLicitacao.getId()){
          licitacao.setTipoLicitacao(tipoLicitacao);
        }
      }
    }
    

  }
}

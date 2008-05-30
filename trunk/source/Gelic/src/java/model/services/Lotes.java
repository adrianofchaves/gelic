/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import model.beans.Lote;



/**
 *
 * @author Adriano
 */
public class Lotes {

  public static void alterar(Lote lote, int numero, String nome) 
          throws SQLException, NamingException {
   Connection gelic = model.services.Conexao.getConnection();
   if (model.daos.Lotes.alterar(lote, numero, nome) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void excluir(Lote lote) throws SQLException, NamingException {
   Connection gelic = model.services.Conexao.getConnection();
   if (model.daos.Lotes.excluir(lote) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void incluir(model.beans.Licitacao licitacao, int numero, 
          String nome) throws SQLException, NamingException {
   Connection gelic = model.services.Conexao.getConnection();
   if (model.daos.Lotes.incluir(licitacao, numero, nome) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }
  static public model.beans.Lote recuperar(int id) 
          throws NamingException, SQLException{
    return model.daos.Lotes.recuperar(id);
  }

  public static model.beans.Lote recuperar(model.beans.Licitacao licitacao, 
          int numeroLote) throws NamingException, SQLException {
    model.daos.Lotes.recuperar(licitacao);
    for( model.beans.Lote lote : licitacao.getMLote()){
        if( lote.getNumero() == numeroLote){
          return lote;
        }
    }
    return null;
    
  }

}

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
public class ItensLote {

  public static void alterar(model.beans.ItemLote itemLote, int numero, 
          model.beans.Produto produto, float quantidade, 
          float precoEstimado) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.ItensLote.alterar(itemLote, numero, produto,
            quantidade, precoEstimado) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void excluir(model.beans.ItemLote itemLote)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.ItensLote.excluir(itemLote) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();

  }
  

  public static void incluir(model.beans.Lote lote, int numero, 
          model.beans.Produto produto, float quantidade, 
          float precoEstimado) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.ItensLote.incluir(lote, numero, produto,
            quantidade, precoEstimado) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void recuperar(model.beans.Lote lote)
          throws NamingException, SQLException {
    model.daos.ItensLote.recuperar(lote);
    model.daos.Produtos.recuperar(lote);
  }

  public static model.beans.ItemLote recuperar(int id)
          throws NamingException, SQLException {
    model.beans.ItemLote item = model.daos.ItensLote.recuperar(id);
    item.setProduto(model.daos.Produtos.recuperar(item.getIdProduto()));

    return item;
  }

  public static model.beans.ItemLote recuperar(model.beans.Lote lote, 
          int numero) throws NamingException, SQLException {
    recuperar(lote);
    for(model.beans.ItemLote item : lote.getItensLote()){
      if(item.getNumero()==numero){
        return item;
      }     
    }
    return null;
  }
}

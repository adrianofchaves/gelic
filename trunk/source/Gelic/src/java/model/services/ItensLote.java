/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class ItensLote {
  public static void recuperar(model.beans.Lote lote) 
          throws NamingException, SQLException {
    model.daos.ItensLote.recuperar(lote);
    model.daos.Produtos.recuperar(lote);
  }
  public static model.beans.ItemLote recuperar(int id)
          throws NamingException, SQLException{
    model.beans.ItemLote item = model.daos.ItensLote.recuperar(id);
    item.setProduto(model.daos.Produtos.recuperar(item.getIdProduto()));
            
    return item;
  }
}

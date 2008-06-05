/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class Propostas {
  public static void recuperar(model.beans.Lote lote) 
          throws NamingException, SQLException{
    model.daos.ItensLote.recuperar(lote);
    model.daos.Empresas.recuperar(lote);
    model.daos.Propostas.recuperar(lote); 
    for( model.beans.EmpresaLote empresa : lote.getEmpresas()){
      for( model.beans.Proposta proposta : empresa.getPropostas() ){
        for( model.beans.ItemLote item : lote.getItensLote() ){
          if( item.getId() == proposta.getIdItemLote()){
            proposta.setItemLote(item);
          }
        }
      }
    }
    
    
    
  }

}

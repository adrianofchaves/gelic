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
 * @author adriano
 */
public class Propostas {

  public static void alterar(model.beans.Lote lote,
          model.beans.EmpresaLote empresa, float[] precos)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Propostas.excluir(lote, empresa);
      int indice = 0;
      for (float preco : precos) {
        model.daos.Propostas.incluir(lote.getItensLote().get(indice++), 
                empresa.getEmpresa(), preco);
      }

      gelic.commit();
    } catch (SQLException ex) {
      gelic.rollback();
      throw ex;
    }
    gelic.close();
  }

  public static void excluir(model.beans.Lote lote,
          model.beans.EmpresaLote empresa)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Propostas.excluir(lote, empresa);
      gelic.commit();
    } catch (SQLException ex) {
      gelic.rollback();
      throw ex;
    }
    gelic.close();
  }

  public static void incluir(model.beans.Lote lote,
          model.beans.Empresa empresa, float[] precos)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      int indice = 0;
      for (float preco : precos) {
        model.daos.Propostas.incluir(lote.getItensLote().get(indice++), 
                empresa, preco);
      }
      gelic.commit();
    } catch (SQLException ex) {
      gelic.rollback();
      throw ex;
    }
    gelic.close();
  }

  public static void recuperar(model.beans.Lote lote)
          throws NamingException, SQLException {
    model.daos.ItensLote.recuperar(lote);
    model.daos.Empresas.recuperar(lote);
    for( model.beans.EmpresaLote empresa : lote.getEmpresas()){
      model.daos.Propostas.recuperar(empresa);
    }
    for( model.beans.EmpresaLote empresa : lote.getEmpresas()){
      for( model.beans.Proposta proposta : empresa.getPropostas() ){
        for( model.beans.ItemLote item : lote.getItensLote()){
          if( item.getId() == proposta.getIdItemLote() ){
            proposta.setItemLote(item);
          }
        }
      }
    }
  }
}

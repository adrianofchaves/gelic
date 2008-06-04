/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class Propostas {

  public static void recuperar(model.beans.Lote lote) 
          throws NamingException, SQLException { 
    final String sql = "select CNPJ, ITEMLOTE, PRECOUNITARIO from PROPOSTAS " +
            " inner join ITENSLOTES on PROPOSTAS.ITEMLOTE = ITENSLOTE.ID  " +
            " and ITENSLOTE.LOTE = ?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, lote.getId());
    ResultSet rs = pstmt.executeQuery();
    HashMap<String, model.beans.LoteProposta> propostas = new HashMap<String, model.beans.LoteProposta>();
    while(rs.next()){
      String empresa = rs.getString("CNPJ");
      model.beans.Proposta proposta = new model.beans.Proposta(
              rs.getInt("ITEMLOTE"),
              rs.getFloat("PRECOUNITARIO"));
      
      if( propostas.get(empresa) == null ){
        propostas.put(empresa, new model.beans.LoteProposta(
                ));
      }
      model.beans.LoteProposta loteproposta = propostas.get(empresa);
      loteproposta.getPropostas().add(proposta);      
    }
            
    throw new UnsupportedOperationException("Not yet implemented");
  }

}

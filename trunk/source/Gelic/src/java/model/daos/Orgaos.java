/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;


/**
 *
 * @author Adriano
 */
public class Orgaos {

  public static void recuperar(ArrayList<model.beans.Licitacao> licitacoes) 
          throws SQLException, NamingException {
    final String sqlRecuperarOrgaosDeLicitacoes =  "select " +
            "LICITACOES.ID LICITACAO,  ORGAOS.CNPJ, ORGAOS.RAZAOSOCIAL, " +
            "ORGAOS.APELIDO, ORGAOS.IE, ORGAOS.ENDERECO " +
            "from  ORGAOS inner join LICITACOES on " +
            "(LICITACOES.ORGAO = ORGAOS.CNPJ)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperarOrgaosDeLicitacoes);
    ResultSet rs = pstmt.executeQuery();
    while( rs.next()){
      /* TODO: melhorar esse algoritmo incluindo uma busca em uma árvore       
       * binária.  Ele não será satisfatório se tivermos mais do que 1000 
       * licitações na lista passada 
       */
      for( model.beans.Licitacao licitacao : licitacoes ){
        if( licitacao.getId() == rs.getInt("LICITACAO")){
          licitacao.setOrgao( new model.beans.Orgao(
                  rs.getString("RAZAOSOCIAL"),
                  rs.getString("APELIDO"),
                  rs.getString("CNPJ"),
                  rs.getString("IE"),                  
                  rs.getInt("ENDERECO")));
        }
      }
    }
    rs.close();
    pstmt.close();
    gelic.close();    
  }

}

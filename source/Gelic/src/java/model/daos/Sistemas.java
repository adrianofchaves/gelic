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
public class Sistemas {

  
  

  static public int incluir(String nome)
          throws SQLException, NamingException {
    final String sqlIncluiSistema =
            "insert into SISTEMAS(NOME) values (?)";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiSistema);

    pstmt.setString(1, nome);
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  static public int alterar(String nomeAnterior, String nome)
          throws SQLException, NamingException {
    final String sqlAlteraSistema =
            "update SISTEMAS set NOME = ? where NOME = ? ";
    
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraSistema);

    pstmt.setString(1, nome);
    pstmt.setString(2, nomeAnterior);
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }
  static public model.beans.Sistema recuperar( int id )
          throws NamingException, SQLException{
    final String sqlRecuperarSistema = 
            "select ID, NOME from SISTEMAS where ID=?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarSistema);
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Sistema sistema = null;
    if(rs.next()){
      sistema = new model.beans.Sistema(
              rs.getString("nome"),
              rs.getInt("id"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return sistema;
  }
  static public ArrayList<model.beans.Sistema> recuperar()
          throws SQLException, NamingException {
    final String sqlContaModalidades = "select count(*) from SISTEMAS";
    final String sqlRecuperaSistemas = "select ID, NOME from SISTEMAS";
    
    ArrayList<model.beans.Sistema> sistemas = null;
    PreparedStatement pstmt;
    int quantidadeSistemas = 0;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaModalidades);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeSistemas = rs.getInt(1);
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      rs.close();
      pstmt.close();
    }
    if (quantidadeSistemas < 1) {
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      gelic.close();
      return null;
    }


    /* Carrega usuários */
    pstmt = gelic.prepareStatement(sqlRecuperaSistemas);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      if (sistemas == null) {
        sistemas = new ArrayList<model.beans.Sistema>(
                quantidadeSistemas);
      }

      sistemas.add(new model.beans.Sistema(rs.getString("NOME"),
              rs.getInt("ID")));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();

    return sistemas;
  }

  public static int excluir(String nome) throws SQLException, NamingException {
    final String sqlExcluiSistema = "delete from SISTEMAS where NOME = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluiSistema);
    pstmt.setString(1, nome);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
}

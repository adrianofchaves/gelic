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
public class ItensLote {

  public static int alterar(model.beans.ItemLote itemLote, int numero, 
          model.beans.Produto produto, float quantidade, float precoEstimado) 
          throws SQLException, NamingException {
    final String sql = "update ITENSLOTE set NUMERO=?, QUANTIDADE=?, " +
            "PRECOESTIMADO=?, PRODUTO=? where ID=?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, numero);
    pstmt.setFloat(2, quantidade);
    pstmt.setFloat(3, precoEstimado);
    pstmt.setInt(4, produto.getId());
    pstmt.setInt(5, itemLote.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int excluir(model.beans.ItemLote itemLote) 
          throws SQLException, NamingException {
    final String sql = "delete from ITENSLOTE where ID = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, itemLote.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
  private static int getNextID() throws SQLException, NamingException{
    final String sql = "select gen_id(GEN_ITENSLOTE_ID, 1) from rdb$database";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    int buffer = rs.getInt(1);
    rs.close();
    pstmt.close();
    return buffer;
  }
  public static int incluir(model.beans.Lote lote, int numero, 
          model.beans.Produto produto, float quantidade, float precoEstimado) 
          throws SQLException, NamingException {
    final String sql = "insert into ITENSLOTE(ID, NUMERO, QUANTIDADE, " +
            "PRECOESTIMADO, PRODUTO, LOTE) values (?, ?,?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1,  getNextID());
    pstmt.setInt(2, numero);
    pstmt.setFloat(3, quantidade);
    pstmt.setFloat(4, precoEstimado);
    pstmt.setInt(5, produto.getId());
    pstmt.setInt(6, lote.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static model.beans.ItemLote recuperar(int id)
          throws NamingException, SQLException {
    final String sql = "select ITENSLOTE.ID, ITENSLOTE.NUMERO, " +
            " ITENSLOTE.QUANTIDADE, ITENSLOTE.PRECOESTIMADO, " +
            " ITENSLOTE.PRECOPROPOSTO, ITENSLOTE.PRECOCOMPRA," +
            " ITENSLOTE.PRODUTO, ITENSLOTE.LOTE " +
            "from ITENSLOTE where ID = ?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    model.beans.ItemLote itemLote = null;
    if(rs.next()){
      itemLote = new model.beans.ItemLote(
                  rs.getInt("ID"),
                  rs.getInt("NUMERO"),
                  rs.getFloat("QUANTIDADE"),
                  rs.getFloat("PRECOESTIMADO"),
                  rs.getFloat("PRECOPROPOSTO"),
                  rs.getFloat("PRECOCOMPRA"),
                  rs.getInt("PRODUTO"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return itemLote;
  }

  public static void recuperar(model.beans.Licitacao licitacao)
          throws NamingException, SQLException {
    final String sql = "select ITENSLOTE.ID, ITENSLOTE.NUMERO, " +
            " ITENSLOTE.QUANTIDADE, ITENSLOTE.PRECOESTIMADO, " +
            " ITENSLOTE.PRECOPROPOSTO, ITENSLOTE.PRECOCOMPRA," +
            " ITENSLOTE.PRODUTO, ITENSLOTE.LOTE " +
            "from ITENSLOTE inner join LOTES on " +
            "(ITENSLOTE.LOTE = LOTES.ID) and (LOTES.LICITACAO = ?)";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, licitacao.getId());
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      for (model.beans.Lote lote : licitacao.getMLote()) {
        if (lote.getId() == rs.getInt("LOTE")) {
          if (lote.getItensLote() == null) {
            lote.setItensLote(new ArrayList<model.beans.ItemLote>(10));
          }
          lote.getItensLote().add(new model.beans.ItemLote(
                  rs.getInt("ID"),
                  rs.getInt("NUMERO"),
                  rs.getFloat("QUANTIDADE"),
                  rs.getFloat("PRECOESTIMADO"),
                  rs.getFloat("PRECOPROPOSTO"),
                  rs.getFloat("PRECOCOMPRA"),
                  rs.getInt("PRODUTO")));
        }
      }
    }
    rs.close();
    pstmt.close();
    gelic.close();
  }

  public static void recuperar(model.beans.Lote lote)
          throws NamingException, SQLException {
    final String sql = "select ID, NUMERO, QUANTIDADE, PRECOESTIMADO, " +
            "PRECOPROPOSTO, PRECOCOMPRA, PRODUTO, LOTE " +
            "from ITENSLOTE where LOTE=?";
    final String sqlConta = "select count(*) from ITENSLOTE where LOTE=?";
    Connection gelic = model.services.Conexao.getPool().getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlConta);
    pstmt.setInt(1, lote.getId());
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    lote.setItensLote(new ArrayList<model.beans.ItemLote>(rs.getInt(1)));
    rs.close();
    pstmt.close();

    pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, lote.getId());
    rs = pstmt.executeQuery();
    while (rs.next()) {
      lote.getItensLote().add(new model.beans.ItemLote(
              rs.getInt("ID"),
              rs.getInt("NUMERO"),
              rs.getFloat("QUANTIDADE"),
              rs.getFloat("PRECOESTIMADO"),
              rs.getFloat("PRECOPROPOSTO"),
              rs.getFloat("PRECOCOMPRA"),
              rs.getInt("PRODUTO")));
    }
    rs.close();
    pstmt.close();
    gelic.close();
  }
}

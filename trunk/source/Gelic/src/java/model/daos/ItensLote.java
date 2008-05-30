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
import model.beans.ItemLote;

/**
 *
 * @author Adriano
 */
public class ItensLote {

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
            lote.setItensLote(new ArrayList<ItemLote>(10));
          }
          lote.getItensLote().add(new ItemLote(
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

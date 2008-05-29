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
public class Lotes {

  public static model.beans.Lote recuperar(int id)
          throws NamingException, SQLException {
    final String sql = "select ID, NUMERO, NOME, LICITACAO, " +
            "ASSINATURACONTRATO, NUMEROCONTRATO " +
            "from LOTES where ID =?";
    Connection gelic = model.services.Conexao.getPool().getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    if (!rs.next()) {
      return null;
    }
    model.beans.Lote lote = new model.beans.Lote(
            rs.getInt("ID"), rs.getString("NUMEROCONTRATO"),
            rs.getString("NOME"),
            rs.getDate("ASSINATURACONTRATO"),
            rs.getInt("NUMERO"));
    rs.close();
    pstmt.close();
    gelic.close();
    return lote;
  }

  public static void recuperar(model.beans.Licitacao licitacao)
          throws NamingException, SQLException {
    final String sqlContar = "select count(*) from LOTES where LICITACAO=?";
    final String sqlrecuperar = "select ID, NUMERO, NOME, LICITACAO, " +
            "ASSINATURACONTRATO, NUMEROCONTRATO from LOTES where LICITACAO=?";
    Connection gelic = model.services.Conexao.getPool().getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlContar);
    pstmt.setInt(1, licitacao.getId());
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    licitacao.setMLote(new ArrayList<model.beans.Lote>(rs.getInt(1)));
    rs.close();
    pstmt.close();

    pstmt = gelic.prepareStatement(sqlrecuperar);
    pstmt.setInt(1, licitacao.getId());
    rs = pstmt.executeQuery();
    while (rs.next()) {
      licitacao.getMLote().add(new model.beans.Lote(
              rs.getInt("ID"), rs.getString("NUMEROCONTRATO"),
              rs.getString("NOME"),
              rs.getDate("ASSINATURACONTRATO"),
              rs.getInt("NUMERO")));
    }
    rs.close();
    pstmt.close();
    gelic.close();
  }
}

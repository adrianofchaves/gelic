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
public class UFs {

  static public ArrayList<String> recuperar()
          throws NamingException, SQLException {
    final String sqlContaUFs = "select  count(*) from UFS";
    final String sqlRecuperaUFs = "select  UF from UFS";


    ArrayList<String> ufs = null;
    PreparedStatement pstmt;
    ResultSet rs;
    Connection gelic = model.services.Conexao.getPool().getConnection();
    int quantidadeUFs = 0;
    pstmt = gelic.prepareStatement(sqlContaUFs);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeUFs = rs.getInt(1);
      rs.close();
    }
    pstmt.close();
    if (quantidadeUFs < 1) {
      gelic.close();
      return null;
    }
    pstmt = gelic.prepareStatement(sqlRecuperaUFs);
    rs = pstmt.executeQuery();
    ufs = new ArrayList<String>(quantidadeUFs);
    while (rs.next()) {
      ufs.add(rs.getString(1));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return ufs;
  }
}

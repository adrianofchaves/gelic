/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class EmpresasLotes {

  public static int incluir(model.beans.Lote lote,
          model.beans.Empresa empresa) throws SQLException, NamingException {
    final String sql = "insert into EMPRESASLOTES(EMPRESA,LOTE) values (?,?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setString(1, empresa.getCnpj());
    pstmt.setInt(2, lote.getId());    
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;

  }
}

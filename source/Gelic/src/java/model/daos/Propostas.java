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
 * @author adriano
 */
public class Propostas {

  public static int excluir(model.beans.Lote lote,
          model.beans.EmpresaLote empresa) 
          throws SQLException, NamingException {
    final String sqlEmpresaLote =
            "delete from EMPRESASLOTES where empresa = ? and lote = ?";
    final String sqlProposta =
            "delete from PROPOSTAS where empresa = ? and lote = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlEmpresaLote);
    pstmt.setString(1, empresa.getIdEmpresa());
    pstmt.setInt(2, lote.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    pstmt = gelic.prepareStatement(sqlProposta);
    buffer += pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int incluir(model.beans.Lote lote,
          model.beans.EmpresaLote empresa) 
          throws SQLException, NamingException {
    final String sql = "insert into EMPRESASLOTES(EMPRESA,LOTE) values (?,?)";
    Connection gelic = model.services.Conexao.getConnection();    
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setString(1, empresa.getIdEmpresa());
    pstmt.setInt(2, lote.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int incluir(model.beans.ItemLote itemLote,
          model.beans.Empresa empresa, float preco) 
          throws SQLException, NamingException {
    final String sql = "insert into PROPOSTAS(CNPJ, ITEMLOTE, PRECOUNITARIO) " +
            "values (?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();    
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setString(1, empresa.getCnpj());
    pstmt.setInt(2, itemLote.getId());
    pstmt.setFloat(3, preco);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static void recuperar(model.beans.Lote lote)
          throws NamingException, SQLException {
    final String sql = "select CNPJ, ITEMLOTE, PRECOUNITARIO from PROPOSTAS " +
            " inner join ITENSLOTE on PROPOSTAS.ITEMLOTE = ITENSLOTE.ID  " +
            " and ITENSLOTE.LOTE = ?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, lote.getId());
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      String cnpj = rs.getString("CNPJ");
      model.beans.Proposta proposta = new model.beans.Proposta(
              rs.getInt("ITEMLOTE"),
              rs.getFloat("PRECOUNITARIO"));
      for (model.beans.EmpresaLote empresa : lote.getEmpresas()) {
        if (empresa.getEmpresa().getCnpj().equals(cnpj)) {
          if (empresa.getPropostas() == null) {
            empresa.setPropostas(new ArrayList<model.beans.Proposta>());
          }
          empresa.getPropostas().add(proposta);
        }
      }
    }
  }
}

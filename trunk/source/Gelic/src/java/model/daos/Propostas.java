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

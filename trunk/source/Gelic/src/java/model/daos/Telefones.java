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
public class Telefones {

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws SQLException, NamingException {
    for (model.beans.Empresa empresa : empresas) {
      recuperar(empresa);
    }
  }
  static final String sqlRecuperaTelefoneEmpresa = "select DDI, DDD, TELEFONE, " +
          "RAMAL from  telefones  inner join enderecos on " +
          "(enderecos.telefone = telefones.id) inner join empresas on  " +
          "(empresas.endereco = enderecos.id) where empresas.cnpj=?";

  protected static void recuperar(model.beans.Empresa empresa)
          throws NamingException, SQLException {
    if( empresa.getEndereco() == null){
      return;
    }
    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaTelefoneEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if (rs != null) {
      empresa.getEndereco().setTelefone(criaTelefone(
              rs.getString("DDI"),
              rs.getString("DDD"),
              rs.getString("TELEFONE"),
              rs.getString("RAMAL")));
    }
  }

  static model.beans.TipoTelefone criaTelefone(String ddi, String ddd,
          String numero, String ramal) {
    model.beans.TipoTelefone telefone = new model.beans.TipoTelefone();
    telefone.setDdd(ddd);
    telefone.setDdi(ddi);
    telefone.setTelefone(numero);
    telefone.setRamal(ramal);
    return telefone;
  }
}

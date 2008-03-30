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
public class Empresas {

  final static String sqlRecuperaEmpresas =
          "select  CNPJ, IE, IM, RAZAOSOCIAL, NOMEFANTASIA, " +
          "EPORTADOR, EFORNECEDOR from EMPRESAS";
  final static String sqlContaEmpresas = "select  count(*) from EMPRESAS";

  public static ArrayList<model.beans.Empresa> recuperar()
          throws NamingException, SQLException {
    ArrayList<model.beans.Empresa> empresas = null;
    PreparedStatement pstmt;
    int quantidadeEmpresas;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaEmpresas);
    rs = pstmt.executeQuery();
    if (rs == null) {
      return null;
    }
    if (!rs.next()) {
      return null;
    }
    quantidadeEmpresas = rs.getInt(1);
    // rs.close(); precisa?
    pstmt.close(); //precisa?

    /* Carrega usuários */
    pstmt = gelic.prepareStatement(sqlRecuperaEmpresas);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      if (empresas == null) {
        empresas = new ArrayList<model.beans.Empresa>(quantidadeEmpresas);
      }

      empresas.add(criaEmpresa(
              rs.getString("CNPJ"),
              rs.getString("IE"),
              rs.getString("IM"),
              rs.getString("RAZAOSOCIAL"),
              rs.getString("NOMEFANTASIA"),
              rs.getString("EPORTADOR"),
              rs.getString("EFORNECEDOR")));
    }
    return empresas;
  }

  private static model.beans.Empresa criaEmpresa(String cnpj, String ie,
          String im, String razaoSocial, String nomeFantasia, String ePortador,
          String eFornecedor) {

    model.beans.Empresa empresa = new model.beans.Empresa();
    empresa.setCnpj(cnpj);
    empresa.setIe(ie);
    empresa.setIm(im);
    empresa.setRazaoSocial(razaoSocial);
    empresa.setNomeFantasia(nomeFantasia);
    if (eFornecedor != null && eFornecedor.equalsIgnoreCase("s")) {
      empresa.setEFornecedor(true);
    } else {
      empresa.setEFornecedor(false);
    }
    if (ePortador != null && ePortador.equalsIgnoreCase("s")) {
      empresa.setEPortador(true);
    } else {
      empresa.setEPortador(false);
    }
    return empresa;
  }
}

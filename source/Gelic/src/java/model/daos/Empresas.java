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

  public static int alterar(String cnpj, String nomeFantasiaEmpresa,
          boolean ePortadorEmpresa, String razaoSocialEmpresa,
          boolean eFornecedorEmpresa, String cnpjEmpresa, String ieEmpresa,
          String imEmpresa) throws SQLException, NamingException {
    final String sqlAlterar = "update EMPRESAS set CNPJ = ?, IE = ?, IM = ?, " +
            "RAZAOSOCIAL = ?, NOMEFANTASIA = ?, EPORTADOR = ?, " +
            "EFORNECEDOR = ?  where CNPJ = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlterar);

    pstmt.setString(1, cnpjEmpresa);
    pstmt.setString(2, ieEmpresa);
    pstmt.setString(3, imEmpresa);
    pstmt.setString(4, razaoSocialEmpresa);
    pstmt.setString(5, nomeFantasiaEmpresa);
    if (ePortadorEmpresa) {
      pstmt.setString(6, "S");
    } else {
      pstmt.setString(6, "N");
    }
    if (eFornecedorEmpresa) {
      pstmt.setString(7, "S");
    } else {
      pstmt.setString(7, "N");
    }

    pstmt.setString(8, cnpj);

    int regs = pstmt.executeUpdate();
    pstmt.close();
    return regs;
  }

  public static int excluir(String cnpj) throws SQLException, NamingException {
    final String sqlExcluiEmpresa = "delete from EMPRESAS where CNPJ = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluiEmpresa);
    pstmt.setString(1, cnpj);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int incluir(String nomeFantasiaEmpresa,
          boolean ePortadorEmpresa, String razaoSocialEmpresa,
          boolean eFornecedorEmpresa, String cnpjEmpresa, String ieEmpresa,
          String imEmpresa, model.beans.TipoEndereco end)
          throws SQLException, NamingException {
    final String sqlIncluir = "insert into EMPRESAS(CNPJ, IE, IM, " +
            "RAZAOSOCIAL, NOMEFANTASIA, EPORTADOR, EFORNECEDOR, ENDERECO) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluir);

    pstmt.setString(1, cnpjEmpresa);
    pstmt.setString(2, ieEmpresa);
    pstmt.setString(3, imEmpresa);
    pstmt.setString(4, razaoSocialEmpresa);
    pstmt.setString(5, nomeFantasiaEmpresa);
    if (ePortadorEmpresa) {
      pstmt.setString(6, "S");
    } else {
      pstmt.setString(6, "N");
    }
    if (eFornecedorEmpresa) {
      pstmt.setString(7, "S");
    } else {
      pstmt.setString(7, "N");
    }
    pstmt.setInt(8, end.getId());

    int regs = pstmt.executeUpdate();

    pstmt.close();
    return regs;
  }

  public static ArrayList<model.beans.Empresa> recuperar()
          throws NamingException, SQLException {
    final String sqlRecuperaEmpresas =
            "select  CNPJ, IE, IM, RAZAOSOCIAL, NOMEFANTASIA, " +
            "EPORTADOR, EFORNECEDOR from EMPRESAS";
    final String sqlContaEmpresas = "select  count(*) from EMPRESAS";
    ArrayList<model.beans.Empresa> empresas = null;
    PreparedStatement pstmt;
    int quantidadeEmpresas;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaEmpresas);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeEmpresas = rs.getInt(1);
    } else {
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      rs.close();
      pstmt.close();
      gelic.close();
      return null;
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();

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
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();
    return empresas;
  }
  static final String sqlRecuperaEmpresa =
          "select CNPJ, IE, IM, RAZAOSOCIAL, NOMEFANTASIA, EPORTADOR, " +
          "EFORNECEDOR from empresas where CNPJ = ?";

  public static void recuperar(model.beans.Lote lote)
          throws NamingException, SQLException {
    final String sqlConta = "select count(*) from EMPRESASLOTES where LOTE = ?";

    final String sql = "select LOTE, EMPRESA, CNPJ, IE, IM, RAZAOSOCIAL, " +
            " NOMEFANTASIA, EPORTADOR, EFORNECEDOR from EMPRESAS " +
            " inner join EMPRESASLOTES " +
            " on (EMPRESASLOTES.LOTE = ?) and " +
            " (EMPRESAS.CNPJ = EMPRESASLOTES.EMPRESA)";

    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlConta);
    pstmt.setInt(1, lote.getId());
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    lote.setEmpresas(new ArrayList<model.beans.EmpresaLote>(rs.getInt(1)));
    rs.close();
    pstmt.close();
    pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, lote.getId());
    rs = pstmt.executeQuery();
    while (rs.next()) {
      lote.getEmpresas().add( new model.beans.EmpresaLote( lote, 
              criaEmpresa(
              rs.getString("CNPJ"),
              rs.getString("IE"),
              rs.getString("IM"),
              rs.getString("RAZAOSOCIAL"),
              rs.getString("NOMEFANTASIA"),
              rs.getString("EPORTADOR"),
              rs.getString("EFORNECEDOR"))));
    }


  }

  public static model.beans.Empresa recuperar(String cnpj)
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperaEmpresa);
    pstmt.setString(1, cnpj);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Empresa empresa = null;
    if (rs != null && rs.next()) {
      empresa = criaEmpresa(
              rs.getString("CNPJ"),
              rs.getString("IE"),
              rs.getString("IM"),
              rs.getString("RAZAOSOCIAL"),
              rs.getString("NOMEFANTASIA"),
              rs.getString("EPORTADOR"),
              rs.getString("EFORNECEDOR"));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */

    rs.close();
    pstmt.close();
    gelic.close();
    return empresa;
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

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
import model.beans.Orgao;

/**
 *
 * @author Adriano
 */
public class Orgaos {

  public static int alterar(Orgao orgao, String cnpj, String razaoSocial, 
          String apelido, String ie) throws SQLException, NamingException {
    final String sqlAlterar = "update ORGAOS set " +
            "CNPJ = ?, RAZAOSOCIAL = ?, APELIDO = ?, IE = ? " +
            "where CNPJ = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlterar);
    pstmt.setString(1, cnpj);
    pstmt.setString(2, razaoSocial);
    pstmt.setString(3, apelido);
    pstmt.setString(4, ie);
    pstmt.setString(5, orgao.getCnpj());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int excluir(String cnpj) throws SQLException, NamingException {
    final String sqlExcluir = "delete from ORGAOS where CNPJ=?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluir);
    pstmt.setString(1, cnpj);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static int incluir(String cnpj, String razaoSocial, String apelido, 
          String ie, model.beans.TipoEndereco end) 
          throws SQLException, NamingException {
    final String sqlIncluiOrgao = "insert into " +
            "ORGAOS(CNPJ, RAZAOSOCIAL, APELIDO, IE, ENDERECO) " +
            "values " +
            "(?,?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiOrgao);
    pstmt.setString(1, cnpj);
    pstmt.setString(2, razaoSocial);
    pstmt.setString(3, apelido);
    pstmt.setString(4, ie);
    pstmt.setInt(5, end.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;    
  }

  public static ArrayList<model.beans.Orgao> recuperar()
          throws NamingException, SQLException {

    final String sqlRecuperarOrgaos = "select CNPJ, RAZAOSOCIAL, APELIDO, " +
            "IE, ENDERECO from ORGAOS";
    final String sqlContaOrgaos = "select count(*) from ORGAOS";

    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlContaOrgaos);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    int quantidadeOrgaos = rs.getInt(1);
    rs.close();
    pstmt.close();
    pstmt = gelic.prepareStatement(sqlRecuperarOrgaos);
    rs = pstmt.executeQuery();
    ArrayList<model.beans.Orgao> orgaos = null;
    while (rs.next()) {
      if (orgaos == null) {
        orgaos = new ArrayList<model.beans.Orgao>(quantidadeOrgaos);
      }
      orgaos.add(new model.beans.Orgao(
              rs.getString("RAZAOSOCIAL"),
              rs.getString("APELIDO"),
              rs.getString("CNPJ"),
              rs.getString("IE"),
              rs.getInt("ENDERECO")));
    }
    gelic.close();
    return orgaos;
  }

  public static void recuperar(ArrayList<model.beans.Licitacao> licitacoes)
          throws SQLException, NamingException {
    final String sqlRecuperarOrgaosDeLicitacoes = "select " +
            "LICITACOES.ID LICITACAO,  ORGAOS.CNPJ, ORGAOS.RAZAOSOCIAL, " +
            "ORGAOS.APELIDO, ORGAOS.IE, ORGAOS.ENDERECO " +
            "from  ORGAOS inner join LICITACOES on " +
            "(LICITACOES.ORGAO = ORGAOS.CNPJ)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperarOrgaosDeLicitacoes);
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      /* TODO: melhorar esse algoritmo incluindo uma busca em uma árvore       
       * binária.  Ele não será satisfatório se tivermos mais do que 1000 
       * licitações na lista passada 
       */
      for (model.beans.Licitacao licitacao : licitacoes) {
        if (licitacao.getId() == rs.getInt("LICITACAO")) {
          licitacao.setOrgao(new model.beans.Orgao(
                  rs.getString("RAZAOSOCIAL"),
                  rs.getString("APELIDO"),
                  rs.getString("CNPJ"),
                  rs.getString("IE"),
                  rs.getInt("ENDERECO")));
        }
      }
    }
    rs.close();
    pstmt.close();
    gelic.close();
  }

  public static model.beans.Orgao recuperar(String cnpj)
          throws NamingException, SQLException {
    final String sqlRecuperarOrgao = "select CNPJ, RAZAOSOCIAL, APELIDO, " +
            "IE, ENDERECO from ORGAOS where CNPJ = ?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarOrgao);
    pstmt.setString(1, cnpj);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
      return new model.beans.Orgao(rs.getString("RAZAOSOCIAL"),
              rs.getString("APELIDO"),
              rs.getString("CNPJ"),
              rs.getString("IE"),
              rs.getInt("ENDERECO"));
    }
    return null;
  }
}

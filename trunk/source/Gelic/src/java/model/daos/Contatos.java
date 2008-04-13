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
import java.util.HashMap;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class Contatos {

  public static int alterar(model.beans.Contato contato, String nomeContato)
          throws SQLException, NamingException {
    final String sqlAlteraContato = "update CONTATOS set NOME=? where ID=?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraContato);
    pstmt.setString(1, nomeContato);
    pstmt.setInt(2, contato.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static model.beans.Contato recuperar(int id)
          throws SQLException, NamingException {
    final String sqlRecuperarContato =
            "select ID, NOME, TELEFONE from CONTATOS where ID=?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarContato);
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Contato contato = null;
    if (rs.next()) {
      contato = new model.beans.Contato(
              rs.getString("NOME"),
              rs.getInt("TELEFONE"),
              rs.getInt("ID"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return contato;
  }

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws NamingException, SQLException {

    final String sqlRecuperarContatosEmpresas =
            "select  EMPRESA, NOME, ID, TELEFONE from  contatos   " +
            "inner join empresas on   (contatos.empresa = empresas.cnpj)";
    /* Para otimizar a busca, reorganiza as empresas em um HashMap */
    HashMap<String, model.beans.Empresa> map;
    map = new HashMap<String, model.beans.Empresa>();
    for (model.beans.Empresa empresa : empresas) {
      map.put(empresa.getCnpj(), empresa);
    }

    model.beans.Empresa empresa;
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperarContatosEmpresas);
    ResultSet rs = pstmt.executeQuery();

    while (rs.next()) {
      empresa = map.get(rs.getString("EMPRESA"));
      if (empresa != null) {
        if (empresa.getContatos() == null) {
          empresa.setContatos(new ArrayList<model.beans.Contato>());
        }
        empresa.getContatos().add(new model.beans.Contato(
                rs.getString("NOME"),
                rs.getInt("TELEFONE"),
                rs.getInt("ID")));
      }
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */

    rs.close();

    pstmt.close();

    gelic.close();
  }

  public static void recuperar(model.beans.Empresa empresa)
          throws SQLException, NamingException {
    final String sqlRecuperaContatosEmpresa =
            "select ID, NOME, TELEFONE from CONTATOS where EMPRESA = ? ";
    final String sqlContaContatosEmpresa =
            "select count(*) from CONTATOS where EMPRESA = ? ";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlContaContatosEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if (rs == null) {
      return;
    }

    if (!rs.next()) {
      return;
    }

    int quantidadeContatos = rs.getInt(1);
    ArrayList<model.beans.Contato> contatos =
            new ArrayList<model.beans.Contato>(quantidadeContatos);

    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();

    pstmt =
            gelic.prepareStatement(sqlRecuperaContatosEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    rs =
            pstmt.executeQuery();
    while (rs.next()) {
      contatos.add(new model.beans.Contato(
              rs.getString("NOME"),
              rs.getInt("TELEFONE"),
              rs.getInt("ID")));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();
    empresa.setContatos(contatos);

  }
}



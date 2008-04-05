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
import model.beans.Empresa;

/**
 *
 * @author Adriano
 */
public class Telefones {

  public static int alterar(Empresa empresa, String ddiEmpresa, 
          String dddEmpresa, String numeroTelefoneEmpresa, String ramalEmpresa) 
          throws SQLException, NamingException {
    final String sqlAlterarTelefoneEmpresa = 
            "update TELEFONES set " +
            "DDI = ?, " +
            "DDD = ?, " +
            "NUMERO = ?, " +
            "RAMAL = ? " +
            "where ID = (select TELEFONE from ENDERECOS where ID = " +
            " (select ENDERECO from EMPRESAS where CNPJ = ? ) )";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlterarTelefoneEmpresa);
    
    pstmt.setString(1, ddiEmpresa);
    pstmt.setString(2, dddEmpresa);
    pstmt.setString(3, numeroTelefoneEmpresa);
    pstmt.setString(3, ramalEmpresa);
    
    pstmt.setString(4, empresa.getCnpj());
    
    int regs = pstmt.executeUpdate();
    pstmt.close();
    return regs;    
  }

  public static model.beans.TipoTelefone incluir(String ddi, 
          String ddd, String numero, String ramal) 
          throws SQLException, NamingException {
    final String sqlCalculaId =
            "select gen_id(GEN_TELEFONES_ID, 1) from rdb$database";
    final String sqlIncluiEndereco = 
            "insert into TELEFONES( ID, DDI, DDD, NUMERO, RAMAL) " +    
            "values (?,?,?,?,?)";
    
    Connection gelic = model.services.Conexao.getConnection();
    
    model.beans.TipoTelefone tel = new model.beans.TipoTelefone();
    tel.setDdd(ddd);
    tel.setDdi(ddi);
    tel.setTelefone(numero);
    tel.setRamal(ramal);    
    
    PreparedStatement pstmt = gelic.prepareStatement(sqlCalculaId);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    tel.setId(rs.getInt(1));
    rs.close();
    pstmt.close();
    
    pstmt = gelic.prepareStatement(sqlIncluiEndereco);
    pstmt.setInt(1, tel.getId());
    pstmt.setString(2, tel.getDdi());
    pstmt.setString(3, tel.getDdd());
    pstmt.setString(4, tel.getTelefone());
    pstmt.setString(5, tel.getRamal());
    
    pstmt.execute();    
    pstmt.close();
    
    return tel;
  }

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws SQLException, NamingException {
    final String sqlRecuperarTelefonesEmpresas =
            "select " +
            " CNPJ, CONTATOS.NOME NOMECONTATO, TELEFONES.DDI DDI, " +
            " TELEFONES.DDD DDD, " +
            " TELEFONES.NUMERO NUMEROTELEFONE, TELEFONES.RAMAL RAMAL " +
            "from " +
            " EMPRESAS " +
            " left outer join CONTATOS  on (CONTATOS.EMPRESA = EMPRESAS.CNPJ) " +
            " inner join TELEFONES on (TELEFONES.ID = CONTATOS.TELEFONE) " +
            "union " +
            "select " +
            " CNPJ, null, TELEFONES.DDI, TELEFONES.DDD, TELEFONES.NUMERO, " +
            " TELEFONES.RAMAL " +
            "from " +
            " EMPRESAS " +
            " inner join ENDERECOS on (EMPRESAS.ENDERECO = ENDERECOS.ID) " +
            " inner join TELEFONES on (ENDERECOS.TELEFONE = TELEFONES.ID) ";

    /* Para otimizar a busca, reorganiza as empresas em HashMaps */
    HashMap<String, model.beans.Empresa> mapEmpresas;
    mapEmpresas = new HashMap<String, model.beans.Empresa>();
    HashMap<String, model.beans.Contato> mapContatos;
    mapContatos = new HashMap<String, model.beans.Contato>();

    for (model.beans.Empresa empresa : empresas) {
      mapEmpresas.put(empresa.getCnpj(), empresa);
      if (empresa.getContatos() != null) {
        for (model.beans.Contato contato : empresa.getContatos()) {
          mapContatos.put(empresa.getCnpj() + contato.getNome(), contato);
        }
      }
    }

    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperarTelefonesEmpresas);
    ResultSet rs = pstmt.executeQuery();
    String cnpj;
    String nomeContato;
    model.beans.Empresa empresa;
    model.beans.TipoEndereco endereco;
    model.beans.Contato contato;

    while (rs != null && rs.next()) {
      model.beans.TipoTelefone telefone = criaTelefone(
              rs.getString("DDI"),
              rs.getString("DDD"),
              rs.getString("NUMEROTELEFONE"),
              rs.getString("RAMAL"));

      cnpj = rs.getString("CNPJ");
      nomeContato = rs.getString("NOMECONTATO");

      if (nomeContato == null || nomeContato.isEmpty()) {
        // telefone da empresa.
        empresa = mapEmpresas.get(cnpj);
        if (empresa != null) {
          endereco = empresa.getEndereco();
        } else {
          endereco = null;
        }

        if (endereco != null) {
          endereco.setTelefone(telefone);
        }


      } else {
        // telefone de um contato
        contato = mapContatos.get(cnpj + nomeContato);
        if (contato != null) {
          contato.setTelefone(telefone);
        }
      }
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();
  }
  static final String sqlRecuperaTelefoneEmpresa =
          "select DDI, DDD, TELEFONE, " +
          "RAMAL from  telefones  inner join enderecos on " +
          "(enderecos.telefone = telefones.id) inner join empresas on  " +
          "(empresas.endereco = enderecos.id) where empresas.cnpj=?";

  public static void recuperar(model.beans.Empresa empresa)
          throws NamingException, SQLException {
    if (empresa.getEndereco() == null) {
      return;
    }
    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaTelefoneEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      empresa.getEndereco().setTelefone(criaTelefone(
              rs.getString("DDI"),
              rs.getString("DDD"),
              rs.getString("TELEFONE"),
              rs.getString("RAMAL")));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();
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

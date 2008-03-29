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
public class Telefones {

  static final String sqlRecuperarTelefonesEmpresas =
          "select " +
          " CNPJ, CONTATOS.NOME, TELEFONES.DDI, TELEFONES.DDD, " +
          " TELEFONES.NUMERO, TELEFONES.RAMAL " +
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

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws SQLException, NamingException {

    /* Para otimizar a busca, reorganiza as empresas em HashMaps */
    HashMap<String, model.beans.Empresa> mapEmpresas;
    mapEmpresas = new HashMap<String, model.beans.Empresa>();
    HashMap<String, model.beans.Contato> mapContatos;
    mapContatos = new HashMap<String, model.beans.Contato>();

    for (model.beans.Empresa empresa : empresas) {
      mapEmpresas.put(empresa.getCnpj(), empresa);
      for (model.beans.Contato contato : empresa.getContatos()) {
        mapContatos.put(empresa.getCnpj() + contato.getNome(), contato);
      }
    }
    
    Connection gelic = model.services.Conexao.getPool().getConnection();
   // PreparedStatement pstmt = gelic.prepareStatement(
  }
  static final String sqlRecuperaTelefoneEmpresa = 
          "select DDI, DDD, TELEFONE, " +
          "RAMAL from  telefones  inner join enderecos on " +
          "(enderecos.telefone = telefones.id) inner join empresas on  " +
          "(empresas.endereco = enderecos.id) where empresas.cnpj=?";

  protected static void recuperar(model.beans.Empresa empresa)
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

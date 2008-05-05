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

  public static int incluir(model.beans.Orgao orgao, String nomeContato, 
          model.beans.TipoTelefone telefone) 
          throws SQLException, NamingException {
    final String sqlIncluirContatoEmpresa = "insert into " +
            "CONTATOS(ID, NOME, TELEFONE, ORGAO) values (?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluirContatoEmpresa);
    pstmt.setInt(1, getNextID());
    pstmt.setString(2, nomeContato);
    pstmt.setInt(3, telefone.getId());
    pstmt.setString(4, orgao.getCnpj());

    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }

  public static void recuperar(model.beans.Orgao orgao) 
          throws NamingException, SQLException {
    final String sqlContaContatosOrgao = 
            "select count(*) from CONTATOS where ORGAO = ?";
    final String sqlRecuperaContatosOrgao =
            "select  ORGAO, ID, NOME, TELEFONE " +
            "from  CONTATOS where ORGAO = ?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlContaContatosOrgao);
    pstmt.setString(1, orgao.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if(!rs.next()){
      return;
    }
    int quantidadeContatos = rs.getInt(1);
    rs.close();
    pstmt.close();
    pstmt = gelic.prepareStatement(sqlRecuperaContatosOrgao);
    pstmt.setString(1, orgao.getCnpj());
    rs = pstmt.executeQuery();
    orgao.setContatos(new ArrayList<model.beans.Contato>(quantidadeContatos));
    while(rs.next()){
      orgao.getContatos().add(new model.beans.Contato(
              rs.getString("NOME"),
              rs.getInt("TELEFONE"), 
              rs.getInt("ID")));      
    }    
  }

  public static void recuperarDeOrgaos(ArrayList<model.beans.Orgao> orgaos)
          throws NamingException, SQLException {

    HashMap<String, model.beans.Orgao> mOrgaos =
            new HashMap<String, model.beans.Orgao>(orgaos.size());
    for (model.beans.Orgao orgao : orgaos) {
      mOrgaos.put(orgao.getCnpj(), orgao);
    }

    final String sqlRecuperaContatosOrgaos =
            "select  ORGAO, ID, NOME, TELEFONE " +
            "from  " +
            "CONTATOS inner join ORGAOS on (ORGAOS.CNPJ = CONTATOS.ORGAO)";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperaContatosOrgaos);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Orgao orgao;
    while (rs.next()) {
      orgao = mOrgaos.get(rs.getString("ORGAO"));
      if (orgao != null) {
        if (orgao.getContatos() == null) {
          orgao.setContatos(new ArrayList<model.beans.Contato>());
        }
        orgao.getContatos().add(new model.beans.Contato(
                rs.getString("NOME"),
                rs.getInt("TELEFONE"),
                rs.getInt("ID")));
      }
    }
    rs.close();
    pstmt.close();
    gelic.close();
    
  }

  private static int getNextID() throws SQLException, NamingException {
    final String sqlCalculaId =
            "select gen_id(GEN_CONTATOS_ID, 1) from rdb$database";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlCalculaId);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    int buffer = rs.getInt(1);
    rs.close();
    pstmt.close();
    return buffer;


  }

  public static int incluir(model.beans.Empresa empresa, String nomeContato,
          model.beans.TipoTelefone telefone)
          throws SQLException, NamingException {
    final String sqlIncluirContatoEmpresa = "insert into " +
            "CONTATOS(ID, NOME, TELEFONE, EMPRESA) values (?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluirContatoEmpresa);
    pstmt.setInt(1, getNextID());
    pstmt.setString(2, nomeContato);
    pstmt.setInt(3, telefone.getId());
    pstmt.setString(4, empresa.getCnpj());

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

    pstmt = gelic.prepareStatement(sqlRecuperaContatosEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    rs = pstmt.executeQuery();
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

  public static int excluir(int idContato) throws SQLException, NamingException {
    final String sqlExcluirContato = "delete from CONTATOS where ID=?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluirContato);
    pstmt.setInt(1, idContato);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
}



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
import model.beans.TipoEndereco;
import model.beans.TipoTelefone;

/**
 *
 * @author Adriano
 */
public class Enderecos {

  public static int alterar(Empresa empresa, String tipoLogradouroEmpresa,
          String logradouroEmpresa, String numeroEmpresa,
          String complementoEmpresa, String bairroEmpresa,
          String cidadeEmpresa, String estadoEmpresa, String cepEmpresa,
          String siteEmpresa, String emailEmpresa)
          throws SQLException, NamingException {
    final String sqlAlterarEnderecoEmpresa =
            "update ENDERECOS set " +
            "TIPO = ?, " +
            "LOGRADOURO = ?, " +
            "NUMERO = ?, " +
            "COMPLEMENTO = ?, " +
            "BAIRRO = ?, " +
            "MUNICIPIO = ?, " +
            "UF = ?, " +
            "CEP = ?,  " +
            "SITE = ?,  " +
            "EMAIL = ? " +
            "where ID = (SELECT ENDERECO FROM EMPRESAS WHERE CNPJ=?)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlterarEnderecoEmpresa);

    pstmt.setString(1, tipoLogradouroEmpresa);
    pstmt.setString(2, logradouroEmpresa);
    pstmt.setString(3, numeroEmpresa);
    pstmt.setString(4, complementoEmpresa);
    pstmt.setString(5, bairroEmpresa);
    pstmt.setString(6, cidadeEmpresa);
    pstmt.setString(7, estadoEmpresa);
    pstmt.setString(8, cepEmpresa);
    pstmt.setString(9, siteEmpresa);
    pstmt.setString(10, emailEmpresa);

    pstmt.setString(11, empresa.getCnpj());

    int regs = pstmt.executeUpdate();
    pstmt.close();
    return regs;
  }

  public static TipoEndereco incluir(String tipoLogradouro,
          String logradouro, String numero, String complemento, String bairro,
          String cidade, String estado, String cep, String site, String email, 
          TipoTelefone tel) throws SQLException, NamingException {
    final String sqlCalculaId =
            "select gen_id(GEN_ENDERECOS_ID, 1) from rdb$database";
    final String sqlIncluiEndereco =
            "insert into ENDERECOS( ID,TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, " +
            "BAIRRO, MUNICIPIO, UF, CEP, SITE, EMAIL, TELEFONE) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?)";
    
    Connection gelic = model.services.Conexao.getConnection();

    model.beans.TipoEndereco end = new model.beans.TipoEndereco();
    end.setBairro(bairro);
    end.setCep(cep);
    end.setCidade(cidade);
    end.setComplemento(complemento);
    end.setEmail(email);
    end.setLogradouro(logradouro);
    end.setNumero(numero);
    end.setSite(site);
    end.setTelefone(tel);
    end.setTipo(tipoLogradouro);  
    
    PreparedStatement pstmt = gelic.prepareStatement(sqlCalculaId);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    end.setId(rs.getInt(1));
    rs.close();
    pstmt.close();
    
    pstmt = gelic.prepareStatement(sqlIncluiEndereco);
    
    pstmt.setInt(1, end.getId());
    pstmt.setString(2, end.getTipo());
    pstmt.setString(3, end.getLogradouro());
    pstmt.setString(4, end.getNumero());
    pstmt.setString(5, end.getComplemento());
    pstmt.setString(6, end.getBairro());
    pstmt.setString(7, end.getCidade());
    pstmt.setString(8, end.getUf());
    pstmt.setString(9, end.getCep());
    pstmt.setString(10, end.getSite());
    pstmt.setString(10, end.getEmail());
    pstmt.setInt(11, end.getTelefone().getId());
    
    pstmt.execute();
    
    pstmt.close();
    
    return end;
  }

  public static ArrayList<model.beans.TipoLogradouro> recuperar() throws NamingException, SQLException {
    final String sqlRecuperaTipos = "select TIPO from TIPOSLOGRADOUROS";
    final String sqlContaTipos = "select count(*) from TIPOSLOGRADOUROS";

    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlContaTipos);
    ResultSet rs = pstmt.executeQuery();
    int quantidadeTipos = 0;
    if (rs != null && rs.next()) {
      quantidadeTipos = rs.getInt(1);
      rs.close();
    }
    pstmt.close();
    if (quantidadeTipos < 1) {
      gelic.close();
      return null;
    }
    pstmt = gelic.prepareStatement(sqlRecuperaTipos);
    rs = pstmt.executeQuery();
    ArrayList<model.beans.TipoLogradouro> tipos =
            new ArrayList<model.beans.TipoLogradouro>(quantidadeTipos);
    while (rs.next()) {
      tipos.add(cria(rs.getString(1)));
    }
    return tipos;
  }

  static private model.beans.TipoLogradouro cria(String nome) {
    model.beans.TipoLogradouro tipo = new model.beans.TipoLogradouro();
    tipo.setNome(nome);
    return tipo;
  }

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws NamingException, SQLException {

    final String sqlRecuperaEnderecosEmpresas =
            "select CNPJ, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, " +
            "MUNICIPIO, UF, CEP, SITE, EMAIL " +
            "from ENDERECOS inner join EMPRESAS " +
            "on (EMPRESAS.ENDERECO = ENDERECOS.ID)";

    HashMap<String, model.beans.Empresa> map =
            new HashMap<String, model.beans.Empresa>();
    for (model.beans.Empresa empresa : empresas) {
      map.put(empresa.getCnpj(), empresa);
    }

    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaEnderecosEmpresas);
    ResultSet rs = pstmt.executeQuery();

    model.beans.Empresa empresa;

    while (rs != null && rs.next()) {
      String cnpj = rs.getString("CNPJ");
      empresa = map.get(cnpj);
      if (empresa != null) {
        empresa.setEndereco(cria(
                rs.getString("TIPO"),
                rs.getString("LOGRADOURO"),
                rs.getString("NUMERO"),
                rs.getString("COMPLEMENTO"),
                rs.getString("BAIRRO"),
                rs.getString("MUNICIPIO"),
                rs.getString("UF"),
                rs.getString("CEP"),
                rs.getString("SITE"),
                rs.getString("EMAIL")));
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
          throws NamingException, SQLException {
    final String sqlRecuperaEnderecoEmpresa =
            "select TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, " +
            "UF, CEP, SITE, EMAIL from enderecos where id = " +
            "(select endereco from empresas where cnpj=? )";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaEnderecoEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      empresa.setEndereco(cria(
              rs.getString("TIPO"),
              rs.getString("LOGRADOURO"),
              rs.getString("NUMERO"),
              rs.getString("COMPLEMENTO"),
              rs.getString("BAIRRO"),
              rs.getString("MUNICIPIO"),
              rs.getString("UF"),
              rs.getString("CEP"),
              rs.getString("SITE"),
              rs.getString("EMAIL")));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */

    rs.close();
    pstmt.close();
    gelic.close();
  }

  private static model.beans.TipoEndereco cria(String tipo,
          String logradouro, String numero, String complemento, String bairro,
          String municipio, String uf, String cep, String site, String email) {
    model.beans.TipoEndereco endereco = new model.beans.TipoEndereco();

    endereco.setCep(cep);
    endereco.setCidade(municipio);
    endereco.setComplemento(complemento);
    endereco.setEmail(email);
    endereco.setLogradouro(logradouro);
    endereco.setNumero(numero);
    endereco.setSite(site);
    endereco.setUf(uf);
    endereco.setBairro(bairro);
    endereco.setTipo(tipo);

    return endereco;
  }
}

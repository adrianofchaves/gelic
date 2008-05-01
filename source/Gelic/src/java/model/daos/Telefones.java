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

  public static int alterar(model.beans.Empresa empresa, String ddiEmpresa,
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
    pstmt.setString(4, ramalEmpresa);

    pstmt.setString(5, empresa.getCnpj());

    int regs = pstmt.executeUpdate();
    pstmt.close();
    return regs;
  }

  public static int alterar(model.beans.TipoTelefone telefone, 
          String ddiContato, String dddContato, String numeroTelefoneContato, 
          String ramalContato)
          throws SQLException, NamingException {
    final String sqlAlteraTelefone = "update TELEFONES set DDI = ?," +
            "DDD = ?, " +
            "NUMERO = ?, " +
            "RAMAL = ? " +
            "where ID = ? ";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraTelefone);
    pstmt.setString(1, dddContato);
    pstmt.setString(2, ddiContato);
    pstmt.setString(3, numeroTelefoneContato);
    pstmt.setString(4, ramalContato);
    pstmt.setInt(5, telefone.getId());
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
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

  public static void recuperarDeOrgaos(ArrayList<model.beans.Orgao> orgaos) 
          throws NamingException, SQLException {
    HashMap<String, model.beans.Orgao> mOrgaos =
            new HashMap<String, model.beans.Orgao>(orgaos.size());
    for (model.beans.Orgao orgao : orgaos) {
      mOrgaos.put(orgao.getCnpj(), orgao);
    }

    final String sqlRecuperarTelefones =
            "select " +
            " TELEFONES.ID TELEFONE, DDI, DDD, NUMERO, RAMAL, " +
            " CONTATOS.ID CONTATO, ORGAOS.CNPJ ORGAO," +
            " null ENDERECO " +
            "from " +
            " TELEFONES" +
            " inner join CONTATOS on (CONTATOS.TELEFONE = TELEFONES.ID)" +
            " inner join ORGAOS on (CONTATOS.ORGAO = ORGAOS.CNPJ) " +
            "union all " +
            "select" +
            " TELEFONES.ID TELEFONE, DDI, DDD, TELEFONES.NUMERO NUMERO, " +
            " RAMAL," +
            " null CONTATO, ORGAOS.CNPJ ORGAO, " +
            " ENDERECOS.ID ENDERECO " +
            "from" +
            " TELEFONES" +
            " inner join ENDERECOS on (ENDERECOS.TELEFONE = TELEFONES.ID)" +
            " inner join ORGAOS on (ORGAOS.ENDERECO = ENDERECOS.ID)";
    
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarTelefones);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Orgao orgao;
    int idEndereco;
    int idContato;
    while (rs.next()) {
      orgao = mOrgaos.get(rs.getString("ORGAO"));
      if( orgao != null ){
        idEndereco = rs.getInt( "ENDERECO");        
        if( !rs.wasNull()){
          // É um telefone de endereço 
          orgao.getEndereco().setTelefone( new model.beans.TipoTelefone(
                  rs.getInt( "TELEFONE"),
                  rs.getString("DDI"),
                  rs.getString("DDD"),
                  rs.getString("NUMERO"),
                  rs.getString("RAMAL")));
        }else{
          idContato = rs.getInt("CONTATO");
          if(!rs.wasNull()){
            for(model.beans.Contato contato : orgao.getContatos()){
              if( contato.getId() == idContato ){
                contato.setTelefone(new model.beans.TipoTelefone(
                  rs.getInt( "TELEFONE"),
                  rs.getString("DDI"),
                  rs.getString("DDD"),
                  rs.getString("NUMERO"),
                  rs.getString("RAMAL")));
              }
            }
          }
        }
        
      }
    }
    rs.close();
    pstmt.close();
    gelic.close();
  }

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws SQLException, NamingException {
    final String sqlRecuperarTelefonesEmpresas =
            "select " +
            " CNPJ, CONTATOS.NOME NOMECONTATO, " +
            " TELEFONES.ID IDTELEFONE, TELEFONES.DDI DDI, " +
            " TELEFONES.DDD DDD, " +
            " TELEFONES.NUMERO NUMEROTELEFONE, TELEFONES.RAMAL RAMAL " +
            "from " +
            " EMPRESAS " +
            " left outer join CONTATOS  on (CONTATOS.EMPRESA = EMPRESAS.CNPJ) " +
            " inner join TELEFONES on (TELEFONES.ID = CONTATOS.TELEFONE) " +
            "union " +
            "select " +
            " CNPJ, null, TELEFONES.ID IDTELEFONE, TELEFONES.DDI, " +
            " TELEFONES.DDD, TELEFONES.NUMERO, TELEFONES.RAMAL " +
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
      model.beans.TipoTelefone telefone = new model.beans.TipoTelefone(
              rs.getInt("IDTELEFONE"),
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
  /**
   * Recupera o telefone de um contato.
   * @param contato
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  public static void recuperar(model.beans.Contato contato)
          throws SQLException, NamingException {
    contato.setTelefone(recuperar(contato.getIdTelefone()));
  }

  /**
   * Recupera todos os telefones de uma empresa.  O telefone poderá ser de um 
   * endereço ou de um dos seus contatos.
   * 
   * @param empresa - as listas de telefones do contato e o contato do endereço
   * do objeto passado como parâmetro serão preenchidos por esta rotina.
   * 
   * @throws javax.naming.NamingException
   * @throws java.sql.SQLException
   */
  public static void recuperar(model.beans.Empresa empresa)
          throws NamingException, SQLException {

    final String sqlRecuperaTelefoneEmpresa =
            "select " +
            " TELEFONES.ID TELEFONE,  DDI, DDD, NUMERO,  RAMAL, " +
            " CONTATOS.ID CONTATO,  CNPJ,  null ENDERECO " +
            "from " +
            " TELEFONES" +
            " inner join CONTATOS on (CONTATOS.TELEFONE = TELEFONES.ID)" +
            " inner join EMPRESAS on (CONTATOS.EMPRESA = EMPRESAS.CNPJ) " +
            "where " +
            " EMPRESAS.CNPJ = ? " +
            "union all " +
            "select " +
            " TELEFONES.ID TELEFONE, DDI, DDD, TELEFONES.NUMERO NUMERO, " +
            " RAMAL, null CONTATO, CNPJ, ENDERECOS.ID ENDERECO " +
            "from " +
            " TELEFONES" +
            " inner join ENDERECOS on (TELEFONES.ID = ENDERECOS.TELEFONE)" +
            " inner join EMPRESAS on (EMPRESAS.ENDERECO = ENDERECOS.ID) " +
            "where " +
            " EMPRESAS.CNPJ = ? ";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaTelefoneEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    pstmt.setString(2, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      int idEndereco = rs.getInt("ENDERECO");
      if (rs.wasNull()) {
        // telefone de algum contato
        int idContato = rs.getInt("CONTATO");
        for (model.beans.Contato contato : empresa.getContatos()) {
          if (contato.getId() == idContato) {
            //achou!
            contato.setTelefone(new model.beans.TipoTelefone(
                    rs.getInt("ID"),
                    rs.getString("DDI"),
                    rs.getString("DDD"),
                    rs.getString("NUMERO"),
                    rs.getString("RAMAL")));
          }
        }
      } else {
        //Telefone de algum endereço
        if (empresa.getEndereco().getId() == idEndereco) {
          //achou!
          empresa.getEndereco().setTelefone(new model.beans.TipoTelefone(
                  rs.getInt("ID"),
                  rs.getString("DDI"),
                  rs.getString("DDD"),
                  rs.getString("NUMERO"),
                  rs.getString("RAMAL")));
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

  public static model.beans.TipoTelefone recuperar(int idTelefone)
          throws SQLException, NamingException {
    final String sqlRecuperaTelefone = "select ID, DDI, DDD, NUMERO, RAMAL " +
            "from TELEFONES WHERE ID = ?";
    model.beans.TipoTelefone telefone = null;
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperaTelefone);
    pstmt.setInt(1, idTelefone);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
      telefone = new model.beans.TipoTelefone(
              rs.getInt("ID"),
              rs.getString("DDI"),
              rs.getString("DDD"),
              rs.getString("NUMERO"),
              rs.getString("RAMAL"));

    }
    rs.close();
    pstmt.close();
    gelic.close();

    return telefone;

  }
}

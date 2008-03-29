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
public class Enderecos {

  private static final String sqlRecuperaEnderecoEmpresa =
          "select TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, " +
          "UF, CEP, SITE, EMAIL from enderecos where id = " +
          "(select endereco from empresas where cnpj=? )";

  public static void recuperar(ArrayList<model.beans.Empresa> empresas) 
          throws NamingException, SQLException {
    /* Essa forma de preencher os endereços de uma empresa pode ser otimizada
     * executando um único comando sql para recuperar todos os endereços
     * das empresas na lista passada pelo parâmetro.  */
    for (model.beans.Empresa empresa : empresas) {
      recuperar(empresa);
    }
  }

  protected static void recuperar(model.beans.Empresa empresa) 
          throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    PreparedStatement pstmt = gelic.prepareStatement(
            sqlRecuperaEnderecoEmpresa);
    pstmt.setString(1, empresa.getCnpj());
    ResultSet rs = pstmt.executeQuery();
    if (rs != null) {
      empresa.setEndereco(criaEndereco(
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
  private static model.beans.TipoEndereco criaEndereco( String tipo, 
          String logradouro, String numero, String complemento, String bairro,
          String municipio, String uf, String cep, String site, String email ){
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

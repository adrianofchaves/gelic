/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class Orgaos {

  public static void excluir(model.beans.Orgao orgao ) 
          throws NamingException, SQLException {
    orgao = recuperar(orgao.getCnpj());
    Connection gelic = model.services.Conexao.getConnection();
    try {
      for (model.beans.Contato contato : orgao.getContatos()) {
        model.daos.Contatos.excluir(contato.getId());
        model.daos.Telefones.excluir(contato.getTelefone().getId());
      }
      model.daos.Orgaos.excluir(orgao.getCnpj());
      model.daos.Enderecos.excluir(orgao.getEndereco().getId());
      model.daos.Telefones.excluir(orgao.getEndereco().getTelefone().getId());

      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }

  }
  static public void alterar(  model.beans.Orgao orgao,
          String cnpj, String razaoSocial, String apelido, String ie,
          
          String tipoLogradouro, String logradouro, String numero, 
          String complemento, String bairro, String municipio, String uf, 
          String cep, String site, String email,
          
          String ddi, String ddd, String numeroTelefone, String ramal ) throws SQLException, NamingException {
    
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Orgaos.alterar(orgao, cnpj, razaoSocial, apelido, ie );
              
      model.daos.Enderecos.alterar(orgao.getEndereco(), tipoLogradouro,
              logradouro, numero, complemento, bairro, municipio, uf, cep,
              site, email);
      model.daos.Telefones.alterar(orgao.getEndereco().getTelefone(), 
              ddi, ddd, numeroTelefone, ramal);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }
    
    
  }
  static public void incluir( 
          String cnpj, String razaoSocial, String apelido, String ie,
          
          String tipoLogradouro, String logradouro, String numero, 
          String complemento, String bairro, String municipio, String uf, 
          String cep, String site, String email,
          
          String ddi, String ddd, String numeroTelefone, String ramal ) 
          throws SQLException, NamingException{
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.beans.TipoTelefone tel = model.daos.Telefones.incluir(
              ddi, ddd, numeroTelefone, ramal);
      model.beans.TipoEndereco end = model.daos.Enderecos.incluir(
              tipoLogradouro, logradouro, numero, complemento, bairro,
              municipio, uf, cep, site, email, tel);
      model.daos.Orgaos.incluir( cnpj, razaoSocial, apelido, ie, end );
      gelic.commit();
      gelic.close();
    } catch (SQLException ex) {
      gelic.rollback();
      gelic.close();
      throw ex;
    }

    
  }
  static public model.beans.Orgao recuperar(String cnpj)
          throws NamingException, SQLException {
    model.beans.Orgao orgao = model.daos.Orgaos.recuperar(cnpj);
    orgao.setEndereco(model.daos.Enderecos.recuperar(orgao.getIdEndereco()));
    model.daos.Contatos.recuperar(orgao);
    if (orgao.getEndereco() != null) {
      orgao.getEndereco().setTelefone(model.daos.Telefones.recuperar(
              orgao.getEndereco().getIdTelefone()));
    }

    /* NOTA: este algoritmo pode tornar o sistema muito lento em situações de
     * muita carga no servidor de banco de dados, já que executa um comando para
     * cada contato passado na lista */
    if (orgao.getContatos() != null) {
      for (model.beans.Contato contato : orgao.getContatos()) {
        contato.setTelefone( model.daos.Telefones.recuperar(
                contato.getIdTelefone()));
      }
    }

    return orgao;
  }

  static public ArrayList<model.beans.Orgao> recuperar()
          throws NamingException, SQLException {
    ArrayList<model.beans.Orgao> orgaos = model.daos.Orgaos.recuperar();

    model.daos.Enderecos.recuperarDeOrgaos(orgaos);
    model.daos.Contatos.recuperarDeOrgaos(orgaos);
    model.daos.Telefones.recuperarDeOrgaos(orgaos);

    return orgaos;
  }
}

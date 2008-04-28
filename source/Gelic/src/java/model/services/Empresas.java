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
 * @author Adriano
 */
public class Empresas {

  public static void incluiEmpresa(String nomeFantasiaEmpresa, boolean ePortadorEmpresa,
          String razaoSocialEmpresa, boolean eFornecedorEmpresa,
          String cnpjEmpresa, String ieEmpresa,
          String imEmpresa, String tipoLogradouroEmpresa,
          String logradouroEmpresa, String numeroEmpresa,
          String complementoEmpresa, String bairroEmpresa,
          String cidadeEmpresa, String estadoEmpresa, String cepEmpresa,
          String siteEmpresa, String emailEmpresa, String ddiEmpresa,
          String dddEmpresa, String numeroTelefoneEmpresa,
          String ramalEmpresa) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.beans.TipoTelefone tel = model.daos.Telefones.incluir(ddiEmpresa,
              dddEmpresa, numeroTelefoneEmpresa, ramalEmpresa);

      model.beans.TipoEndereco end = model.daos.Enderecos.incluir(
              tipoLogradouroEmpresa, logradouroEmpresa, numeroEmpresa,
              complementoEmpresa, bairroEmpresa, cidadeEmpresa, estadoEmpresa,
              cepEmpresa, siteEmpresa, emailEmpresa, tel);

      model.daos.Empresas.incluir(nomeFantasiaEmpresa, ePortadorEmpresa,
              razaoSocialEmpresa, eFornecedorEmpresa, cnpjEmpresa, ieEmpresa,
              imEmpresa, end);

      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }

  }

  public static void alteraEmpresa(model.beans.Empresa empresa,
          String nomeFantasiaEmpresa, boolean ePortadorEmpresa,
          String razaoSocialEmpresa, boolean eFornecedorEmpresa,
          String cnpjEmpresa, String ieEmpresa,
          String imEmpresa, String tipoLogradouroEmpresa,
          String logradouroEmpresa, String numeroEmpresa,
          String complementoEmpresa, String bairroEmpresa,
          String cidadeEmpresa, String estadoEmpresa, String cepEmpresa,
          String siteEmpresa, String emailEmpresa, String ddiEmpresa,
          String dddEmpresa, String numeroTelefoneEmpresa,
          String ramalEmpresa) throws SQLException, NamingException {


    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Empresas.alterar(empresa.getCnpj(),
              nomeFantasiaEmpresa, ePortadorEmpresa, razaoSocialEmpresa,
              eFornecedorEmpresa, cnpjEmpresa, ieEmpresa, imEmpresa);
      model.daos.Enderecos.alterar(empresa, tipoLogradouroEmpresa,
              logradouroEmpresa, numeroEmpresa,
              complementoEmpresa, bairroEmpresa,
              cidadeEmpresa, estadoEmpresa, cepEmpresa,
              siteEmpresa, emailEmpresa);
      model.daos.Telefones.alterar(empresa, ddiEmpresa, dddEmpresa,
              numeroTelefoneEmpresa, ramalEmpresa);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }


  }

  public static void excluir(String cnpj) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
      model.daos.Empresas.excluir(cnpj);
      gelic.commit();
      gelic.close();
    } catch (SQLException e) {
      gelic.rollback();
      gelic.close();
      throw e;
    }
  }

  public static model.beans.Empresa recuperar(String cnpj)
          throws SQLException, NamingException {
    model.beans.Empresa empresa = model.daos.Empresas.recuperar(cnpj);
    model.daos.Enderecos.recuperar(empresa);
    model.services.Contatos.recuperar(empresa);
    model.daos.Telefones.recuperar(empresa);
    return empresa;
  }

  public static ArrayList<model.beans.Empresa> recuperar()
          throws NamingException, SQLException {
    ArrayList<model.beans.Empresa> empresas = model.daos.Empresas.recuperar();
    /* NOTA: como o telefone fica no endereço e há telefone no contato também,
    é necessário fazer essa recuperação nesta ordem */
    model.daos.Enderecos.recuperar(empresas);
    model.daos.Contatos.recuperar(empresas);
    model.daos.Telefones.recuperar(empresas);
    return empresas;
  }
}

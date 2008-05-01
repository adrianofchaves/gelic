/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class Orgaos {

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

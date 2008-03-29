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

  private static final String sqlRecuperarContatosEmpresas =
          "select  EMPRESA, NOME from  contatos   " +
          "inner join empresas on   (contatos.empresa = empresas.cnpj)";

  public static void recuperar(ArrayList<model.beans.Empresa> empresas)
          throws NamingException, SQLException {

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
        if( empresa.getContatos() == null ){
          empresa.setContatos(new ArrayList<model.beans.Contato>());
        }
        empresa.getContatos().add(criaContato(rs.getString("NOME")));
      }
    }
  }
  private static model.beans.Contato criaContato(String nome ){
    model.beans.Contato contato = new model.beans.Contato();
    contato.setNome(nome);
    return contato;
  }  
}



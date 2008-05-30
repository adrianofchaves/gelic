/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Licitacao;

/**
 *
 * @author Paulo
 */
public class Licitacoes { 

  public static void excluir(Licitacao licitacao) 
          throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Licitacoes.excluir(licitacao) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  public static void incluir(model.beans.TipoLicitacao tipoLicitacao,
          String numero, int ano, model.beans.Modalidade modalidade,
          model.beans.Sistema sistema, model.beans.Orgao orgao, 
          String numeroProcesso, String objeto, Date dataDocumentacao, 
          Date dataProposta, Date dataRealizacao, int diasValidadeProposta,
          int diasPrazoEntrega, int diasPrazoPagamento, int diasVigencia,
          int anosPrazoGarantia, String termosAmostra, String termosGarantia,
          String termosMulta) throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Licitacoes.incluir(tipoLicitacao, numero, ano, modalidade, 
            sistema, orgao, numeroProcesso, objeto, dataDocumentacao, 
            dataProposta, dataRealizacao, diasValidadeProposta, 
            diasPrazoEntrega, diasPrazoPagamento, diasVigencia, 
            anosPrazoGarantia, termosAmostra, termosGarantia, 
            termosMulta) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }
  
  public static void alterar(model.beans.Licitacao licitacao, 
          model.beans.TipoLicitacao tipoLicitacao,
          String numero, int ano, model.beans.Modalidade modalidade,
          model.beans.Sistema sistema, model.beans.Orgao orgao, 
          String numeroProcesso, String objeto, Date dataDocumentacao, 
          Date dataProposta, Date dataRealizacao, int diasValidadeProposta,
          int diasPrazoEntrega, int diasPrazoPagamento, int diasVigencia,
          int anosPrazoGarantia, String termosAmostra, String termosGarantia,
          String termosMulta) throws NamingException, SQLException {
    Connection gelic = model.services.Conexao.getConnection();
    if (model.daos.Licitacoes.alterar(licitacao, 
            tipoLicitacao, numero, ano, modalidade, 
            sistema, orgao, numeroProcesso, objeto, dataDocumentacao, 
            dataProposta, dataRealizacao, diasValidadeProposta, 
            diasPrazoEntrega, diasPrazoPagamento, diasVigencia, 
            anosPrazoGarantia, termosAmostra, termosGarantia, 
            termosMulta) == 1) {
      gelic.commit();
    } else {
      gelic.rollback();
    }
    gelic.close();
  }

  static public ArrayList<model.beans.Licitacao> recuperar()
          throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = 
            model.daos.Licitacoes.recuperar();
    model.services.TiposLicitacoes.recuperar(licitacoes);
    model.daos.Orgaos.recuperar( licitacoes );   
    model.services.Sistemas.recuperar(licitacoes);
    return licitacoes;
  }

  public static model.beans.Licitacao recuperar(int id)
          throws SQLException, NamingException {
    model.beans.Licitacao licitacao = model.daos.Licitacoes.recuperar(id);
    licitacao.setOrgao(model.daos.Orgaos.recuperar(licitacao.getIdorgao()));
    licitacao.setSistema(model.daos.Sistemas.recuperar(licitacao.getIdSistema()));
    licitacao.setModalidade(
            model.daos.Modalidades.recuperar(licitacao.getIdModalidade()));
    licitacao.setTipoLicitacao(model.daos.TiposLicitacoes.recuperar(
            licitacao.getIdTipoLicitacao()));
    model.daos.Lotes.recuperar(licitacao);
    return licitacao;
  }
}

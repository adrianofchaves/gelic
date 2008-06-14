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

/**
 *
 * @author Paulo
 */
public class Licitacoes {

  public static boolean temLicitacao(model.beans.Modalidade modalidade)
          throws SQLException, NamingException {

    ArrayList<model.beans.Licitacao> licitacoes = recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      if (licitacao.getIdModalidade() == modalidade.getId()) {
        return true;
      }
    }
    return false;
  }

  public static boolean temLicitacao(model.beans.Orgao orgao)
          throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      if (licitacao.getOrgao().getCnpj().equals(orgao.getCnpj())) {
        return true;
      }
    }
    return false;
  }

  public static void excluir(model.beans.Licitacao licitacao)
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
    model.daos.Orgaos.recuperar(licitacoes);
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
    model.daos.ItensLote.recuperar(licitacao);
    return licitacao;
  }

  public static boolean temLicitacao(model.beans.Sistema sistema)
          throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      if (licitacao.getIdSistema() == sistema.getId()) {
        return true;
      }
    }
    return false;

  }

  public static boolean temLicitacao(model.beans.TipoLicitacao tipoLicitacao)
          throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      if (licitacao.getIdTipoLicitacao() == tipoLicitacao.getId()) {
        return true;
      }
    }
    return false;
  }

  public static boolean temLicitacao(model.beans.TipoLicitacao tipo,
          String numeroLicitacao, int anoLicitacao,
          model.beans.Orgao orgao) throws SQLException, NamingException {
    ArrayList<model.beans.Licitacao> licitacoes = recuperar();
    for (model.beans.Licitacao licitacao : licitacoes) {
      if (licitacao.getOrgao().getCnpj().equals(orgao.getCnpj()) &&
              licitacao.getTipoLicitacao().getId() == tipo.getId() &&
              licitacao.getNumero().equals(numeroLicitacao) &&
              licitacao.getAno() == anoLicitacao) {
        return true;
      }
    }
    return false;

  }
}

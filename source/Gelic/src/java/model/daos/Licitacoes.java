/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Licitacao;

/**
 *
 * @author Paulo
 */
public class Licitacoes {

  /**
   * Inclui nova licitacao no banco de dados.
   * @return -  O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int incluir(int tipolicitacao, String numero, int ano,
          String orgao, String objeto)
          throws SQLException, NamingException {
    final String sqlIncluiLicitacao = "insert into LICITACOES( " +
            "TIPOLICITACAO, NUMERO, ANO, ORGAO, OBJETO) values (?,?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiLicitacao);

    pstmt.setInt(1, tipolicitacao);
    pstmt.setString(2, numero);
    pstmt.setInt(3, ano);
    pstmt.setString(4, orgao);
    pstmt.setString(5, objeto);
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  /**
   * Altera o registro no banco de um produto.
   * @return O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int alterar(int tipolicitacao, String numero, 
          String numeroAnterior, int ano, String orgao, String descricao)
          throws SQLException, NamingException {
    final String sqlAlteraLicitacao = "update LICITACOES set " +
            "tipolicitacao = ?, numero = ?, ano = ?, orgao = ?, " +
            "objeto = ? where numero = ? ";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraLicitacao);

    pstmt.setInt(1, tipolicitacao);
    pstmt.setString(2, numero);
    pstmt.setInt(3, ano);
    pstmt.setString(4, orgao);
    pstmt.setString(5, descricao);
    pstmt.setString(6, numeroAnterior);

    int buffer = pstmt.executeUpdate();

    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  public static model.beans.Licitacao recuperar(String numero)
          throws SQLException, NamingException {
    final String sqlRecuperarLicitacao = "select ID, TIPOLICITACAO, " +
            "NUMERO, ANO, MODALIDADE, SISTEMA, ORGAO, NUMEROPROCESSO, " +
            "OBJETO, DATADOCUMENTACAO, DATAPROPOSTA, DATAREALIZACAO, " +
            "DIASVALIDADEPROPOSTA, DIASPRAZOENTREGA, DIASPRAZOPAGAMENTO, " +
            "DIASVIGENCIA, ANOSPRAZOGARANTIA, PEDEAMOSTRA, TERMOSAMOSTRA, " +
            "PEDEGARANTIA, TERMOSGARANTIA, PREVEMULTA, TERMOSMULTA, STATUS " +
            "from LICITACOES where NUMERO = ?";

    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarLicitacao);

    pstmt.setString(1, numero);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Licitacao licitacao = null;
    if (rs != null && rs.next()) {
      licitacao = criaLicitacao(rs);
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return licitacao;
  }

  static public ArrayList<model.beans.Licitacao> recuperar()
          throws SQLException, NamingException {
    final String sqlContaLicitacoes =
            "select count(*) from LICITACOES";
    final String sqlRecuperaLicitacoes = "select ID, TIPOLICITACAO, " +
            "NUMERO, ANO, MODALIDADE, SISTEMA, ORGAO, NUMEROPROCESSO, " +
            "OBJETO, DATADOCUMENTACAO, DATAPROPOSTA, DATAREALIZACAO, " +
            "DIASVALIDADEPROPOSTA, DIASPRAZOENTREGA, DIASPRAZOPAGAMENTO, " +
            "DIASVIGENCIA, ANOSPRAZOGARANTIA, PEDEAMOSTRA, TERMOSAMOSTRA, " +
            "PEDEGARANTIA, TERMOSGARANTIA, PREVEMULTA, TERMOSMULTA, STATUS " +
            "from LICITACOES";
    ArrayList<model.beans.Licitacao> licitacoes = null;
    PreparedStatement pstmt;
    int quantidadeLicitacoes = 0;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaLicitacoes);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeLicitacoes = rs.getInt(1);
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      rs.close();
      pstmt.close();
    }
    if (quantidadeLicitacoes < 1) {
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      gelic.close();
      return null;
    }
    /* Carrega usuários */
    pstmt = gelic.prepareStatement(sqlRecuperaLicitacoes);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      if (licitacoes == null) {
        licitacoes = new ArrayList<model.beans.Licitacao>(
                quantidadeLicitacoes);
      }

      licitacoes.add(criaLicitacao(rs));
    }

    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();

    return licitacoes;
  }

  private static Licitacao criaLicitacao(ResultSet rs) throws SQLException {
    Licitacao licitacao;

    int id = rs.getInt("ID");
    int idTipoLicitacao = rs.getInt("TIPOLICITACAO");
    String numero = rs.getString("NUMERO");
    int ano = rs.getInt("ANO");
    int idModalidade = rs.getInt("MODALIDADE");
    int idSistema = rs.getInt("SISTEMA");
    String idorgao = rs.getString("ORGAO");
    String numeroProcesso = rs.getString("NUMEROPROCESSO");
    String objeto = rs.getString("OBJETO");
    Date dataDocumentacao = rs.getDate("DATADOCUMENTACAO");
    Date dataProposta = rs.getDate("DATAPROPOSTA");
    Date dataRealizacao = rs.getDate("DATAREALIZACAO");
    int diasValidadeProposta = rs.getInt("DIASVALIDADEPROPOSTA");
    int diasPrazoEntrega = rs.getInt("DIASPRAZOENTREGA");
    int diasPrazoPagamento = rs.getInt("DIASPRAZOPAGAMENTO");
    int diasVigencia = rs.getInt("DIASVIGENCIA");
    int anosPrazoGarantia = rs.getInt("ANOSPRAZOGARANTIA");
    boolean pedeAmostra = (new model.beans.SimNao(
            rs.getString("PEDEAMOSTRA"))).toBoolean();
    String termosAmostra = rs.getString("TERMOSAMOSTRA");
    boolean pedeGarantia = (new model.beans.SimNao(
            rs.getString("PEDEGARANTIA"))).toBoolean();
    String termosGarantia = rs.getString("TERMOSGARANTIA");
    boolean preveMulta = (new model.beans.SimNao(
            rs.getString("PREVEMULTA"))).toBoolean();
    String termosMulta = rs.getString("TERMOSMULTA");
    int status = rs.getInt("STATUS");

    licitacao = new model.beans.Licitacao(id, idTipoLicitacao, numero, ano, 
            idModalidade, idSistema, idorgao, numeroProcesso, objeto, 
            dataDocumentacao,  dataProposta, dataRealizacao, 
            diasValidadeProposta, diasPrazoEntrega, diasPrazoPagamento, 
            diasVigencia, anosPrazoGarantia, pedeAmostra, termosAmostra, 
            pedeGarantia, termosGarantia, preveMulta, termosMulta, status);
    
    return licitacao;
  }
}

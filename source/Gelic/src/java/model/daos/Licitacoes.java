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

  public static int excluir(Licitacao licitacao) 
          throws NamingException, SQLException {
    final String sqlExcluirLicitacao = "delete from LICITACOES where ID = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluirLicitacao);
    pstmt.setInt(1, licitacao.getId());
    int result =  pstmt.executeUpdate();
    pstmt.close();
    return result;
  }
  private static int getNextID() throws SQLException, NamingException{
    final String sql = "select gen_id(GEN_LICITACOES_ID, 1) from rdb$database";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    return rs.getInt(1);
  }
  static public int alterar( model.beans.Licitacao licitacao,
          model.beans.TipoLicitacao tipoLicitacao,
          String numero, int ano, model.beans.Modalidade modalidade,
          model.beans.Sistema sistema, model.beans.Orgao orgao, 
          String numeroProcesso, String objeto, Date dataDocumentacao, 
          Date dataProposta, Date dataRealizacao, int diasValidadeProposta,
          int diasPrazoEntrega, int diasPrazoPagamento, int diasVigencia,
          int anosPrazoGarantia, String termosAmostra, String termosGarantia,
          String termosMulta) throws SQLException, NamingException {
    
    final String sqlIncluiLicitacao = "update LICITACOES set " +
            "TIPOLICITACAO = ?, NUMERO = ?, ANO = ?, MODALIDADE = ?, " +
            "SISTEMA = ?, ORGAO = ?, NUMEROPROCESSO = ?, OBJETO = ?, " +
            "DATADOCUMENTACAO = ?, DATAPROPOSTA = ?, DATAREALIZACAO = ?," +
            "DIASVALIDADEPROPOSTA = ?, DIASPRAZOENTREGA = ?," +
            "DIASPRAZOPAGAMENTO = ?, DIASVIGENCIA = ?, ANOSPRAZOGARANTIA = ?," +
            "TERMOSAMOSTRA = ?, TERMOSGARANTIA = ?, TERMOSMULTA = ? " +
            "where ID=?";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiLicitacao);

    pstmt.setInt(1, tipoLicitacao.getId());
    pstmt.setString(2, numero);
    pstmt.setInt(3, ano);
    pstmt.setInt(4, modalidade.getId());
    pstmt.setInt(5, sistema.getId());
    pstmt.setString(6, orgao.getCnpj());
    pstmt.setString(7, numeroProcesso);
    pstmt.setString(8, objeto);
    pstmt.setDate(9, dataDocumentacao);
    pstmt.setDate(10, dataProposta);
    pstmt.setDate(11, dataRealizacao);
    pstmt.setInt(12, diasValidadeProposta);
    pstmt.setInt(13, diasPrazoEntrega);
    pstmt.setInt(14, diasPrazoPagamento);
    pstmt.setInt(15, diasVigencia);
    pstmt.setInt(16, anosPrazoGarantia);
    pstmt.setString(17, termosAmostra);
    pstmt.setString(18, termosGarantia);
    pstmt.setString(19, termosMulta);
    
    pstmt.setInt(20, licitacao.getId());
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  /**
   * Inclui nova licitacao no banco de dados.
   * @return -  O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int incluir( model.beans.TipoLicitacao tipoLicitacao,
          String numero, int ano, model.beans.Modalidade modalidade,
          model.beans.Sistema sistema, model.beans.Orgao orgao, 
          String numeroProcesso, String objeto, Date dataDocumentacao, 
          Date dataProposta, Date dataRealizacao, int diasValidadeProposta,
          int diasPrazoEntrega, int diasPrazoPagamento, int diasVigencia,
          int anosPrazoGarantia, String termosAmostra, String termosGarantia,
          String termosMulta) throws SQLException, NamingException {
    
    final String sqlIncluiLicitacao = "insert into LICITACOES( " +
            "TIPOLICITACAO, NUMERO, ANO, MODALIDADE, SISTEMA, ORGAO, " +
            "NUMEROPROCESSO, OBJETO, DATADOCUMENTACAO, DATAPROPOSTA, " +
            "DATAREALIZACAO, DIASVALIDADEPROPOSTA, DIASPRAZOENTREGA," +
            "DIASPRAZOPAGAMENTO, DIASVIGENCIA, ANOSPRAZOGARANTIA," +
            "TERMOSAMOSTRA, TERMOSGARANTIA, TERMOSMULTA ) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiLicitacao);

    pstmt.setInt(1, tipoLicitacao.getId());
    pstmt.setString(2, numero);
    pstmt.setInt(3, ano);
    pstmt.setInt(4, modalidade.getId());
    pstmt.setInt(5, sistema.getId());
    pstmt.setString(6, orgao.getCnpj());
    pstmt.setString(7, numeroProcesso);
    pstmt.setString(8, objeto);
    pstmt.setDate(9, dataDocumentacao);
    pstmt.setDate(10, dataProposta);
    pstmt.setDate(11, dataRealizacao);
    pstmt.setInt(12, diasValidadeProposta);
    pstmt.setInt(13, diasPrazoEntrega);
    pstmt.setInt(14, diasPrazoPagamento);
    pstmt.setInt(15, diasVigencia);
    pstmt.setInt(16, anosPrazoGarantia);
    pstmt.setString(17, termosAmostra);
    pstmt.setString(18, termosGarantia);
    pstmt.setString(19, termosMulta);
    
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

  public static model.beans.Licitacao recuperar(int id)
          throws SQLException, NamingException {
    final String sqlRecuperarLicitacao = "select ID, TIPOLICITACAO, " +
            "NUMERO, ANO, MODALIDADE, SISTEMA, ORGAO, NUMEROPROCESSO, " +
            "OBJETO, DATADOCUMENTACAO, DATAPROPOSTA, DATAREALIZACAO, " +
            "DIASVALIDADEPROPOSTA, DIASPRAZOENTREGA, DIASPRAZOPAGAMENTO, " +
            "DIASVIGENCIA, ANOSPRAZOGARANTIA, TERMOSAMOSTRA, " +
            "TERMOSGARANTIA, TERMOSMULTA, STATUS " +
            "from LICITACOES where ID = ?";

    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarLicitacao);

    pstmt.setInt(1, id);
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
            "DIASVIGENCIA, ANOSPRAZOGARANTIA, TERMOSAMOSTRA, " +
            "TERMOSGARANTIA, TERMOSMULTA, STATUS " +
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
    String termosAmostra = rs.getString("TERMOSAMOSTRA");
    String termosGarantia = rs.getString("TERMOSGARANTIA");
    String termosMulta = rs.getString("TERMOSMULTA");
    int status = rs.getInt("STATUS");

    licitacao = new model.beans.Licitacao(id, idTipoLicitacao, numero, ano,
            idModalidade, idSistema, idorgao, numeroProcesso, objeto,
            dataDocumentacao, dataProposta, dataRealizacao,
            diasValidadeProposta, diasPrazoEntrega, diasPrazoPagamento,
            diasVigencia, anosPrazoGarantia, termosAmostra, termosGarantia, 
            termosMulta, status);

    return licitacao;
  }
}

package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 * DAO de Modalidades de Licitação
 * @author Adriano
 */
public class Modalidades {

  /**
   * Inclui uma nova modalidade de licitação no banco de dados.
   * @param sigla - sigla da nova modalidade
   * @param nome - nome da nova modalidade
   * @return -  O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int incluir(String sigla, String nome)
          throws SQLException, NamingException {
    final String sqlIncluiModalidade =
            "insert into MODALIDADES(SIGLA, NOME) values (?,?)";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiModalidade);

    pstmt.setString(1, sigla);
    pstmt.setString(2, nome);
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  /**
   * Altera o registro no banco de uma modalidade de licitação.
   * @param siglaAnterior - sigla atual
   * @param sigla - nova sigla
   * @param nome - novo nome
   * @return O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int alterar(String siglaAnterior, String sigla,
          String nome) throws SQLException, NamingException {
    final String sqlAlteraModalidade =
            "update MODALIDADES set sigla = ?, nome = ? where sigla = ? ";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraModalidade);

    pstmt.setString(1, sigla);
    pstmt.setString(2, nome);
    pstmt.setString(3, siglaAnterior);
    int buffer = pstmt.executeUpdate();
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();


    return buffer;
  }

  static private model.beans.Modalidade criaModalidade(int id, String sigla,
          String nome) {
    model.beans.Modalidade modalidade = new model.beans.Modalidade(
            id, nome, sigla);

    return modalidade;
  }

  static public model.beans.Modalidade recuperar(int id)
          throws NamingException, SQLException {
    final String sqlRecuperaModalidade =
            "select ID, SIGLA, NOME from MODALIDADES where ID=?";
    Connection gelic = model.services.Conexao.getPool().getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperaModalidade);
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Modalidade modalidade = null;
    if (rs.next()) {
      modalidade = criaModalidade(
              rs.getInt("ID"),
              rs.getString("SIGLA"),
              rs.getString("NOME"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return modalidade;
  }

  static public ArrayList<model.beans.Modalidade> recuperar()
          throws SQLException, NamingException {
    final String sqlContaModalidades = "select count(*) from MODALIDADES";
    final String sqlRecuperaModalidades =
            "select ID, SIGLA, NOME from MODALIDADES";
    ArrayList<model.beans.Modalidade> modalidades = null;
    PreparedStatement pstmt;
    int quantidadeModalidades = 0;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaModalidades);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeModalidades = rs.getInt(1);
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      rs.close();
      pstmt.close();
    }
    if (quantidadeModalidades < 1) {
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      gelic.close();
      return null;
    }
    /* Carrega usuários */
    pstmt = gelic.prepareStatement(sqlRecuperaModalidades);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      if (modalidades == null) {
        modalidades = new ArrayList<model.beans.Modalidade>(
                quantidadeModalidades);
      }

      modalidades.add(criaModalidade(
              rs.getInt("id"),
              rs.getString("SIGLA"),
              rs.getString("NOME")));
    }
    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();
    return modalidades;
  }

  public static int excluir(String sigla) throws SQLException, NamingException {
    final String sqlExcluiModalidade =
            "delete from MODALIDADES where SIGLA = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluiModalidade);
    pstmt.setString(1, sigla);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
}

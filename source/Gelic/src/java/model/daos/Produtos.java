package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;

/**
 * DAO de Produtos
 * @author Paulo
 */
public class Produtos {

  /**
   * Inclui um novo produto no banco de dados.
   * @param codigo - codigo do produto
   * @param descricao - descricao do produto
   * @param precovenda - preco de venda do produto
   * @param precocompra - preco de compra do produto
   * @return -  O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int incluir(String codigo, String descricao, float precovenda,
          float precocompra)
          throws SQLException, NamingException {
    final String sqlIncluiProduto =
            "insert into " +
            "PRODUTOS(CODIGO, DESCRICAO, PRECOVENDA, PRECOCOMPRA) " +
            "values (?,?,?,?)";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiProduto);

    pstmt.setString(1, codigo);
    pstmt.setString(2, descricao);
    pstmt.setFloat(3, precovenda);
    pstmt.setFloat(4, precocompra);
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
   * @param codigoAnterior - codigo atual
   * @param codigo - codigo do produto
   * @param descricao - descricao do produto
   * @param precovenda - preco de venda do produto
   * @param precocompra - preco de compra do produto
   * @return O retorno do <code>executeUpdate()</code>:
   * either (1) the row count for SQL Data Manipulation Language (DML) 
   * statements or (2) 0 for SQL statements that return nothing 
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  static public int alterar(String codigoAnterior, String codigo,
          String descricao, float precovenda, float precocompra)
          throws SQLException, NamingException {
    final String sqlAlteraProduto =
            "update PRODUTOS set codigo = ?, descricao = ?, precovenda = ?, " +
            "precocompra = ? where codigo = ? ";
    Connection gelic = model.services.Conexao.getConnection();

    PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraProduto);

    pstmt.setString(1, codigo);
    pstmt.setString(2, descricao);
    pstmt.setFloat(3, precovenda);
    pstmt.setFloat(4, precocompra);
    pstmt.setString(5, codigoAnterior);

    int buffer = pstmt.executeUpdate();

    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     * Não fecha o connection por causa do transaction.
     */
    pstmt.close();

    return buffer;
  }

  public static model.beans.Produto recuperar(int id)
          throws SQLException, NamingException {
    final String sqlRecuperarProduto = "select ID, CODIGO, DESCRICAO, " +
            "PRECOVENDA, PRECOCOMPRA from PRODUTOS where ID = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarProduto);

    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Produto produto = null;
    if (rs != null && rs.next()) {
      produto = new model.beans.Produto(
              rs.getInt("ID"),
              rs.getString("CODIGO"),
              rs.getString("DESCRICAO"),
              rs.getFloat("PRECOVENDA"),
              rs.getFloat("PRECOCOMPRA"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return produto;
  }

  public static void recuperar(model.beans.Lote lote)
          throws SQLException, NamingException {
    final String sql = "select distinct PRODUTOS.ID, PRODUTOS.CODIGO, " +
            "PRODUTOS.DESCRICAO, " +
            "PRODUTOS.PRECOVENDA, PRODUTOS.PRECOCOMPRA " +
            "from PRODUTOS inner join ITENSLOTE ON " +
            "( ITENSLOTE.LOTE=? ) AND (ITENSLOTE.PRODUTO = PRODUTOS.ID)";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sql);
    pstmt.setInt(1, lote.getId());
    ResultSet rs = pstmt.executeQuery();
    HashMap<Integer, model.beans.Produto> produtos = new HashMap<Integer, model.beans.Produto>();
    while (rs.next()) {
      produtos.put(new Integer(rs.getInt("ID")),
              new model.beans.Produto(rs.getInt("ID"),
              rs.getString("CODIGO"),
              rs.getString("DESCRICAO"),
              rs.getFloat("PRECOVENDA"),
              rs.getFloat("PRECOCOMPRA")));
    }
    for (model.beans.ItemLote itemLote : lote.getItensLote()) {
      itemLote.setProduto(produtos.get(new Integer(itemLote.getIdProduto())));
    }
    rs.close();
    pstmt.close();
    gelic.close();    
  }

  public static model.beans.Produto recuperar(String codigo)
          throws SQLException, NamingException {
    final String sqlRecuperarProduto = "select ID, CODIGO, DESCRICAO, " +
            "PRECOVENDA, PRECOCOMPRA from PRODUTOS where CODIGO = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarProduto);

    pstmt.setString(1, codigo);
    ResultSet rs = pstmt.executeQuery();
    model.beans.Produto produto = null;
    if (rs != null && rs.next()) {
      produto = new model.beans.Produto(
              rs.getInt("ID"),
              rs.getString("CODIGO"),
              rs.getString("DESCRICAO"),
              rs.getFloat("PRECOVENDA"),
              rs.getFloat("PRECOCOMPRA"));
    }
    rs.close();
    pstmt.close();
    gelic.close();
    return produto;
  }

  static public ArrayList<model.beans.Produto> recuperar()
          throws SQLException, NamingException {
    final String sqlContaProdutos = "select count(*) from PRODUTOS";
    final String sqlRecuperaProdutos =
            "select ID, CODIGO, DESCRICAO, PRECOVENDA, PRECOCOMPRA " +
            "from PRODUTOS";
    ArrayList<model.beans.Produto> produtos = null;
    PreparedStatement pstmt;
    int quantidadeProdutos = 0;
    ResultSet rs;

    Connection gelic = model.services.Conexao.getPool().getConnection();
    /* Conta quantidade de usuários cadastrados */
    pstmt = gelic.prepareStatement(sqlContaProdutos);
    rs = pstmt.executeQuery();
    if (rs != null && rs.next()) {
      quantidadeProdutos = rs.getInt(1);
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      rs.close();
      pstmt.close();
    }
    if (quantidadeProdutos < 1) {
      /*
       * Para aproveitar a conexão no pool é necessário fechar tudo...
       */
      gelic.close();
      return null;
    }
    /* Carrega usuários */
    pstmt = gelic.prepareStatement(sqlRecuperaProdutos);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      if (produtos == null) {
        produtos = new ArrayList<model.beans.Produto>(
                quantidadeProdutos);
      }

      produtos.add(new model.beans.Produto(
              rs.getInt("ID"),
              rs.getString("CODIGO"),
              rs.getString("DESCRICAO"),
              rs.getFloat("PRECOVENDA"),
              rs.getFloat("PRECOCOMPRA")));
    }

    /*
     * Para aproveitar a conexão no pool é necessário fechar tudo...
     */
    rs.close();
    pstmt.close();
    gelic.close();

    return produtos;
  }

  public static int excluir(int id) throws SQLException, NamingException {
    final String sqlExcluiProduto = "delete from PRODUTOS where ID = ?";
    Connection gelic = model.services.Conexao.getConnection();
    PreparedStatement pstmt = gelic.prepareStatement(sqlExcluiProduto);
    pstmt.setInt(1, id);
    int buffer = pstmt.executeUpdate();
    pstmt.close();
    return buffer;
  }
}

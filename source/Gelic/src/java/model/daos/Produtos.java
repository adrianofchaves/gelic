package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 * DAO de Produtos
 * @author Paulo
 */
public class Produtos {
    
    final static String sqlIncluiProduto =
            "insert into PRODUTOS(CODIGO, DESCRICAO, PRECOVENDA, PRECOCOMPRA) values (?,?,?,?)";
    final static String sqlAlteraProduto =
            "update PRODUTOS set codigo = ?, descricao = ?, precovenda = ?, precocompra = ?, where id = ? ";
    final static String sqlContaProdutos =
            "select count(*) from PRODUTOS";
    final static String sqlRecuperaProdutos =
            "select CODIGO, DESCRICAO, PRECOVENDA, PRECOCOMPRA from PRODUTOS";

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
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlIncluiProduto);

        pstmt.setString(1, codigo);
        pstmt.setString(2, descricao);
        pstmt.setFloat(3, precovenda);
        pstmt.setFloat(4, precocompra);

        return pstmt.executeUpdate();
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
            String descricao, float precovenda,float precocompra )
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraProduto);

        pstmt.setString(1, codigo);
        pstmt.setString(2, descricao);
        pstmt.setFloat(3, precovenda);
        pstmt.setFloat(4, precocompra);
        pstmt.setString(5, codigoAnterior);

        return pstmt.executeUpdate();
    }
    
    static private model.beans.Produto criaProduto( String codigo, String descricao,
            float precovenda,float precocompra ){
        model.beans.Produto produto = new model.beans.Produto();
        produto.setCodigo(codigo);
        produto.setDescricao(descricao);
        produto.setPrecoCompra(precocompra);
        produto.setPrecoVenda(precovenda);
        return produto;        
    }
    static public ArrayList<model.beans.Produto> recuperar() 
            throws SQLException, NamingException{
        ArrayList<model.beans.Produto> produtos = null;
        PreparedStatement pstmt;
        int quantidadeProdutos;
        ResultSet rs;

        Connection gelic = model.services.Conexao.getPool().getConnection();
        /* Conta quantidade de usuários cadastrados */
        pstmt = gelic.prepareStatement(sqlContaProdutos);
        rs = pstmt.executeQuery();
        if (rs == null) {
            return null;
        }
        if (!rs.next()) {
            return null;
        }
        quantidadeProdutos = rs.getInt(1);
        // rs.close(); precisa?
        pstmt.close(); //precisa?

        /* Carrega usuários */
        pstmt = gelic.prepareStatement(sqlRecuperaProdutos);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            if (produtos == null) {
                produtos = new ArrayList<model.beans.Produto>
                        (quantidadeProdutos);
            }

            produtos.add(criaProduto(
                    rs.getString("CODIGO"),
                    rs.getString("DESCRICAO"),
                    rs.getFloat("PRECOVENDA"),
                    rs.getFloat("PRECOCOMPRA")));
        }
        return produtos;
    }
}
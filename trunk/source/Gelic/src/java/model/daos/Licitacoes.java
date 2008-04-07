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
import javax.naming.NamingException;
import model.beans.Licitacao;

/**
 *
 * @author Paulo
 */
public class Licitacoes {

    final static String sqlIncluiLicitacao =
            "insert into LICITACOES(TIPOLICITACAO, NUMERO, ANO, ORGAO, OBJETO) values (?,?,?,?,?)";
    final static String sqlAlteraLicitacao =
            "update LICITACOES set tipolicitacao = ?, numero = ?, ano = ?, orgao = ?," +
            " objeto = ? where numero = ? ";
    final static String sqlContaLicitacoes =
            "select count(*) from LICITACOES";
    final static String sqlRecuperaLicitacoes =
            "select TIPOLICITACAO, NUMERO, ANO, ORGAO, OBJETO from LICITACOES";

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
    static public int alterar(int tipolicitacao, String numero, String numeroAnterior,
            int ano, String orgao, String descricao)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlAlteraLicitacao);

        pstmt.setInt(1, tipolicitacao);
        pstmt.setString(2, numero);
        pstmt.setInt(3, ano);
        pstmt.setString(4, orgao);
        pstmt.setString(5, descricao);
        pstmt.setString(6,numeroAnterior);

        int buffer = pstmt.executeUpdate();

        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         * Não fecha o connection por causa do transaction.
         */
        pstmt.close();

        return buffer;
    }
    static final String sqlRecuperarLicitacao = "select TIPOLICITACAO, NUMERO, " +
            "ANO, ORGAO, OBJETO from LICITACOES where NUMERO = ?";

    public static model.beans.Licitacao recuperar(String numero)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();

        PreparedStatement pstmt = gelic.prepareStatement(sqlRecuperarLicitacao);

        pstmt.setString(1, numero);
        ResultSet rs = pstmt.executeQuery();
        model.beans.Licitacao licitacao = null;
        if (rs != null && rs.next()) {
            licitacao = criaLicitacao(rs.getInt("TIPOLICITACAO"),
                    rs.getString("NUMERO"),
                    rs.getInt("ANO"),
                    rs.getFloat("ORGAO"),
                    rs.getString("OBJETO"));
        }
        rs.close();
        pstmt.close();
        gelic.close();
        return licitacao;
    }

    private static Licitacao criaLicitacao(int aInt, String string, int aInt0, float aFloat, String string0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static private model.beans.Licitacao criaLicitacao(int tipolicitacao, String numero, int ano,
            String orgao, String objeto) {
        model.beans.Licitacao licitacao = new model.beans.Licitacao();
        licitacao.setTipolicitacao(tipolicitacao);
        licitacao.setNumero(numero);
        licitacao.setAno(ano);
        licitacao.setOrgao(orgao);
        licitacao.setObjeto(objeto);
        return licitacao;
    }

    static public ArrayList<model.beans.Licitacao> recuperar()
            throws SQLException, NamingException {
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

            licitacoes.add(criaLicitacao(
                    rs.getInt("TIPOLICITACAO"),
                    rs.getString("NUMERO"),
                    rs.getInt("ANO"),
                    rs.getFloat("ORGAO"),
                    rs.getString("OBJETO")
                    )
                    );
        }

        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         */
        rs.close();
        pstmt.close();
        gelic.close();

        return licitacoes;
    }
}

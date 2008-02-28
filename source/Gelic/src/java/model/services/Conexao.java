/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Essa classe é responsável por fornecer a conexão com o banco de dados.  
 * @author adriano
 */
public class Conexao {

    static private Conexao servico = null;
    private DataSource pool;
    private ThreadLocal<Connection> conexao;

    private Conexao() throws NamingException {
        /* Abre arquivo poolGelic.properties */
        ResourceBundle prop = ResourceBundle.getBundle("Gelic");

        /* lê valor "pool" */
        String nomePool = prop.getString("pool");
        if (nomePool == null) {
            nomePool = "jdbc/gelic";
        }
        if (nomePool.equals("")) {
            nomePool = "jdbc/gelic";
        }

        /* procura conexão no pull do Tomcat */
        InitialContext ic = new InitialContext();
        Context ambiente = (Context) ic.lookup("java:comp/env");
        pool = (DataSource) ambiente.lookup(nomePool);
    }

    /**
     * Retorna o DataSource que corresponde ao pool do Tomcat.  Deve ser usado
     * quando a operação estiver dentro do escopo.  Por exemplo, se o o commit 
     * for executado pelo método que o chamou.  Para usar um escopo maior, use
     * o método <code>getConnection()</code>.
     * 
     * @return um pool (DataSource)
     * @throws javax.naming.NamingException
     */
    public static DataSource getPool() throws NamingException {
        if (servico == null) {
            servico = new Conexao();
        }
        return servico.pool;
    }

    /**
     * Retorna um Connection usado no Thread corrente. 
     * 
     * @return Connection
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
    public static Connection getConnection()
            throws SQLException, NamingException {
        if (servico == null) {
            servico = new Conexao();
        }
        if (servico.conexao == null) {
            servico.conexao = new ThreadLocal<Connection>();
            servico.conexao.set(servico.pool.getConnection());
            return servico.conexao.get();
        }
        return servico.conexao.get();
    }
}

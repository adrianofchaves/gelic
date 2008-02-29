/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Essa classe é responsável por fornecer a conexão com o banco de dados.  A 
 * princípio ele busca um <CODE>Datasource</CODE> no pool de conexões do Tomcat.  
 * 
 * Ela pode fornecer um <CODE>Datasource</CODE> para quem não precisar compartilhar a conexão
 * ou um <Code>Connection</code>
 * <BR><BR>
 * <COLOR="GREEN">TODO: Se não encontrar cria um próprio.  Assim deixará de 
 * propagar NamingException's.</COLOR>
 * @author adriano
 */
public class Conexao {

    static private Conexao servico = null;
    private final String nomePoolDefault = "jdbc/gelic";
    private DataSource pool;
    private ThreadLocal<Connection> conexao;

    /**
     * Lê no bundle "Gelic.properties" o nome do pool de conexões do Tomcat.
     * Se não encontrar o arquivo ou a propriedade "pool" retorna o padrão:
     * "jdbc/gelic".
     * 
     * @return String contendo o nome do pool do Tomcat.
     */
    private String getNomePool() {
        ResourceBundle prop = null;
        
        try {
            /* Abre arquivo poolGelic.properties */
            prop = ResourceBundle.getBundle("Gelic");
        } catch (MissingResourceException e) {
            return nomePoolDefault;
        }
        if (prop == null) {
            return nomePoolDefault; /* lê valor "pool" */
        }
        String nomePool = prop.getString("pool");
        if (nomePool == null) {
            return nomePoolDefault;
        }
        if (nomePool.equals("")) {
            return nomePoolDefault;
        }
        return nomePool;

    }

    private Conexao() throws NamingException {
        String nomePool = getNomePool();
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

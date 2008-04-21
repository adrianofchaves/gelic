/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author gustavo
 */
public class Produtos {

    public static void alterar(String codigoAnterior, String novoCodigo,
            String descricao, float precovenda, float precocompra)
            throws NamingException, SQLException {
        Connection gelic = model.services.Conexao.getConnection();
        if (model.daos.Produtos.alterar(codigoAnterior, novoCodigo, descricao,
                precovenda, precocompra) == 1) {
            gelic.commit();
        } else {
            gelic.rollback();
        }
        gelic.close();
    }

    public static void incluir(String codigo, String descricao, float precovenda,
            float precocompra)
            throws NamingException, SQLException {
        Connection gelic = model.services.Conexao.getConnection();
        if (model.daos.Produtos.incluir(codigo, descricao, precovenda,
                precocompra) == 1) {
            gelic.commit();
        } else {
            gelic.rollback();
        }
        gelic.close();
    }

    static public ArrayList<model.beans.Produto> recuperar()
            throws SQLException, NamingException {
        return model.daos.Produtos.recuperar();
    }

    public static model.beans.Produto recuperar(String codigo)
            throws SQLException, NamingException {
        return model.daos.Produtos.recuperar(codigo);
    }
    
    public static void excluir(String id) throws SQLException, NamingException {
    Connection gelic = model.services.Conexao.getConnection();
    try {
        model.daos.Produtos.excluir(id);
        gelic.commit();
        gelic.close();
        }catch (SQLException e) {
            gelic.rollback();
            gelic.close();
            throw e;
            }
    }
}

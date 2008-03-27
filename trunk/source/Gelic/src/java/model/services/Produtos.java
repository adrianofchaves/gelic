/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.services;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author gustavo
 */
public class Produtos {
    static ArrayList<model.beans.Produto> produtos = null;

    public static void alterar(String codigoAnterior, String novoCodigo,
            String descricao, float precovenda,float precocompra) 
            throws NamingException, SQLException {
        if (model.daos.Produtos.alterar(codigoAnterior, novoCodigo, descricao,
                precovenda, precocompra) == 1 ) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            produtos = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
    }

    public static void incluir(String codigo, String descricao, float precovenda,
            float precocompra) 
            throws NamingException, SQLException {
         if (model.daos.Produtos.incluir(codigo, descricao, precovenda, 
                 precocompra) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            produtos = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
    }

    static public ArrayList<model.beans.Produto> recuperar()
            throws SQLException, NamingException {
        if (produtos == null) {
            produtos = model.daos.Produtos.recuperar();
        }
        return produtos;
    }

    public static model.beans.Produto recuperar(String codigo,
            String descricao, float precovenda, float precocompra)
            throws SQLException, NamingException {
        if (produtos == null) {
            recuperar();
            if (produtos == null) {
                return null;
            }
        }
        
        for (model.beans.Produto produto : produtos) {
            
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return produto;
            }            
            
        }
        return null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.TipoLicitacao;

/**
 *
 * @author Adriano
 */
public class TiposLicitacoes {

    static ArrayList<model.beans.TipoLicitacao> tiposLicitacoes = null;

    public static void alterar(String nomeAnterior, String novoNome, 
            String novaSigla ) 
            throws NamingException, SQLException {
        Connection gelic = model.services.Conexao.getConnection();
        if (model.daos.TiposLicitacoes.alterar(
                nomeAnterior, novoNome, novaSigla ) == 1) {
            gelic.commit();
            /* apaga cache */
            tiposLicitacoes = null;
        } else {
            gelic.rollback();
        }
        gelic.close();
    }

    public static void incluir(String nome, String sigla) 
            throws NamingException, SQLException {
        Connection gelic = model.services.Conexao.getConnection();
         if (model.daos.TiposLicitacoes.incluir(nome, sigla) == 1) {
            gelic.commit();
            /* apaga cache */
            tiposLicitacoes = null;
        } else {
            gelic.rollback();
        }
        gelic.close();
    }

    static public ArrayList<model.beans.TipoLicitacao> recuperar()
            throws SQLException, NamingException {
        if (tiposLicitacoes == null) {
            tiposLicitacoes = model.daos.TiposLicitacoes.recuperar();
        }
        return tiposLicitacoes;
    }

    public static TipoLicitacao recuperar(String nome)
            throws SQLException, NamingException {
        if (tiposLicitacoes == null) {
            recuperar();
            if (tiposLicitacoes == null) {
                return null;
            }
        }
        
        for (TipoLicitacao tipo : tiposLicitacoes) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }
}

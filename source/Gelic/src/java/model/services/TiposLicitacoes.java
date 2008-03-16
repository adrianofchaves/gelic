/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

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

    public static void alterar(String nomeAnterior, String novoNome) 
            throws NamingException, SQLException {
        if (model.daos.TiposLicitacoes.alterar(
                nomeAnterior, novoNome ) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            tiposLicitacoes = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
    }

    public static void incluir(String nome) 
            throws NamingException, SQLException {
         if (model.daos.TiposLicitacoes.incluir(nome) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            tiposLicitacoes = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
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
        }
        for (TipoLicitacao tipo : tiposLicitacoes) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }
}

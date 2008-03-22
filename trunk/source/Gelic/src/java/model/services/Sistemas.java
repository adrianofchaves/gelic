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
 * @author Adriano
 */
public class Sistemas {

    static ArrayList<model.beans.Sistema> sistemas = null;

    static public void alterar(String nomeAnterior, String novoNome)
            throws SQLException, NamingException {
        if (model.daos.Sistemas.alterar(nomeAnterior, novoNome) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            sistemas = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }

    }

    static public void incluir(String nome)
            throws SQLException, NamingException {
        if (model.daos.Sistemas.incluir(nome) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            sistemas = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }

    }

    static public ArrayList<model.beans.Sistema> recuperar()
            throws SQLException, NamingException {
        if (sistemas == null) {
            sistemas = model.daos.Sistemas.recuperar();
        }
        return sistemas;
    }

    static public model.beans.Sistema recuperar(String nome)
            throws SQLException, NamingException {
        if (nome == null) {
            return null;
        }
        recuperar();
        for (model.beans.Sistema sistema : sistemas) {
            if (sistema.getNome().equals(nome)) {
                return sistema;
            }
        }
        return null;
    }
}

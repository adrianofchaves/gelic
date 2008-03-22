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
public class TiposDocumentos {
    static ArrayList<model.beans.TipoDocumento> tiposDocumentos = null;

    public static void alterar(String nomeAnterior, String novoNome ) 
            throws NamingException, SQLException {
        if (model.daos.TiposDocumentos.alterar( nomeAnterior, novoNome ) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            tiposDocumentos = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
    }

    public static void incluir(String nome) 
            throws NamingException, SQLException {
         if (model.daos.TiposDocumentos.incluir(nome) == 1) {
            model.services.Conexao.getConnection().commit();
            /* apaga cache */
            tiposDocumentos = null;
        } else {
            model.services.Conexao.getConnection().rollback();
        }
    }

    static public ArrayList<model.beans.TipoDocumento> recuperar()
            throws SQLException, NamingException {
        if (tiposDocumentos == null) {
            tiposDocumentos = model.daos.TiposDocumentos.recuperar();
        }
        return tiposDocumentos;
    }

    public static model.beans.TipoDocumento recuperar(String nome)
            throws SQLException, NamingException {
        if (tiposDocumentos == null) {
            recuperar();
            if (tiposDocumentos == null) {
                return null;
            }
        }
        
        for (model.beans.TipoDocumento tipo : tiposDocumentos) {
            
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }            
            
        }
        return null;
    }
}

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
 * @author adriano
 */
public class Enderecos {

    static private ArrayList<model.beans.TipoLogradouro> tipos = null;

    /**
     * Recupera os tipos de logradouros cadastrados.
     * 
     * @return Lista de objetos valores
     */
    static public ArrayList<model.beans.TipoLogradouro> recuperar()
            throws NamingException, SQLException {

        if (tipos == null) {
            tipos = model.daos.Enderecos.recuperar();
        }

        return tipos;
    }
}

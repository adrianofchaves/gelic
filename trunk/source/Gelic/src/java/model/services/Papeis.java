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
public class Papeis {
    static ArrayList <model.beans.Papel> papeis = null;

    static public ArrayList<model.beans.Papel> recuperar()
            throws NamingException, SQLException {
        if (papeis==null){
            papeis = model.daos.Papeis.recuperar();
        }
        return papeis;

    }

    public static Object recuperar(String papelUsuario) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}

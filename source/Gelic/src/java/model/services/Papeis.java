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

    static public ArrayList<model.beans.Papel> recuperar()
            throws NamingException, SQLException {
        return model.daos.Papeis.recuperar();

    }
}

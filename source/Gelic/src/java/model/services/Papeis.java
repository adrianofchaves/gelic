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
    /**
     * Retorna todos os papeis cadastrados.
     * 
     * @return
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    static public ArrayList<model.beans.Papel> recuperar()
            throws NamingException, SQLException {
        if (papeis==null){
            papeis = model.daos.Papeis.recuperar();
        }
        return papeis;

    }
    /**
     * Retorna o papel com o nome passado pelo parâmetro.
     * 
     * @param nomePapel
     * @return
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    public static model.beans.Papel recuperar(String nomePapel) 
            throws NamingException, SQLException {
        if(nomePapel == null){
            return null;
        }
        /* Como espera-se que a lista de papéis seja relativamente curta, não
         * há necessidade de ir ao banco buscar essa informação: resolve com 
         * a lista mantida estáticamente
         */         
        recuperar();
        for( model.beans.Papel papel : papeis ){
            if( nomePapel.equalsIgnoreCase(papel.getNome()))
                return papel;
        }
        return null;
    }
    
}

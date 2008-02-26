/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.daos;

/**
 * DAO responsável pelo acesso a tabela de usuário.
 * @author adriano
 */
public class Usuarios {
    /**
     * Recupera um usuário do banco de dados.
     * @param Login login do usuário
     * @return model.beans.Usuario
     */
    public static model.beans.Usuario recuperar( String Login ){
        /**
         * TODO: Aqui, o banco é o próprio programa.  Quando o banco estiver 
         * implementado devemos programar um select. Que substituirá todos esses
         * if...
         */
        if( Login.equalsIgnoreCase("ADMIN")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.ADMINISTRADOR);
            return usuario;
        }
        if( Login.equalsIgnoreCase("ANALISTA")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.ANALISTA);
            return usuario;
        }
        if( Login.equalsIgnoreCase("COMERCIAL")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.COMERCIAL);
            return usuario;
        }
        if( Login.equalsIgnoreCase("FINANCEIRO")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.FINANCEIRO);
            return usuario;
        }
        if( Login.equalsIgnoreCase("GERENTECOMERCIAL")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.GERENTECOMERCIAL);
            return usuario;
        }
            
        return null;
        
    }

}

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
     * @param Login login do usuário.  Se for null a função retornará null.
     * @return model.beans.Usuario
     */
    public static model.beans.Usuario recuperar( String login  ){
        /**
         * TODO: Aqui, o banco é o próprio programa.  Quando o banco estiver 
         * implementado devemos programar um select. Que substituirá todos esses
         * if...
         */
        if( login == null )
            return null;
        if( login.equalsIgnoreCase("ADMIN")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.ADMINISTRADOR);
            return usuario;
        }
        if( login.equalsIgnoreCase("ANALISTA")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.ANALISTA);
            return usuario;
        }
        if( login.equalsIgnoreCase("COMERCIAL")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.COMERCIAL);
            return usuario;
        }
        if( login.equalsIgnoreCase("FINANCEIRO")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.FINANCEIRO);
            return usuario;
        }
        if( login.equalsIgnoreCase("GERENTECOMERCIAL")){
            model.beans.Usuario usuario = new model.beans.Usuario();
            
            usuario.setTipo(model.beans.Usuario.GERENTECOMERCIAL);
            return usuario;
        }
            
        return null;
        
    }

}
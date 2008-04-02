/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.beans;

/**
 *
 * @author adriano
 */
public class TipoLogradouro {
    private String nome;
    
    public String toString(){
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.beans;

/**
 *
 * @author Adriano
 */
public class Sistema {
    private String nome;
    private int id;

  public Sistema(String nome, int id) {
    this.nome = nome;
    this.id = id;
  }
    
    public Sistema(){
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
    

}

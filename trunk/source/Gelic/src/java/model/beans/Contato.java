/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.beans;

/**
 *
 * @author Adriano
 */
public class Contato {
  private String nome;
  private TipoTelefone telefone;
  
  public Contato(){
    
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public TipoTelefone getTelefone() {
    return telefone;
  }

  public void setTelefone(TipoTelefone telefone) {
    this.telefone = telefone;
  }
}

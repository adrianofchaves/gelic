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
  private int idTelefone;
  private TipoTelefone telefone;
  private int id;
  
  public Contato(){
    
  }

  public Contato(String nome, int idTelefone, int id) {
    this.nome = nome;
    this.idTelefone = idTelefone;
    this.id = id;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdTelefone() {
    return idTelefone;
  }

  public void setIdTelefone(int idTelefone) {
    this.idTelefone = idTelefone;
  }
}

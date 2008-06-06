/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.beans.Proposta;



/**
 *
 * @author adriano
 */
public class ItemFormProposta {

  private float valor;
  private String nome;
  private String erro;
  private model.beans.Proposta proposta;

  public Proposta getProposta() {
    return proposta;
  }

  public void setProposta(Proposta proposta) {
    this.proposta = proposta;
  }
  
  private model.beans.ItemLote itemLote;

  public model.beans.ItemLote getItemLote() {
    return itemLote;
  }

  public void setItemLote(model.beans.ItemLote itemLote) {
    this.itemLote = itemLote;
  }

  public String getErro() {
    return erro;
  }

  public void setErro(String erro) {
    this.erro = erro;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}

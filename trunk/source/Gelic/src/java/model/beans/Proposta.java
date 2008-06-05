/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author adriano
 */
public class Proposta {

  private int idItemLote;
  private model.beans.ItemLote itemLote;
  private float preco;

  public int getIdItemLote() {
    return idItemLote;
  }

  public void setIdItemLote(int idItemLote) {
    this.idItemLote = idItemLote;
  }

  public Proposta(int idItemLote, float preco) {
    this.idItemLote = idItemLote;
    this.preco = preco;
  }

  public ItemLote getItemLote() {
    return itemLote;
  }

  public void setItemLote(ItemLote itemLote) {
    this.itemLote = itemLote;
  }

  public float getPreco() {
    return preco;
  }

  public void setPreco(float preco) {
    this.preco = preco;
  }

  public float getTotal() {
    return getItemLote().getQuantidade() * getPreco();
  }
}

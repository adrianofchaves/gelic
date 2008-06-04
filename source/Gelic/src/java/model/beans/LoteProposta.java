/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.beans;

import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public class LoteProposta {
  
  private model.beans.Lote lote;
  private model.beans.Empresa empresa;

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public Lote getLote() {
    return lote;
  }

  public void setLote(Lote lote) {
    this.lote = lote;
  }

  public ArrayList<Proposta> getPropostas() {
    return propostas;
  }

  public void setPropostas(ArrayList<Proposta> propostas) {
    this.propostas = propostas;
  }
  ArrayList <model.beans.Proposta> propostas;
  
  public float getValorTotal(){
    float total = 0;
    for( model.beans.Proposta proposta : getPropostas()){
      total += proposta.getTotal();
    }
    return total;
  }

}

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
public class EmpresaLote {

  private model.beans.Lote lote;
  private int idLote;
  private model.beans.Empresa empresa;
  private String idEmpresa;
  private ArrayList<Proposta> propostas;

  public EmpresaLote(String idEmpresa, int idLote) {
    this.idEmpresa = idEmpresa;
    this.idLote = idLote;
  }

  public EmpresaLote(Lote lote, Empresa empresa) {
    this.lote = lote;
    if (lote != null) {
      setIdLote(lote.getId());
    }
    this.empresa = empresa;
    if (empresa != null) {
      setIdEmpresa(empresa.getCnpj());
    }
  }

  public String getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(String idEmpresa) {
    this.idEmpresa = idEmpresa;
  }

  public float getTotal() {
    float total = 0;
    if (getPropostas() != null) {
      for (model.beans.Proposta proposta : getPropostas()) {
        total += proposta.getTotal();
      }
    }
    return total;
  }

  public int getIdLote() {
    return idLote;
  }

  public void setIdLote(int idLote) {
    this.idLote = idLote;
  }

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

  public float getValorTotal() {
    float total = 0;
    for (model.beans.Proposta proposta : getPropostas()) {
      total += proposta.getTotal();
    }
    return total;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class FormProposta extends Form {

  static final public String NOME_ATRIBUTO_DEFAULT = "formProposta";
  static final public String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private ArrayList<model.beans.Empresa> empresas;
  private ArrayList<ItemFormProposta> itens;
  private boolean inclusao;
  private boolean exclusao;
  private boolean alteracao;
  private String empresaProposta;

  public String getEmpresaProposta() {
    return empresaProposta;
  }

  public String preparaAlteracao(String empresa) throws NamingException, SQLException {
    prepara();

    for (model.beans.EmpresaLote emp : getLote().getEmpresas()) {
      if (empresa.equals(emp.getEmpresa().getCnpj())) {
        setEmpresaProposta(emp.getEmpresa().toString());
        for (model.beans.Proposta proposta : emp.getPropostas()) {
          for( ItemFormProposta itemForm : getItens()){
            if( itemForm.getItemLote().getId() == proposta.getIdItemLote()){
              itemForm.setProposta(proposta);
              itemForm.setValor(proposta.getPreco());
            }
          }
        }
      }
    }
    setTitulo("Alterando proposta");
    setAlteracao(true);
    return getNome();
  }

  public void setEmpresaProposta(String empresaProposta) {
    this.empresaProposta = empresaProposta;
  }

  public ArrayList<model.beans.Empresa> getEmpresas() {
    return empresas;
  }

  public void setEmpresas(ArrayList<model.beans.Empresa> empresas) {
    this.empresas = empresas;
  }

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
    if (alteracao) {
      setExclusao(false);
      setInclusao(false);
    }
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
    if (exclusao) {
      setAlteracao(false);
      setInclusao(false);
    }
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
    if (inclusao) {
      setAlteracao(false);
      setExclusao(false);
    }
  }

  public ArrayList<ItemFormProposta> getItens() {
    return itens;
  }

  public void setItens(ArrayList<ItemFormProposta> itens) {
    this.itens = itens;
  }

  private view.FormLote getFormLote() {
    return (view.FormLote) getOrigem().getOrigem();
  }

  private model.beans.Lote getLote() {
    return getFormLote().getLote();
  }

  private void prepara() throws NamingException, SQLException {
    setNome(NOME_DEFAULT);
    setEmpresas(model.services.Empresas.recuperar());
    model.services.ItensLote.recuperar(getLote());
    setItens(new ArrayList<ItemFormProposta>(getLote().getItensLote().size()));
    int indice = 0;
    for (model.beans.ItemLote item : getLote().getItensLote()) {
      indice++;
      ItemFormProposta itemForm = new ItemFormProposta();
      itemForm.setNome("precoProposta" + Integer.toString(indice));
      itemForm.setItemLote(item);
      getItens().add(itemForm);
    }

  }

  public String preparaInclusao() throws NamingException, SQLException {
    prepara();
    setTitulo("Nova proposta");
    return getNome();
  }
}

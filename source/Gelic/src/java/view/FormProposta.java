/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.EmpresaLote;

/**
 *
 * @author adriano
 */
public class FormProposta extends Form {

  static final public String NOME_ATRIBUTO_DEFAULT = "formProposta";
  static final public String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private ArrayList<model.beans.Empresa> empresas;
  private String empresaProposta;
  private String erroEmpresaProposta;

  public String getErroEmpresaProposta() {
    return erroEmpresaProposta;
  }

  public void setErroEmpresaProposta(String erroEmpresaProposta) {
    this.erroEmpresaProposta = erroEmpresaProposta;
  }
  private model.beans.EmpresaLote empresa;
  private ArrayList<ItemFormProposta> itens;
  private boolean inclusao;
  private boolean exclusao;
  private boolean alteracao;

  public EmpresaLote getEmpresa() {
    return empresa;
  }

  public void setEmpresa(EmpresaLote empresa) {
    this.empresa = empresa;
  }

  public String getEmpresaProposta() {
    return empresaProposta;
  }

  public String gravar() throws ExcecaoForm, SQLException, NamingException {
    if (isExclusao()) {
      apagaErros();
    }
    valida();
    if (temErros()) {
      return getNome();
    }
    if (isExclusao()) {
      model.services.Propostas.excluir(getLote(), getEmpresa());
      getOrigem().setMensagem("Proposta excluída.");
    } else {
      float precos[] = new float[getItens().size()];
      int indice = 0;
      for (ItemFormProposta item : getItens()) {
        precos[indice++] = item.getValor();
      }
      if (isAlteracao()) {
        model.services.Propostas.alterar(getLote(), getEmpresa(), precos);
        getOrigem().setMensagem("Proposta alterada.");
      }
      if (isInclusao()) {        
        model.services.Propostas.incluir(getLote(), calculaEmpresa(), precos);
        getOrigem().setMensagem("Proposta incluída.");

      }
    }
    getOrigem().refresh();
    return getOrigem().getNome();
  }

  private model.beans.Empresa calculaEmpresa() {
    for (model.beans.Empresa emp : getEmpresas()) {
      if (emp.toString().equals(getEmpresaProposta())) {
        return emp;
      }      
    }
    return null;
  }

  public String preparaAlteracao(String empresa) throws NamingException, SQLException {
    prepara();

    for (model.beans.EmpresaLote emp : getLote().getEmpresas()) {
      if (empresa.equals(emp.getEmpresa().getCnpj())) {
        setEmpresa(emp);
        setEmpresaProposta(emp.getEmpresa().toString());
        for (model.beans.Proposta proposta : emp.getPropostas()) {
          for (ItemFormProposta itemForm : getItens()) {
            if (itemForm.getItemLote().getId() == proposta.getIdItemLote()) {
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

  public String preparaExclusao(String empresa)
          throws NamingException, SQLException {
    prepara();

    for (model.beans.EmpresaLote emp : getLote().getEmpresas()) {
      if (empresa.equals(emp.getEmpresa().getCnpj())) {
        setEmpresa(emp);
        setEmpresaProposta(emp.getEmpresa().toString());
        for (model.beans.Proposta proposta : emp.getPropostas()) {
          for (ItemFormProposta itemForm : getItens()) {
            if (itemForm.getItemLote().getId() == proposta.getIdItemLote()) {
              itemForm.setProposta(proposta);
              itemForm.setValor(proposta.getPreco());
            }
          }
        }
      }
    }
    setTitulo("Excluindo proposta");
    setExclusao(true);
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
    setInclusao(true);
    return getNome();
  }

  private void valida() {
    if(isInclusao()){
      for( model.beans.EmpresaLote empresaLote: getLote().getEmpresas()){
        if( calculaEmpresa().getCnpj().equals(empresaLote.getIdEmpresa())){
          erroEmpresaProposta= "Esta empresa já tem uma proposta para " +
                  "este lote.";
          addErro("Empresa inválida!");
        }
      }
    }
  }
}

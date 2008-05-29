/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class FormLote extends Form {

  private model.beans.Lote lote;
  private String nomeLote;
  private int numeroLote;
  private String erroNomeLote;
  private String erroNumeroLote;
  private boolean inclusao;
  private boolean exclusao;
  private boolean alteracao;
  public final static String NOME_ATRIBUTO_DEFAULT = "formLote";
  public final static String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  
  public void apagaErros(){
    super.apagaErros();
    setErroNomeLote(null);
    setErroNumeroLote(null);
  }
  public String cancelar() {
    getOrigem().setMensagem("");
    return getOrigem().getNome();    
  }

  public model.beans.Lote getLote() {
    return lote;
  }

  public String gravar() {
    if(isExclusao()){
      //ignora erros de parse
      apagaErros();
    }
    
    
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public String preparaAlteracao(String lote) throws NamingException, SQLException {
    view.FormLicitacao form = (view.FormLicitacao)getOrigem().getOrigem();
    
    setLote(model.services.Lotes.recuperar(Integer.parseInt(lote)));
    atualizaCampos();
    setTitulo("Alterando lote " + getLote().toString() +
            " da licitação " + form.getLicitacao().toString());
    setAlteracao(true);    
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);
    
    return getNome();
  }

  public String preparaExclusao(String lote) throws NamingException, SQLException {
    view.FormLicitacao form = (view.FormLicitacao)getOrigem().getOrigem();
    
    setLote(model.services.Lotes.recuperar(Integer.parseInt(lote)));
    atualizaCampos();
    setTitulo("Excluindo lote " + getLote().toString() +
            " da licitação " + form.getLicitacao().toString());
    setExclusao(true);    
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);
    
    return getNome();
  }

  public String preparaInclusao() {
    view.FormLicitacao form = (view.FormLicitacao) getOrigem().getOrigem();
    setTitulo("Novo lote da licitação " + form.getLicitacao().toString());
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);
    /* sugere um número para o lote */
    for(model.beans.Lote mlote : form.getLicitacao().getMLote()){        
        if( mlote.getNumero() >= getNumeroLote() ){
           setNumeroLote(mlote.getNumero()+1);
        }
    }
    return getNome();
  }

  public void setLote(model.beans.Lote lote) {
    this.lote = lote;
  }

  public String getNomeLote() {
    return nomeLote;
  }

  public void setNomeLote(String nomeLote) {
    this.nomeLote = nomeLote;
  }

  public int getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(int numeroLote) {
    this.numeroLote = numeroLote;
  }

  public String getErroNomeLote() {
    return erroNomeLote;
  }

  public void setErroNomeLote(String erroNomeLote) {
    this.erroNomeLote = erroNomeLote;
  }

  public String getErroNumeroLote() {
    return erroNumeroLote;
  }

  public void setErroNumeroLote(String erroNumeroLote) {
    this.erroNumeroLote = erroNumeroLote;
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
  }

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
  }

  private void atualizaCampos() {
    setNumeroLote(lote.getNumero());
    setNomeLote(lote.getNome());    
  }
}

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

  @Override
  public void apagaErros() {
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

  public String gravar() throws NamingException, SQLException, ExcecaoForm {
    if (isExclusao()) {
      //ignora erros de parse
      apagaErros();
    }
    valida();
    if( temErros()){
      return getNome();
    }
    if( isInclusao()){
      model.services.Lotes.incluir( getLicitacao(), getNumeroLote(), 
              getNomeLote());
      getOrigem().setMensagem("Lote incluído.");
    }
    if(isAlteracao()){
      model.services.Lotes.alterar( getLote(), getNumeroLote(), 
              getNomeLote());
      getOrigem().setMensagem("Lote alterado.");
    }
    if(isExclusao()){
      model.services.Lotes.excluir( getLote() );
      getOrigem().setMensagem("Lote excluído.");
    }
    getOrigem().refresh();
    return getOrigem().getNome();
  }

  public String preparaAlteracao(String lote)
          throws NamingException, SQLException {

    setLote(model.services.Lotes.recuperar(Integer.parseInt(lote)));
    atualizaCampos();
    setTitulo("Alterando lote " + getLote().toString() +
            " da licitação " + getLicitacao().toString());
    setAlteracao(true);
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);

    return getNome();
  }

  public String preparaExclusao(String lote)
          throws NamingException, SQLException {


    setLote(model.services.Lotes.recuperar(Integer.parseInt(lote)));
    atualizaCampos();
    setTitulo("Excluindo lote " + getLote().toString() +
            " da licitação " + getLicitacao().toString());
    setExclusao(true);
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);

    return getNome();
  }

  public String preparaInclusao() {
    setTitulo("Novo lote da licitação " + getLicitacao().toString());
    getOrigem().setMensagem("");
    setNome(NOME_DEFAULT);
    setInclusao(true);
    /* sugere um número para o lote */
    setNumeroLote(1);
    for (model.beans.Lote mlote : getLicitacao().getMLote()) {
      if (mlote.getNumero() >= getNumeroLote()) {
        setNumeroLote(mlote.getNumero() + 1);
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

  private view.FormLicitacao getFormLicitacao() {
    view.FormLicitacao form = (view.FormLicitacao) getOrigem().getOrigem();
    return form;
  }

  private model.beans.Licitacao getLicitacao() {
    return getFormLicitacao().getLicitacao();
  }

  private void valida() throws NamingException, SQLException {
    if (isInclusao()) {
      if (model.services.Lotes.recuperar(
              getLicitacao(), getNumeroLote()) != null) {
        addErro("Número do lote inválido.");
        setErroNumeroLote("Já existe lote com esse número nesta licitação.");
      }
    }
    if (isAlteracao()) {
      if (model.services.Lotes.recuperar(
              getLicitacao(), getNumeroLote()).getId() != lote.getId()) {
        addErro("Número do lote inválido.");
        setErroNumeroLote("Já existe lote com esse número nesta licitação.");

      }
    }
  }
}

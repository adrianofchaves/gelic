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
public class FormModalidade extends Form {

  private model.beans.Modalidade modalidade;
  private String siglaModalidade;
  private String errosiglaModalidade;
  private String nomeModalidade;
  private String erroNomeModalidade;
  private boolean inclusao = true;
  private boolean exclusao;
  private boolean alteracao;

  public void apagaErros() {
    super.apagaErros();
    erroNomeModalidade = "";
    errosiglaModalidade = "";
  }

  public void valida() throws SQLException, NamingException {
    if( isExclusao()){
      // críticas de exclusão
      return;
    }
    apagaErros();
    if (getSiglaModalidade().length() > 3) {
      setErroSiglaModalidade("Sigla deve ter no máximo 3 caracteres");
      addErro("Sigla inválida");
    }
  }

  public void atualizaCampos() {
    apagaErros();
    if (modalidade == null) {
      return;
    }
    siglaModalidade = modalidade.getSigla();
    nomeModalidade = modalidade.getNome();
  }

  public model.beans.Modalidade getModalidade() {
    return modalidade;
  }

  public void setModalidade(model.beans.Modalidade modalidade) {
    this.modalidade = modalidade;
  }

  public String getSiglaModalidade() {
    return siglaModalidade;
  }

  public void setSiglaModalidade(String siglaModalidade) {
    this.siglaModalidade = siglaModalidade;
  }

  public String getErroSiglaModalidade() {
    return errosiglaModalidade;
  }

  public void setErroSiglaModalidade(String errosiglaModalidade) {
    this.errosiglaModalidade = errosiglaModalidade;
  }

  public String getNomeModalidade() {
    return nomeModalidade;
  }

  public void setNomeModalidade(String nomeModalidade) {
    this.nomeModalidade = nomeModalidade;
  }

  public String getErroNomeModalidade() {
    return erroNomeModalidade;
  }

  public void setErroNomeModalidade(String erroNomeModalidade) {
    this.erroNomeModalidade = erroNomeModalidade;
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(Boolean inclusao) {
    this.inclusao = inclusao;
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
    if (exclusao) {
      alteracao = false;
      inclusao = false;
    }
  }

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
    if (alteracao) {
      exclusao = false;
      inclusao = false;
    }
  }
}

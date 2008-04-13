/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Adriano
 */
public class FormContato extends Form {

  private model.beans.Contato contato;
  private String nomeContato;
  private String erroNomeContato;
  private String ddiContato;
  private String erroDdiContato;
  private String dddContato;
  private String erroDddContato;
  private String numeroTelefoneContato;
  private String erroNumeroTelfoneContato;
  private String ramalContato;
  private String erroRamalContato;
  private boolean inclusao;
  private boolean exclusao;
  private boolean alteracao;

  public void atualizaCampos() {
    if (contato == null) {
      return;
    }
    this.nomeContato = contato.getNome();
    if (contato.getTelefone() == null) {
      return;
    }

    this.ddiContato = contato.getTelefone().getDdi();
    this.dddContato = contato.getTelefone().getDdd();
    this.numeroTelefoneContato = contato.getTelefone().getTelefone();
    this.ramalContato = contato.getTelefone().getRamal();

  }

  public model.beans.Contato getContato() {
    return contato;
  }

  public void setContato(model.beans.Contato contato) {
    this.contato = contato;
  }

  public String getNomeContato() {
    return nomeContato;
  }

  public void setNomeContato(String nomeContato) {
    this.nomeContato = nomeContato;
  }

  public String getDdiContato() {
    return ddiContato;
  }

  public void setDdiContato(String ddiContato) {
    this.ddiContato = ddiContato;
  }

  public String getDddContato() {
    return dddContato;
  }

  public void setDddContato(String dddContato) {
    this.dddContato = dddContato;
  }

  public String getNumeroTelefoneContato() {
    return numeroTelefoneContato;
  }

  public void setNumeroTelefoneContato(String numeroTelefoneContato) {
    this.numeroTelefoneContato = numeroTelefoneContato;
  }

  public String getRamalContato() {
    return ramalContato;
  }

  public void setRamalContato(String ramalContato) {
    this.ramalContato = ramalContato;
  }

  public String getErroNomeContato() {
    return erroNomeContato;
  }

  public void setErroNomeContato(String erroNomeContato) {
    this.erroNomeContato = erroNomeContato;
  }

  public String getErroDdiContato() {
    return erroDdiContato;
  }

  public void setErroDdiContato(String erroDdiContato) {
    this.erroDdiContato = erroDdiContato;
  }

  public String getErroDddContato() {
    return erroDddContato;
  }

  public void setErroDddContato(String erroDddContato) {
    this.erroDddContato = erroDddContato;
  }

  public String getErroNumeroTelfoneContato() {
    return erroNumeroTelfoneContato;
  }

  public void setErroNumeroTelfoneContato(String erroNumeroTelfoneContato) {
    this.erroNumeroTelfoneContato = erroNumeroTelfoneContato;
  }

  public String getErroRamalContato() {
    return erroRamalContato;
  }

  public void setErroRamalContato(String erroRamalContato) {
    this.erroRamalContato = erroRamalContato;
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

  public void valida() {
    super.apagaErros();
  }
}

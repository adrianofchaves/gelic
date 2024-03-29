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
public class FormSistema extends Form {

  private model.beans.Sistema sistema;
  private String nomeSistema;
  private String erroNomeSistema;
  private Boolean inclusao = true;
  private boolean exclusao;
  private boolean alteracao;

  @Override
  public void apagaErros() {
    super.apagaErros();
    erroNomeSistema = "";
  }

  public void valida() throws SQLException, NamingException {
    apagaErros();
    if (isExclusao()) {
      if (model.services.Licitacoes.temLicitacao(sistema)) {
        addErro("Exclusão inválida: existem licitações para este sistema.");
      }
    }
    if (!isExclusao() && !isAlteracao()) { // inclusão
      if (model.services.Sistemas.recuperar(nomeSistema) != null) {
        addErro("Nome inválido!");
        erroNomeSistema = "Já existe um sistema com esse nome";
      }
    }
    if (isAlteracao()) {
      if (!nomeSistema.equalsIgnoreCase(sistema.getNome())) {
        if (model.services.Sistemas.recuperar(nomeSistema) != null) {
          addErro("Nome inválido!");
          erroNomeSistema = "Já existe um sistema com esse nome";
        }
      }
    }
  }

  public void atualizaCampos() {
    apagaErros();
    if (sistema == null) {
      return;
    }
    nomeSistema = sistema.getNome();
  }

  public FormSistema() {

  }

  public model.beans.Sistema getSistema() {
    return sistema;
  }

  public void setSistema(model.beans.Sistema sistema) {
    this.sistema = sistema;
  }

  public String getNomeSistema() {
    return nomeSistema;
  }

  public void setNomeSistema(String nomeSistema) {
    this.nomeSistema = nomeSistema;
  }

  public String getErroNomeSistema() {
    return erroNomeSistema;
  }

  public void setErroNomeSistema(String erroNomeSistema) {
    this.erroNomeSistema = erroNomeSistema;
  }

  public Boolean getInclusao() {
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

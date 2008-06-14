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
public class FormTipoLicitacao extends Form {

  private model.beans.TipoLicitacao tipoLicitacao;
  private String nomeTipoLicitacao;
  private String erroNomeTipoLicitacao;
  private String siglaTipoLicitacao;
  private String erroSiglaTipoLicitacao;
  private boolean inclusao = true;
  private boolean exclusao;
  private boolean alteracao;

  public void valida() throws SQLException, NamingException {
    apagaErros();
    if (isExclusao()) {
      /* Incluir críticas de exclusão aqui */
      if (model.services.Licitacoes.temLicitacao(tipoLicitacao)) {
        addErro("Exclusão inválida: existem licitações desse tipo.");
      }
      return;
    }
    if (siglaTipoLicitacao.length() != 2) {
      erroSiglaTipoLicitacao = "Sigla deve ter 2 caracteres";
      addErro("Sigla inválida!");
    }
    if (isInclusao()) {
      /* críticas de inclusão */
      if (model.services.TiposLicitacoes.recuperarNome(
              nomeTipoLicitacao) != null) {
        erroNomeTipoLicitacao = "Nome já existe";
        addErro("Já existe um tipo de licitação com este nome.");
      }
      if (model.services.TiposLicitacoes.recuperar(
              siglaTipoLicitacao) != null) {
        erroNomeTipoLicitacao = "Sigla já existe";
        addErro("Já existe um tipo de licitação com esta sigla.");
      }

    }
    if (!isInclusao()) {
      /* críticas para a alteração */
      if (!getNomeTipoLicitacao().equalsIgnoreCase(
              tipoLicitacao.getNome())) {
        /* alterou o nome.  Verificamos se novo nome já existe */
        if (model.services.TiposLicitacoes.recuperarNome(
                nomeTipoLicitacao) != null) {
          erroNomeTipoLicitacao = "Nome já existe";
          addErro("Já existe um tipo de licitação com este nome.");
        }
      }
      if (!getSiglaTipoLicitacao().equalsIgnoreCase(
              tipoLicitacao.getSigla())) {
        if (model.services.TiposLicitacoes.recuperar(
                siglaTipoLicitacao) != null) {
          erroSiglaTipoLicitacao = "Sigla já existe";
          addErro("Já existe um tipo de licitação com esta sigla.");
        }
      }
    }
  }

  protected void apagaErros() {
    super.apagaErros();
    erroNomeTipoLicitacao = "";
  }

  public void atualizaCampos() {
    apagaErros();
    if (tipoLicitacao == null) {
      return;
    }
    setNomeTipoLicitacao(tipoLicitacao.getNome());
    setSiglaTipoLicitacao(tipoLicitacao.getSigla());
  }

  public model.beans.TipoLicitacao getTipoLicitacao() {
    return tipoLicitacao;
  }

  public void setTipoLicitacao(model.beans.TipoLicitacao tipoLicitacao) {
    this.tipoLicitacao = tipoLicitacao;
  }

  public String getNomeTipoLicitacao() {
    return nomeTipoLicitacao;
  }

  public void setNomeTipoLicitacao(String nomeTipoLicitacao) {
    this.nomeTipoLicitacao = nomeTipoLicitacao;
  }

  public String getErroNomeTipoLicitacao() {
    return erroNomeTipoLicitacao;
  }

  public void setErroNomeTipoLicitacao(String erroNomeTipoLicitacao) {
    this.erroNomeTipoLicitacao = erroNomeTipoLicitacao;
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
  }

  public String getSiglaTipoLicitacao() {
    return siglaTipoLicitacao;
  }

  public void setSiglaTipoLicitacao(String siglaTipoLicitacao) {
    this.siglaTipoLicitacao = siglaTipoLicitacao;
  }

  public String getErroSiglaTipoLicitacao() {
    return erroSiglaTipoLicitacao;
  }

  public void setErroSiglaTipoLicitacao(String erroSiglaTipoLicitacao) {
    this.erroSiglaTipoLicitacao = erroSiglaTipoLicitacao;
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

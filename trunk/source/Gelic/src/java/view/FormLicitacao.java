/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Paulo
 */
public class FormLicitacao extends Form {

  static public final String NOME_ATRIBUTO_DEFAULT = "formLicitacao";
  static public final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private model.beans.Licitacao licitacao;
  private ArrayList<model.beans.TipoLicitacao> tiposLicitacoes;
  private String tipoLicitacaoLicitacao;
  private String erroTipoLicitacaoLicitacao;
  private String numeroLicitacao;
  private String erroNumeroLicitacao;
  private int anoLicitacao;
  private String erroAnoLicitacao;
  private ArrayList<model.beans.Orgao> orgaos;
  private String orgaoLicitacao;
  private String erroOrgaoLicitacao;
  private String objetoLicitacao;
  private String erroObjetoLicitacao;
  private String numeroProcessoLicitacao;
  private String erroNumeroProcessoLicitacao;
  private ArrayList<model.beans.Modalidade> modalidades;
  private String modalidadeLicitacao;
  private String erroModalidadeLicitacao;
  private ArrayList<model.beans.Sistema> sistemas;
  private String sistemaLicitacao;
  private String erroSistemaLicitacao;
  private Date dataDocumentacaoLicitacao;
  private String erroDataDocumentacaoLicitacao;
  private Date dataPropostaLicitacao;
  private String erroDataPropostaLicitacao;
  private Date dataRealizacaoLicitacao;
  private String erroDataRealizacaoLicitacao;
  private int diasPrazoEntregaLicitacao;
  private String erroDiasPrazoEntregaLicitacao;
  private int diasPrazoPagamentoLicitacao;
  private String erroDiasPrazoPagamentoLicitacao;
  private int diasVigenciaLicitacao;
  private String erroDiasVigenciaLicitacao;
  private int anosPrazoGarantiaLicitacao;
  private String erroAnosPrazoGarantiaLicitacao;
  private int diasValidadePropostaLicitacao;
  private String erroDiasValidadePropostaLicitacao;
  private String termosAmostraLicitacao;
  private String erroTermosAmostraLicitacao;
  private String termosGarantiaLicitacao;
  private String erroTermosGarantiaLicitacao;
  private String termosMultaLicitacao;
  private String erroTermosMultaLicitacao;
  private boolean inclusao = true;
  private boolean exclusao = false;
  private boolean alteracao = false;
  
  @Override
  public void refresh(){
    
  }
  @Override
  public void apagaErros() {
    super.apagaErros();

    setErroTipoLicitacaoLicitacao(null);
    setErroNumeroLicitacao(null);
    setErroAnoLicitacao(null);
    setErroOrgaoLicitacao(null);
    setErroObjetoLicitacao(null);
    setErroNumeroProcessoLicitacao(null);
    setErroModalidadeLicitacao(null);
    setErroSistemaLicitacao(null);
    setErroDataDocumentacaoLicitacao(null);
    setErroDataPropostaLicitacao(null);
    setErroDataRealizacaoLicitacao(null);
    setErroDiasPrazoEntregaLicitacao(null);
    setErroDiasPrazoPagamentoLicitacao(null);
    setErroDiasVigenciaLicitacao(null);
    setErroAnosPrazoGarantiaLicitacao(null);
    setErroDiasValidadePropostaLicitacao(null);
    setErroTermosAmostraLicitacao(null);
    setErroTermosGarantiaLicitacao(null);
    setErroTermosMultaLicitacao(null);

  }

  public String cancelar() {
    return getOrigem().getNome();
  }

  private model.beans.TipoLicitacao calculaTipoLicitacaoLicitacao() {
    String buffer = tipoLicitacaoLicitacao;
    for (model.beans.TipoLicitacao tipo : tiposLicitacoes) {
      if (tipo.getSigla().equalsIgnoreCase(buffer)) {
        return tipo;
      }
    }
    return null;
  }

  private model.beans.Modalidade calculaModalidadeLicitacao() {
    String buffer = modalidadeLicitacao;
    for (model.beans.Modalidade modalidade : modalidades) {
      if (modalidade.getSigla().equalsIgnoreCase(buffer)) {
        return modalidade;
      }
    }
    return null;
  }

  private model.beans.Sistema calculaSistemaLicitacao() {
    String buffer = sistemaLicitacao;
    for (model.beans.Sistema sistema : sistemas) {
      if (sistema.getNome().equalsIgnoreCase(buffer)) {
        return sistema;
      }
    }
    return null;
  }

  private model.beans.Orgao calculaOrgaoLicitacao() {
    String buffer = orgaoLicitacao;
    for (model.beans.Orgao orgao : orgaos) {
      if (orgao.getApelido().equalsIgnoreCase(buffer)) {
        return orgao;
      }
    }
    return null;
  }

  public String gravar() throws ExcecaoForm, NamingException, SQLException {
    if(isExclusao()){
      //ignora erros de parse
     apagaErros(); 
    }
    validar();
    if (temErros()) {
      return getNome();
    }
    if (isInclusao()) {
      model.services.Licitacoes.incluir(
              calculaTipoLicitacaoLicitacao(), getNumeroLicitacao(),
              getAnoLicitacao(), calculaModalidadeLicitacao(),
              calculaSistemaLicitacao(), calculaOrgaoLicitacao(),
              getNumeroProcessoLicitacao(), getObjetoLicitacao(),
              getDataDocumentacaoLicitacao(), getDataPropostaLicitacao(),
              getDataRealizacaoLicitacao(), getDiasValidadePropostaLicitacao(),
              getDiasPrazoEntregaLicitacao(), getDiasPrazoPagamentoLicitacao(),
              getDiasVigenciaLicitacao(), getAnosPrazoGarantiaLicitacao(),
              getTermosAmostraLicitacao(), getTermosGarantiaLicitacao(),
              getTermosMultaLicitacao());
      getOrigem().setMensagem("Nova licitação incluída.");
    }
    if( isExclusao()){
      model.services.Licitacoes.excluir(licitacao);
      getOrigem().setMensagem("Licitação excluída.");
    }
    if (isAlteracao()) {
      model.services.Licitacoes.alterar( getLicitacao(),
              calculaTipoLicitacaoLicitacao(), getNumeroLicitacao(),
              getAnoLicitacao(), calculaModalidadeLicitacao(),
              calculaSistemaLicitacao(), calculaOrgaoLicitacao(),
              getNumeroProcessoLicitacao(), getObjetoLicitacao(),
              getDataDocumentacaoLicitacao(), getDataPropostaLicitacao(),
              getDataRealizacaoLicitacao(), getDiasValidadePropostaLicitacao(),
              getDiasPrazoEntregaLicitacao(), getDiasPrazoPagamentoLicitacao(),
              getDiasVigenciaLicitacao(), getAnosPrazoGarantiaLicitacao(),
              getTermosAmostraLicitacao(), getTermosGarantiaLicitacao(),
              getTermosMultaLicitacao());
      getOrigem().setMensagem("Licitação alterada.");
    }

    getOrigem().refresh();

    return getOrigem().getNome();
  }

  /**
   * Prepara form para alteração.
   * @param licitacao - ID da licitação
   */
  public void preparaAlteracao(String licitacao)
          throws SQLException, NamingException {
    this.getOrigem().setMensagem("");
    this.licitacao = model.services.Licitacoes.recuperar(
            Integer.parseInt(licitacao));
    atualizaCampos();
    setAlteracao(true);
    setNome(NOME_DEFAULT);
    carregaListas();
  }

  public void preparaExclusao(String licitacao)
          throws SQLException, NamingException {
    this.getOrigem().setMensagem("");
    this.licitacao = model.services.Licitacoes.recuperar(
            Integer.parseInt(licitacao));
    atualizaCampos();
    setExclusao(true);
    setNome(NOME_DEFAULT);
    carregaListas();
  }

  public void preparaInclusao() throws NamingException, SQLException {
    this.getOrigem().setMensagem("");
    setExclusao(false);
    setAlteracao(false);
    setInclusao(true);
    setNome(NOME_DEFAULT);
    carregaListas();

  }

  public void valida() throws SQLException, NamingException {
    apagaErros();
    if (isExclusao()) {
      // Colocar críticas de exclusão aqui.
      return;
    }
    if (getNumeroLicitacao().length() == 0) {
      setErroNumeroLicitacao("Numero não pode ser vazio");
      addErro("Numero inválido!");
    }
  }

  public void atualizaCampos() {
    apagaErros();
    if (getLicitacao() == null) {
      return;
    }
    setOrgaoLicitacao(licitacao.getOrgao().toString());
    setNumeroLicitacao(licitacao.getNumero());
    setNumeroProcessoLicitacao(licitacao.getNumeroProcesso());
    setAnoLicitacao(licitacao.getAno());
    setModalidadeLicitacao(licitacao.getModalidade().toString());
    setTipoLicitacaoLicitacao(licitacao.getTipoLicitacao().toString());
    setSistemaLicitacao(licitacao.getSistema().toString());
    setDataDocumentacaoLicitacao(
            Date.valueOf(licitacao.getDataRealizacao().toString()));
    setDataPropostaLicitacao(
            Date.valueOf(licitacao.getDataProposta().toString()));
    setDataRealizacaoLicitacao(
            Date.valueOf(licitacao.getDataRealizacao().toString()));
    setDiasValidadePropostaLicitacao(licitacao.getDiasValidadeProposta());
    setDiasPrazoEntregaLicitacao(licitacao.getDiasPrazoEntrega());
    setDiasPrazoPagamentoLicitacao(licitacao.getDiasPrazoPagamento());
    setDiasVigenciaLicitacao(licitacao.getDiasVigencia());
    setAnosPrazoGarantiaLicitacao(licitacao.getAnosPrazoGarantia());
    setTermosAmostraLicitacao(licitacao.getTermosAmostra());
    setTermosGarantiaLicitacao(licitacao.getTermosGarantia());
    setTermosMultaLicitacao(licitacao.getTermosMulta());
    setObjetoLicitacao(licitacao.getObjeto());
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public model.beans.Licitacao getLicitacao() {
    return licitacao;
  }

  public String getTipoLicitacaoLicitacao() {
    return tipoLicitacaoLicitacao;
  }

  public String getErroTipoLicitacaoLicitacao() {
    return erroTipoLicitacaoLicitacao;
  }

  public String getNumeroLicitacao() {
    return numeroLicitacao;
  }

  public void setNumeroLicitacao(String numeroLicitacao) {
    this.numeroLicitacao = numeroLicitacao;
  }

  public String getErroNumeroLicitacao() {
    return erroNumeroLicitacao;
  }

  public void setErroNumeroLicitacao(String erroNumeroLicitacao) {
    this.erroNumeroLicitacao = erroNumeroLicitacao;
  }

  public int getAnoLicitacao() {
    return anoLicitacao;
  }

  public void setAnoLicitacao(int anoLicitacao) {
    this.anoLicitacao = anoLicitacao;
  }

  public String getErroAnoLicitacao() {
    return erroAnoLicitacao;
  }

  public void setErroAnoLicitacao(String erroAnoLicitacao) {
    this.erroAnoLicitacao = erroAnoLicitacao;
  }

  public String getOrgaoLicitacao() {
    return orgaoLicitacao;
  }

  public void setOrgaoLicitacao(String orgaoLicitacao) {
    this.orgaoLicitacao = orgaoLicitacao;
  }

  public String getErroOrgaoLicitacao() {
    return erroOrgaoLicitacao;
  }

  public void setErroOrgaoLicitacao(String erroOrgaoLicitacao) {
    this.erroOrgaoLicitacao = erroOrgaoLicitacao;
  }

  public String getObjetoLicitacao() {
    return objetoLicitacao;
  }

  public void setObjetoLicitacao(String objetoLicitacao) {
    this.objetoLicitacao = objetoLicitacao;
  }

  public String getErroObjetoLicitacao() {
    return erroObjetoLicitacao;
  }

  public void setErroObjetoLicitacao(String erroObjetoLicitacao) {
    this.erroObjetoLicitacao = erroObjetoLicitacao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
    if(inclusao){
      setAlteracao(false);
      setExclusao(false);
    }
  }

  public void setTipoLicitacaoLicitacao(String tipoLicitacaoLicitacao) {
    this.tipoLicitacaoLicitacao = tipoLicitacaoLicitacao;
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
    if(exclusao){
      setAlteracao(false);
      setInclusao(false);
    }
  }

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
    if(alteracao){
      setInclusao(false);
      setExclusao(false);
    }
  }

  public String getNumeroProcessoLicitacao() {
    return numeroProcessoLicitacao;
  }

  public void setNumeroProcessoLicitacao(String numeroProcessoLicitacao) {
    this.numeroProcessoLicitacao = numeroProcessoLicitacao;
  }

  public String getErroNumeroProcessoLicitacao() {
    return erroNumeroProcessoLicitacao;
  }

  public void setErroNumeroProcesso(String erroNumeroProcessoLicitacao) {
    this.setErroNumeroProcessoLicitacao(erroNumeroProcessoLicitacao);
  }

  public String getModalidadeLicitacao() {
    return modalidadeLicitacao;
  }

  public void setModalidadeLicitacao(String modalidadeLicitacao) {
    this.modalidadeLicitacao = modalidadeLicitacao;
  }

  public String getErroModalidadeLicitacao() {
    return erroModalidadeLicitacao;
  }

  public void setErroModalidadeLicitacao(String erroModalidadeLicitacao) {
    this.erroModalidadeLicitacao = erroModalidadeLicitacao;
  }

  public String getSistemaLicitacao() {
    return sistemaLicitacao;
  }

  public void setSistemaLicitacao(String sistemaLicitacao) {
    this.sistemaLicitacao = sistemaLicitacao;
  }

  public String getErroSistemaLicitacao() {
    return erroSistemaLicitacao;
  }

  public void setErroSistemaLicitacao(String erroSistemaLicitacao) {
    this.erroSistemaLicitacao = erroSistemaLicitacao;
  }
  public String getDataDocumentacaoLicitacaoFormatada(){
    return util.Forms.formata(getDataDocumentacaoLicitacao());
  }
  public Date getDataDocumentacaoLicitacao() {
    return dataDocumentacaoLicitacao;
  }

  public void setDataDocumentacaoLicitacao(Date dataDocumentacaoLicitacao) {
    this.dataDocumentacaoLicitacao = dataDocumentacaoLicitacao;    
  }
  public String getDataPropostaLicitacaoFormatada(){
    return util.Forms.formata(getDataPropostaLicitacao());
  }
  public Date getDataPropostaLicitacao() {
    return dataPropostaLicitacao;
  }

  public void setDataPropostaLicitacao(Date dataPropostaLicitacao) {
    this.dataPropostaLicitacao = dataPropostaLicitacao;
  }
  public String getDataRealizacaoLicitacaoFormatada(){
    return util.Forms.formata(getDataRealizacaoLicitacao());
  }
  public Date getDataRealizacaoLicitacao() {
    return dataRealizacaoLicitacao;
  }

  public void setDataRealizacaoLicitacao(Date dataRealizacaoLicitacao) {
    this.dataRealizacaoLicitacao = dataRealizacaoLicitacao;
  }

  public String getErroDataDocumentacaoLicitacao() {
    return erroDataDocumentacaoLicitacao;
  }

  public void setErroDataDocumentacaoLicitacao(String erroDataDocumentacaoLicitacao) {
    this.erroDataDocumentacaoLicitacao = erroDataDocumentacaoLicitacao;
  }

  public String getErroDataPropostaLicitacao() {
    return erroDataPropostaLicitacao;
  }

  public void setErroDataPropostaLicitacao(String erroDataPropostaLicitacao) {
    this.erroDataPropostaLicitacao = erroDataPropostaLicitacao;
  }

  public String getErroDataRealizacaoLicitacao() {
    return erroDataRealizacaoLicitacao;
  }

  public void setErroDataRealizacaoLicitacao(String erroDataRealizacaoLicitacao) {
    this.erroDataRealizacaoLicitacao = erroDataRealizacaoLicitacao;
  }

  public ArrayList<model.beans.TipoLicitacao> getTiposLicitacoes() {
    return tiposLicitacoes;
  }

  public void setTiposLicitacoes(ArrayList<model.beans.TipoLicitacao> tiposLicitacoes) {
    this.tiposLicitacoes = tiposLicitacoes;
  }

  public ArrayList<model.beans.Orgao> getOrgaos() {
    return orgaos;
  }

  public void setOrgaos(ArrayList<model.beans.Orgao> orgaos) {
    this.orgaos = orgaos;
  }

  public ArrayList<model.beans.Modalidade> getModalidades() {
    return modalidades;
  }

  public void setModalidades(ArrayList<model.beans.Modalidade> modalidades) {
    this.modalidades = modalidades;
  }

  public ArrayList<model.beans.Sistema> getSistemas() {
    return sistemas;
  }

  public void setSistemas(ArrayList<model.beans.Sistema> sistemas) {
    this.sistemas = sistemas;
  }

  public int getDiasPrazoEntregaLicitacao() {
    return diasPrazoEntregaLicitacao;
  }

  public void setDiasPrazoEntregaLicitacao(int diasPrazoEntregaLicitacao) {
    this.diasPrazoEntregaLicitacao = diasPrazoEntregaLicitacao;
  }

  public int getDiasPrazoPagamentoLicitacao() {
    return diasPrazoPagamentoLicitacao;
  }

  public void setDiasPrazoPagamentoLicitacao(int diasPrazoPagamentoLicitacao) {
    this.diasPrazoPagamentoLicitacao = diasPrazoPagamentoLicitacao;
  }

  public int getDiasVigenciaLicitacao() {
    return diasVigenciaLicitacao;
  }

  public void setDiasVigenciaLicitacao(int diasVigenciaLicitacao) {
    this.diasVigenciaLicitacao = diasVigenciaLicitacao;
  }

  public int getAnosPrazoGarantiaLicitacao() {
    return anosPrazoGarantiaLicitacao;
  }

  public void setAnosPrazoGarantiaLicitacao(int anosPrazoGarantiaLicitacao) {
    this.anosPrazoGarantiaLicitacao = anosPrazoGarantiaLicitacao;
  }

  public int getDiasValidadePropostaLicitacao() {
    return diasValidadePropostaLicitacao;
  }

  public void setDiasValidadePropostaLicitacao(int diasValidadePropostaLicitacao) {
    this.diasValidadePropostaLicitacao = diasValidadePropostaLicitacao;
  }

  public String getTermosAmostraLicitacao() {
    return termosAmostraLicitacao;
  }

  public void setTermosAmostraLicitacao(String termosAmostraLicitacao) {
    this.termosAmostraLicitacao = termosAmostraLicitacao;
  }

  public String getTermosGarantiaLicitacao() {
    return termosGarantiaLicitacao;
  }

  public void setTermosGarantiaLicitacao(String termosGarantiaLicitacao) {
    this.termosGarantiaLicitacao = termosGarantiaLicitacao;
  }

  public String getTermosMultaLicitacao() {
    return termosMultaLicitacao;
  }

  public void setTermosMultaLicitacao(String termosMultaLicitacao) {
    this.termosMultaLicitacao = termosMultaLicitacao;
  }

  public String getErroDiasPrazoEntregaLicitacao() {
    return erroDiasPrazoEntregaLicitacao;
  }

  public void setErroDiasPrazoEntregaLicitacao(String erroDiasPrazoEntregaLicitacao) {
    this.erroDiasPrazoEntregaLicitacao = erroDiasPrazoEntregaLicitacao;
  }

  public String getErroDiasPrazoPagamentoLicitacao() {
    return erroDiasPrazoPagamentoLicitacao;
  }

  public void setErroDiasPrazoPagamentoLicitacao(String erroDiasPrazoPagamentoLicitacao) {
    this.erroDiasPrazoPagamentoLicitacao = erroDiasPrazoPagamentoLicitacao;
  }

  public String getErroDiasVigenciaLicitacao() {
    return erroDiasVigenciaLicitacao;
  }

  public void setErroDiasVigenciaLicitacao(String erroDiasVigenciaLicitacao) {
    this.erroDiasVigenciaLicitacao = erroDiasVigenciaLicitacao;
  }

  public String getErroAnosPrazoGarantiaLicitacao() {
    return erroAnosPrazoGarantiaLicitacao;
  }

  public void setErroAnosPrazoGarantiaLicitacao(String erroAnosPrazoGarantiaLicitacao) {
    this.erroAnosPrazoGarantiaLicitacao = erroAnosPrazoGarantiaLicitacao;
  }

  public String getErroDiasValidadePropostaLicitacao() {
    return erroDiasValidadePropostaLicitacao;
  }

  public void setErroDiasValidadePropostaLicitacao(String erroDiasValidadePropostaLicitacao) {
    this.erroDiasValidadePropostaLicitacao = erroDiasValidadePropostaLicitacao;
  }

  public String getErroTermosAmostraLicitacao() {
    return erroTermosAmostraLicitacao;
  }

  public void setErroTermosAmostraLicitacao(String erroTermosAmostraLicitacao) {
    this.erroTermosAmostraLicitacao = erroTermosAmostraLicitacao;
  }

  public String getErroTermosGarantiaLicitacao() {
    return erroTermosGarantiaLicitacao;
  }

  public void setErroTermosGarantiaLicitacao(String erroTermosGarantiaLicitacao) {
    this.erroTermosGarantiaLicitacao = erroTermosGarantiaLicitacao;
  }

  public String getErroTermosMultaLicitacao() {
    return erroTermosMultaLicitacao;
  }

  public void setErroTermosMultaLicitacao(String erroTermosMultaLicitacao) {
    this.erroTermosMultaLicitacao = erroTermosMultaLicitacao;
  }

  private void carregaListas() throws SQLException, NamingException {
    orgaos = model.services.Orgaos.recuperar();
    modalidades = model.services.Modalidades.recuperar();
    sistemas = model.services.Sistemas.recuperar();
    tiposLicitacoes = model.services.TiposLicitacoes.recuperar();
  }

  private boolean validar() {
    if (isExclusao()) {
      /**
       * Incluir aqui as críticas de esclusão, se houverem 
       */
      return true;
    }
    boolean result = true;
    if (getAnoLicitacao() == 0) {
      setErroAnoLicitacao("Ano da licitação inválido!");
      addErro("Ano da licitação inválido.");
      result = false;
    } else {
      if (getAnoLicitacao() < 2000) {
        setErroAnoLicitacao("Informe um ano posterior a 1999.");
        addErro("Ano da licitação inválido.");
        result = false;
      }
    }
    if ( getDataRealizacaoLicitacao() != null &&
            getDataDocumentacaoLicitacao() != null &&            
            getDataRealizacaoLicitacao().before(
            getDataDocumentacaoLicitacao())) {
      addErro("Data da realização deve ser posterior à data de documentação");
      setErroDataRealizacaoLicitacao("Deve ser posterior à " +
              "data de documentação");
      setErroDataDocumentacaoLicitacao("Deve ser anterior à " +
              "data de realização");
      result = false;
    }
    if (getDataRealizacaoLicitacao() != null &&
            getDataPropostaLicitacao() != null &&
            getDataRealizacaoLicitacao().before(getDataPropostaLicitacao())) {
      addErro("Data da realização deve ser posterior à data da " +
              "apresentação da proposta");
      setErroDataRealizacaoLicitacao("Deve ser posterior à data da proposta");
      setErroDataPropostaLicitacao("Deve ser anterior à " +
              "data de realização");
      result = false;
    }
    if (getNumeroLicitacao() == null || getNumeroLicitacao().isEmpty()) {
      addErro("O número da licitação deve ser informado.");
      setErroNumeroLicitacao("Este campo deve ser informado.");
      result = false;
    }
    if (getNumeroProcessoLicitacao() == null || 
            getNumeroProcessoLicitacao().isEmpty()) {
      addErro("O número do processo deve ser informado.");
      setErroNumeroProcesso("Este campo deve ser informado.");
      result = false;
    }
    return result;
  }

  public void setErroTipoLicitacaoLicitacao(String erroTipoLicitacaoLicitacao) {
    this.erroTipoLicitacaoLicitacao = erroTipoLicitacaoLicitacao;
  }

  public void setErroNumeroProcessoLicitacao(String erroNumeroProcessoLicitacao) {
    this.erroNumeroProcessoLicitacao = erroNumeroProcessoLicitacao;
  }
}

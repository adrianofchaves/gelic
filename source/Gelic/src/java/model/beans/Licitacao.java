package model.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Licitacao {

  private int id;
  private int idTipoLicitacao;
  private TipoLicitacao tipoLicitacao;
  private String numero;
  private int ano;
  private int idModalidade;
  private model.beans.Modalidade modalidade;
  private int idSistema;
  private Sistema sistema;
  private String idorgao;
  private Orgao orgao;
  private String numeroProcesso;
  private String objeto;
  private Date dataDocumentacao;
  private Date dataProposta;
  private Date dataRealizacao;
  private int diasValidadeProposta;
  private int diasPrazoEntrega;
  private int diasPrazoPagamento;
  private int diasVigencia;
  private int anosPrazoGarantia;
  private String termosAmostra;
  private String termosGarantia;
  private String termosMulta;
  private int status;
  private ArrayList<Lote> mLote;

  public Licitacao() {

  }
  
  public String toString(){
    String buffer = "";
    if( getTipoLicitacao() != null ){
       buffer = getTipoLicitacao().getSigla() + " ";
    }
    
    return buffer + getNumero() + "/" + getAno();
  }
  /**
   * Cria uma nova instância da classe apenas com os atributos "atômicos", isto
   * é, os que não estão relacionados à outras classes.
   * 
   * @param id
   * @param idTipoLicitacao
   * @param numero
   * @param ano
   * @param idModalidade
   * @param idSistema
   * @param idorgao
   * @param numeroProcesso
   * @param objeto
   * @param dataDocumentacao
   * @param dataProposta
   * @param dataRealizacao
   * @param diasValidadeProposta
   * @param diasPrazoEntrega
   * @param diasPrazoPagamento
   * @param diasVigencia
   * @param anosPrazoGarantia
   * @param termosAmostra
   * @param termosGarantia
   * @param termosMulta
   * @param status
   */
  public Licitacao(int id, int idTipoLicitacao, String numero, int ano,
          int idModalidade, int idSistema, String idorgao,
          String numeroProcesso, String objeto, Date dataDocumentacao,
          Date dataProposta, Date dataRealizacao, int diasValidadeProposta,
          int diasPrazoEntrega, int diasPrazoPagamento, int diasVigencia,
          int anosPrazoGarantia, String termosAmostra, String termosGarantia,
          String termosMulta, int status) {
    this.id = id;
    this.idTipoLicitacao = idTipoLicitacao;
    this.numero = numero;
    this.ano = ano;
    this.idModalidade = idModalidade;
    this.idSistema = idSistema;
    this.idorgao = idorgao;
    this.numeroProcesso = numeroProcesso;
    this.objeto = objeto;
    this.dataDocumentacao = dataDocumentacao;
    this.dataProposta = dataProposta;
    this.dataRealizacao = dataRealizacao;
    this.diasValidadeProposta = diasValidadeProposta;
    this.diasPrazoEntrega = diasPrazoEntrega;
    this.diasPrazoPagamento = diasPrazoPagamento;
    this.diasVigencia = diasVigencia;
    this.anosPrazoGarantia = anosPrazoGarantia;
    this.termosAmostra = termosAmostra;
    this.termosGarantia = termosGarantia;
    this.termosMulta = termosMulta;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getIdModalidade() {
    return idModalidade;
  }

  public void setIdModalidade(int idModalidade) {
    this.idModalidade = idModalidade;
  }

  public model.beans.Modalidade getModalidade() {
    return modalidade;
  }

  public void setModalidade(model.beans.Modalidade modalidade) {
    this.modalidade = modalidade;
  }

  public int getIdSistema() {
    return idSistema;
  }

  public void setIdSistema(int idSistema) {
    this.idSistema = idSistema;
  }

  public Sistema getSistema() {
    return sistema;
  }

  public void setSistema(Sistema sistema) {
    this.sistema = sistema;
  }

  public String getIdorgao() {
    return idorgao;
  }

  public void setIdorgao(String idorgao) {
    this.idorgao = idorgao;
  }

  public Orgao getOrgao() {
    return orgao;
  }

  public void setOrgao(Orgao orgao) {
    this.orgao = orgao;
  }

  public String getNumeroProcesso() {
    return numeroProcesso;
  }

  public void setNumeroProcesso(String numeroProcesso) {
    this.numeroProcesso = numeroProcesso;
  }

  public String getObjeto() {
    return objeto;
  }

  public void setObjeto(String objeto) {
    this.objeto = objeto;
  }

  public Date getDataDocumentacao() {
    return dataDocumentacao;
  }

  public void setDataDocumentacao(Date dataDocumentacao) {
    this.dataDocumentacao = dataDocumentacao;
  }

  public Date getDataProposta() {
    return dataProposta;
  }

  public void setDataProposta(Date dataProposta) {
    this.dataProposta = dataProposta;
  }

  public Date getDataRealizacao() {
    return dataRealizacao;
  }

  public void setDataRealizacao(Date dataRealizacao) {
    this.dataRealizacao = dataRealizacao;
  }

  public int getDiasValidadeProposta() {
    return diasValidadeProposta;
  }

  public void setDiasValidadeProposta(int diasValidadeProposta) {
    this.diasValidadeProposta = diasValidadeProposta;
  }

  public int getDiasPrazoEntrega() {
    return diasPrazoEntrega;
  }

  public void setDiasPrazoEntrega(int diasPrazoEntrega) {
    this.diasPrazoEntrega = diasPrazoEntrega;
  }

  public int getDiasPrazoPagamento() {
    return diasPrazoPagamento;
  }

  public void setDiasPrazoPagamento(int diasPrazoPagamento) {
    this.diasPrazoPagamento = diasPrazoPagamento;
  }

  public int getDiasVigencia() {
    return diasVigencia;
  }

  public void setDiasVigencia(int diasVigencia) {
    this.diasVigencia = diasVigencia;
  }

  public int getAnosPrazoGarantia() {
    return anosPrazoGarantia;
  }

  public void setAnosPrazoGarantia(int anosPrazoGarantia) {
    this.anosPrazoGarantia = anosPrazoGarantia;
  }

  public String getTermosAmostra() {
    return termosAmostra;
  }

  public void setTermosAmostra(String termosAmostra) {
    this.termosAmostra = termosAmostra;
  }

  public String getTermosGarantia() {
    return termosGarantia;
  }

  public void setTermosGarantia(String termosGarantia) {
    this.termosGarantia = termosGarantia;
  }

  public String getTermosMulta() {
    return termosMulta;
  }

  public void setTermosMulta(String termosMulta) {
    this.termosMulta = termosMulta;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public ArrayList<Lote> getMLote() {
    return mLote;
  }

  public void setMLote(ArrayList<Lote> mLote) {
    this.mLote = mLote;
  }

  public int getIdTipoLicitacao() {
    return idTipoLicitacao;
  }

  public void setIdTipoLicitacao(int idTipoLicitacao) {
    this.idTipoLicitacao = idTipoLicitacao;
  }

  public TipoLicitacao getTipoLicitacao() {
    return tipoLicitacao;
  }

  public void setTipoLicitacao(TipoLicitacao tipoLicitacao) {
    this.tipoLicitacao = tipoLicitacao;
  }
}


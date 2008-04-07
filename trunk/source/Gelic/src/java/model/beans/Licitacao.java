package model.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Licitacao {
    
    private int tipolicitacao;
    private String numero;
    private int ano;
    private model.beans.Modalidade modalidade;
    private int sistema;
    private String orgao;
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
    private boolean pedeAmostra;
    private String termosAmostra;
    private boolean pedeGarantia;
    private String termosGarantia;
    private boolean preveMulta;
    private String termosMulta;
    private int status;
    private ArrayList<Lote> mLote;
    
    
    public Licitacao () {
    }

    public int getTipolicitacao() {
        return tipolicitacao;
    }

    public void setTipolicitacao(int tipolicitacao) {
        this.tipolicitacao = tipolicitacao;
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

    public model.beans.Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(model.beans.Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public int getSistema() {
        return sistema;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
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

    public boolean isPedeAmostra() {
        return pedeAmostra;
    }

    public void setPedeAmostra(boolean pedeAmostra) {
        this.pedeAmostra = pedeAmostra;
    }

    public String getTermosAmostra() {
        return termosAmostra;
    }

    public void setTermosAmostra(String termosAmostra) {
        this.termosAmostra = termosAmostra;
    }

    public boolean isPedeGarantia() {
        return pedeGarantia;
    }

    public void setPedeGarantia(boolean pedeGarantia) {
        this.pedeGarantia = pedeGarantia;
    }

    public String getTermosGarantia() {
        return termosGarantia;
    }

    public void setTermosGarantia(String termosGarantia) {
        this.termosGarantia = termosGarantia;
    }

    public boolean isPreveMulta() {
        return preveMulta;
    }

    public void setPreveMulta(boolean preveMulta) {
        this.preveMulta = preveMulta;
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

}


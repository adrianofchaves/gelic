/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

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
    private String dataDocumentacaoLicitacao;
    private String erroDataDocumentacaoLicitacao;    
    private String dataPropostaLicitacao;
    private String erroDataPropostaLicitacao;
    private String dataRealizacaoLicitacao;
    private String erroDataRealizacaoLicitacao;
    private int diasPrazoEntregaLicitacao;
    private int diasPrazoPagamentoLicitacao;
    private int diasVigenciaLicitacao;
    private int anosPrazoGarantiaLicitacao;
    private int diasValidadePropostaLicitacao;
    private String termosAmostraLicitacao;
    private String termosGarantiaLicitacao;
    private String termosMultaLicitacao;
    
    
    
    
    private boolean inclusao = true;
    private boolean exclusao = false;
    private boolean alteracao = false;

  public void  preparaInclusao() throws NamingException, SQLException {
    setExclusao(false);
    setAlteracao(false);
    setInclusao(true);    
    setNome(NOME_DEFAULT);
    orgaos = model.services.Orgaos.recuperar();
    modalidades = model.services.Modalidades.recuperar();
    sistemas = model.services.Sistemas.recuperar();
    tiposLicitacoes = model.services.TiposLicitacoes.recuperar();
    
  }
    
    public void valida() throws SQLException, NamingException {
        apagaErros();
        if( isExclusao() ){
          // Colocar críticas de exclusão aqui.
          return;
        }
        if( getNumeroLicitacao().length() ==0){
            setErroNumeroLicitacao("Numero não pode ser vazio");
            addErro("Numero inválido!");
        }
    }
    @Override
    protected void apagaErros() {
        super.apagaErros();
        setErroNumeroLicitacao("");
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
    }

    public void setTipoLicitacaoLicitacao(String tipoLicitacaoLicitacao) {
        this.tipoLicitacaoLicitacao = tipoLicitacaoLicitacao;
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

  public

  String getNumeroProcessoLicitacao() {
    return numeroProcessoLicitacao;
  }

  public void setNumeroProcessoLicitacao(String numeroProcessoLicitacao) {
    this.numeroProcessoLicitacao = numeroProcessoLicitacao;
  }

  public String getErroNumeroProcessoLicitacao() {
    return erroNumeroProcessoLicitacao;
  }

  public void setErroNumeroProcesso(String erroNumeroProcessoLicitacao) {
    this.erroNumeroProcessoLicitacao = erroNumeroProcessoLicitacao;
  }

  public

  String getModalidadeLicitacao() {
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

  public

  String getSistemaLicitacao() {
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

  public

  String getDataDocumentacaoLicitacao() {
    return dataDocumentacaoLicitacao;
  }

  public void setDataDocumentacaoLicitacao(String dataDocumentacaoLicitacao) {
    this.dataDocumentacaoLicitacao = dataDocumentacaoLicitacao;
  }

  public String getDataPropostaLicitacao() {
    return dataPropostaLicitacao;
  }

  public void setDataPropostaLicitacao(String dataPropostaLicitacao) {
    this.dataPropostaLicitacao = dataPropostaLicitacao;
  }

  public String getDataRealizacaoLicitacao() {
    return dataRealizacaoLicitacao;
  }

  public void setDataRealizacaoLicitacao(String dataRealizacaoLicitacao) {
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

}

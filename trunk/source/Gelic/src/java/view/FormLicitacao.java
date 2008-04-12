/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Paulo
 */
public class FormLicitacao extends Form {
    
    private model.beans.Licitacao licitacao;
    private int tipoLicitacaoLicitacao;
    private String erroTipoLicitacaoLicitacao;
    private String numeroLicitacao;
    private String erroNumeroLicitacao;
    private int anoLicitacao;
    private String erroAnoLicitacao;
    private String orgaoLicitacao;
    private String erroOrgaoLicitacao;
    private String objetoLicitacao;
    private String erroObjetoLicitacao;
    
    private boolean inclusao = true;
    
    public void valida() throws SQLException, NamingException {
        apagaErros();
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
        //setTipoLicitacaoLicitacao(licitacao.getTipolicitacao());
        setNumeroLicitacao(licitacao.getNumero());
        setAnoLicitacao(licitacao.getAno());
        //setOrgaoLicitacao(licitacao.getOrgao());
        setObjetoLicitacao(licitacao.getObjeto());
    }


    public boolean isInclusao() {
        return inclusao;
    }

    public model.beans.Licitacao getLicitacao() {
        return licitacao;
    }

    public int getTipoLicitacaoLicitacao() {
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

    public void setTipoLicitacaoLicitacao(int tipoLicitacaoLicitacao) {
        this.tipoLicitacaoLicitacao = tipoLicitacaoLicitacao;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    private Boolean inclusao = true;
    

    public void apagaErros() {
        super.apagaErros();
        erroNomeModalidade = "";
        errosiglaModalidade = "";
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

    public Boolean getInclusao() {
        return inclusao;
    }

    public void setInclusao(Boolean inclusao) {
        this.inclusao = inclusao;
    }
}

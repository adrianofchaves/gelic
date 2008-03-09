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
    private String sigla;
    private String erroSigla;
    private String nome;
    private String erroNome;
    private Boolean inclusao = true;
    

    public void apagaErros() {
        super.apagaErros();
        erroNome = "";
        erroSigla = "";
    }

    public void atualizaCampos() {
        apagaErros();
        if (modalidade == null) {
            return;
        }
        sigla = modalidade.getSigla();
        nome = modalidade.getNome();
    }

    public model.beans.Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(model.beans.Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getErroSigla() {
        return erroSigla;
    }

    public void setErroSigla(String erroSigla) {
        this.erroSigla = erroSigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getErroNome() {
        return erroNome;
    }

    public void setErroNome(String erroNome) {
        this.erroNome = erroNome;
    }

    public Boolean getInclusao() {
        return inclusao;
    }

    public void setInclusao(Boolean inclusao) {
        this.inclusao = inclusao;
    }
}

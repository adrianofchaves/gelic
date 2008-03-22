/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author Adriano
 */
public class FormSistema extends Form{
    private model.beans.Sistema sistema;
    
    private String nomeSistema;
    private String erroNomeSistema;
    
    public void apagaErros() {
        super.apagaErros();
        erroNomeSistema = "";
    }

    public void valida() {
        apagaErros();        

    }

    public void atualizaCampos() {
        apagaErros();
        if (sistema == null) {
            return;
        }        
        nomeSistema = sistema.getNome();
    }
    
    private Boolean inclusao = true;
    
    public FormSistema(){
        
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
    

}

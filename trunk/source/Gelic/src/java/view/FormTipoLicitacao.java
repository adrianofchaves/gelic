/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author Adriano
 */
public class FormTipoLicitacao extends Form{
    private model.beans.TipoLicitacao tipoLicitacao;
    private String nomeTipoLicitacao;
    private String erroNomeTipoLicitacao;
    private boolean inclusao = true;
    protected void apagaErros(){
        super.apagaErros();
        erroNomeTipoLicitacao="";        
    }
    public void atualizaCampos() {
        apagaErros();
        if(tipoLicitacao==null){
            return;
        }
        setNomeTipoLicitacao(tipoLicitacao.getNome());
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
    

}

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
    private boolean inclusao = true;

    public void valida() throws SQLException, NamingException {
        apagaErros();
        if (isInclusao()) {
            /* críticas de inclusão */
            if (model.services.TiposLicitacoes.recuperar(
                    nomeTipoLicitacao) != null) {
                erroNomeTipoLicitacao = "Nome já existe";
                addErro("Já existe um tipo de licitação com este nome.");
            }
        }
        if (!isInclusao()) {
            /* críticas para a alteração */
            if (!getNomeTipoLicitacao().equalsIgnoreCase(
                    tipoLicitacao.getNome())) {
                /* alterou o nome.  Verificamos se novo nome já existe */
                if (model.services.TiposLicitacoes.recuperar(
                        nomeTipoLicitacao) != null) {
                    erroNomeTipoLicitacao = "Nome já existe";
                    addErro("Já existe um tipo de licitação com este nome.");
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

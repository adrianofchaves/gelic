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
public class FormTipoDocumento extends Form{
    private model.beans.TipoDocumento tipoDocumento;
    private String nomeTipoDocumento;
    private String erroNomeTipoDocumento;
    private boolean inclusao = true;
    private boolean exclusao;
    private boolean alteracao;

    public void valida() throws SQLException, NamingException {
        apagaErros();
        if (isInclusao()) {
            /* críticas de inclusão */
            if ( model.services.TiposDocumentos.recuperar( 
                    nomeTipoDocumento) != null) {
                erroNomeTipoDocumento = "Nome já existe";
                addErro("Já existe um tipo de documento com este nome.");
            }
        }
        if (!isInclusao()) {
            /* críticas para a alteração */
            if (!getNomeTipoDocumento().equalsIgnoreCase(
                    tipoDocumento.getNome())) {
                /* alterou o nome.  Verificamos se novo nome já existe */
                if (model.services.TiposDocumentos.recuperar(
                        nomeTipoDocumento) != null) {
                    erroNomeTipoDocumento = "Nome já existe";
                    addErro("Já existe um tipo de licitação com este nome.");
                }
            }
        }
    }
    @Override
    protected void apagaErros() {
        super.apagaErros();
        erroNomeTipoDocumento = "";
    }

    public void atualizaCampos() {
        apagaErros();
        if (tipoDocumento == null) {
            return;
        }
        setNomeTipoDocumento(tipoDocumento.getNome());
        
    }

    public model.beans.TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(model.beans.TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNomeTipoDocumento() {
        return nomeTipoDocumento;
    }

    public void setNomeTipoDocumento(String nomeTipoDocumento) {
        this.nomeTipoDocumento = nomeTipoDocumento;
    }

    public String getErroNomeTipoDocumento() {
        return erroNomeTipoDocumento;
    }

    public void setErroNomeTipoDocumento(String erroNomeTipoDocumento) {
        this.erroNomeTipoDocumento = erroNomeTipoDocumento;
    }

    public boolean isInclusao() {
        return inclusao;
    }

    public void setInclusao(boolean inclusao) {
        this.inclusao = inclusao;
    }

    public boolean isExclusao() {
        return exclusao;
    }

    public void setExclusao(boolean exclusao) {
        this.exclusao = exclusao;
        if (exclusao) {
            alteracao = false;
            inclusao = false;
            }
    }

    public boolean isAlteracao() {
        return alteracao;
    }

    public void setAlteracao(boolean alteracao) {
        this.alteracao = alteracao;
        if (alteracao) {
            exclusao = false;
            inclusao = false;
        }
    }
}

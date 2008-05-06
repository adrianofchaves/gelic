/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author gustavo
 */
public class FormProduto extends Form {
    
    private model.beans.Produto produto;
    private String codigoProduto;
    private String erroCodigoProduto;
    private String descricaoProduto;
    private String erroDescricaoProduto;
    private float precovendaProduto;
    private float precocompraProduto;
    private boolean inclusao = true;
    private boolean exclusao;
    private boolean alteracao;
        
    
    public void valida() throws SQLException, NamingException {
        apagaErros();
        if( isExclusao()){
          /* colocar aqui críticas de exclusão */
          return;
        }
        if( getCodigoProduto().length() == 0){
            setErroCodigoProduto("Código não pode ser vazio");
            addErro("Código inválido!");
        }
    }
    @Override
    protected void apagaErros() {
        super.apagaErros();
        setErroCodigoProduto("");
    }

    public void atualizaCampos() {
        apagaErros();
        if (getProduto() == null) {
            return;
        }
        setCodigoProduto(produto.getCodigo());
        setDescricaoProduto(produto.getDescricao());
        setPrecovendaProduto(produto.getPrecoVenda());
        setPrecocompraProduto(produto.getPrecoCompra());
    }


    public boolean isInclusao() {
        return inclusao;
    }

    public void setInclusao(boolean inclusao) {
        this.inclusao = inclusao;
    }

    public model.beans.Produto getProduto() {
        return produto;
    }

    public void setProduto(model.beans.Produto produto) {
        this.produto = produto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getErroCodigoProduto() {
        return erroCodigoProduto;
    }

    public void setErroCodigoProduto(String erroCodigoProduto) {
        this.erroCodigoProduto = erroCodigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getErroDescricaoProduto() {
        return erroDescricaoProduto;
    }

    public void setErroDescricaoProduto(String erroDescricaoProduto) {
        this.erroDescricaoProduto = erroDescricaoProduto;
    }

    public float getPrecovendaProduto() {
        return precovendaProduto;
    }

    public void setPrecovendaProduto(float precovendaProduto) {
        this.precovendaProduto = precovendaProduto;
    }

    public float getPrecocompraProduto() {
        return precocompraProduto;
    }

    public void setPrecocompraProduto(float precocompraProduto) {
        this.precocompraProduto = precocompraProduto;
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

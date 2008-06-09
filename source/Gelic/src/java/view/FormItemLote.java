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
 * @author Adriano
 */
public class FormItemLote extends Form {

  private model.beans.ItemLote itemLote;
  public static final String NOME_ATRIBUTO_DEFAULT = "formItemLote";
  public static final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private int numeroItemLote;
  private String erroNumeroItemLote;
  private String produtoItemLote;
  private String erroProdutoItemLote;
  private float quantidadeItemLote;
  private String erroQuantidadeItemLote;
  private String nomeAtributo;
  float precoEstimadoItemLote;
  private String erroPrecoEstimadoItemLote;

  public String cancelar() {
    getOrigem().setMensagem("");
    return getOrigem().getNome();
  }

  public String getErroNumeroItemLote() {
    return erroNumeroItemLote;
  }

  private view.FormLote getFormLote() {
    return (view.FormLote) getBrowserItensLote().getOrigem();
  }

  private model.beans.Lote getLote() {
    return getFormLote().getLote();
  }

  private model.beans.Produto calculaProdutoItemLote() {
    for (model.beans.Produto produto : getProdutos()) {
      if (produto.toString().equals(getProdutoItemLote())) {
        return produto;
      }
    }
    return null;
  }
  
  @Override
  public void apagaErros(){
    super.apagaErros();
    erroNumeroItemLote="";
    erroPrecoEstimadoItemLote = "";
    erroProdutoItemLote = "";
    erroQuantidadeItemLote = "";
  }
          
  public String gravar() throws SQLException, NamingException, ExcecaoForm {
    if (isExclusao()) {
      //ignora erros de parse
      apagaErros();
    }
    valida();
    if (temErros()) {
      return getNome();
    }
    if (isInclusao()) {
      model.services.ItensLote.incluir(getLote(), getNumeroItemLote(),
              calculaProdutoItemLote(), getQuantidadeItemLote(),
              getPrecoEstimadoItemLote());
      getOrigem().setMensagem("Item do Lote incluído.");
    }
    if (isAlteracao()) {
      model.services.ItensLote.alterar(getItemLote(), getNumeroItemLote(),
              calculaProdutoItemLote(), getQuantidadeItemLote(),
              getPrecoEstimadoItemLote());
      getOrigem().setMensagem("Item do Lote alterado.");
    }
    if (isExclusao()) {
      model.services.ItensLote.excluir(getItemLote());
      getOrigem().setMensagem("Item do Lote excluído.");
    }
    getOrigem().refresh();
    return getOrigem().getNome();

  }

  public String preparaExclusao(String parameter)
          throws SQLException, NamingException {
    setProdutos(model.services.Produtos.recuperar());
    setTitulo("Excluindo item do lote " +
            getFormLicitacao().getLicitacao().toString() + "-" +
            getFormLote().getLote().toString());
    setNome(NOME_DEFAULT);
    setNomeAtributo(NOME_ATRIBUTO_DEFAULT);
    int idItemLote = Integer.parseInt(parameter);
    setItemLote(model.services.ItensLote.recuperar(idItemLote));
    carregaCampos();
    getOrigem().setMensagem("");
    setExclusao(true);
    return getNome();
  }

  public void setErroNumeroItemLote(String erroNumeroItemLote) {
    this.erroNumeroItemLote = erroNumeroItemLote;
  }

  public String getErroPrecoEstimadoItemLote() {
    return erroPrecoEstimadoItemLote;
  }

  public void setErroPrecoEstimadoItemLote(String erroPrecoEstimadoItemLote) {
    this.erroPrecoEstimadoItemLote = erroPrecoEstimadoItemLote;
  }

  public String getErroProdutoItemLote() {
    return erroProdutoItemLote;
  }

  public void setErroProdutoItemLote(String erroProdutoItemLote) {
    this.erroProdutoItemLote = erroProdutoItemLote;
  }

  public String getErroQuantidadeItemLote() {
    return erroQuantidadeItemLote;
  }

  public void setErroQuantidadeItemLote(String erroQuantidadeItemLote) {
    this.erroQuantidadeItemLote = erroQuantidadeItemLote;
  }
  private ArrayList<model.beans.Produto> produtos;
  private boolean inclusao;
  private boolean exclusao;
  private boolean alteracao;

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
    if (alteracao) {
      setExclusao(false);
      setInclusao(false);
    }
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
    if (exclusao) {
      setInclusao(false);
      setAlteracao(false);
    }
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
    if (inclusao) {
      setAlteracao(false);
      setExclusao(false);
    }
  }

  public String getNomeAtributo() {
    return nomeAtributo;
  }

  private view.FormLicitacao getFormLicitacao() {
    return (view.FormLicitacao) getFormLote().getOrigem().getOrigem();
  }

  public String preparaAlteracao(String pItemLote)
          throws SQLException, NamingException {
    setProdutos(model.services.Produtos.recuperar());
    setTitulo("Alterando item do lote " +
            getFormLicitacao().getLicitacao().toString() + "-" +
            getFormLote().getLote().toString());
    setNome(NOME_DEFAULT);
    setNomeAtributo(NOME_ATRIBUTO_DEFAULT);
    int idItemLote = Integer.parseInt(pItemLote);
    setItemLote(model.services.ItensLote.recuperar(idItemLote));
    carregaCampos();
    getOrigem().setMensagem("");
    setAlteracao(true);
    return getNome();
  }

  public void setNomeAtributo(String nomeAtributo) {
    this.nomeAtributo = nomeAtributo;
  }

  public ArrayList<model.beans.Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<model.beans.Produto> produtos) {
    this.produtos = produtos;
  }

  private void carregaCampos() {
    numeroItemLote = itemLote.getNumero();
    produtoItemLote = itemLote.getProduto().toString();
    quantidadeItemLote = itemLote.getQuantidade();
    precoEstimadoItemLote = itemLote.getPrecoEstimado();

  }

  private view.BrowserItensLote getBrowserItensLote() {
    return (view.BrowserItensLote) getOrigem();
  }

  private ArrayList<model.beans.ItemLote> getItensLote() {
    return getBrowserItensLote().getItensLote();
  }

  public String preparaInclusao() throws NamingException, SQLException {
    setProdutos(model.services.Produtos.recuperar());
    setNome(NOME_DEFAULT);
    setNomeAtributo(NOME_ATRIBUTO_DEFAULT);
    setTitulo("Novo item do lote " +
            getFormLicitacao().getLicitacao().toString() + "-" +
            getFormLote().getLote().toString());
    // Sugere próximo número disponível.
    setNumeroItemLote(1);
    for (model.beans.ItemLote item : getItensLote()) {
      if (item.getNumero() >= getNumeroItemLote()) {
        setNumeroItemLote(item.getNumero() + 1);
      }
    }
    getOrigem().setMensagem("");
    setInclusao(true);
    return getNome();
  }

  public model.beans.ItemLote getItemLote() {
    return itemLote;
  }

  public void setItemLote(model.beans.ItemLote itemLote) {
    this.itemLote = itemLote;
  }

  public int getNumeroItemLote() {
    return numeroItemLote;
  }

  public void setNumeroItemLote(int numeroItemLote) {
    this.numeroItemLote = numeroItemLote;
  }

  public float getPrecoEstimadoItemLote() {
    return precoEstimadoItemLote;
  }

  public void setPrecoEstimadoItemLote(float precoEstimadoItemLote) {
    this.precoEstimadoItemLote = precoEstimadoItemLote;
  }

  public String getProdutoItemLote() {
    return produtoItemLote;
  }

  public void setProdutoItemLote(String produtoItemLote) {
    this.produtoItemLote = produtoItemLote;
  }

  public float getQuantidadeItemLote() {
    return quantidadeItemLote;
  }

  public void setQuantidadeItemLote(float quantidadeItemLote) {
    this.quantidadeItemLote = quantidadeItemLote;
  }

  private void valida() throws NamingException, SQLException {
    if (isInclusao()) {
      if (model.services.ItensLote.recuperar( 
              getLote(), getNumeroItemLote()) != null) {
        addErro("Número do item de lote inválido.");
        setErroNumeroItemLote("Já existe item com esse número neste lote.");
      }
    }
    if (isAlteracao()) {
      if (model.services.ItensLote.recuperar(
              getLote(), getNumeroItemLote()).getId() != getItemLote().getId()) {
        addErro("Número do item de lote inválido.");
        setErroNumeroItemLote("Já existe item com esse número neste lote.");

      }
    }  
  }
  
}

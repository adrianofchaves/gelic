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
 * @author adriano
 */
public class FormOrgao extends Form {

  /* Campos */
  private String apelidoOrgao;
  private String erroApelidoOrgao;
  private String razaoSocialOrgao;
  private String erroRazaoSocialOrgao;
  private String cnpjOrgao;
  private String erroCnpjOrgao;
  private String ieOrgao;
  private String ErroIeOrgao;
  private String tipoLogradouroOrgao;
  private String ErroTipoLogradouroOrgao;
  private ArrayList<model.beans.TipoLogradouro> tiposLogradouros;
  private String logradouroOrgao;
  private String erroLogradouroOrgao;
  private String numeroOrgao;
  private String erroNumeroOrgao;
  private String complementoOrgao;
  private String erroComplementoOrgao;
  private String bairroOrgao;
  private String erroBairroOrgao;
  private String cidadeOrgao;
  private String erroCidadeOrgao;
  private String estadoOrgao;
  private String erroEstadoOrgao;
  private ArrayList<String> estados;
  private String cepOrgao;
  private String erroCepOrgao;
  private String siteOrgao;
  private String erroSiteOrgao;
  private String emailOrgao;
  private String erroEmailOrgao;
  private String ddiOrgao;
  private String erroDdiOrgao;
  private String dddOrgao;
  private String erroDddOrgao;
  private String numeroTelefoneOrgao;
  private String erroNumeroTelefoneOrgao;
  private String ramalOrgao;
  private String erroRamalOrgao;
  /* Outros atributos */
  private String nomeAtributo;
  private boolean inclusao = false;
  private boolean exclusao = false;
  private boolean alteracao = true;
  private final String tituloAlteracao = "Alterando Órgão Público";
  private final String tituloExclusao = "Excluindo Órgão Público";
  private final String tituloInclusao = "Incluindo novo Órgão Público";
  private model.beans.Orgao orgao;

  public FormOrgao() {
    final String nomeAtributoDefault = "formOrgao";
    final String nome = nomeAtributoDefault + ".jsp";


    setNome(nome);
    setNomeAtributo(nomeAtributoDefault);
    setTitulo(tituloInclusao);

  }

  /**
   * Executa ações necessárias por conta do cancelamento
   */
  public void cancelar() {

  }

  /**
   * Prepara exclusão do órgão.
   * @param cnpj - identificador do órgão que será excluído.
   */
  public void excluir(String cnpj) throws NamingException, SQLException {
    setOrgao(model.services.Orgaos.recuperar(cnpj));
    setExclusao(true);
    atualizaCampos();

  }

  public String gravar() throws ExcecaoForm, SQLException, NamingException {
    executarCriticas();
    if (temErros()) {
      return getNome();
    }
    
    String mensagem = null;
    if (isInclusao()) {
      model.services.Orgaos.novoOrgao(cnpjOrgao, razaoSocialOrgao, apelidoOrgao, 
              ieOrgao, tipoLogradouroOrgao, logradouroOrgao, numeroOrgao, 
              complementoOrgao, bairroOrgao, cidadeOrgao, estadoOrgao, cepOrgao, 
              siteOrgao, emailOrgao, ddiOrgao, dddOrgao, numeroTelefoneOrgao, 
              ramalOrgao);
              
      mensagem = "Novo órgão incluido.";
    }
    if (isAlteracao()) {
      mensagem = "Órgão alterado.";
    }
    if (isExclusao()) {
      mensagem = "Órgão excluído.";
    }

    getOrigem().setMensagem(mensagem);
    getOrigem().refresh();
    return getOrigem().getNome();
  }

  /**
   * Prepara form para inclusão de um novo órgão.
   */
  public void incluir() {
    setOrgao(null);
    setInclusao(true);
  }

  /**
   * Prepara o form para alteração.  
   * @param cnpj - identificador do órgão que será alterado
   * @throws java.sql.SQLException
   * @throws javax.naming.NamingException
   */
  public void alterar(String cnpj) throws SQLException, NamingException {
    setOrgao(model.services.Orgaos.recuperar(cnpj));
    atualizaCampos();
    setAlteracao(true);
  }

  public String getNomeAtributo() {
    return nomeAtributo;
  }

  public void setNomeAtributo(String nomeAtributo) {
    this.nomeAtributo = nomeAtributo;
  }

  public /* Campos */ String getApelidoOrgao() {
    return apelidoOrgao;
  }

  public void setApelidoOrgao(String apelidoOrgao) {
    this.apelidoOrgao = apelidoOrgao;
  }

  public String getErroApelidoOrgao() {
    return erroApelidoOrgao;
  }

  public void setErroApelidoOrgao(String erroApelidoOrgao) {
    this.erroApelidoOrgao = erroApelidoOrgao;
  }

  public /* Outros atributos */ boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
    if (inclusao) {
      setAlteracao(false);
      setExclusao(false);
      setTitulo(tituloInclusao);
    }
  }

  public boolean isExclusao() {
    return exclusao;
  }

  public void setExclusao(boolean exclusao) {
    this.exclusao = exclusao;
    if (exclusao) {
      setAlteracao(false);
      setInclusao(false);
      setTitulo(tituloExclusao);
    }
  }

  public boolean isAlteracao() {
    return alteracao;
  }

  public void setAlteracao(boolean alteracao) {
    this.alteracao = alteracao;
    if (alteracao) {
      setInclusao(false);
      setExclusao(false);
      setTitulo(tituloAlteracao);
    }
  }

  public String getRazaoSocialOrgao() {
    return razaoSocialOrgao;
  }

  public void setRazaoSocialOrgao(String razaoSocialOrgao) {
    this.razaoSocialOrgao = razaoSocialOrgao;
  }

  public String getErroRazaoSocialOrgao() {
    return erroRazaoSocialOrgao;
  }

  public void setErroRazaoSocialOrgao(String erroRazaoSocialOrgao) {
    this.erroRazaoSocialOrgao = erroRazaoSocialOrgao;
  }

  public String getCnpjOrgao() {
    return cnpjOrgao;
  }

  public void setCnpjOrgao(String cnpjOrgao) {
    this.cnpjOrgao = cnpjOrgao;
  }

  public String getErroCnpjOrgao() {
    return erroCnpjOrgao;
  }

  public void setErroCnpjOrgao(String erroCnpjOrgao) {
    this.erroCnpjOrgao = erroCnpjOrgao;
  }

  public String getIeOrgao() {
    return ieOrgao;
  }

  public void setIeOrgao(String ieOrgao) {
    this.ieOrgao = ieOrgao;
  }

  public String getErroIeOrgao() {
    return ErroIeOrgao;
  }

  public void setErroIeOrgao(String ErroIeOrgao) {
    this.ErroIeOrgao = ErroIeOrgao;
  }

  public String getTipoLogradouroOrgao() {
    return tipoLogradouroOrgao;
  }

  public void setTipoLogradouroOrgao(String tipoLogradouroOrgao) {
    this.tipoLogradouroOrgao = tipoLogradouroOrgao;
  }

  public String getErroTipoLogradouroOrgao() {
    return ErroTipoLogradouroOrgao;
  }

  public void setErroTipoLogradouroOrgao(String ErroTipoLogradouroOrgao) {
    this.ErroTipoLogradouroOrgao = ErroTipoLogradouroOrgao;
  }

  public ArrayList<model.beans.TipoLogradouro> getTiposLogradouros() {
    return tiposLogradouros;
  }

  public void setTiposLogradouros(ArrayList<model.beans.TipoLogradouro> tiposLogradouros) {
    this.tiposLogradouros = tiposLogradouros;
  }

  public String getLogradouroOrgao() {
    return logradouroOrgao;
  }

  public void setLogradouroOrgao(String logradouroOrgao) {
    this.logradouroOrgao = logradouroOrgao;
  }

  public String getErroLogradouroOrgao() {
    return erroLogradouroOrgao;
  }

  public void setErroLogradouroOrgao(String erroLogradouroOrgao) {
    this.erroLogradouroOrgao = erroLogradouroOrgao;
  }

  public String getNumeroOrgao() {
    return numeroOrgao;
  }

  public void setNumeroOrgao(String numeroOrgao) {
    this.numeroOrgao = numeroOrgao;
  }

  public String getErroNumeroOrgao() {
    return erroNumeroOrgao;
  }

  public void setErroNumeroOrgao(String erroNumeroOrgao) {
    this.erroNumeroOrgao = erroNumeroOrgao;
  }

  public String getComplementoOrgao() {
    return complementoOrgao;
  }

  public void setComplementoOrgao(String complementoOrgao) {
    this.complementoOrgao = complementoOrgao;
  }

  public String getErroComplementoOrgao() {
    return erroComplementoOrgao;
  }

  public void setErroComplementoOrgao(String erroComplementoOrgao) {
    this.erroComplementoOrgao = erroComplementoOrgao;
  }

  public String getBairroOrgao() {
    return bairroOrgao;
  }

  public void setBairroOrgao(String bairroOrgao) {
    this.bairroOrgao = bairroOrgao;
  }

  public String getErroBairroOrgao() {
    return erroBairroOrgao;
  }

  public void setErroBairroOrgao(String erroBairroOrgao) {
    this.erroBairroOrgao = erroBairroOrgao;
  }

  public String getCidadeOrgao() {
    return cidadeOrgao;
  }

  public void setCidadeOrgao(String cidadeOrgao) {
    this.cidadeOrgao = cidadeOrgao;
  }

  public String getErroCidadeOrgao() {
    return erroCidadeOrgao;
  }

  public void setErroCidadeOrgao(String erroCidadeOrgao) {
    this.erroCidadeOrgao = erroCidadeOrgao;
  }

  public String getEstadoOrgao() {
    return estadoOrgao;
  }

  public void setEstadoOrgao(String estadoOrgao) {
    this.estadoOrgao = estadoOrgao;
  }

  public String getErroEstadoOrgao() {
    return erroEstadoOrgao;
  }

  public void setErroEstadoOrgao(String erroEstadoOrgao) {
    this.erroEstadoOrgao = erroEstadoOrgao;
  }

  public ArrayList<String> getEstados() {
    return estados;
  }

  public void setEstados(ArrayList<String> estados) {
    this.estados = estados;
  }

  public String getCepOrgao() {
    return cepOrgao;
  }

  public void setCepOrgao(String cepOrgao) {
    this.cepOrgao = cepOrgao;
  }

  public String getErroCepOrgao() {
    return erroCepOrgao;
  }

  public void setErroCepOrgao(String erroCepOrgao) {
    this.erroCepOrgao = erroCepOrgao;
  }

  public String getSiteOrgao() {
    return siteOrgao;
  }

  public void setSiteOrgao(String siteOrgao) {
    this.siteOrgao = siteOrgao;
  }

  public String getErroSiteOrgao() {
    return erroSiteOrgao;
  }

  public void setErroSiteOrgao(String erroSiteOrgao) {
    this.erroSiteOrgao = erroSiteOrgao;
  }

  public String getEmailOrgao() {
    return emailOrgao;
  }

  public void setEmailOrgao(String emailOrgao) {
    this.emailOrgao = emailOrgao;
  }

  public String getErroEmailOrgao() {
    return erroEmailOrgao;
  }

  public void setErroEmailOrgao(String erroEmailOrgao) {
    this.erroEmailOrgao = erroEmailOrgao;
  }

  public String getDdiOrgao() {
    return ddiOrgao;
  }

  public void setDdiOrgao(String ddiOrgao) {
    this.ddiOrgao = ddiOrgao;
  }

  public String getErroDdiOrgao() {
    return erroDdiOrgao;
  }

  public void setErroDdiOrgao(String erroDdiOrgao) {
    this.erroDdiOrgao = erroDdiOrgao;
  }

  public String getDddOrgao() {
    return dddOrgao;
  }

  public void setDddOrgao(String dddOrgao) {
    this.dddOrgao = dddOrgao;
  }

  public String getErroDddOrgao() {
    return erroDddOrgao;
  }

  public void setErroDddOrgao(String erroDddOrgao) {
    this.erroDddOrgao = erroDddOrgao;
  }

  public String getNumeroTelefoneOrgao() {
    return numeroTelefoneOrgao;
  }

  public void setNumeroTelefoneOrgao(String numeroTelefoneOrgao) {
    this.numeroTelefoneOrgao = numeroTelefoneOrgao;
  }

  public String getErroNumeroTelefoneOrgao() {
    return erroNumeroTelefoneOrgao;
  }

  public void setErroNumeroTelefoneOrgao(String erroNumeroTelefoneOrgao) {
    this.erroNumeroTelefoneOrgao = erroNumeroTelefoneOrgao;
  }

  public String getRamalOrgao() {
    return ramalOrgao;
  }

  public void setRamalOrgao(String ramalOrgao) {
    this.ramalOrgao = ramalOrgao;
  }

  public String getErroRamalOrgao() {
    return erroRamalOrgao;
  }

  public void setErroRamalOrgao(String erroRamalOrgao) {
    this.erroRamalOrgao = erroRamalOrgao;
  }

  public model.beans.Orgao getOrgao() {
    return orgao;
  }

  public void setOrgao(model.beans.Orgao Orgao) {
    this.orgao = Orgao;
  }

  private void atualizaCampos() {
    if (orgao == null) {
      return;
    }
    razaoSocialOrgao = orgao.getRazaoSocial();

    cnpjOrgao = orgao.getCnpj();
    ieOrgao = orgao.getIe();
    apelidoOrgao = orgao.getApelido();

    if (orgao.getEndereco() != null) {
      tipoLogradouroOrgao = orgao.getEndereco().getTipo();
      logradouroOrgao = orgao.getEndereco().getLogradouro();
      numeroOrgao = orgao.getEndereco().getNumero();
      complementoOrgao = orgao.getEndereco().getComplemento();
      bairroOrgao = orgao.getEndereco().getBairro();
      cidadeOrgao = orgao.getEndereco().getCidade();
      estadoOrgao = orgao.getEndereco().getUf();
      cepOrgao = orgao.getEndereco().getCep();
      siteOrgao = orgao.getEndereco().getSite();
      emailOrgao = orgao.getEndereco().getEmail();

      if (orgao.getEndereco().getTelefone() != null) {
        ddiOrgao = orgao.getEndereco().getTelefone().getDdi();
        dddOrgao = orgao.getEndereco().getTelefone().getDdd();
        numeroTelefoneOrgao = orgao.getEndereco().getTelefone().
                getTelefone();
        ramalOrgao = orgao.getEndereco().getTelefone().getRamal();
      }
    }

  }

  private void executarCriticas() {
     if( isExclusao()){
       executarCriticasExclusao();
       return;
     }
     /* ... */
  }

  private void executarCriticasExclusao() {
    
  }
}

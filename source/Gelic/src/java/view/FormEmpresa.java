/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

/**
 *
 * @author Adriano
 */
public class FormEmpresa extends Form {

  private model.beans.Empresa empresa;
  
  private String nomeFantasiaEmpresa;
  private String erroNomeFantasiaEmpresa;
  
  
  private boolean ePortadorEmpresa;
  private String erroEPortadorEmpresa;
  
  private String razaoSocialEmpresa;
  private String erroRazaoSocialEmpresa;
  
  private boolean eFornecedorEmpresa;
  private String erroEFornecedorEmpresa;
  
  private String cnpjEmpresa;
  private String erroCnpjEmpresa;
  private String ieEmpresa;
  private String erroIeEmpresa;
  private String imEmpresa;
  private String erroImEmpresa;
  private ArrayList<String> tiposLogradouro;
  private String tipoLogradouroEmpresa;
  private String erroTipoLogradouroEmpresa;
  private String logradouroEmpresa;
  private String erroLogradouroEmpresa;
  private String numeroEmpresa;
  private String erroNumeroEmpresa;
  private String complementoEmpresa;
  private String erroComplementoEmpresa;
  private String bairroEmpresa;
  private String erroBairroEmpresa;
  private String cidadeEmpresa;
  private String erroCidadeEmpresa;
  private ArrayList<String> estados;
  private String estadoEmpresa;
  private String erroEstadoEmpresa;
  private String cepEmpresa;
  private String erroCepEmpresa;
  private String siteEmpresa;
  private String erroSiteEmpresa;
  private String emailEmpresa;
  private String erroEmailEmpresa;
  private String ddiEmpresa;
  private String erroDdiEmpresa;
  private String dddEmpresa;
  private String erroDddEmpresa;
  private String numeroTelefoneEmpresa;
  private String erroNumeroTelefoneEmpresa;
  private String ramalEmpresa;
  private String erroRamalEmpresa;
  private boolean inclusao;

  public void atualizaCampos() {
    if (empresa == null) {
      return;
    }
    nomeFantasiaEmpresa = empresa.getNomeFantasia();
    eFornecedorEmpresa = empresa.getEFornecedor();
    ePortadorEmpresa = empresa.getEPortador();
    razaoSocialEmpresa = empresa.getRazaoSocial();
    
    cnpjEmpresa = empresa.getCnpj();
    ieEmpresa = empresa.getIe();
    imEmpresa = empresa.getIm();

    if (empresa.getEndereco() != null) {
      tipoLogradouroEmpresa = empresa.getEndereco().getTipo();
      logradouroEmpresa = empresa.getEndereco().getLogradouro();
      numeroEmpresa = empresa.getEndereco().getNumero();
      complementoEmpresa = empresa.getEndereco().getComplemento();
      bairroEmpresa = empresa.getEndereco().getBairro();
      cidadeEmpresa = empresa.getEndereco().getCidade();
      estadoEmpresa = empresa.getEndereco().getUf();
      cepEmpresa = empresa.getEndereco().getCep();
      siteEmpresa = empresa.getEndereco().getSite();
      emailEmpresa = empresa.getEndereco().getEmail();

      if (empresa.getEndereco().getTelefone() != null) {
        ddiEmpresa = empresa.getEndereco().getTelefone().getDdi();
        dddEmpresa = empresa.getEndereco().getTelefone().getDdd();
        numeroTelefoneEmpresa = empresa.getEndereco().getTelefone().
                getTelefone();
        ramalEmpresa = empresa.getEndereco().getTelefone().getRamal();
      }
    }

  }

  public model.beans.Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(model.beans.Empresa empresa) {
    this.empresa = empresa;
  }

  public String getNomeFantasiaEmpresa() {
    return nomeFantasiaEmpresa;
  }

  public void setNomeFantasiaEmpresa(String nomeFantasiaEmpresa) {
    this.nomeFantasiaEmpresa = nomeFantasiaEmpresa;
  }

  public String getErroNomeFantasiaEmpresa() {
    return erroNomeFantasiaEmpresa;
  }

  public void setErroNomeFantasiaEmpresa(String erroNomeFantasiaEmpresa) {
    this.erroNomeFantasiaEmpresa = erroNomeFantasiaEmpresa;
  }

    public String getErroEPortadorEmpresa() {
    return erroEPortadorEmpresa;
  }

  public void setErroEPortadorEmpresa(String erroEPortadorEmpresa) {
    this.erroEPortadorEmpresa = erroEPortadorEmpresa;
  }

  public String getRazaoSocialEmpresa() {
    return razaoSocialEmpresa;
  }

  public void setRazaoSocialEmpresa(String razaoSocialEmpresa) {
    this.razaoSocialEmpresa = razaoSocialEmpresa;
  }

  public String getErroRazaoSocialEmpresa() {
    return erroRazaoSocialEmpresa;
  }

  public void setErroRazaoSocialEmpresa(String erroRazaoSocialEmpresa) {
    this.erroRazaoSocialEmpresa = erroRazaoSocialEmpresa;
  }

  

  public String getErroEFornecedorEmpresa() {
    return erroEFornecedorEmpresa;
  }

  public void setErroEFornecedorEmpresa(String erroEFornecedorEmpresa) {
    this.erroEFornecedorEmpresa = erroEFornecedorEmpresa;
  }

  public String getCnpjEmpresa() {
    return cnpjEmpresa;
  }

  public void setCnpjEmpresa(String cnpjEmpresa) {
    this.cnpjEmpresa = cnpjEmpresa;
  }

  public String getErroCnpjEmpresa() {
    return erroCnpjEmpresa;
  }

  public void setErroCnpjEmpresa(String erroCnpjEmpresa) {
    this.erroCnpjEmpresa = erroCnpjEmpresa;
  }

  public String getIeEmpresa() {
    return ieEmpresa;
  }

  public void setIeEmpresa(String ieEmpresa) {
    this.ieEmpresa = ieEmpresa;
  }

  public String getErroIeEmpresa() {
    return erroIeEmpresa;
  }

  public void setErroIeEmpresa(String erroIeEmpresa) {
    this.erroIeEmpresa = erroIeEmpresa;
  }

  public String getImEmpresa() {
    return imEmpresa;
  }

  public void setImEmpresa(String imEmpresa) {
    this.imEmpresa = imEmpresa;
  }

  public String getErroImEmpresa() {
    return erroImEmpresa;
  }

  public void setErroImEmpresa(String erroImEmpresa) {
    this.erroImEmpresa = erroImEmpresa;
  }

  public ArrayList<String> getTiposLogradouro() {
    return tiposLogradouro;
  }

  public void setTiposLogradouro(ArrayList<String> tiposLogradouro) {
    this.tiposLogradouro = tiposLogradouro;
  }

  public String getTipoLogradouroEmpresa() {
    return tipoLogradouroEmpresa;
  }

  public void setTipoLogradouroEmpresa(String tipoLogradouroEmpresa) {
    this.tipoLogradouroEmpresa = tipoLogradouroEmpresa;
  }

  public String getErroTipoLogradouroEmpresa() {
    return erroTipoLogradouroEmpresa;
  }

  public void setErroTipoLogradouroEmpresa(String erroTipoLogradouroEmpresa) {
    this.erroTipoLogradouroEmpresa = erroTipoLogradouroEmpresa;
  }

  public String getLogradouroEmpresa() {
    return logradouroEmpresa;
  }

  public void setLogradouroEmpresa(String logradouroEmpresa) {
    this.logradouroEmpresa = logradouroEmpresa;
  }

  public String getErroLogradouroEmpresa() {
    return erroLogradouroEmpresa;
  }

  public void setErroLogradouroEmpresa(String erroLogradouroEmpresa) {
    this.erroLogradouroEmpresa = erroLogradouroEmpresa;
  }

  public String getNumeroEmpresa() {
    return numeroEmpresa;
  }

  public void setNumeroEmpresa(String numeroEmpresa) {
    this.numeroEmpresa = numeroEmpresa;
  }

  public String getErroNumeroEmpresa() {
    return erroNumeroEmpresa;
  }

  public void setErroNumeroEmpresa(String erroNumeroEmpresa) {
    this.erroNumeroEmpresa = erroNumeroEmpresa;
  }

  public String getComplementoEmpresa() {
    return complementoEmpresa;
  }

  public void setComplementoEmpresa(String complementoEmpresa) {
    this.complementoEmpresa = complementoEmpresa;
  }

  public String getErroComplementoEmpresa() {
    return erroComplementoEmpresa;
  }

  public void setErroComplementoEmpresa(String erroComplementoEmpresa) {
    this.erroComplementoEmpresa = erroComplementoEmpresa;
  }

  public String getBairroEmpresa() {
    return bairroEmpresa;
  }

  public void setBairroEmpresa(String bairroEmpresa) {
    this.bairroEmpresa = bairroEmpresa;
  }

  public String getErroBairroEmpresa() {
    return erroBairroEmpresa;
  }

  public void setErroBairroEmpresa(String erroBairroEmpresa) {
    this.erroBairroEmpresa = erroBairroEmpresa;
  }

  public String getCidadeEmpresa() {
    return cidadeEmpresa;
  }

  public void setCidadeEmpresa(String cidadeEmpresa) {
    this.cidadeEmpresa = cidadeEmpresa;
  }

  public String getErroCidadeEmpresa() {
    return erroCidadeEmpresa;
  }

  public void setErroCidadeEmpresa(String erroCidadeEmpresa) {
    this.erroCidadeEmpresa = erroCidadeEmpresa;
  }

  public ArrayList<String> getEstados() {
    return estados;
  }

  public void setEstados(ArrayList<String> estados) {
    this.estados = estados;
  }

  public String getEstadoEmpresa() {
    return estadoEmpresa;
  }

  public void setEstadoEmpresa(String estadoEmpresa) {
    this.estadoEmpresa = estadoEmpresa;
  }

  public String getErroEstadoEmpresa() {
    return erroEstadoEmpresa;
  }

  public void setErroEstadoEmpresa(String erroEstadoEmpresa) {
    this.erroEstadoEmpresa = erroEstadoEmpresa;
  }

  public String getCepEmpresa() {
    return cepEmpresa;
  }

  public void setCepEmpresa(String cepEmpresa) {
    this.cepEmpresa = cepEmpresa;
  }

  public String getErroCepEmpresa() {
    return erroCepEmpresa;
  }

  public void setErroCepEmpresa(String erroCepEmpresa) {
    this.erroCepEmpresa = erroCepEmpresa;
  }

  public String getSiteEmpresa() {
    return siteEmpresa;
  }

  public void setSiteEmpresa(String siteEmpresa) {
    this.siteEmpresa = siteEmpresa;
  }

  public String getErroSiteEmpresa() {
    return erroSiteEmpresa;
  }

  public void setErroSiteEmpresa(String erroSiteEmpresa) {
    this.erroSiteEmpresa = erroSiteEmpresa;
  }

  public String getEmailEmpresa() {
    return emailEmpresa;
  }

  public void setEmailEmpresa(String emailEmpresa) {
    this.emailEmpresa = emailEmpresa;
  }

  public String getErroEmailEmpresa() {
    return erroEmailEmpresa;
  }

  public void setErroEmailEmpresa(String erroEmailEmpresa) {
    this.erroEmailEmpresa = erroEmailEmpresa;
  }

  public String getDdiEmpresa() {
    return ddiEmpresa;
  }

  public void setDdiEmpresa(String ddiEmpresa) {
    this.ddiEmpresa = ddiEmpresa;
  }

  public String getErroDdiEmpresa() {
    return erroDdiEmpresa;
  }

  public void setErroDdiEmpresa(String erroDdiEmpresa) {
    this.erroDdiEmpresa = erroDdiEmpresa;
  }

  public String getDddEmpresa() {
    return dddEmpresa;
  }

  public void setDddEmpresa(String dddEmpresa) {
    this.dddEmpresa = dddEmpresa;
  }

  public String getErroDddEmpresa() {
    return erroDddEmpresa;
  }

  public void setErroDddEmpresa(String erroDddEmpresa) {
    this.erroDddEmpresa = erroDddEmpresa;
  }

  public String getNumeroTelefoneEmpresa() {
    return numeroTelefoneEmpresa;
  }

  public void setNumeroTelefoneEmpresa(String numeroTelefoneEmpresa) {
    this.numeroTelefoneEmpresa = numeroTelefoneEmpresa;
  }

  public String getErroNumeroTelefoneEmpresa() {
    return erroNumeroTelefoneEmpresa;
  }

  public void setErroNumeroTelefoneEmpresa(String erroNumeroTelefoneEmpresa) {
    this.erroNumeroTelefoneEmpresa = erroNumeroTelefoneEmpresa;
  }

  public String getRamalEmpresa() {
    return ramalEmpresa;
  }

  public void setRamalEmpresa(String ramalEmpresa) {
    this.ramalEmpresa = ramalEmpresa;
  }

  public String getErroRamalEmpresa() {
    return erroRamalEmpresa;
  }

  public void setErroRamalEmpresa(String erroRamalEmpresa) {
    this.erroRamalEmpresa = erroRamalEmpresa;
  }

  public boolean isInclusao() {
    return inclusao;
  }

  public void setInclusao(boolean inclusao) {
    this.inclusao = inclusao;
  }

    public


    boolean isEPortadorEmpresa() {
        return ePortadorEmpresa;
    }

    public void setEPortadorEmpresa(boolean ePortadorEmpresa) {
        this.ePortadorEmpresa = ePortadorEmpresa;
    }

    public

    boolean isEFornecedorEmpresa() {
        return eFornecedorEmpresa;
    }

    public void setEFornecedorEmpresa(boolean eFornecedorEmpresa) {
        this.eFornecedorEmpresa = eFornecedorEmpresa;
    }




}
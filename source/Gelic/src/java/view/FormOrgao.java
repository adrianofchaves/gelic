/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author adriano
 */
public class FormOrgao extends Form{
  private String nomeAtributo;
  
  public FormOrgao(){
    final String nomeAtributoDefault = "formOrgao";
    final String nome = nomeAtributoDefault + ".jsp";
    
    setNome(nome);
    setNomeAtributo(nomeAtributoDefault);
    
  }

  public String getNomeAtributo() {
    return nomeAtributo;
  }

  public void setNomeAtributo(String nomeAtributo) {
    this.nomeAtributo = nomeAtributo;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class BrowserOrgaos extends Form{
  private static final String nome = "browserOrgaos";
  private static final String nomeJSP = nome + ".jsp";
  private static final String caption = "Órgãos Públicos";
  private ArrayList <model.beans.Orgao> orgaos;
  private String nomeAtributo;
  
  public void refresh() throws ExcecaoForm{
    try {
      setOrgaos(model.services.Orgaos.recuperar());
    } catch (NamingException ex) {
      Logger.getLogger(BrowserOrgaos.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(BrowserOrgaos.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    }
  }
  public BrowserOrgaos(){
    setNome(nomeJSP);
    setTitulo(caption);    
    setNome(nome);    
  }

  public ArrayList<model.beans.Orgao> getOrgaos() {
    return orgaos;
  }

  public void setOrgaos(ArrayList<model.beans.Orgao> orgaos) {
    this.orgaos = orgaos;
  }

  public String getNomeAtributo() {
    return nomeAtributo;
  }

  public void setNomeAtributo(String nomeAtributo) {
    this.nomeAtributo = nomeAtributo;
  }
}

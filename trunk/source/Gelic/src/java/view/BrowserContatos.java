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
 * @author Adriano
 */
public class BrowserContatos extends Form {

  private ArrayList<model.beans.Contato> contatos;

  public void refresh() throws ExcecaoForm {
    if (getOrigem() == null) {
      return;
    }
    try {
      if (getOrigem() instanceof view.FormEmpresa) {
        view.FormEmpresa form = (FormEmpresa) getOrigem();
        model.services.Contatos.recuperar(form.getEmpresa());
        
        setContatos(form.getEmpresa().getContatos());
      }
    } catch (SQLException ex) {
      Logger.getLogger(BrowserContatos.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(BrowserContatos.class.getName()).log(
              Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    }

  }

  public ArrayList<model.beans.Contato> getContatos() {
    return contatos;
  }

  public void setContatos(ArrayList<model.beans.Contato> contatos) {
    this.contatos = contatos;
  }
}

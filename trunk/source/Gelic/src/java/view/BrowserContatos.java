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
public class BrowserContatos extends Form{
  private ArrayList <model.beans.Contato> contatos;
  private String origem;

  public ArrayList<model.beans.Contato> getContatos() {
    return contatos;
  }

  public void setContatos(ArrayList<model.beans.Contato> contatos) {
    this.contatos = contatos;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

}

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
public class BrowserEmpresas extends Form{
  private ArrayList<model.beans.Empresa> empresas;
  public BrowserEmpresas(){
    super.setTitulo("Empresas");
  }

  public ArrayList<model.beans.Empresa> getEmpresas() {
    return empresas;
  }

  public void setEmpresas(ArrayList<model.beans.Empresa> empresas) {
    this.empresas = empresas;
  }
          

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Adriano
 */
public class SimNao {

  boolean flag;

  public SimNao(boolean flag) {
    this.flag = flag;
  }

  public SimNao(String flag) {
    if (flag != null && flag.equalsIgnoreCase("s")) {
      this.flag = true;
    } else {
      this.flag = false;
    }
  }
  public boolean toBoolean(){
    return flag;
  }
  
}

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
public class BrowserSistemas extends Form {

    private ArrayList<model.beans.Sistema> sistemas = null;

    public BrowserSistemas() {

    }

    public BrowserSistemas(ArrayList<model.beans.Sistema> sistemas) {
        this.sistemas = sistemas;
    }

    public ArrayList<model.beans.Sistema> getSistemas() {
        return sistemas;
    }

    public void setSistemas(ArrayList<model.beans.Sistema> sistemas) {
        this.sistemas = sistemas;
    }
}

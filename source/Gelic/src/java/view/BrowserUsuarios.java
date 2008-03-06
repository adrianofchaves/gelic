/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public class BrowserUsuarios extends Form {

    private ArrayList<model.beans.Usuario> usuarios;

    public BrowserUsuarios(
            ArrayList<model.beans.Usuario> usuarios) {
        this.usuarios = usuarios;

    }

    public ArrayList<model.beans.Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<model.beans.Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

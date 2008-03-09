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
public class BrowserModalidades extends Form {
    private ArrayList <model.beans.Modalidade> modalidades = null;
    public BrowserModalidades(){
        
    }
    public BrowserModalidades(ArrayList <model.beans.Modalidade> modalidades){
        this.modalidades = modalidades;        
    }

    public ArrayList<model.beans.Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(ArrayList<model.beans.Modalidade> modalidades) {
        this.modalidades = modalidades;
    }

}

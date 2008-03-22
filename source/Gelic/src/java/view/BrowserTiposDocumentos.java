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
public class BrowserTiposDocumentos extends Form{

    private ArrayList<model.beans.TipoDocumento> tiposDocumentos = null;
    
    public BrowserTiposDocumentos(){
        
    }
    
    public BrowserTiposDocumentos(
            ArrayList<model.beans.TipoDocumento> tiposDocumentos ){
        this.tiposDocumentos = tiposDocumentos;
    }
    public ArrayList<model.beans.TipoDocumento> getTiposDocumentos() {
        return tiposDocumentos;
    }

    public void setTiposDocumentos(ArrayList<model.beans.TipoDocumento> 
            tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
    }
}

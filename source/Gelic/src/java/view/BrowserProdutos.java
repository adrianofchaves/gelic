/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class BrowserProdutos extends Form {
    
     private ArrayList<model.beans.Produto> produtos = null;
    
    public BrowserProdutos(){
        
    }
    
    public BrowserProdutos(
            ArrayList<model.beans.Produto> produtos ){
        this.produtos = produtos;
    }
    public ArrayList<model.beans.Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<model.beans.Produto> 
            produtos) {
        this.produtos = produtos;
    }

}

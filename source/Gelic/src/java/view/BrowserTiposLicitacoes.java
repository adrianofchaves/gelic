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
public class BrowserTiposLicitacoes extends Form{

    private ArrayList<model.beans.TipoLicitacao> tiposLicitacoes;
    
    public BrowserTiposLicitacoes(
            ArrayList<model.beans.TipoLicitacao> tiposLicitacoes ){
        this.tiposLicitacoes = tiposLicitacoes;
    }
    public ArrayList<model.beans.TipoLicitacao> getTiposLicitacoes() {
        return tiposLicitacoes;
    }

    public void setTiposLicitacoes(ArrayList<model.beans.TipoLicitacao> tiposLicitacoes) {
        this.tiposLicitacoes = tiposLicitacoes;
    }
}

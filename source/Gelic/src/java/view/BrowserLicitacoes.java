/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class BrowserLicitacoes extends Form {

    private ArrayList<model.beans.Licitacao> licitacoes = null;

    public BrowserLicitacoes() {

    }

    public BrowserLicitacoes(
            ArrayList<model.beans.Licitacao> licitacoes) {
        this.licitacoes = licitacoes;
    }

    public ArrayList<model.beans.Licitacao> getLicitacoes() {
        return licitacoes;
    }

    public void setLicitacoes(ArrayList<model.beans.Licitacao> licitacoes) {
        this.licitacoes = licitacoes;
    }
}
    
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
public class Form {

    private ArrayList<String> erros = null;

    public void apagaErros() {
        erros = null;
    }

    public void addErro(String erro) {
        if (getErros() == null) {
            setErros(new ArrayList<String>());
        }
        getErros().add(erro);
    }

    public ArrayList<String> getErros() {
        return erros;
    }
    public boolean temErros(){
        return !((erros == null)||erros.isEmpty());
    }

    public void setErros(ArrayList<String> erros) {
        this.erros = erros;
    }
}

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
public class BrowserLotes extends Form {
  static public final String NOME_ATRIBUTO_DEFAULT = "browserLotes";
  static public final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private ArrayList<model.beans.Lote> lotes;
  public String executar() {
    view.FormLicitacao form = (view.FormLicitacao) this.getOrigem();
    setLotes(form.getLicitacao().getMLote());
    setNome(NOME_DEFAULT);
    setTitulo("Lotes da licitação " + 
            form.getLicitacao().getTipoLicitacao().getSigla() + " " +
            form.getLicitacao().getNumero() + "/" +
            form.getLicitacao().getAno()); 
    return this.getNome();
  }

  public ArrayList<model.beans.Lote> getLotes() {
    return lotes;
  }

  public void setLotes(ArrayList<model.beans.Lote> lotes) {
    this.lotes = lotes;
  }

}

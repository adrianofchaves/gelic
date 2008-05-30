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
public class BrowserItensLote extends Form{
  ArrayList<model.beans.ItemLote> itensLote;
  static public final String NOME_ATRIBUTO_DEFAULT = "browserItensLote";
  static public final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  
  private view.FormLote getFormLote(){
    return (view.FormLote) getOrigem();
  }
  private model.beans.Lote getLote(){
    return getFormLote().getLote();
  }
  private view.FormLicitacao getFormLicitacao(){
    return (view.FormLicitacao)getFormLote().getOrigem().getOrigem();
  }
  private model.beans.Licitacao getLicitacao(){
    return getFormLicitacao().getLicitacao();
  }
  public String executar(){
    setTitulo( "Itens do lote " + getLicitacao() + "-" + getLote());
    setItensLote( getLote().getItensLote() );
    setNome(NOME_DEFAULT);
    if( getItensLote().isEmpty()){
      setMensagem("Não há itens para este lote.");
    }
    return getNome();
  }
  public ArrayList<model.beans.ItemLote> getItensLote() {
    return itensLote;
  }

  public void setItensLote(ArrayList<model.beans.ItemLote> itensLote) {
    this.itensLote = itensLote;
  }
  
  
}

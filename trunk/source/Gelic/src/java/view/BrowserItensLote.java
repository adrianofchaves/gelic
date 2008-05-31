/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;


/**
 *
 * @author Adriano
 */
public class BrowserItensLote extends Form{
  private ArrayList<model.beans.ItemLote> itensLote;
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
  @Override
  public void refresh() throws ExcecaoForm{
    try {
      getOrigem().refresh();
      model.services.ItensLote.recuperar(getLote());
    } catch (NamingException ex) {
      Logger.getLogger(
              BrowserItensLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(
              BrowserItensLote.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    }
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

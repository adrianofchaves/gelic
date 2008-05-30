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
public class BrowserLotes extends Form {

  static public final String NOME_ATRIBUTO_DEFAULT = "browserLotes";
  static public final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private ArrayList<model.beans.Lote> lotes;

  private view.FormLicitacao getFormLicitacao() {
    view.FormLicitacao form = (view.FormLicitacao) this.getOrigem();
    return form;
  }

  private model.beans.Licitacao getLicitacao() {
    return getFormLicitacao().getLicitacao();
  }

  @Override
  public void refresh() throws ExcecaoForm {
    try {
      getOrigem().refresh();
      setLotes(model.services.Licitacoes.recuperar(getLicitacao().getId()).
              getMLote());
    } catch (SQLException ex) {
      Logger.getLogger(
              BrowserLotes.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(
              BrowserLotes.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    }
  }

  public String executar() throws ExcecaoForm {
    refresh();
    setNome(NOME_DEFAULT);
    setTitulo("Lotes da licitação " +
            getLicitacao().getTipoLicitacao().getSigla() + " " +
            getLicitacao().getNumero() + "/" +
            getLicitacao().getAno());
    return this.getNome();
  }

  public ArrayList<model.beans.Lote> getLotes() {
    return lotes;
  }

  public void setLotes(ArrayList<model.beans.Lote> lotes) {
    this.lotes = lotes;
  }
}

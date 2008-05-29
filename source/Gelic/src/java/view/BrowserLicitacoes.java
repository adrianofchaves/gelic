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
 * @author Paulo
 */
public class BrowserLicitacoes extends Form {

  private ArrayList<model.beans.Licitacao> licitacoes = null;

  public BrowserLicitacoes() {

  }
  final static public String NOME_ATRIBUTO_DEFAULT = "browserLicitacoes";
  final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";

  public String executar() throws SQLException, NamingException {
    setNome(NOME_DEFAULT);
    carregaLicitacoes();
    return getNome();
  }

  @Override
  public void refresh() throws ExcecaoForm {
    try {
      carregaLicitacoes();
    } catch (SQLException ex) {
      Logger.getLogger(
              BrowserLicitacoes.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(
              BrowserLicitacoes.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoForm(ex.getMessage());
    }
  }

  public ArrayList<model.beans.Licitacao> getLicitacoes() {
    return licitacoes;
  }

  public void setLicitacoes(ArrayList<model.beans.Licitacao> licitacoes) {
    this.licitacoes = licitacoes;
  }

  private void carregaLicitacoes() throws NamingException, SQLException {
    licitacoes = model.services.Licitacoes.recuperar();
  }
}
    
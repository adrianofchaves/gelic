/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.EmpresaLote;

/**
 *
 * @author adriano
 */
public class BrowserPropostas extends Form {

  public static final String NOME_ATRIBUTO_DEFAULT = "browserPropostas";
  public static final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  ArrayList<model.beans.EmpresaLote> empresas;

  public ArrayList<EmpresaLote> getEmpresas() {
    return empresas;
  }

  public void setEmpresas(ArrayList<EmpresaLote> empresas) {
    this.empresas = empresas;
  }

  private view.FormLicitacao getFormLicitacao() {
    return (view.FormLicitacao) getOrigem().getOrigem().getOrigem();
  }

  private model.beans.Licitacao getLicitacao() {
    return getFormLicitacao().getLicitacao();
  }

  private view.FormLote getFormLote() {
    return (view.FormLote) getOrigem();
  }

  private model.beans.Lote getLote() {
    return getFormLote().getLote();
  }

  public String executar() throws NamingException, SQLException {

    model.services.Propostas.recuperar(getLote());
    setEmpresas(getLote().getEmpresas());

    if (getEmpresas().isEmpty()) {
      setMensagem("Não há proposta para este lote ainda.");
    }
    setTitulo("Propostas do lote " + getLicitacao() + "-" + getLote());
    setNome(NOME_DEFAULT);
    return getNome();
  }

}

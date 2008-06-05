/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Empresa;

/**
 *
 * @author adriano
 */
public class FormProposta extends Form {

  static final public String NOME_ATRIBUTO_DEFAULT = "formProposta";
  static final public String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private ArrayList<model.beans.Empresa> empresas;
  private ArrayList<ItemFormProposta> itens;

  public ArrayList<Empresa> getEmpresas() {
    return empresas;
  }

  public void setEmpresas(ArrayList<Empresa> empresas) {
    this.empresas = empresas;
  }

  public ArrayList<ItemFormProposta> getItens() {
    return itens;
  }

  public void setItens(ArrayList<ItemFormProposta> itens) {
    this.itens = itens;
  }

  private view.FormLote getFormLote() {
    return (view.FormLote) getOrigem().getOrigem();
  }

  private model.beans.Lote getLote() {
    return getFormLote().getLote();
  }

  public String preparaInclusao() throws NamingException, SQLException {
    setNome(NOME_DEFAULT);
    setEmpresas(model.services.Empresas.recuperar());
    model.services.ItensLote.recuperar(getLote());
    setItens(new ArrayList<ItemFormProposta>(getLote().getItensLote().size()));
    int indice = 0;
    for (model.beans.ItemLote item : getLote().getItensLote()) {
      indice ++;
      ItemFormProposta itemForm = new ItemFormProposta();      
      itemForm.setNome("precoProposta" + Integer.toString(indice));
      itemForm.setItemLote( item );
      getItens().add( itemForm );
    }
    return getNome();
  }
}

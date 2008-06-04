/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.LoteProposta;

/**
 *
 * @author adriano
 */
public class BrowserPropostas extends Form {

  private ArrayList<model.beans.LoteProposta> lotesProposta;
  public static final String NOME_ATRIBUTO_DEFAULT = "browserPropostas";
  public static final String NOME_DEFAULT = NOME_ATRIBUTO_DEFAULT + ".jsp";
  private view.FormLicitacao getFormLicitacao(){
    return (view.FormLicitacao) getOrigem().getOrigem().getOrigem();
  }
  private model.beans.Licitacao getLicitacao(){
    return getFormLicitacao().getLicitacao();
  }
  private view.FormLote getFormLote(){
    return (view.FormLote) getOrigem();
  }
  private model.beans.Lote getLote(){
    return getFormLote().getLote();
  }
  public String executar() throws NamingException, SQLException {
    
            model.services.Propostas.recuperar(getLote());
            setLotesProposta(getLote().getLotesProposta());
            
    if( getLotesProposta().isEmpty()){
      setMensagem("Não há proposta para este lote ainda.");
    }
    setTitulo("Propostas do lote " + getLicitacao() + "-" + getLote());
    setNome(NOME_DEFAULT);
    return getNome();
  }

  public ArrayList<LoteProposta> getLotesProposta() {
    return lotesProposta;
  }

  public void setLotesProposta(ArrayList<LoteProposta> lotesProposta) {
    this.lotesProposta = lotesProposta;
  }
}

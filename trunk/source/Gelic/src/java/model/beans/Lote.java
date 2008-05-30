package model.beans;

import java.sql.Date;
import java.util.ArrayList;

/**
 *  <p style="margin-top: 0">
 *        Agrupamento de itens que comp&#245;e uma licita&#231;&#227;o.<br><br>Na 
 *        documenta&#231;&#227;o estava previsto nome e n&#250;mero. Isso n&#227;o seria redundante?
 *  <br>
 *  <br>
 *      </p>
 *      <p style="margin-top: 0">
 *        <b>Caso de uso</b>: Incluir Lote
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4CBE2DD7-6487-576D-D4C2-3147106C027E]
// </editor-fold> 
public class Lote {

  private int id;
  private String numeroContrato;
  ArrayList<ItemLote> itensLote;
  
  public float getTotalEstimado(){
    if( getItensLote() == null ){
      return 0;
    }
    float total = 0;
    for( model.beans.ItemLote item : getItensLote()){
      total += item.getPrecoEstimado() * item.getQuantidade();
    }
    return total;
  }

  public ArrayList<ItemLote> getItensLote() {
    return itensLote;
  }

  public void setItensLote(ArrayList<ItemLote> itensLote) {
    this.itensLote = itensLote;
  }
  
  public String toString(){
    return Integer.toString(getNumero());
  }
  public Lote(int id, String numeroContrato, String nome,
          Date assinaturaContrato, int numero) {
    this.id = id;
    this.numeroContrato = numeroContrato;
    this.nome = nome;
    this.assinaturaContrato = assinaturaContrato;
    this.numero = numero;
  }
  /**
   *  <p style="margin-top: 0">
   *        Nome do lote.
   *  <br>
   *  <br>
   *      </p>
   *      <p style="margin-top: 0">
   *        <b>Caso de uso</b>: Incluir Lote
   *      </p>
   */
  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.FA239F82-3325-F4F3-8109-96BE094D0259]
  // </editor-fold> 
  private String nome;
  /**
   *  <p style="margin-top: 0">
   *        Data em que foi assinado o contrato que abrange o lote de licita&#231;&#227;o.
   *  <br>    </p>
   *      <p style="margin-top: 0">
   *        <b>
   *  </b><br>    </p>
   *      <p style="margin-top: 0">
   *        <b>Caso de uso: </b>Incluir Contrato
   *      </p>
   */
  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.36E47696-2D51-8C1C-1C49-A6AE1E3BDFE3]
  // </editor-fold> 
  private Date assinaturaContrato;
  /**
   *  <p style="margin-top: 0">
   *        N&#250;mero do lote.
   *  <br>
   *  <br>
   *      </p>
   *      <p style="margin-top: 0">
   *        <b>Caso de uso</b>: Incluir Lote
   *      </p>
   */
  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.20B41EFB-36D8-DD50-B4C0-D2482D99E559]
  // </editor-fold> 
  private int numero;

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.7AECEB6D-D7BB-C383-40BC-62E25CB45A66]
  // </editor-fold> 
  public Lote() {
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.98E90D9D-2BF8-AEA6-48A1-517AB81FC6F3]
  // </editor-fold> 
  public Date getAssinaturaContrato() {
    return assinaturaContrato;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.326BCF8B-E2A7-6592-76E1-8BFD95704732]
  // </editor-fold> 
  public void setAssinaturaContrato(Date val) {
    this.assinaturaContrato = val;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.B0B22F76-FA8B-B6FE-9C60-69118AA87112]
  // </editor-fold> 
  public String getNome() {
    return nome;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.D377D46A-99D8-5EA2-464B-43374440304A]
  // </editor-fold> 
  public void setNome(String val) {
    this.nome = val;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.60B63E2C-24E4-6D66-B775-CC042ED177DF]
  // </editor-fold> 
  public int getNumero() {
    return numero;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.16BF0C1A-0372-0DCE-F200-91428EDE0E66]
  // </editor-fold> 
  public void setNumero(int val) {
    this.numero = val;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNumeroContrato() {
    return numeroContrato;
  }

  public void setNumeroContrato(String numeroContrato) {
    this.numeroContrato = numeroContrato;
  }
}


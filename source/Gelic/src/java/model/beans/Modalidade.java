package model.beans;

/**
 *  <p style="margin-top: 0">
 *        Modalidade de licita&#231;&#245;es.
 *  <br>
 *  <br><b>Caso de Uso: </b>Manter Modalidade
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.AE3CF9F1-73F1-6A42-61C4-5451E2B7687F]
// </editor-fold> 
public class Modalidade {

  public String toString() {
    return getSigla();
  }
  /**
   *  <p style="margin-top: 0">
   *        Nome da modalidade de licita&#231;&#245;es.
   *      </p>
   */
  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.F3409979-781D-3507-D574-ABAAFC961277]
  // </editor-fold> 
  private String nome;
  /**
   *  <p style="margin-top: 0">
   *    Sigla da modalidade de licita&#231;&#245;es.
   *      </p>
   */
  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.8980F649-142C-E322-5248-C4A1887FE382]
  // </editor-fold> 
  private String sigla;

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,id=DCE.9E7B4605-4FFB-98AF-C39E-D6D0F06E1BB2]
  // </editor-fold> 
  public Modalidade() {
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.6665B1B5-33EB-B143-5488-621B351434FD]
  // </editor-fold> 
  public String getNome() {
    return nome;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.5B58F7F6-A63F-C910-82C1-23BB2F970BF5]
  // </editor-fold> 
  public void setNome(String val) {
    this.nome = val;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.6A3974D3-EF76-3527-A98A-3E1450303FB5]
  // </editor-fold> 
  public String getSigla() {
    return sigla;
  }

  // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
  // #[regen=yes,regenBody=yes,id=DCE.6A509F93-576E-302F-F0CE-AD92D64DB61A]
  // </editor-fold> 
  public void setSigla(String val) {
    this.sigla = val;
  }
}


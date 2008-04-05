package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Esse &#233; um tipo de dados que representa um n&#250;mero de telefone.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BAB00DA0-2043-E400-768E-6061FE9F4813]
// </editor-fold> 
public class TipoTelefone {
    public String toString(){
      String buffer = getRamal();
      
      if( buffer != null && !buffer.isEmpty() ){
        return getDdi() + " " + getDdd() + " " + getTelefone() + " R:"  + 
                buffer;
      }
      return getDdi() + " " + getDdd() + " " + getTelefone();
    }
    
    private int id;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0404D7C9-F090-E52C-50A9-E41FC67E3A3A]
    // </editor-fold> 
    private String ddi;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8352777C-F556-1427-3633-E2DB32871C9A]
    // </editor-fold> 
    private String ddd;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.032B6194-2787-A71F-A9C1-532CD7B8BC12]
    // </editor-fold> 
    private String telefone;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2CFFD046-2C8E-1EB1-B274-2FCD39BC7F87]
    // </editor-fold> 
    private String ramal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3DCBF5A7-607D-4B35-EE69-2514CB75DDFD]
    // </editor-fold> 
    public TipoTelefone () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96416CC0-743B-4463-BB22-9F5BD37C4640]
    // </editor-fold> 
    public String getDdd () {
        return ddd;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.70245C2D-16A2-0661-1A32-F72DB9FDC672]
    // </editor-fold> 
    public void setDdd (String val) {
        this.ddd = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.65CD6054-9AB7-C593-A0FA-119E293329B2]
    // </editor-fold> 
    public String getDdi () {
        return ddi;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9368162A-860B-607A-4CFD-62A442F52E8C]
    // </editor-fold> 
    public void setDdi (String val) {
        this.ddi = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9A5DCF5E-1317-9DBB-0044-3153461A4D60]
    // </editor-fold> 
    public String getRamal () {
        return ramal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5593ACDC-FE3C-7E5E-2079-418FC270D205]
    // </editor-fold> 
    public void setRamal (String val) {
        this.ramal = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1419A339-CFDE-CE93-B0F6-B01238C284AF]
    // </editor-fold> 
    public String getTelefone () {
        return telefone;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B66F863E-0648-ACA3-33AD-1BC052F911C7]
    // </editor-fold> 
    public void setTelefone (String val) {
        this.telefone = val;
    }

  public

  int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}


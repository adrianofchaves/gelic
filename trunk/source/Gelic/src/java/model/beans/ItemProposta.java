package model.beans;


/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto: </b>ver classe ItemLote.
 *      </p>
 *      <p style="margin-top: 0">
 *        
 *  <br>    </p>
 *      <p style="margin-top: 0">
 *        Item que comp&#245;e a proposta para licita&#231;&#227;o.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.37DBB6A1-358B-F5AA-C575-99D8751B9F94]
// </editor-fold> 
public class ItemProposta {

    /**
     *  <p style="margin-top: 0">
     *    Pre&#231;o proposto para o item do lote.
     *  <br>
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *    D&#250;vida: este pre&#231;o &#233; unit&#225;rio ou total?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E430E5D4-2E46-A1DA-8128-F6BE092DA279]
    // </editor-fold> 
    private float preco;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B55F9C85-11DB-EE17-90CB-AD02C2336982]
    // </editor-fold> 
    public ItemProposta () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7839E1BC-6C4B-AAD0-8A67-1A7A14BF18DD]
    // </editor-fold> 
    public float getPreco () {
        return preco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.509FDD98-6FA4-81DD-7C7F-35928CAF0C41]
    // </editor-fold> 
    public void setPreco (float val) {
        this.preco = val;
    }

}


package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Comp&#245;e uma ordem de fornecimento.
 *  <br>
 *  <br><b>Caso de uso: </b>Incluir Item de Ordem de Fornecimento
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.112E86A2-421C-44D8-ECCE-3C5EA1946FA5]
// </editor-fold> 
public class ItemOrdemFornecimento {

    /**
     *  <p style="margin-top: 0">
     *    <b>Caso de uso: </b>Incluir Item de Ordem de Fornecimento
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9EF7CCB4-0397-4295-AF47-E91DC6BE7FAE]
    // </editor-fold> 
    private float quantidade;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61F86772-7B7D-1063-79B9-6C1CE5AAD1DF]
    // </editor-fold> 
    public ItemOrdemFornecimento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6697D280-2274-5583-7F93-676B98DA3669]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F8E9B826-CC4D-2D5D-5E3E-E1AEE8A22E0B]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

}


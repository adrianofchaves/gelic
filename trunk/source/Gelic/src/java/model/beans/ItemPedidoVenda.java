package model.beans;


/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto: </b>ver classe Fornecimento e seus relacionamentos.
 *      </p>
 *      <p style="margin-top: 0">
 *        
 *  <br>    </p>
 *      <p style="margin-top: 0">
 *        Item que comp&#245;e um pedido de venda.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.9B77463C-5054-5CB1-59E9-AA73A7712A45]
// </editor-fold> 
public class ItemPedidoVenda {

    /**
     *  <p style="margin-top: 0">
     *    Quantidade de itens que ser&#227;o entregues/vendidos.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A4B979BE-354E-1461-BA53-E02BE585CF3F]
    // </editor-fold> 
    private float quantidade;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.943D422E-DC48-4CA8-4920-3FFCFAA4E363]
    // </editor-fold> 
    public ItemPedidoVenda () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0D3D4AEB-4183-FAC1-98C5-90DC731342E5]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8D7B94FA-26E3-D772-646E-963B107C21B0]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

}


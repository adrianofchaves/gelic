package model.gelic;


/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto: </b>ver classe Fornecimento e seus relacionamentos.
 *      </p>
 *      <p style="margin-top: 0">
 *        
 *  <br>    </p>
 *      <p style="margin-top: 0">
 *        Item que comp&#245;e o pedido de compra ao fornecedor (empresa fornecedora).
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.FDCB59C6-7C61-CCFB-B761-272C4BE4B1FD]
// </editor-fold> 
public class ItemPedidoCompra {

    /**
     *  <p style="margin-top: 0">
     *        Pre&#231;o cobrado pelo fornecedor para este item. Pre&#231;o que dever&#225; ser pago 
     *        ao fornecedor (empresa) pelo item.<br><br>Estava previsto long mas achei 
     *        melhor deixar como float.
     *  <br>
     *  <br>D&#250;vida: este pre&#231;o &#233; unit&#225;rio ou total?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B860F00A-18C2-CF38-3DCB-946F4015C8EE]
    // </editor-fold> 
    private float preco;

    /**
     *  <p style="margin-top: 0">
     *        Quantidade pedida do item.
     *  <br>
     *  <br>Estava previsto o tipo Long, mas achei muito. Adotei Int.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FF9E64EE-A6AE-842D-421D-C337D6D2652B]
    // </editor-fold> 
    private float quantidade;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2AFC4362-A1BC-FD98-88F3-1D9DD72BFD2B]
    // </editor-fold> 
    public ItemPedidoCompra () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CCCAA4CF-A8CE-9D92-6C06-FC936EA61468]
    // </editor-fold> 
    public float getPreco () {
        return preco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FD6B3FA0-3662-95F2-05C2-302EBEBDAC0A]
    // </editor-fold> 
    public void setPreco (float val) {
        this.preco = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.874C9101-0F33-FFC0-AEFB-197DFEB24303]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7D7C3B85-33DF-6C53-404C-FCCD55EB9042]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

}


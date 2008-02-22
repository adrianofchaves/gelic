package model.gelic;


/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto: </b>ver classe Fornecimento.
 *  <br>    </p>
 *      <p style="margin-top: 0">
 *        Item que comp&#245;e o pedido-m&#227;e. Pedido-m&#227;e &#233; um aviso de fornecimento 
 *        eviado ao assinar o contrato.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D125DB96-6202-1B69-AA7A-2E334201B376]
// </editor-fold> 
public class ItemPedidoMae {

    /**
     *  <p style="margin-top: 0">
     *    Quantidade do item a ser fornecida.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1A393982-3462-0EA2-AEBA-C03D8974A644]
    // </editor-fold> 
    private float quantidade;

    /**
     *  <p style="margin-top: 0">
     *    Pre&#231;o que ser&#225; pago ao fornecedor pela compra do item.
     *  <br>
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *    D&#250;vida: este pre&#231;o &#233; unit&#225;rio ou total?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8F786778-3BA2-FD36-6EA6-EEEA8183B3A4]
    // </editor-fold> 
    private float preco;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.15BCF31B-6CD8-6AAE-540D-AC51865FDF60]
    // </editor-fold> 
    public ItemPedidoMae () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7BB8C25B-5B63-19C8-9603-CE20E5BF507D]
    // </editor-fold> 
    public float getPreco () {
        return preco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A74D995F-43D9-6E25-A26C-64DD889CD036]
    // </editor-fold> 
    public void setPreco (float val) {
        this.preco = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.30088F13-D51E-7F07-2274-3E57A9147708]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E102B9F0-8B43-9EA6-6827-EB09C71DC9DD]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

}


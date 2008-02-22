package model.gelic;


/**
 *  <p style="margin-top: 0">
 *        Relaciona cada item de lote com sua empresa fornecedora. Essa entidade 
 *        guarda as informa&#231;&#245;es para gerar os pedidos-m&#227;e: Empresa, Item, Lote, 
 *        Quantidade.
 *  <br>
 *  <br><b>Caso de uso</b>: Gerar Pedido-m&#227;e
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1520BABD-8AA1-FA2C-E7A6-EFD3D89C4ACC]
// </editor-fold> 
public class Fornecimento {

    /**
     *  <p style="margin-top: 0">
     *        Quantidade do item que ser&#225; fornecido pela empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Gerar Pedido-m&#227;e
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.569D9970-AD48-726B-B91B-5BDE98BB408F]
    // </editor-fold> 
    private float quantidade;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A7FE596-C21A-C2E5-0305-0FA8AC2E54AA]
    // </editor-fold> 
    public Fornecimento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2D9BE523-60FD-5E95-2290-0CF0FE67AB07]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.666C947B-2D3E-57CE-E5F8-3040EEB61B9E]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

}


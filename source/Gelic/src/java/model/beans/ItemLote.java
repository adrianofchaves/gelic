package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Item que comp&#245;e um lote.  Quando o lote &#233; ganho e o contrato &#233; assinado 
 *        esta classe representa o item do contrato.<br><br><b>M&#225;quina de estado</b>: 
 *        Item Lote<br><b>Casos de uso</b>:<br>. Incluir Item de Lote<br>. Gerar 
 *        Pedido-m&#227;e<br>
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1B3D7650-EA1D-BE7F-2724-90964431007B]
// </editor-fold> 
public class ItemLote {

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  int id;
  
  model.beans.Produto produto;

  public int getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }
  int idProduto;
  
  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public ItemLote(int id, int numero, float quantidade, float precoEstimado, 
          float precoProposto, float precoCompra, int idProduto) {
    this.numero = numero;
    this.quantidade = quantidade;
    this.precoEstimado = precoEstimado;
    this.precoProposto = precoProposto;
    this.precoCompra = precoCompra;
    this.idProduto = idProduto;
  }

    /**
     *  <p style="margin-top: 0">
     *        N&#250;mero do item.
     *  <br>
     *  <br>N&#227;o deveria ser String?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6A5B9779-1AB1-E109-B8B4-A46A92BA3340]
    // </editor-fold> 
    private int numero;

    /**
     *  <p style="margin-top: 0">
     *    Quantidade que ser&#225; comprada do item.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D0947A93-D3FE-1974-1FD8-A6066A598E50]
    // </editor-fold> 
    private float quantidade;

    /**
     *  <p style="margin-top: 0">
     *        Pre&#231;o estimado pelo &#243;rg&#227;o licitante para o item.<br><br>
     *      </p>
     *      <p style="margin-top: 0">
     *        D&#250;vida: este pre&#231;o &#233; unit&#225;rio ou total?
     *  <br>Estava previsto long, mas acho melhor float.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5D79410B-2914-EAA1-2913-52C4D449F6F0]
    // </editor-fold> 
    private float precoEstimado;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3097FE43-2126-4056-D911-03ABA3B8463A]
    // </editor-fold> 
    private float precoProposto;

    /**
     *  <p style="margin-top: 0">
     *    <b>M&#225;quina de estado</b>: Item Lote
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1F64910E-E4D1-ACD0-2DF1-1CEAF106AE45]
    // </editor-fold> 
    private int status;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8D1138D5-1648-40F3-B411-BDEE927A3964]
    // </editor-fold> 
    private float precoCompra;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.96A0069D-9050-9E47-C16C-E56E46292936]
    // </editor-fold> 
    public ItemLote () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.64E430C2-B437-824C-2268-E5F703D433B0]
    // </editor-fold> 
    public int getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4F55A6CA-0CF2-F9BC-70D5-610B46CDE5D9]
    // </editor-fold> 
    public void setNumero (int val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2DFADFAB-2505-40E0-C8A7-98090A2A083D]
    // </editor-fold> 
    public float getPrecoCompra () {
        return precoCompra;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.22A5EC05-6DF2-7165-EB07-12A54F7062F7]
    // </editor-fold> 
    public void setPrecoCompra (float val) {
        this.precoCompra = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8BB543B3-5907-E9B8-5C36-31C999173541]
    // </editor-fold> 
    public float getPrecoEstimado () {
        return precoEstimado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.32BF3119-AC6C-C4CE-79F2-535C97D591FD]
    // </editor-fold> 
    public void setPrecoEstimado (float val) {
        this.precoEstimado = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EBD3362D-CBF4-692E-BB2F-BB8F7F7BDE73]
    // </editor-fold> 
    public float getPrecoProposto () {
        return precoProposto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8E82ED1A-0427-5381-3EAA-3F5A55DCF7F4]
    // </editor-fold> 
    public void setPrecoProposto (float val) {
        this.precoProposto = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3B499F73-C1E0-CC56-B217-9A7DA01FCE6A]
    // </editor-fold> 
    public float getQuantidade () {
        return quantidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.323B1186-62DA-BC3C-C6CA-FD30246D07BA]
    // </editor-fold> 
    public void setQuantidade (float val) {
        this.quantidade = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.893F8838-8CF3-C013-8075-9A65FFA26DEE]
    // </editor-fold> 
    public int getStatus () {
        return status;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3CDA04C4-38F0-B530-467D-73AB4D14250A]
    // </editor-fold> 
    public void setStatus (int val) {
        this.status = val;
    }

}


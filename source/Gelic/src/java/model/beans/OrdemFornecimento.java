package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Representa o documento ofical do &#243;rg&#227;o p&#250;blico em que &#233; solicitado o 
 *        fornecimento do material contratado.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BC2124DF-B5AB-6BC1-8E32-9BC679F92621]
// </editor-fold> 
public class OrdemFornecimento {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.49F141D8-3190-0430-E289-8EDBE7851438]
    // </editor-fold> 
    private String numero;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.92B464D4-1701-F607-BC88-39985F48B0DB]
    // </editor-fold> 
    private Date recebimento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2604231F-7AC1-43E8-CEF6-87203A0E6792]
    // </editor-fold> 
    private Date envioPedidoVenda;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A9F704B7-90D6-7AD5-5C27-1121A2247FB8]
    // </editor-fold> 
    public OrdemFornecimento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.81AFD25F-0527-E3A6-627A-DB52BF1967BF]
    // </editor-fold> 
    public Date getEnvioPedidoVenda () {
        return envioPedidoVenda;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF47EC3A-2531-0BB3-4360-40724533776E]
    // </editor-fold> 
    public void setEnvioPedidoVenda (Date val) {
        this.envioPedidoVenda = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9DE7B08D-8827-F9D1-81D3-A8583923DD43]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.35E327FC-D233-0769-C346-83A3BE8E3E74]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3FCCED54-40E5-EDFA-EB14-EFBE0C71DD1B]
    // </editor-fold> 
    public Date getRecebimento () {
        return recebimento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.51FD6925-ED91-5FE0-07F4-83EED3067251]
    // </editor-fold> 
    public void setRecebimento (Date val) {
        this.recebimento = val;
    }

}


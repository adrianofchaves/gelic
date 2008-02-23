package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Documento de cobran&#231;a emitido pelo fornecedor contra a empresa para o 
 *        pagamento da nota fiscal de compra.<br>
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        <b>Caso de usos</b>: Incluir Duplicata, Baixar Duplicata
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        <b>Pend&#234;ncias:</b><br>Estava previsto ainda um atributo Banco. Ele 
 *        ainda e necessario ja que existe a classe banco?<br><br>Uma nota fiscal 
 *        tem no maximo uma duplicata? Caso contrario seria necessario um atributo 
 *        valor aqui. Pelo que vi a classe TituloAPagar ficaria com essa 
 *        responsabilidade. Agora n&#227;o vejo motivo para as duas classes existirem. 
 *        Sendo assim, a princ&#237;pio vou matar a classe TituloAPagar (o termo 
 *        Duplicata parece mais apropriado neste dom&#237;nio).<br>
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        O valor pago nao pode ser diferente do valor da duplicata por conta de 
 *        multa, descontos etc? Se for talvez precisemos de um atributo valor pago.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B73B2325-D059-18C6-CB72-31839B4DAB68]
// </editor-fold> 
public class Duplicata {

    /**
     *  <p style="margin-top: 0">
     *        N&#250;mero da duplicata.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Duplicata
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7C426D1B-4861-0130-2F37-8FC555AB79ED]
    // </editor-fold> 
    private int numero;

    /**
     *  <p style="margin-top: 0">
     *        Vencimento da duplicata.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Duplicata
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FA8D43D8-326B-CF48-25B1-DB6A4721843E]
    // </editor-fold> 
    private Date vencimento;

    /**
     *  <p style="margin-top: 0">
     *        Data de pagamento da duplicata.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Baixar Duplicata
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.47DC07D5-E2C4-9BA7-A5DE-8857E304BD6C]
    // </editor-fold> 
    private Date pagamento;

    /**
     *  <p style="margin-top: 0">
     *        Valor da duplicata.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Duplicata
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8C437D44-C743-9D21-0BC9-85EB7C664CAD]
    // </editor-fold> 
    private float valor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C6DD3F2D-2162-4F6E-C3DA-34D98BF431E1]
    // </editor-fold> 
    public Duplicata () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D891965E-0694-A82B-FFCF-921AB4C3DDD6]
    // </editor-fold> 
    public int getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6A158A53-553B-190D-BE8B-D3574C3A4042]
    // </editor-fold> 
    public void setNumero (int val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4DEB3391-620E-A3D8-6701-14EAE2FEDA91]
    // </editor-fold> 
    public Date getPagamento () {
        return pagamento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.06A41BC8-BF0C-610D-4FB1-19D6A6D759C8]
    // </editor-fold> 
    public void setPagamento (Date val) {
        this.pagamento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42B9CEDE-C338-CA57-44DD-2BAAB8AE3CF2]
    // </editor-fold> 
    public float getValor () {
        return valor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E97F55FA-6B04-F7CB-9A55-FBD69E79C47F]
    // </editor-fold> 
    public void setValor (float val) {
        this.valor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.24017AAF-7019-FCFE-B781-3C03A0C5740E]
    // </editor-fold> 
    public Date getVencimento () {
        return vencimento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5C09DFCB-D34A-E1B7-E4B9-EDD3C2DBA95F]
    // </editor-fold> 
    public void setVencimento (Date val) {
        this.vencimento = val;
    }

}


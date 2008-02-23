package model.beans;

import java.sql.Date;


/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto - ver classe Lote.</b>
 *  <br>
 *  <br>
 *  <br>    </p>
 *      <p style="margin-top: 0">
 *        Contrato assinado entre o licitante e o &#243;rg&#227;o p&#250;blico ap&#243;s t&#233;rmino do 
 *        processo licitat&#243;rio.
 *  <br>
 *  <br>
 *  <br>    </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.DEC2049A-8C96-FCC2-FB8C-6056C0849C26]
// </editor-fold> 
public class Contrato {

    /**
     *  <p style="margin-top: 0">
     *    Numero do contrato assinado entre as partes.
     *  <br>
     *  <br>Tem mesmo que ser inteiro?  N&#227;o seria melhor se o tipo fosse String?
     *  <br>    </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8EBE4583-C115-1A9B-F294-9B0072C4C17F]
    // </editor-fold> 
    private int numero;

    /**
     *  <p style="margin-top: 0">
     *    Data da assinatura do contrato.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B1C1879D-6D6E-F76D-2983-823D875ADDDB]
    // </editor-fold> 
    private Date assinatura;

    /**
     *  <p style="margin-top: 0">
     *    Valor de garantia do contrato.  
     *  <br>
     *  <br>
     *  <br>    </p>
     *      <p style="margin-top: 0">
     *    Esse valor somente ser&#225; pago ao t&#233;rmino do contrato?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.228246BC-6168-5519-42F4-5033FE0C7DD1]
    // </editor-fold> 
    private float valorGarantia;

    /**
     *  <p style="margin-top: 0">
     *    Numero do contrato assinado entre as partes.
     *  <br>
     *  <br>Tem mesmo que ser inteiro?!
     *  <br>    </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EEC02836-E997-47BB-501B-18A9A98AE456]
    // </editor-fold> 
    public Contrato () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F4E5FDB6-22EB-8AFA-7641-EC0D7177A7FC]
    // </editor-fold> 
    public Date getAssinatura () {
        return assinatura;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96FD12C7-9DEE-AE64-AC89-47AD735CD375]
    // </editor-fold> 
    public void setAssinatura (Date val) {
        this.assinatura = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.797FC69A-9CD0-546F-57E7-B9BC09C126B6]
    // </editor-fold> 
    public int getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.12522EFF-FD21-176B-D2D5-8CD0CC39DCF9]
    // </editor-fold> 
    public void setNumero (int val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8D72AE11-0B39-9CB7-5756-EB0BB8FD0F03]
    // </editor-fold> 
    public float getValorGarantia () {
        return valorGarantia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DADBFB47-7908-E574-57E0-79F980D1D9AD]
    // </editor-fold> 
    public void setValorGarantia (float val) {
        this.valorGarantia = val;
    }

}


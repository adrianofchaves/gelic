package model.beans;

import java.sql.Date;
/**
 *  <p style="margin-top: 0">
 *        <b>obsoleto: </b>ver classe Fornecimento e seus relacionamentos
 *      </p>
 *      <p style="margin-top: 0">
 *        
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        
 *      </p>
 *      <p style="margin-top: 0">
 *        Pedido de venda do contratado gerado automaticamente pelo sistema ao 
 *        cadastrar nova ordem de fornecimento.<br><br>Assim como pedido de 
 *        compra, essa classe parece um pouco sem sentido. Podemos criar uma classe
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.5CF4D642-740F-DC4D-B770-7074E53E5A7F]
// </editor-fold> 
public class PedidoVenda {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.820A24F8-111B-BA56-A6A8-6F973814BE76]
    // </editor-fold> 
    private Date envio;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A803D8C6-5DA7-5540-09B0-2376F433959E]
    // </editor-fold> 
    private String numero;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AC52211F-1F29-1CCB-09BF-967A444E26C0]
    // </editor-fold> 
    private int status;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B5239E3A-06ED-AD9C-3633-9E87F67872CC]
    // </editor-fold> 
    public PedidoVenda () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.90C5EE43-0F7C-E6BE-2559-61DABAC8A242]
    // </editor-fold> 
    public Date getEnvio () {
        return envio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A3616AF1-D6ED-D0EE-C49C-451037B9643B]
    // </editor-fold> 
    public void setEnvio (Date val) {
        this.envio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.60DCF32F-0AC5-76BC-D9A4-7C489ACBC446]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A70AC030-D1CF-7B30-4235-205E87B77780]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EBCC3E54-688D-AB0C-705D-C30CD303B30C]
    // </editor-fold> 
    public int getStatus () {
        return status;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F7899050-B332-5FFA-2AB8-0F8D6C9A0C56]
    // </editor-fold> 
    public void setStatus (int val) {
        this.status = val;
    }

}


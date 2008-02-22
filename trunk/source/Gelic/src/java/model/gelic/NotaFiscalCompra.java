package model.gelic;

import java.sql.Date;


/**
 *  <p style="margin-top: 0">
 *        Representa uma nota fiscal emitida pelo fornecedor contra a empresa.
 *  <br>
 *  <br><b>Caso de uso</b>: Incluir Nota Fiscal de Compra
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4EC004D4-C0C4-A11A-56B6-8AD71E19F851]
// </editor-fold> 
public class NotaFiscalCompra {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C47919BA-F983-1C4F-1CCC-571A1D2B8F47]
    // </editor-fold> 
    private String numero;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4EB511AA-C196-3B1E-DF0C-B6FB5CF53DAA]
    // </editor-fold> 
    private Date emissao;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.95DE71DC-471E-41FB-DD4A-6C2648DEA6D5]
    // </editor-fold> 
    public NotaFiscalCompra () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A8434719-8940-390E-1975-CEDCB0BE086D]
    // </editor-fold> 
    public Date getEmissao () {
        return emissao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A961A4CF-306D-1DF6-E6C1-D6B868E34FD0]
    // </editor-fold> 
    public void setEmissao (Date val) {
        this.emissao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E2D9FD4E-3C83-5814-ABC7-E476C8F86435]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7911984D-F928-9B1B-42AD-75CE898D624B]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

}


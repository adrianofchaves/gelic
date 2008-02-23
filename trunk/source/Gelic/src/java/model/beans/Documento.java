package model.beans;

import java.sql.Date;


/**
 *  <p style="margin-top: 0">
 *        Documento que a empresa deve apresentar para participar de uma licita&#231;&#227;o.
 *  <br>
 *  <br><b>Caso de uso</b>: Incluir Documento
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        <br>
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.21B12427-AE50-4F7D-6289-A022191DD4DE]
// </editor-fold> 
public class Documento {

    /**
     *  <p style="margin-top: 0">
     *        Nome do documento
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D34E3ACD-8CE0-F387-D0D4-DC50D5682F6B]
    // </editor-fold> 
    private String nome;

    /**
     *  <p style="margin-top: 0">
     *        Data de emiss&#227;o do documento.
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0857276D-05DB-D2D5-95E9-99879820F3A7]
    // </editor-fold> 
    private Date emissao;

    /**
     *  <p style="margin-top: 0">
     *        Quantidade de dias que o documento tem de validade.<br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        O documento estar&#225; &quot;vencido&quot; ap&#243;s emissao + dias vencimento?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AB9CCB45-0B49-DCED-E137-F67007EB2502]
    // </editor-fold> 
    private int diasValidade;

    /**
     *  <p style="margin-top: 0">
     *        Munc&#237;pio de emiss&#227;o do documento
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.463F5FBF-DC86-EF39-6511-21978AF739C6]
    // </editor-fold> 
    private String municipio;

    /**
     *  <p style="margin-top: 0">
     *        Estado (unidade federativa) de emiss&#227;o do documento
     *      </p>
     *      <p style="margin-top: 0">
     *        .<br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.076009D3-B293-7775-6EE6-F82D77D593A4]
    // </editor-fold> 
    private String uf;

    /**
     *  <p style="margin-top: 0">
     *        Endere&#231;o eletr&#244;nico do site para emiss&#227;o ou confer&#234;ncia do documento.
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <b>Caso de uso</b>: Incluir Documento
     *      </p>
     *      <p style="margin-top: 0">
     *        <br>
     *        <br>
     *        
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A8A63E3-ACCB-B49E-4BA7-F0EE65E7969E]
    // </editor-fold> 
    private String site;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D115A86E-84D4-FE0E-0ED1-741D202B6B41]
    // </editor-fold> 
    public Documento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B2F472B-554A-9084-26A3-2ED3685BA69B]
    // </editor-fold> 
    public int getDiasValidade () {
        return diasValidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1AB4D497-420B-94A3-2851-3296B40EF9F0]
    // </editor-fold> 
    public void setDiasValidade (int val) {
        this.diasValidade = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.89831B93-85EA-73DE-4442-9CC03EDDAB06]
    // </editor-fold> 
    public Date getEmissao () {
        return emissao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A4C9CF74-D6DB-64D6-CC02-39837A7EED0B]
    // </editor-fold> 
    public void setEmissao (Date val) {
        this.emissao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.85830C03-4044-46AC-EBFF-8F16659BBAEC]
    // </editor-fold> 
    public String getMunicipio () {
        return municipio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C72B2D3A-D01B-4D22-56BA-7A0EE707D1B1]
    // </editor-fold> 
    public void setMunicipio (String val) {
        this.municipio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.31FDBAC1-7CA8-EC29-92FB-CBE3A18EC582]
    // </editor-fold> 
    public String getNome () {
        return nome;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D3D0BD00-3EBB-38BB-FD19-C4175236E91B]
    // </editor-fold> 
    public void setNome (String val) {
        this.nome = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5515DE64-EC2C-73F7-4B71-094FB2590DC1]
    // </editor-fold> 
    public String getSite () {
        return site;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5B53E925-BFEF-3EAF-222A-37DB2EF7EB1B]
    // </editor-fold> 
    public void setSite (String val) {
        this.site = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4027F0DD-F744-D2B3-3CCC-DC5D5985BBA6]
    // </editor-fold> 
    public String getUf () {
        return uf;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DD44C593-73D8-1C55-577A-20D714CF32AA]
    // </editor-fold> 
    public void setUf (String val) {
        this.uf = val;
    }

}


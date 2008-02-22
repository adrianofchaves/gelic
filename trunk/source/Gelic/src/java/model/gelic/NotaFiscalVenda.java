package model.gelic;

import java.sql.Date;


/**
 *  <p style="margin-top: 0">
 *        Um objeto desta classe representa uma Nota fiscal emitida pela empresa 
 *        contratada contra o &#243;rg&#227;o.
 *      </p>
 *      <p style="margin-top: 0">
 *        
 *  <br>Esse objeto, entretanto, &#233; instanciado no momento em que temos uma entrega 
 *        registrada junto a &#243;rg&#227;o licitante.  Os dados da Nota Fiscal s&#227;o 
 *        finalmente atribu&#237;dos ap&#243;s sua emiss&#227;o.<br>
 *  <br><b>Casos de uso</b>:Registrar Entrega e Incluir Nota Fiscal de Venda.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4FC95F7F-680F-002E-D9AB-1749EF3BC4DF]
// </editor-fold> 
public class NotaFiscalVenda {

    /**
     *  <p style="margin-top: 0">
     *    N&#250;mero da nota fiscal.
     *  <br>
     *  <br>Estava previsto inteiro, mas preferi mater como String.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2334510D-42B0-66DE-2D04-238B4CED64AF]
    // </editor-fold> 
    private String numero;

    /**
     *  <p style="margin-top: 0">
     *    Data da emiss&#227;o da nota fiscal.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C58A7E1-60E6-C0F5-B346-915FFA3CA20B]
    // </editor-fold> 
    private Date emissao;

    /**
     *  <p style="margin-top: 0">
     *    N&#250;mero do cupom fiscal correspondente a nota fiscal.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5ACB0083-A47E-6188-F5BC-67FC6FFE61EB]
    // </editor-fold> 
    private String numeroCupomFiscal;

    /**
     *  <p style="margin-top: 0">
     *    Dia que o &#243;rg&#227;o recebeu a mercadoria.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A3C25A6-45B6-7A6E-5608-15102B7415DA]
    // </editor-fold> 
    private Date dataRecebimento;

    /**
     *  <p style="margin-top: 0">
     *    Nome da pessoa que recebeu a mercadoria.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.62131A5D-F404-4694-3F34-BB0533CAAB5D]
    // </editor-fold> 
    private String nomeReceptor;

    /**
     *  <p style="margin-top: 0">
     *    Cargo da pessoa que recebeu a mercadoria.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9C6A367E-E40F-4F4B-600D-818737613DB0]
    // </editor-fold> 
    private String cargoReceptor;

    /**
     *  <p style="margin-top: 0">
     *    Matr&#237;cula da pessoa que recebeu a mercadoria.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D65FB2EF-2ACF-5467-9817-F71362535685]
    // </editor-fold> 
    private String matriculaReceptor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.92DB920A-7A7E-D188-5894-BC2B3CDE4818]
    // </editor-fold> 
    public NotaFiscalVenda () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2719E3EA-C956-B20D-CA74-D417E5170B9B]
    // </editor-fold> 
    public String getCargoReceptor () {
        return cargoReceptor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C7312D48-BFD5-C5A5-0FC8-88E72DC4179D]
    // </editor-fold> 
    public void setCargoReceptor (String val) {
        this.cargoReceptor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.285F2100-45AD-F836-6041-35FE207353D0]
    // </editor-fold> 
    public Date getDataRecebimento () {
        return dataRecebimento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7F9083AC-B5E5-44B1-5C48-D71D1938D206]
    // </editor-fold> 
    public void setDataRecebimento (Date val) {
        this.dataRecebimento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5D3FCADC-C82E-1935-F04B-6174E697242C]
    // </editor-fold> 
    public Date getEmissao () {
        return emissao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.737CADC9-B82D-41BD-2292-A2C52F251A20]
    // </editor-fold> 
    public void setEmissao (Date val) {
        this.emissao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.905693FE-2B9E-0010-B176-B70276A59F24]
    // </editor-fold> 
    public String getMatriculaReceptor () {
        return matriculaReceptor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AC36C688-F18F-1FEE-BBB6-E63908D605DD]
    // </editor-fold> 
    public void setMatriculaReceptor (String val) {
        this.matriculaReceptor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.10BC27A2-C0B7-956F-FAD7-A92FE6C93B9E]
    // </editor-fold> 
    public String getNomeReceptor () {
        return nomeReceptor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9A48D317-E932-06D7-8384-EBA45DA6036E]
    // </editor-fold> 
    public void setNomeReceptor (String val) {
        this.nomeReceptor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8FC1A02E-EC4D-04A4-491F-16A1E955058F]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96A00890-A5CE-651E-6ABF-7E3FB03D6D5B]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F158E206-968E-55E7-3570-E042105729C2]
    // </editor-fold> 
    public String getNumeroCupomFiscal () {
        return numeroCupomFiscal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6A5ABE78-CE48-2ECE-62D0-345E5E9E614C]
    // </editor-fold> 
    public void setNumeroCupomFiscal (String val) {
        this.numeroCupomFiscal = val;
    }

}


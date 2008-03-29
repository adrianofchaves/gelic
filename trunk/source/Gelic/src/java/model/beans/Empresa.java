package model.beans;

import java.util.ArrayList;


/**
 *  <p style="margin-top: 0">
 *        Empresa que participa da licita&#231;&#227;o. Uma empresa pode ser Fornecedor (n&#227;o 
 *        participa da licita&#231;&#227;o, mas fornece o material). Pode ainda assumir o 
 *        papel de Portador, que recebe o valor da duplicata.<br><br>
 *      </p>
 *      <p style="margin-top: 0">
 *        <b>Caso de uso</b>: Incluir Empresa<br><br><b>Pend&#234;ncias: </b><br>Est&#225; 
 *        previsto por enquanto que o ator Comercial ser&#225; respons&#225;vel por 
 *        cadastrar empresas.  Ele dever&#225; assinalar os flags indicando se a 
 *        empresa pode ser fornecedor ou portador.   Isso significa que se for 
 *        necess&#225;rio cadastrar uma empresa para ser portadora de uma duplicata o 
 *        comercial dever&#225; faz&#234;-lo.  Isso est&#225; correto?  Se n&#227;o estiver podemos 
 *        relacionar outros atores (financeiro, analista) aos casos de uso de 
 *        empresas.
 *  <br>    </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E413090E-BDA9-411D-2941-6596971A8777]
// </editor-fold> 
public class Empresa {
    
    
    /**
     *  <p style="margin-top: 0">
     *        Endere&#231;o da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.94246EF8-1F49-5B69-676A-01ECE28292CA]
    // </editor-fold> 
    private TipoEndereco endereco;

    /**
     *  <p style="margin-top: 0">
     *        Raz&#227;o social da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.793B6D71-468C-4D2D-32D1-A60E4870DA42]
    // </editor-fold> 
    private String razaoSocial;

    /**
     *  <p style="margin-top: 0">
     *        Nome de fantasia da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B0DC042D-3C52-8F24-1179-5402E8664A02]
    // </editor-fold> 
    private String nomeFantasia;

       
    

    /**
     *  <p style="margin-top: 0">
     *        Pessoa de contato na empresa.<br><br>Esse campo &#233; para quando a empresa 
     *        &#233; fornecedor?
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A7D0A89B-961B-6912-51EF-CC55BB8BA62D]
    // </editor-fold> 
    private ArrayList<Contato> contatos;

    /**
     *  <p style="margin-top: 0">
     *        Flag. Se assinalado, indica que a empresa pode ser portadora de 
     *        duplicatas.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.95CA43FA-4509-7F7A-382E-90E144294D7D]
    // </editor-fold> 
    private boolean ePortador;

    /**
     *  <p style="margin-top: 0">
     *        Flag. Quando assinalado indica que a empresa pode assumir o papel de 
     *        fornecedor.
     *  <br>
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D64CBB91-E548-0835-583E-E0F65D4C5F4B]
    // </editor-fold> 
    private boolean eFornecedor;

    /**
     *  <p style="margin-top: 0">
     *        CNPJ da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A38DB897-C222-EFAD-3D91-1F948B3B6702]
    // </editor-fold> 
    private String cnpj;

    /**
     *  <p style="margin-top: 0">
     *        Inscri&#231;&#227;o estadual da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.66D7A9DB-685A-111A-004A-5FC2599BAE87]
    // </editor-fold> 
    private String ie;

    /**
     *  <p style="margin-top: 0">
     *        Inscri&#231;&#227;o municipal da empresa.
     *  <br>
     *  <br>
     *      </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Incluir Empresa
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1E889F4D-2A28-B4BF-E3BD-47228183147B]
    // </editor-fold> 
    private String im;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EA98B415-FB11-97C9-F267-952559F81268]
    // </editor-fold> 
    public Empresa () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3B307097-E9E8-811E-40C8-8C66535CBF5F]
    // </editor-fold> 
    public String getCnpj () {
        return cnpj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.44024801-2088-1300-2EB4-E3278F4808E7]
    // </editor-fold> 
    public void setCnpj (String val) {
        this.cnpj = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.91BFEDCA-E6EE-8B4C-3FEF-8D244D89FCA0]
    // </editor-fold> 
    public ArrayList<Contato> getContatos () {
        return contatos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C801A376-F679-5466-D254-E091AEEC96A1]
    // </editor-fold> 
    public void setContatos (ArrayList<Contato> val) {
        this.contatos = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8FCCE0CB-6F09-B348-C62C-154B25D3E474]
    // </editor-fold> 
    public boolean getEFornecedor () {
        return eFornecedor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C17AA1CA-1CFD-79F1-242E-C91A6FFC7C58]
    // </editor-fold> 
    public void setEFornecedor (boolean val) {
        this.eFornecedor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CDF36CE4-6364-4DDB-DA6E-3B7915AF82CE]
    // </editor-fold> 
    public boolean getEPortador () {
        return ePortador;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3F03B01B-6FE6-7119-8424-AC9021FE8142]
    // </editor-fold> 
    public void setEPortador (boolean val) {
        this.ePortador = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.60B7F65D-7007-F9B2-B243-03FD3CE64E39]
    // </editor-fold> 
    public TipoEndereco getEndereco () {
        return endereco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A48AF8C1-96FD-563E-9C4D-BF55F2236251]
    // </editor-fold> 
    public void setEndereco (TipoEndereco val) {
        this.endereco = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4EA49CA2-BA92-5894-5730-6382178018AF]
    // </editor-fold> 
    public String getIe () {
        return ie;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A370F7B9-0D83-3EAC-B9E1-F23CC6C03352]
    // </editor-fold> 
    public void setIe (String val) {
        this.ie = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.069F346D-B20B-F586-9DDD-ACAEFA8A4836]
    // </editor-fold> 
    public String getIm () {
        return im;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.54C4EAA2-47FB-BF67-3438-19FE1F420AAC]
    // </editor-fold> 
    public void setIm (String val) {
        this.im = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B7DEA630-8D74-C757-EF41-AB3E21810187]
    // </editor-fold> 
    public String getNomeFantasia () {
        return nomeFantasia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F55D76AE-C264-4711-87AC-C117BC59C33D]
    // </editor-fold> 
    public void setNomeFantasia (String val) {
        this.nomeFantasia = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.055F5567-B863-099D-D943-6C1624447550]
    // </editor-fold> 
    public String getRazaoSocial () {
        return razaoSocial;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.79F24F3F-5D80-F2FB-1F64-ABD5B4D37643]
    // </editor-fold> 
    public void setRazaoSocial (String val) {
        this.razaoSocial = val;
    }
    
}


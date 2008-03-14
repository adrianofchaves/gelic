package model.beans;

import java.sql.Date;
import java.util.ArrayList;

/**
 *  <p style="margin-top: 0">
 *        Representa uma licita&#231;&#227;o que uma empresa participa.
 *  <br>
 *  <br><b>Caso de uso</b>: Incluir Licita&#231;&#227;o
 *      </p>
 *      <p style="margin-top: 0">
 *        <br>
 *        <br>
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.CFF743B0-A47F-16ED-2373-CC945800542A]
// </editor-fold> 
public class Licitacao {
    private model.beans.Modalidade modalidade;
    /**
     *  <p style="margin-top: 0">
     *    N&#250;mero da licita&#231;&#227;o
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.250907EE-7939-9FC7-AF91-13C2923869E0]
    // </editor-fold> 
    private String numero;

    /**
     *  <p style="margin-top: 0">
     *    N&#250;mero do processo licit&#243;rio
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8E5FF86C-99D9-B353-8FFE-FF01B5FF1FE9]
    // </editor-fold> 
    private String numeroProcesso;

    /**
     *  <p style="margin-top: 0">
     *    Material que o &#243;rg&#227;o deseja comprar atrav&#233;s da licita&#231;&#227;o.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.35F8F7BB-88DE-0AEE-7D2C-B7C776370D75]
    // </editor-fold> 
    private String objeto;

    /**
     *  <p style="margin-top: 0">
     *        Prazo para entrega do material.
     *  <br>
     *  <br>Este prazo &#233; em rela&#231;&#227;o a que?  Como funciona?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D2B3B27-ECBE-5FC3-7664-EAB6FB0AE60B]
    // </editor-fold> 
    private int diasPrazoEntrega;

    /**
     *  <p style="margin-top: 0">
     *    Tempo de garantia do material licitado
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0E34C0A9-94A7-3D94-9C2D-C36B6F66F36E]
    // </editor-fold> 
    private int anosPrazoGarantia;

    /**
     *  <p style="margin-top: 0">
     *        Flag.  Se assinalado, indica se a licita&#231;&#227;o pede a apresenta&#231;&#227;o de 
     *        amostra
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C6542DE2-7BA1-B580-31ED-25D9A5F5A3B3]
    // </editor-fold> 
    private boolean pedeAmostra;

    /**
     *  <p style="margin-top: 0">
     *        Dia em que a amostra dever&#225; ser apresentada. Somente preenchido se o 
     *        &quot;pedeAmostra&quot; estiver assinalado.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F1CE1A65-7E3D-2A85-4EF6-6CF5F21EC041]
    // </editor-fold> 
    private Date apresentacaoAmostra;

    /**
     *  <p style="margin-top: 0">
     *    Valor prestado como garantia de proposta.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6240D543-54B7-F950-4BE0-FF5B37A1F75F]
    // </editor-fold> 
    private float valorGarantia;

    /**
     *  <p style="margin-top: 0">
     *        Prazo de vig&#234;ncia do contrato
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1A18BED2-ADEB-AB53-A68F-70F4799B9BDF]
    // </editor-fold> 
    private int diasVigencia;

    /**
     *  <p style="margin-top: 0">
     *    Prazo para pagamento da fatura pelo orgao.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.53792840-1148-443D-391A-3A6C44B2D57A]
    // </editor-fold> 
    private int diasPrazoPagamento;

    /**
     *  <p style="margin-top: 0">
     *    Nome do principal responsavel pela licitacao
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.751D3E01-1BEC-CAEF-8A30-248146A4D750]
    // </editor-fold> 
    private String contato;

    /**
     *  <p style="margin-top: 0">
     *        Flag.  Se assinalado, indica se a licitacao preve multa por atraso na 
     *        entrega
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6B597D12-6F56-C938-2977-3E9ABBFC0966]
    // </editor-fold> 
    private boolean preveMulta;

    /**
     *  <p style="margin-top: 0">
     *        Descreve os termos da multa por atraso na entrega.
     *  <br>
     *  <br>
     *  <br>Isso n&#227;o parece bem normalizado.  Ter&#237;amos que atomizar mais.
     *  <br>    </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B01187BA-8524-C496-49A6-327199810EE7]
    // </editor-fold> 
    private String termosMulta;

    /**
     *  <p style="margin-top: 0">
     *        Prazo de validade da proposta contado em dias.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.35DB1926-CCA5-FC3F-2DED-10D291EA902B]
    // </editor-fold> 
    private int diasValidadeProposta;

    /**
     *  <p style="margin-top: 0">
     *    Data de entrega da documenta&#231;&#227;o.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AABCA106-910A-DA2C-4E81-D3ED9B594080]
    // </editor-fold> 
    private Date recebimentoDocumentacao;

    /**
     *  <p style="margin-top: 0">
     *        Data de entrega da proposta.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7632B087-083F-650D-6871-3872CC1787BF]
    // </editor-fold> 
    private Date recebimentoProposta;

    /**
     *  <p style="margin-top: 0">
     *    Data em que ser&#225; realizado o preg&#227;o eletr&#244;nico da licita&#231;&#227;o.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C952872F-D82C-C6D6-C168-FA9A20F65B13]
    // </editor-fold> 
    private Date realizacaoPregao;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.27EFD415-D535-4DD9-BA6D-C6E02EEE4B8D]
    // </editor-fold> 
    private int diasApresentacaoAmostra;

    /**
     *  <p style="margin-top: 0">
     *    Cont&#233;m o estado da licita&#231;&#227;o.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.88021694-EBA7-F018-6CA2-52AFAFB219BA]
    // </editor-fold> 
    private int status;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.39BD8E4B-C0A5-88D4-EF08-AD33CAA4C953]
    // </editor-fold> 
    private ArrayList<Lote> mLote;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0EF86301-735D-77A2-C284-DD55C167E463]
    // </editor-fold> 
    public Licitacao () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4B5C3DF9-5E93-149F-7AFF-E8DD75FE69F8]
    // </editor-fold> 
    public int getAnosPrazoGarantia () {
        return anosPrazoGarantia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D9ABB7D4-0C4E-F7FB-CC7B-B13BB9AA777E]
    // </editor-fold> 
    public void setAnosPrazoGarantia (int val) {
        this.anosPrazoGarantia = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F2B7FC44-0A7C-6693-5371-0CE855AA0F16]
    // </editor-fold> 
    public Date getApresentacaoAmostra () {
        return apresentacaoAmostra;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7466ABD7-A506-0918-A573-FD7A7E4BD306]
    // </editor-fold> 
    public void setApresentacaoAmostra (Date val) {
        this.apresentacaoAmostra = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.13E8DD0B-F123-9266-4654-D511FA59D30A]
    // </editor-fold> 
    public String getContato () {
        return contato;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BEAB3E23-304D-E9C4-6C09-27B2D6705201]
    // </editor-fold> 
    public void setContato (String val) {
        this.contato = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C7F44A0F-AFD2-0E31-A6DC-4CADBB77E948]
    // </editor-fold> 
    public int getDiasApresentacaoAmostra () {
        return diasApresentacaoAmostra;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B7EB5D97-D627-BDDB-6B26-96E704C4702B]
    // </editor-fold> 
    public void setDiasApresentacaoAmostra (int val) {
        this.diasApresentacaoAmostra = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.72DEB201-3F9C-04B9-6FCE-516BA5DB1114]
    // </editor-fold> 
    public int getDiasPrazoEntrega () {
        return diasPrazoEntrega;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E369E50C-C986-7D56-9286-AF126EFCC98F]
    // </editor-fold> 
    public void setDiasPrazoEntrega (int val) {
        this.diasPrazoEntrega = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BDA0AA5-9753-6353-AE73-1C7A42AA3742]
    // </editor-fold> 
    public int getDiasPrazoPagamento () {
        return diasPrazoPagamento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.24128C71-BC81-063E-99CF-71055296F26C]
    // </editor-fold> 
    public void setDiasPrazoPagamento (int val) {
        this.diasPrazoPagamento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.77ED2AA4-E41A-D961-80F8-9D11DC86F512]
    // </editor-fold> 
    public int getDiasValidadeProposta () {
        return diasValidadeProposta;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.931E9FEE-B60A-D184-D949-87C35D6C03B1]
    // </editor-fold> 
    public void setDiasValidadeProposta (int val) {
        this.diasValidadeProposta = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DAB442DA-7AC5-7CEF-626D-7AE7DED318D0]
    // </editor-fold> 
    public int getDiasVigencia () {
        return diasVigencia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.251C3962-4B0A-23F6-B1A9-3901C199E3AC]
    // </editor-fold> 
    public void setDiasVigencia (int val) {
        this.diasVigencia = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A753F2D1-3DB9-373E-2F2D-959C5693397C]
    // </editor-fold> 
    public ArrayList<Lote> getLote () {
        return mLote;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4FF95DC4-BA8B-BF83-9BFC-E2C0FC90A613]
    // </editor-fold> 
    public void setLote (ArrayList<Lote> val) {
        this.mLote = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.29EA5201-D9AB-E332-942B-A97333370207]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D674A33D-0C66-4F99-632A-AF0B311F6956]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F5EB6A86-2E3E-9315-3E50-C83E972A59C2]
    // </editor-fold> 
    public String getNumeroProcesso () {
        return numeroProcesso;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BEB0B099-1A75-0B6F-F1FB-C989ADFCDF5F]
    // </editor-fold> 
    public void setNumeroProcesso (String val) {
        this.numeroProcesso = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5753A23A-EB3A-030D-925D-BE037E465970]
    // </editor-fold> 
    public String getObjeto () {
        return objeto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0C17AA6E-BFB3-920B-3CDB-777FF06D34E0]
    // </editor-fold> 
    public void setObjeto (String val) {
        this.objeto = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.66F3F2FF-367C-4AEA-DF41-25B0E9545AAF]
    // </editor-fold> 
    public boolean getPedeAmostra () {
        return pedeAmostra;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2AD4AD53-B1AB-F7D2-7C49-E13AB36A6289]
    // </editor-fold> 
    public void setPedeAmostra (boolean val) {
        this.pedeAmostra = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8D265532-9367-6332-6DCA-ADABCF927D0A]
    // </editor-fold> 
    public boolean getPreveMulta () {
        return preveMulta;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.05CBE753-3C9F-06B1-634F-EA841F7D3A1B]
    // </editor-fold> 
    public void setPreveMulta (boolean val) {
        this.preveMulta = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C9E75F31-FAE9-00C7-14AE-DB4370B84088]
    // </editor-fold> 
    public Date getRealizacaoPregao () {
        return realizacaoPregao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1CB7F11D-96C5-1E15-5344-B7CBD4FF829A]
    // </editor-fold> 
    public void setRealizacaoPregao (Date val) {
        this.realizacaoPregao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.95D429CE-76B2-8678-F8AC-A804C9139AE9]
    // </editor-fold> 
    public Date getRecebimentoDocumentacao () {
        return recebimentoDocumentacao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.224CEDD3-187A-0692-D1A2-8BB5A32A2863]
    // </editor-fold> 
    public void setRecebimentoDocumentacao (Date val) {
        this.recebimentoDocumentacao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9E5E52B6-CD79-ABBC-E623-119DC713C293]
    // </editor-fold> 
    public Date getRecebimentoProposta () {
        return recebimentoProposta;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.03771C96-E1AD-59C9-0C9E-A81EEA38F34E]
    // </editor-fold> 
    public void setRecebimentoProposta (Date val) {
        this.recebimentoProposta = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8BE9856A-FB31-88D7-FF5A-115D9E8D7C7B]
    // </editor-fold> 
    public int getStatus () {
        return status;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1E7C5F62-EB21-DB82-FBBD-DDE246DAAF21]
    // </editor-fold> 
    public void setStatus (int val) {
        this.status = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C5CF43E6-8C35-1639-5069-C7A447AB6A6F]
    // </editor-fold> 
    public String getTermosMulta () {
        return termosMulta;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DE08E256-955D-520D-0EA4-B6C582454862]
    // </editor-fold> 
    public void setTermosMulta (String val) {
        this.termosMulta = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C133E98A-7D38-3DA6-B6C7-C24FE0ACF5D9]
    // </editor-fold> 
    public float getValorGarantia () {
        return valorGarantia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.18ECD1FC-2510-07E4-27A3-B283D88B7BBE]
    // </editor-fold> 
    public void setValorGarantia (float val) {
        this.valorGarantia = val;
    }

    public model.beans.Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(model.beans.Modalidade modalidade) {
        this.modalidade = modalidade;
    }

}


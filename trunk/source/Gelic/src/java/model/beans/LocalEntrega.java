package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Local para entrega dos pedidos de venda..<br><br>
 *      </p>
 *      <p style="margin-top: 0">
 *        Um local de entrega n&#227;o deveria ter inscri&#231;&#227;o estadual?
 *  <br>
 *  <br><b>Caso de uso</b>: Incluir Local Entrega
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.48BE5015-3ADD-5382-1F37-6CE25D7C07AB]
// </editor-fold> 
public class LocalEntrega {

    /**
     *  <p style="margin-top: 0">
     *    Endere&#231;o do local de entrega.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AFEDBFB8-CF45-9500-2AF5-780A0177AFDB]
    // </editor-fold> 
    private TipoEndereco endereco;

    /**
     *  <p style="margin-top: 0">
     *    Raz&#227;o social do local de entrega.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61D63674-421E-12C9-107B-3576BF3EC03D]
    // </editor-fold> 
    private String razaoSocial;

    /**
     *  <p style="margin-top: 0">
     *    CNPJ do local de entrega.
     *  <br>
     *  <br>No dicion&#225;rio de dados original estava CNPJ da empresa.  Isso estaria 
     *    certo?
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D6FF7DB-901C-E5A0-419F-FB0A20690122]
    // </editor-fold> 
    private String cnpj;

    /**
     *  <p style="margin-top: 0">
     *    Pessoa para contato no local de entrega.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F75D04CA-A04A-64A9-CFD7-937EEC27DC73]
    // </editor-fold> 
    private String contato;

    /**
     *  <p style="margin-top: 0">
     *    Telefone do local de entrega.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8A7BDD3D-CA44-A4C4-5FDF-FDC62A064036]
    // </editor-fold> 
    private TipoTelefone telefone;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.239E1865-48DC-A95C-2B1F-C11386FCAA3E]
    // </editor-fold> 
    public LocalEntrega () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7D3A78FA-A24A-253B-A252-C89102E2F254]
    // </editor-fold> 
    public String getCnpj () {
        return cnpj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A959A2F2-E128-980C-1030-683063E59A63]
    // </editor-fold> 
    public void setCnpj (String val) {
        this.cnpj = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F988CB6D-198F-4C04-30A9-484DB06C6E5E]
    // </editor-fold> 
    public String getContato () {
        return contato;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E1C35006-45F0-CC3D-7819-1B3F1A861349]
    // </editor-fold> 
    public void setContato (String val) {
        this.contato = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.14496E40-C71D-0CEC-07C3-193A22ECAEC9]
    // </editor-fold> 
    public TipoEndereco getEndereco () {
        return endereco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3448D34D-9E3A-9D4F-DB88-C00CB12F49D0]
    // </editor-fold> 
    public void setEndereco (TipoEndereco val) {
        this.endereco = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.75F85088-3A63-FB44-DFCF-FD46898B2EA6]
    // </editor-fold> 
    public String getRazaoSocial () {
        return razaoSocial;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6C0544B-36CD-9412-7ACD-BC290DD306AD]
    // </editor-fold> 
    public void setRazaoSocial (String val) {
        this.razaoSocial = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5AF288FE-83A1-0724-0BB2-3AC00184CBE7]
    // </editor-fold> 
    public TipoTelefone getTelefone () {
        return telefone;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6A8A3AD0-857A-D257-956B-1DE05A069796]
    // </editor-fold> 
    public void setTelefone (TipoTelefone val) {
        this.telefone = val;
    }

}


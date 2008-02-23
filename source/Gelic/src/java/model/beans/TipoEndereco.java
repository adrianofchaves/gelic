package model.beans;


/**
 *  <p style="margin-top: 0">
 *    Esse e um tiopo de dados que representa um endere&#231;o.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.F71DACFC-65BB-3380-B03C-371904681013]
// </editor-fold> 
public class TipoEndereco {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CCF11DD5-B9AE-88FD-A404-B02B26F60C85]
    // </editor-fold> 
    private String logradouro;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C63779B5-3242-DC4A-5DE9-A02D14EACF73]
    // </editor-fold> 
    private String complemento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F172896F-8C19-FB40-870F-E1E8B70328ED]
    // </editor-fold> 
    private String cep;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A1A48AF-9908-C395-EE37-63D11F741236]
    // </editor-fold> 
    private String numero;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3C7E7458-F8EB-5C99-BADD-4FF7F83CE24E]
    // </editor-fold> 
    private String uf;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D4F60163-CE2B-C27D-3D32-19222EDC1EB0]
    // </editor-fold> 
    private String cidade;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3D50B145-9C16-2782-6B1A-3DE22C9A7C23]
    // </editor-fold> 
    private String email;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.08BBFA24-409D-5801-E7BC-95FA77BB0F44]
    // </editor-fold> 
    private String site;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0894C1A1-7F3B-8391-C3D9-6942BA0514A8]
    // </editor-fold> 
    public TipoEndereco () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B3FEC123-F3A5-118F-DFA6-74984A0808DF]
    // </editor-fold> 
    public String getCep () {
        return cep;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4517D28D-9961-0952-1163-9303F4151F0C]
    // </editor-fold> 
    public void setCep (String val) {
        this.cep = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.797C48DA-0C07-D6F1-C4DC-CB83FB7567DC]
    // </editor-fold> 
    public String getCidade () {
        return cidade;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A197E945-CA70-2AB1-46BE-A9F152DD8AC3]
    // </editor-fold> 
    public void setCidade (String val) {
        this.cidade = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.658F7C61-A676-01D2-3A78-30E2561883E9]
    // </editor-fold> 
    public String getComplemento () {
        return complemento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EEDEAAED-4ECD-22D3-EDE8-42C8A06FC3A5]
    // </editor-fold> 
    public void setComplemento (String val) {
        this.complemento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A5504A76-6755-0ABE-1846-DCEC0D266D4E]
    // </editor-fold> 
    public String getEmail () {
        return email;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0C5EEB1E-2CE2-4735-4AFD-5166CCA675AD]
    // </editor-fold> 
    public void setEmail (String val) {
        this.email = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.30FCB098-2D01-0E7D-F15E-CF094515F086]
    // </editor-fold> 
    public String getLogradouro () {
        return logradouro;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.152FF407-2D37-E92D-8D0A-6B3D37F5B295]
    // </editor-fold> 
    public void setLogradouro (String val) {
        this.logradouro = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A34CA362-FF2D-7E4E-5B74-E2F1BC90C3A1]
    // </editor-fold> 
    public String getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A17BD7A1-5311-60C0-C9F6-DF472FCE7CC0]
    // </editor-fold> 
    public void setNumero (String val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F25EE300-87EC-6C28-E067-2F34FC57A820]
    // </editor-fold> 
    public String getSite () {
        return site;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0F95BB13-27F3-9B32-C35F-A8B85C2BBE87]
    // </editor-fold> 
    public void setSite (String val) {
        this.site = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8883C8E6-89B9-D09D-78BD-436F08C2B676]
    // </editor-fold> 
    public String getUf () {
        return uf;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A00195FD-8A63-2672-ADE8-780B6C84E68E]
    // </editor-fold> 
    public void setUf (String val) {
        this.uf = val;
    }

}


package model.beans;

import java.util.ArrayList;


/**
 *  <p style="margin-top: 0">
 *    Org&#227;o p&#250;blico que realiza licita&#231;&#245;es.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BCBEDA24-3258-895B-6ABA-2FB01F80EE75]
// </editor-fold> 
public class Orgao {
    private ArrayList<model.beans.Contato> contatos;

    /**
     *  <p style="margin-top: 0">
     *    Raz&#227;o social do &#243;rg&#227;o.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4BA2AE62-6964-4C47-FAD6-700BA3A2BA0F]
    // </editor-fold> 
    private String razaoSocial;

    /**
     *  <p style="margin-top: 0">
     *    Apelido do &#243;rg&#227;o p&#250;blico.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.37CE0882-CED7-C835-25FA-467FE516CDA0]
    // </editor-fold> 
    private String apelido;

    /**
     *  <p style="margin-top: 0">
     *    CNPJ do &#243;rg&#227;o p&#250;blico.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E4389CB-411B-A511-6619-B8F27A106BEF]
    // </editor-fold> 
    private String cnpj;

    /**
     *  <p style="margin-top: 0">
     *    Inscri&#231;&#227;o estadual do &#243;rg&#227;o p&#250;blico.
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C5903E0-6846-004E-ED68-A3E75A62B65F]
    // </editor-fold> 
    private String ie;

    private int idEndereco;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D165704F-BEFB-A53B-95B1-310F9237A24A]
    // </editor-fold> 
    private TipoEndereco endereco;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63752C57-73A7-9511-515F-7E6216C048D8]
    // </editor-fold> 
    public Orgao () {
    }

  public Orgao(String razaoSocial, String apelido, String cnpj, String ie, 
          int idEndereco) {
    this.razaoSocial = razaoSocial;
    this.apelido = apelido;
    this.cnpj = cnpj;
    this.ie = ie;
    this.idEndereco = idEndereco;
  }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1FB80F18-F010-5331-5B0E-F4F6837BD967]
    // </editor-fold> 
    public String getApelido () {
        return apelido;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3E51C133-0197-B15D-6195-4901A8BF1BFB]
    // </editor-fold> 
    public void setApelido (String val) {
        this.apelido = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B810A6BB-335D-F6ED-E51A-84A74EBF711F]
    // </editor-fold> 
    public String getCnpj () {
        return cnpj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.042D2805-BDAA-EFD4-B792-6FD2031FF621]
    // </editor-fold> 
    public void setCnpj (String val) {
        this.cnpj = val;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8AF38383-69DE-BA67-B736-9EB867600326]
    // </editor-fold> 
    public TipoEndereco getEndereco () {
        return endereco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.517612F4-3AA2-F892-787E-1B929C49952B]
    // </editor-fold> 
    public void setEndereco (TipoEndereco val) {
        this.endereco = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EE4CC22F-FD33-B87B-4FE9-22C34CC016AF]
    // </editor-fold> 
    public String getIe () {
        return ie;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1715FB8F-D67D-8520-870A-E9872B53B25F]
    // </editor-fold> 
    public void setIe (String val) {
        this.ie = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.91607366-819F-3E81-7DBA-6E1970358F5C]
    // </editor-fold> 
    public String getRazaoSocial () {
        return razaoSocial;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6660635-55EE-2D2B-3418-398D696421F0]
    // </editor-fold> 
    public void setRazaoSocial (String val) {
        this.razaoSocial = val;
    }

  public ArrayList<model.beans.Contato> getContatos() {
    return contatos;
  }

  public void setContatos(ArrayList<model.beans.Contato> contatos) {
    this.contatos = contatos;
  }

  public

  int getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }

}


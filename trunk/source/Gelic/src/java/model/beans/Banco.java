package model.beans;


/**
 *  <p style="margin-top: 0">
 *        Institui&#231;&#227;o banc&#225;ria respons&#225;vel pela cobran&#231;a da duplicata
 *  <br>
 *  <br>
 *  <br><b>Caso de Uso</b>: Manter Bancos
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B631426F-3701-C623-ED99-572A8481D5B6]
// </editor-fold> 
public class Banco {

    /**
     *  <p style="margin-top: 0">
     *        Nome do banco.<b>
     *  </b>    </p>
     *      <p style="margin-top: 0">
     *        <b>
     *  </b><br>    </p>
     *      <p style="margin-top: 0">
     *        <b>Caso de uso</b>: Manter Bancos
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.83DC0302-A4FD-A1C3-DEA3-F70E20367417]
    // </editor-fold> 
    private String nome;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C5C4DEDA-EC31-D4D7-192F-4E92292FF8DD]
    // </editor-fold> 
    public Banco () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A4114142-7746-3F4C-65F9-0BE06454A443]
    // </editor-fold> 
    public String getNome () {
        return nome;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.76FF5CC4-9BF9-786A-B929-94E6DE17DA14]
    // </editor-fold> 
    public void setNome (String val) {
        this.nome = val;
    }

}


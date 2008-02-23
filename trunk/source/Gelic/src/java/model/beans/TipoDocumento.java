package model.beans;


/**
 *  <p style="margin-top: 0">
 *    Representa a esp&#233;cie do documento.  
 *  <br>
 *  <br><b>Caso de uso: </b> Manter Tipos Documento
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E30DA965-77DC-66AB-CA71-5EE32462FA5F]
// </editor-fold> 
public class TipoDocumento {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CD8DFC0B-A293-0F42-DF06-873E3E10F81A]
    // </editor-fold> 
    private String nome;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.528AE73E-2A70-D57E-33C1-8026AA7C4E74]
    // </editor-fold> 
    public TipoDocumento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E5E6F9F0-60BE-77B4-3C64-08D1DADFC4B0]
    // </editor-fold> 
    public String getNome () {
        return nome;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.54D0E8FA-37D4-EF96-500C-6AA2E44BF4EF]
    // </editor-fold> 
    public void setNome (String val) {
        this.nome = val;
    }

}


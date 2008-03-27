package model.beans;


/**
 *  <p style="margin-top: 0">
 *    Representa um produto vendido pela empresa.
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0EECE5E9-CA3D-016C-9706-65F107D71271]
// </editor-fold> 
public class Produto {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6EAFF3B4-1FD7-305E-3E21-440DE008DB53]
    // </editor-fold> 
    private String codigo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.021D513B-040A-7F17-531C-872853C1936D]
    // </editor-fold> 
    private String descricao;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D91128E7-ACC8-A0FC-E9D5-82DB4565C81C]
    // </editor-fold> 
    private float precoVenda;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9E8D0B50-27FF-3CC8-B952-AEF39884AB4E]
    // </editor-fold> 
    private float precoCompra;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4E520002-9FEE-FB69-3B03-965A41686FA0]
    // </editor-fold> 
    public Produto () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D2242089-637F-3BF7-EAE2-7AC16820ACA4]
    // </editor-fold> 
    public String getCodigo () {
        return codigo;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BC1005FC-E917-C8C6-8C41-607D838C7E89]
    // </editor-fold> 
    public void setCodigo (String val) {
        this.codigo = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.06F8FB5E-1A30-FF3A-4BCB-2F030BC5CFD2]
    // </editor-fold> 
    public String getDescricao () {
        return descricao;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5CBAC322-6BA9-7727-364B-9D9090B402CD]
    // </editor-fold> 
    public void setDescricao (String val) {
        this.descricao = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F01B1D64-9122-4604-3288-0C6AB740D605]
    // </editor-fold> 
    public float getPrecoCompra () {
        return precoCompra;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.116CFE7F-532A-9734-45F6-38FAF9D9CE55]
    // </editor-fold> 
    public void setPrecoCompra (float val) {
        this.precoCompra = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8417CC0A-D6CE-3BCD-84CA-1169D47F1B34]
    // </editor-fold> 
    public float getPrecoVenda () {
        return precoVenda;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF06D7F6-754A-8B5C-923D-D4D06FE8ED25]
    // </editor-fold> 
    public void setPrecoVenda (float val) {
        this.precoVenda = val;
    }

}


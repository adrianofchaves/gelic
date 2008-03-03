package model.beans;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E27F3EE7-B7EE-658E-399B-839565633C35]
// </editor-fold> 
public class Usuario {
    private int tipo;
    private String login;
    private String senha;
    private Papel papel;

    public static final int ADMINISTRADOR = 1;
    public static final int COMERCIAL = 2;
    public static final int FINANCEIRO = 3;
    public static final int ANALISTA = 4;
    public static final int GERENTECOMERCIAL = 5;    
            

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2ACAAAD3-42E4-4715-92B5-E833484A0163]
    // </editor-fold> 
    public Usuario () {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

}


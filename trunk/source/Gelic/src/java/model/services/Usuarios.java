package model.services;
// #[regen=yes,id=DCE.4C280404-F5D8-E997-9B56-B559AAEA5A24]
// </editor-fold> 
public class Usuarios {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4DD9DF74-6AB7-439C-D378-2D7EB77AEE4E]
    // </editor-fold> 
    public Usuarios() {
    }

    /**
     * Método do sistema usado para executar login.
     * 
     * Por enquanto a senha não é checada.
     * 
     * @param login - login do usuário (case insensitive check)
     * @param senha - senha do usuário (case sensitive check)
     * @param usuario - bean do usuário retornado caso o login seja válido.
     * @return - retorna True se o login e senha representam um usuário válido
     * para o sistema.
     */
    public static boolean loginValido(String login, String senha,
            model.beans.Usuario usuario) {
        usuario = model.daos.Usuarios.recuperaUm(login);
        if( senha.equals(usuario.getSenha()))
            return true;
        usuario = null; 
        return false;

    }
}


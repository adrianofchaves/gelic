package model.services;
// #[regen=yes,id=DCE.4C280404-F5D8-E997-9B56-B559AAEA5A24]
// </editor-fold> 
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Usuario;

public class Usuarios {

    public static void alterar(String login, String loginUsuario, String senhaUsuario, int idPapel) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void incluir(String loginUsuario, String senhaUsuario, int idPapel) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Recupera todos os usuários cadastrados no banco.  Cada item terá seu 
     * papel preenchido.
     * 
     * @return lista de usuários
     */
    public static ArrayList<Usuario> recuperar()
            throws SQLException, NamingException {
        return model.daos.Usuarios.recuperar();
    }

    /**
     * Retorna o bean do usuário carregado do banco a partir do login 
     * 
     * @param login
     * @return bean do usuário com seu Papel preenchido.
     */
    public static Usuario recuperar(String login)
            throws NamingException, SQLException {
        return model.daos.Usuarios.recuperar(login);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4DD9DF74-6AB7-439C-D378-2D7EB77AEE4E]
    // </editor-fold> 
    public Usuarios() {
    }

    /**
     * Recupera um usuário a partir do login e senha.
     * @param login - login do usuário (case insensitive check)
     * @param senha - senha do usuário (case sensitive check). Aceita senha nula
     * ou vazia.
     * @return usuario - bean do usuário retornado caso o login seja válido. 
     * <B>retorna <CODE>null</CODE> se usuário não for encontrado.  A 
     * propriedade papel é também assinalada.
     */
    public static model.beans.Usuario recuperar(String login, String senha)
            throws NamingException, SQLException {
        return model.daos.Usuarios.recuperar(login);
    }
}


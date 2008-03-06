package model.services;
// #[regen=yes,id=DCE.4C280404-F5D8-E997-9B56-B559AAEA5A24]
// </editor-fold> 
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.beans.Usuario;

public class Usuarios {
    /**
     * Altera o registro do usuário no banco de dados.
     * @param login - login do usuário (antes de alterar).
     * @param loginUsuario - novo login do usuário
     * @param senhaUsuario - nova senha do usuário
     * @param idPapel - novo papel do usuário
     */
    public static void alterar(
            String login, 
            String loginUsuario, 
            String senhaUsuario, 
            int idPapel) 
            throws SQLException, NamingException, NoSuchAlgorithmException {
        if ( model.daos.Usuarios.alterar( 
                login, 
                loginUsuario, 
                senhaUsuario, 
                idPapel ) == 1 )
            model.services.Conexao.getConnection().commit();
        else
            model.services.Conexao.getConnection().rollback();
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

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 * O cadastro de usuários é o comando executado pelo administrador a partir de 
 * sua home.  O sistema deverá exibir todos os usuários cadastrados e exibir um 
 * formulário capaz de executar o comando para cadastrar um novo usuário 
 * 
 * @author Adriano
 */
public class CadastroUsuarios implements Comando {

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {

           return control.Usuarios.prepararBrowser(req);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }
}

/**
 * 
 */
package control.commands;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author adriano
 */
public class ExcecaoComando extends Exception {

    public ExcecaoComando() {
        super();
    }

    public ExcecaoComando(String msg) {
        super(msg);
    }

    ExcecaoComando(NamingException ex) {
        super(ex.getMessage());
    }

    ExcecaoComando(SQLException ex) {
        super(ex.getMessage());        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class ExcecaoForm extends Exception {

    public ExcecaoForm() {
        super();
    }

    public ExcecaoForm(String msg) {
        super(msg);
    }

    ExcecaoForm(NamingException ex) {
        super(ex.getMessage());
    }

    ExcecaoForm(SQLException ex) {
        super(ex.getMessage());        
    }
}

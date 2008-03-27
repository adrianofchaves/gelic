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
 *
 * @author gustavo
 */
public class CadastroProdutos implements Comando{
    
        public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            return control.Produto.preparaBrowser(req);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProdutos.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(CadastroProdutos.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ExcecaoComando(ex.getMessage());
        }
    }
}

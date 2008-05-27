package control.commands;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import view.BrowserLicitacoes;
// #[regen=yes,id=DCE.2DD02736-2417-4F69-3826-F82889379BDD]
// </editor-fold> 
public class NovaLicitacao implements Comando{
    public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.BrowserLicitacoes browser = (BrowserLicitacoes) req.getSession().getAttribute("browserLicitacoes");
      view.FormLicitacao form = new view.FormLicitacao();
      form.setOrigem(browser);
      req.getSession().setAttribute(view.FormLicitacao.NOME_ATRIBUTO_DEFAULT, form);
      form.preparaInclusao();
      form.setTitulo("Nova licitação");
      return form.getNome();
    } catch (NamingException ex) {
      Logger.getLogger(NovaLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(NovaLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
              
       
    }

}


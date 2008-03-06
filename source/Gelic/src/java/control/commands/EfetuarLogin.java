package control.commands;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// </editor-fold> 
public class EfetuarLogin implements Comando {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.485A52D2-0677-3484-9B8A-0B4EDEA6AAC0]
    // </editor-fold> 
    public EfetuarLogin() {
    }

    public String executar(HttpServletRequest req) throws ExcecaoComando {
        try {
            return processar(req);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EfetuarLogin.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(EfetuarLogin.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(EfetuarLogin.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new control.commands.ExcecaoComando(ex.getMessage());
        }

    }

    private String processar(HttpServletRequest req) throws NamingException, SQLException, NoSuchAlgorithmException {

        /* Popula form */
        view.FormLogin frm = new view.FormLogin();
        frm.setLogin(util.Forms.recuperaParametro(req, "login"));
        frm.setSenha(util.Forms.recuperaParametro(req, "senha"));



        model.beans.Usuario usuario = model.services.Usuarios.recuperar(
                frm.getLogin());

        if (usuario == null) {
            /* Não existe usuário com este login */
            if (frm.getLogin().isEmpty()) {
                frm.setErroLogin("Informe um Login");
            } else {
                frm.setErroLogin("Não existe usuário com este login.");
            }
            frm.addErro("Login inválido!");
        } else {
            if (!usuario.isSenhaValida(frm.getSenha())) {
                frm.setErroSenha("Senha inválida.");
                frm.addErro("Senha inválida.");
            }
        }

        req.setAttribute("formLogin", frm);
        if (frm.temErros()) {
            return "/login.jsp";
        }

        /* Login aceito */
        req.getSession().setAttribute("usuario", usuario);
        switch (usuario.getTipo()) {
            case model.beans.Usuario.ADMINISTRADOR:
                return "homeAdministrador.jsp";
            case model.beans.Usuario.ANALISTA:
                return "homeAnalista.jsp";
            case model.beans.Usuario.COMERCIAL:
                return "homeComercial.jsp";
            case model.beans.Usuario.FINANCEIRO:
                return "homeFinanceiro.jsp";
            case model.beans.Usuario.GERENTECOMERCIAL:
                return "homeGerenteComercial.jsp";
            default:
                return "login.jsp";
        }
    }
}


package control.commands;

import javax.servlet.http.HttpServletRequest;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

// #[regen=yes,id=DCE.EA8F4164-3E10-FACD-0F29-08131E42EFB0]
// </editor-fold> 
public class EfetuarLogin implements Comando {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.485A52D2-0677-3484-9B8A-0B4EDEA6AAC0]
    // </editor-fold> 
    public EfetuarLogin() {
    }

    public String executar(HttpServletRequest req) /*throws ExcecaoComando*/ {
        String login = (String) req.getAttribute("login");
        String senha = (String) req.getAttribute("senha");
        model.beans.Usuario usuario = null;

        if (model.services.Usuarios.loginValido(login, senha, usuario)) {
            req.getSession().setAttribute("login", login);
        }
        /* Se tentou logar e errou, mata a sessão (usuario == null), se não 
        coloca os dados do usuário na sessão. */
        req.getSession().setAttribute("usuario", usuario);

        switch (usuario.getTipo()) {
            case model.beans.Usuario.ADMINISTRADOR:
                return "/homeAdministrador.jsp";
            case model.beans.Usuario.ANALISTA:
                return "/homeAnalisata.jsp";
            case model.beans.Usuario.COMERCIAL:
                return "/homeComercial.jsp";
            case model.beans.Usuario.FINANCEIRO:
                return "/homeFinanceiro.jsp";
            case model.beans.Usuario.GERENTECOMERCIAL:
                return "/homeGerenteComercial";
            default:
                return "/login.jsp";
        }
    }
}


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

        String login = (String) req.getParameter("login");
        String senha = (String) req.getParameter("senha");

        model.beans.Usuario usuario = model.services.Usuarios.recuperar(login, senha);
        if (usuario == null) {
            req.setAttribute("erroLogin", "Informe o login.");
            req.setAttribute("erros", "Login inválido!");
            /* se foi uma tentar o login e falhar, mata a sessão */
            req.setAttribute("usuario", null);
            return "login.jsp";
        }
        if ((senha != null) && (!senha.equals(""))) {
            /* informou alguma senha */
            if ((usuario.getSenha() == null) || usuario.getSenha().equals("")) {
                /* tem usuário com o login e sem senha.  No entanto foi informada
                 * uma senha */
                req.setAttribute("erros", "Senha inválida!");
                req.setAttribute("erroSenha", "Informe a senha.");
                req.setAttribute("usuario", null);
                return "login.jsp";
            }
            if (!usuario.getSenha().equals(senha)){
                /* senha informada diferente da cadastrada.*/
                req.setAttribute( "erros", "Senha inválida!");
                req.setAttribute("erroSenha", "Informe a senha.");
                req.setAttribute("usuario", null);
                return "login.jsp";                
            }
        }
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


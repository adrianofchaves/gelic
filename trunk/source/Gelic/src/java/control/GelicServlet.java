/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.commands.Comando;
import control.commands.ExcecaoComando;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Este é o Servlet principal do sistema. A princípio é responsável pelo Login
 * e pelos casos de uso do administrador.
 *
 * @author adriano
 */
public class GelicServlet extends HttpServlet {

    /**
     * Contém os comandos suportados pelo Servlet.  Definido em temo de 
     * programação.
     */
    private HashMap comandos;

    private void carregaComandos() {
        comandos = new HashMap();

        comandos.put("<vazio>", new control.commands.Nulo("index.jsp"));
        comandos.put("EfetuarLogin", new control.commands.EfetuarLogin());
        comandos.put("CadastroUsuarios", new control.commands.CadastroUsuarios());
        comandos.put("AlterarUsuario", new control.commands.AlterarUsuario());
        comandos.put("ExcluirUsuario", new control.commands.ExcluirUsuario());
        comandos.put("GravarUsuario", new control.commands.GravarUsuario());

    }

    private void carregaPapeis() throws SQLException, NamingException {

        /* Lista de papéis cadastrados */
        ServletContext cntx = this.getServletContext();
        cntx.setAttribute("papeis", model.services.Papeis.recuperar());
    }
    /**
     * Carrega listas no contexto da aplicação.  Essas listas somente são 
     * recarregadas quando o Servlet é iniciado.
     */
    private void carregaTabelasNoContexto() throws ServletException{
        try {
            carregaPapeis();
        } catch (SQLException ex) {
            Logger.getLogger(GelicServlet.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServletException(ex.getClass().getName() + "." + ex.getMessage() );
        } catch (NamingException ex) {
            Logger.getLogger(GelicServlet.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServletException(ex.getClass().getName() + "." + ex.getMessage() );
        }
    }
    public void init() throws ServletException {
        carregaComandos();        
        carregaTabelasNoContexto();
    }
    /**
     * Inclui, se necessário  "/" no início do url
     * 
     * @param url
     * @return url com o "/"
     */
    private String colocaBarraNoInicio(String url) {
        if (url.charAt(0) != '/') {
            return '/' + url;
        } else {
            return url;
        }
    }

    /** Este método executa um forward.<BR>
     * <B>NOTA:</B>Os exceptions são tratados.
     * 
     * @param url
     * url para onde o forward será executado.  Este deverá ser passado 
     * corretamente tratado.
     * @param request
     * @param response
     */
    private void forward(String url,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String urlTratada = colocaBarraNoInicio(url);
        getServletConfig().getServletContext().getRequestDispatcher(urlTratada).
                forward(request, response);
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            processa(response, request);
            //forward("/homeAdministrador.jsp", request, response);
        } catch (ExcecaoComando ex) {
            Logger.getLogger(GelicServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex.getClass().getName() + "." + ex.getMessage() );
        }
    //forward("/homeAdministrador.jsp", request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Servlet do Gerente de Licitações";
    }

    private void processa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, ExcecaoComando {
        /**
         *
         * Por enquanto vou deixar aqui um forward para o homeAdministrador.
         * deve-se implementar uma resolução de comandos aqui.
         *
         */
        String nomeComando = request.getParameter("comando");
        control.commands.Comando comando = procuraComando(nomeComando);
        if (comando == null) {
            comando = procuraComando("<vazio>");
        }
        forward(comando.executar(request), request, response);
        //forward("/homeAdministrador.jsp", request, response);
    }

    private Comando procuraComando(String nomeComando) {
        return (Comando) comandos.get(nomeComando);
    }
    // </editor-fold>
}

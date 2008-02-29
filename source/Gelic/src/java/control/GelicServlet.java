/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.commands.Comando;
import control.commands.ExcecaoComando;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
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

    }

    public void init() throws ServletException {
        carregaComandos();
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

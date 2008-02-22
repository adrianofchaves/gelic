/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.*;
import java.net.*;

import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

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
    
    private void carregaComandos(){
        comandos = new HashMap();
        
        comandos.put("<vazio>", new control.commands.Nulo("index.jsp"));
        
    }
    public void init() throws ServletException {
        carregaComandos();
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

        getServletConfig().getServletContext().getRequestDispatcher(url).
                forward(request, response);
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 
         * Por enquanto vou deixar aqui um forward para o homeAdministrador.  
         * deve-se implementar uma resolução de comandos aqui.
         * 
         */
        forward("/homeAdministrador.jsp", request, response);
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
        return "Short description";
    }
    // </editor-fold>
}

package control;

import control.commands.AlterarContato;
import control.commands.AlterarEmpresa;
import control.commands.AlterarOrgao;
import control.commands.AlterarProduto;
import control.commands.AlterarTipoDocumento;
import control.commands.AlterarTipoLicitacao;
import control.commands.CadastroContatos;
import control.commands.CadastroEmpresas;
import control.commands.CadastroOrgaos;
import control.commands.CadastroTiposDocumentos;
import control.commands.CadastroTiposLicitacoes;
import control.commands.CadastroProdutos;
import control.commands.Comando;
import control.commands.ExcecaoComando;
import control.commands.ExcluirContato;
import control.commands.ExcluirEmpresa;
import control.commands.ExcluirProduto;
import control.commands.ExcluirTipoDocumento;
import control.commands.ExcluirTipoLicitacao;
import control.commands.GravarContato;
import control.commands.GravarEmpresa;
import control.commands.GravarNovoProduto;
import control.commands.GravarTipoDocumento;
import control.commands.GravarTipoLicitacao;
import control.commands.NovaEmpresa;
import control.commands.NovoContato;
import control.commands.NovoOrgao;
import control.commands.NovoProduto;
import control.commands.NovoTipoDocumento;
import control.commands.Nulo;
import control.commands.NovoTipoLicitacao;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import javax.servlet.http.HttpServletRequest;
// #[regen=yes,id=DCE.504C57C2-4006-0DBE-1B39-401B66EAA3B8]
import javax.servlet.http.HttpServletResponse;
// </editor-fold> 
public class ServletComercial extends HttpServlet {

    private HashMap<String, Comando> comandos;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1B2CD1EF-B36D-4742-7062-39E0F74D183E]
    // </editor-fold> 
    public ServletComercial() {
    }

    private void carregaComandos() {
        comandos = new HashMap<String, Comando>();

        comandos.put("<vazio>", new Nulo("index.jsp"));
        comandos.put("CadastroTiposLicitacoes", new CadastroTiposLicitacoes());
        comandos.put("AlterarTipoLicitacao", new AlterarTipoLicitacao());
        comandos.put("NovoTipoLicitacao", new NovoTipoLicitacao());
        comandos.put("GravarTipoLicitacao", new GravarTipoLicitacao());
        comandos.put("ExcluirTipoLicitacao",new ExcluirTipoLicitacao());
        comandos.put("CadastroTiposDocumentos", new CadastroTiposDocumentos());
        comandos.put("NovoTipoDocumento", new NovoTipoDocumento());
        comandos.put("AlterarTipoDocumento", new AlterarTipoDocumento());
        comandos.put("GravarTipoDocumento", new GravarTipoDocumento());
        comandos.put("ExcluirTipoDocumento", new ExcluirTipoDocumento());
        comandos.put("CadastroProdutos", new CadastroProdutos());
        comandos.put("NovoProduto",new NovoProduto());
        comandos.put("GravarNovoProduto", new GravarNovoProduto());
        comandos.put("AlterarProduto", new AlterarProduto());
        comandos.put("ExcluirProduto", new ExcluirProduto());
        comandos.put("CadastroEmpresas", new CadastroEmpresas());
        comandos.put("AlterarEmpresa", new AlterarEmpresa());
        comandos.put("NovaEmpresa", new NovaEmpresa());
        comandos.put("GravarEmpresa", new GravarEmpresa());
        comandos.put("ExcluirEmpresa", new ExcluirEmpresa());
        comandos.put("CadastroContatos", new CadastroContatos());
        comandos.put("AlterarContato", new AlterarContato());
        comandos.put("ExcluirContato", new ExcluirContato());
        comandos.put("NovoContato", new NovoContato());
        comandos.put("GravarContato", new GravarContato());
        comandos.put("CadastroOrgaos", new CadastroOrgaos());
        comandos.put("AlterarOrgao", new AlterarOrgao());
        comandos.put("NovoOrgao", new NovoOrgao());
        
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> 
     * methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processa(response, request);
        //forward("/homeAdministrador.jsp", request, response);
        } catch (ExcecaoComando ex) {
            Logger.getLogger(GelicServlet.class.getName()).log(
                    Level.SEVERE, null, ex);
            throw new ServletException(ex.getClass().getName() + "." +
                    ex.getMessage());
        }
    //forward("/homeAdministrador.jsp", request, response);
    }

    private void processa(HttpServletResponse response,
            HttpServletRequest request) throws
            ServletException, IOException, ExcecaoComando {
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
        return comandos.get(nomeComando);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet do Gerente de Licitações - Comercial";
    }

    // </editor-fold>
}


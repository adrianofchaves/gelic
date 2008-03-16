package control.commands;

import javax.servlet.http.HttpServletRequest;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2DD02736-2417-4F69-3826-F82889379BDD]
// </editor-fold> 
public class NovaLicitacao implements Comando{
    public String executar(HttpServletRequest req) throws ExcecaoComando {
       return control.TipoLicitacao.preparaCadastro(req);
    }

}


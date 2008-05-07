<%-- 
    Document   : formLicitacao
    Created on : 29/03/2008, 19:03:16
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Cadastro de Licitações</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="homeComercial.jsp">Voltar</a>
        </th>
        <c:if test="${!sessionScope.formLicitacao.inclusao}">
          <th class="menuItem" >
            <a href="browserContatos.jsp">Contatos</a>
          </th>
          <th class="menuItem" >
            <a href="browserDocumentos.jsp">Documentos</a>
          </th>
          <th class="menuItem" >
            <a href="formLote.jsp">Lotes</a>                    
          </th>
        </c:if>
        <th class="menuItem" >
          <a href="homeComercial.jsp">Início</a>
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">Trocar usuário</a>                    
        </th>
      </tr>
    </table>
  </head>
  <body>
    
    <form name="frmOrgao" 
          action="Comercial?comando=GravarLicitacao" 
          method="POST">
      <p class="caption">
        ${sessionScope.formLicitacao.titulo}
        formLicitacao.JSP
      </p>            
      
      <c:forEach var="erro" items="${sessionScope.formLicitacao.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           
      
      <p class="grupo">Identificação:</p>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:30%">
          Órgão:<BR>
          <select name="razaoSocialOrgao" 
                  class="tabelaCadastro"
                  value="${sessionScope.formLicitacao.razaoSocialOrgao}">
            <option>pcrj</option>
            <option>bb</option>
            <option>cef-df</option>
            <option>cef-rj</option>
          </select>
        </td>
        <td class="tabelaCadastro" style = "width:40%">
          Número:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formLicitacao.numeroLicitacao}" />
        </td>
        <td class="tabelaCadastro" style="width:40">
          Processo:<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.processoLicitacao}"/>
        </td>
      </table>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:30%">
          Modalidade:<BR>
          <select name="modalidadeLicitacao" 
                  class="tabelaCadastro"
                  value="${sessionScope.formLicitacao.modalidadeLicitacao}">
            <option>Por Lote</option>
            <option>Por Item</option>
          </select>
        </td>
        
        <td class="tabelaCadastro" style = "width:40%">
          Tipo:<BR>
          <select name="tipoLicitacao" 
                  class="tabelaCadastro"
                  value="${sessionScope.formLicitacao.tipoLicitacao}">
            <option>Carta Convite</option>
            <option>Tomada de Preços</option>
            <option>Pregão Eletronico</option>
          </select>
        </td>
        
        <td class="tabelaCadastro" style = "width:40%">
          Sistema:<BR>
          <select name="sistemaLicitacao" 
                  class="tabelaCadastro"
                  value="${sessionScope.formLicitacao.sistemaLicitacao}">
            <option>Registro de Preços</option>
            <option>Fornecimento</option>
          </select>
        </td>
      </table>
      
      <p class="grupo">Datas:</p>
      
      <table class="tabelaCadastro">
        
        <td class="tabelaCadastro" style="width: 33%">
          Documentação:<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.dataDocumentacaoLicitacao}"/>
        </td>        
        <td class="tabelaCadastro" style="width: 34%">
          Proposta:<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.dataPropostaLicitacao}"/>
        </td>        
        <td class="tabelaCadastro" style="width: 33%">
          Realização:<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.dataRealizacaoLicitacao}"/>
        </td>        
      </table>
      
      <p class="grupo"> Objeto:</p>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width: 100%" >          
          <textarea name="objetoLicitacao" style="width:100%" rows="4">
            ${sessionScope.formLicitacao.objetoLicitacao}
          </textarea>
        </td>
      </table>
      
      <p class="grupo"> Prazos:</p>
      
      <table class="tabelaCadastro">
        
        <td class="tabelaCadastro" style="width: 20%">
          Validade da Proposta: (dias)<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.diasValidadePropostaLicitacao}"/>
        </td>
        
        <td class="tabelaCadastro" style="width: 20%">
          Prazo de Entrega: (dias) <BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.diasPrazoEntregaLicitacao}"/>
        </td>
        
        <td class="tabelaCadastro" style="width: 20%">
          Prazo de Pagamento: (dias)<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.diasPrazoPagamentoLicitacao}"/>
        </td>
        
        <td class="tabelaCadastro" style="width: 20%">
          Vigência do Contrato: (dias)<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.diasVigenciaLicitacao}"/>
        </td>
        
        <td class="tabelaCadastro" style="width: 20%">
          Prazo de Garantia: (Anos)<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formLicitacao.anosPrazoGarantiaLicitacao}"/>
        </td>
      </table>    
      
      <p class="grupo"> Termos:</p>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:33%">
          Amostra:<BR>
          <textarea name="ad" rows="4" style="width:100%" 
                    name="termosAmostraLicitacao">
                    ${sessionScope.formLicitacao.termosAmostraLicitacao} 
          </textarea>                   
        </td>
        <td class="tabelaCadastro" style="width:34%">
          Garantia:<BR>
          <textarea rows="4" cols="20" 
                    style="width:100%" 
                    name="termosGarantiaLicitacao">
                      ${sessionScope.formLicitacao.termosGarantiaLicitacao}
          </textarea>  
        </td>
        <td class="tabelaCadastro" style="width:33%">
          Multa:<BR>
          <textarea rows="4" cols="20" 
                    style="width:100%" 
                    name="termosMultaLicitacao">
                      ${sessionScope.formLicitacao.termosMultaLicitacao}
          </textarea>  
        </td>
      </table>
      <p>
        <input class="botao" type="submit" value="Salvar" 
               name="executar"/>
        <input class="botao" type="submit" value="Excluir" 
               name="excluir"/>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
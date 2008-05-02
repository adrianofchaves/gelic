<%-- 
    Document   : formContrato
    Created on : 02/05/2008, 19:41:40
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
    <title>GELIC--Cadastro de Contratos</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="homeAnalista.jsp">Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">Trocar usuário</a>                    
        </th>
      </tr>
    </table>
    </head>
    <body>

    <form name="frmContrato" 
          action="Analista?comando=GravarContrato" 
          method="POST">
      <p class="caption">
        ${sessionScope.formContrato.titulo}
        Cadastro de Contratos
      </p>            

      <c:forEach var="erro" items="${sessionScope.formContrato.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           

    <p class="grupo"></p>

      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:25%">
          Licitação:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}"
                 value="PE/003/07"/>
          </td>
        <td class="tabelaCadastro" style = "width:25%">
          Processo:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}" 
                 value="185.148/2007"/>
        </td>                
        <td class="tabelaCadastro" style="width:25%">
          Sistema:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.processoLicitacao}"
                 value="Registro de Preços"/>
        </td>
        <td class="tabelaCadastro" style="width:25%">
          Órgão:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.processoLicitacao}"
                 value="CEF/CT"/>
        </td>
      </table>
      <p>
      
    <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:25%">
          Lote:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}"
                 value="1"/>
          </td>
        <td class="tabelaCadastro" style = "width:25%">
          Objeto:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}" 
                 value="Mesas e Armários"/>
        </td>                
        <td class="tabelaCadastro" style="width:25%">
          Empresa:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.processoLicitacao}"
                 value="Sólio Comercial Brasileira Ltda."/>
        </td>
        <td class="tabelaCadastro" style="width:25%">
          Valor R$:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.processoLicitacao}"
                 value="150.000,00"/>
        </td>        
    </table>
    
    <p>
        
    <table class="tabelaCadastro">

        <td class="tabelaCadastro" style = "width:25%">
          Numero do Contrato:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}"/>
          </td>
          
        <td class="tabelaCadastro" style = "width:25%">
          Data de Assinatura:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formContrato.numeroLicitacao}"/>
          </td>
        <td class="tabelaCadastro" style = "width:25%">
          </td>
        <td class="tabelaCadastro" style = "width:25%">
          </td>
        
    </table>

      <BR><BR>
      <p>
        <input class="botao" type="submit" value="Salvar" 
               name="executar"/>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>
    </body>
</html>
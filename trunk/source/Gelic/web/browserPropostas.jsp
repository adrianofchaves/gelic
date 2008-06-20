<%-- 
    Document   : browserPropostas
    Created on : 02/06/2008, 11:07:06
    Author     : adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Cadastro de propostas</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <th class="menuItem" >
        <a href="${sessionScope.browserPropostas.origem.nome}">
        Voltar</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=NovaProposta">
        Nova proposta</a>                    
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">
        Trocar usuário</a>                    
      </th>
    </table>
  </head>
  <body>    
    <table class="cadastro">
      <TH class="cadastro">${browserPropostas.titulo}</TH>
    </TABLE>
    <table class="cadastro">
      <tr class="cabecalho">
        <td>Empresa</td>
        <td>Valor proposto</td>
        <TD> </TD>
      </tr>
      <c:forEach 
        var="empresa" 
        items="${sessionScope.browserPropostas.empresas}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarProposta&proposta=${empresa.empresa.cnpj}">
              ${empresa.empresa}
            </a>                        
          </td>                    
          <td>
            ${empresa.total}
          </td>                    
          <td>
            <a href="Comercial?comando=ExcluirProposta&proposta=${empresa.empresa.cnpj}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>        
    <P class="mensagem">${sessionScope.browserPropostas.mensagem}</P>
  </body>
</html>
<%-- 
    Document   : browserLotes
    Created on : 29/05/2008, 00:59:47
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Lotes da Licitação</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu"><tr>
        <th class="menuItem" >                
        <a href="${sessionScope.browserLotes.origem.nome}">
          Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Comercial?comando=NovoLote">
          Novo lote</a>                    
        </th>        
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">
          Trocar usuário</a>                    
        </th>
    </tr></table>        
  </head>
  <body>    
    <table class="cadastro"><TH class="cadastro">
        ${sessionScope.browserLotes.titulo}
    </TH></TABLE>
    <table class="cadastro">
      <tr class="cabecalho">
        <td>Número</td>
        <td>Nome</td>   
        <td>Total Estimado</td>
        <td></td>
      </tr>
      
      <c:forEach 
        var="lote" 
        items="${sessionScope.browserLotes.lotes}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarLote&lote=${lote.id}">
              ${lote.numero}
            </a>                        
          </td>                    
          <td>${lote.nome}</td>  
          <td>${lote.totalEstimado}</td>
          <td>
            <a href="Comercial?comando=ExcluirLote&lote=${lote.id}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>      
    </table>        
    <font class="mensagem">
      <P>${sessionScope.browserLotes.mensagem}</P>
    </font>
  </body>
</html>
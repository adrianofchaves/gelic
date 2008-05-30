<%-- 
    Document   : browserItensLote
    Created on : 30/05/2008, 11:50:40
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
    <title>GELIC--Cadastro de Itens de Lotes</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">      
      <th class="menuItem" >
        <a href="${sessionScope.browserItensLote.origem.nome}">
        Voltar</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=NovoItemLote">
        Novo Item</a>                    
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">
        Trocar usuário</a>                    
      </th>
    </table>     
  </head>
  <body>    
    <table class="cadastro">
      <TH class="cadastro">${sessionScope.browserItensLote.titulo}</TH>
    </TABLE>
    <table class="cadastro">            
      <tr class="cabecalho">
        <td>Numero</td>
        <td>Codigo</td>
        <td>Descricao</td>
        <td>Quantidade</td>
        <td>Preço Estimado</td>
        <TD> </TD>
      </tr>
      <c:forEach 
        var="itemLote" 
        items="${sessionScope.browserItensLote.itensLote}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarItemLote&itemLote=${itemLote.id}">
              ${itemLote.numero}    
            </a>                        
          </td>
          <td>
            ${itemLote.produto.codigo}
          </td>
          <td>
            ${itemLote.produto.descricao}
          </td>
          <td>
            ${itemLote.quantidade}
          </td>
          <td>
            ${itemLote.precoEstimado}
          </td>
          <td>
            <a href="Comercial?comando=ExcluirItemLote&itemLote=${itemLote.id}">
              <img src="img/trash.PNG"  width="16" height="16" alt="trash"/>
            </a>
          </td>
        </tr>        
      </c:forEach>
    </table>        
    <font class="mensagem">
      <P>${sessionScope.browserItensLote.mensagem}</P>
    </font>
  </body>
</html>
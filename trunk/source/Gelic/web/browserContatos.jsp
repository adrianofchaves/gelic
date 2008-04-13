<%-- 
    Document   : browserContatos
    Created on : 28/03/2008, 09:23:23
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
    <title>GELIC--Cadastro de contatos</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu"><tr>
        <th class="menuItem" >                
        <a href="${sessionScope.browserContatos.origem.nome}">
          Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Comercial?comando=NovoContato">
          Novo contato</a>                    
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">
          Trocar usuário</a>                    
        </th>
    </tr></table>        
  </head>
  <body>    
    <table class="cadastro"><TH class="cadastro">
        ${sessionScope.browserContatos.titulo}
    </TH></TABLE>
    <table class="cadastro">
      <tr class="cabecalho">
        <td>Nome</td>
        <td>Telefone</td>                    
      </tr>
      
      <c:forEach 
        var="contato" 
        items="${sessionScope.browserContatos.contatos}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarContato&id=${contato.id}">
              ${contato.nome}
            </a>                        
          </td>                    
          <td>
            ${contato.telefone}                        
          </td>                    
          <td>
            <a href="Comercial?comando=ExcluirContato&id=${contato.id}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>      
    </table>        
    <font class="mensagem">
      <P>${sessionScope.browserModalidades.mensagem}</P>
    </font>
  </body>
</html>
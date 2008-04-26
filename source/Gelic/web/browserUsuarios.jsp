<%-- 
    Document   : browserUsuarios
    Created on : 25/04/2008, 23:56:41
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <link rel="STYLESHEET" href="estilos.css" type="text/css">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Cadastro de usuários</title> 
    <table class="nomeSistema">
      <th>GELIC &nbsp;&nbsp;</th>        
    </table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="homeAdministrador.jsp">Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=NovoUsuario">Novo usuário</a>
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">Trocar usuário</a>                    
        </th>
      </tr>
    </table>
    <P></P>
  </head>
  <body>  
    <table class="cadastro">
      <TH class="cadastro">USUÁRIOS</TH>    
    </table>
    <table class="cadastro">             
      <tr class="cabecalho">
        <td>Login</td>
        <td>Papel</td>
        <TD> </TD>
      </tr>
      <c:forEach 
        var="usuario" 
        items="${sessionScope.browserUsuarios.usuarios}">                
        <tr class="dados">
          <td>
            <a href="Gelic?comando=AlterarUsuario&login=${usuario.login}">
              ${usuario.login}    
            </a>                        
          </td>
          <td>
            ${usuario.papel.nome}
          </td>  
          <td>
            <a href="Gelic?comando=ExcluirUsuario&login=${usuario.login}">
              <img src="img/trash.PNG" width="16" height="16" 
                   alt="excluir"/>
            </a>
          </td>
        </tr>
        
      </c:forEach>
    </table>        
    <P>
      <font class="mensagem">
        ${sessionScope.browserUsuarios.mensagem}
      </font>
    </P>    
  </body>
</html>

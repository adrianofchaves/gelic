<%-- 
    Document   : browserSistemas
    Created on : 21/03/2008, 23:01:29
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
        <title>GELIC--Cadastro de sistemas de licitações</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="homeAdministrador.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=NovoSistema">
                    Novo sistema</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table>
        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">Sistemas</TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">                
                <td>Nome</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="sistema" 
                items="${sessionScope.browserSistemas.sistemas}">                
                <tr class="dados">
                    <td>
                        <a href="Gelic?comando=AlterarSistema&nome=${sistema.nome}">
                            ${sistema.nome}    
                        </a>                        
                    </td>                    
                    <td>
                        <a href="Gelic?comando=ExcluirSistema&nome=${sistema.nome}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>        
        <P class="mensagem">${sessionScope.browserSistemas.mensagem}</P>
    </body>
</html>
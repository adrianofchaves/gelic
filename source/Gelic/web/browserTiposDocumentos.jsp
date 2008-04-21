<%-- 
    Document   : browserTiposDocumentos
    Created on : 22/03/2008, 00:33:02
    Author     : Adriano
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="STYLESHEET" href="estilos.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de tipos de documentos</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Comercial?comando=NovoTipoDocumento">
                    Novo tipo de documento</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table>        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">
                Tipos de documentos
        </TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">
                <td>Nome</td>                
                <TD> </TD>
            </tr>
            <c:forEach 
                var="tipo" 
                items="${sessionScope.browserTiposDocumentos.tiposDocumentos}">                
                <tr class="dados">
                    <td>
                        <a href="Comercial?comando=AlterarTipoDocumento&nome=${tipo.nome}">
                            ${tipo.nome}    
                        </a>                        
                    </td>                    
                    <td>
                        <a href="Comercial?comando=ExcluirTipoDocumento&nome=${tipo.nome}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>                
            </c:forEach>
        </table>        
        <font class="mensagem">
            <P>${sessionScope.browserTiposDocumentos.mensagem}</P>
        </font>
    </body>
</html>

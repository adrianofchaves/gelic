<%-- 
    Document   : browserModalidades
    Created on : 08/03/2008, 15:37:11
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
        <title>GELIC--Cadastro de modalidades de licitações</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="homeAdministrador.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=NovaModalidade">
                    Nova modalidade</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table>
        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">Modalidades</TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">
                <td>Sigla</td>
                <td>Nome</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="modalidade" 
                items="${sessionScope.browserModalidades.modalidades}">                
                <tr class="dados">
                    <td>
                        <a href="Gelic?comando=AlterarModalidade&sigla=${modalidade.sigla}">
                            ${modalidade.sigla}    
                        </a>                        
                    </td>
                    <td>
                        ${modalidade.nome}
                    </td>  
                    <td>
                        <a href="Gelic?comando=ExcluirModalidade&sigla=${modalidade.sigla}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>        
        <P class="mensagem">${sessionScope.browserModalidades.mensagem}</P>
    </body>
</html>
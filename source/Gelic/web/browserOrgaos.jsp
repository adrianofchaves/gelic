<%-- 
    Document   : browserOrgaos
    Created on : 29/03/2008, 17:55:13
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
        <title>GELIC--Cadastro de Órgãos Públicos</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="formOrgao.jsp">
                    Novo Órgão</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table> 
        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">Órgãos Publicos</TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">
                <td>CNPJ</td>
                <td>Apelido</td>
                <td>Estado</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="orgao" 
                items="${sessionScope.browserOrgaos.orgaos}">                
                <tr class="dados">
                    <td>
                        <a href="Gelic?comando=AlterarOrgao&cnpj=${orgao.cnpj}">
                            ${orgao.cnpj}
                            00.360.305/0001-04
                        </a>                        
                    </td>
                    <td>
                        ${orgao.apelido}
                        CEF-DF
                    </td>
                    <td>
                        ${orgao.estado}
                        DF
                    </td>
                    <td>
                        <a href="Gelic?comando=ExcluirOrgao&orgado=${orgao.cnpj}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>

                <tr class="dados">
                    <td>
                        <a href="formOrgao.jsp">
                            00.360.305/0001-04
                        </a>                        
                    </td>
                    <td>
                        CEF-DF
                    </td>
                    <td>
                        DF
                    </td>
                    <td>
                        <a href="Gelic?comando=ExcluirOrgao&orgado=${orgao.cnpj}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
            
                <tr class="dados">
                    <td>
                        <a href="formOrgao.jsp">
                            00.000.000/0001-94
                        </a>                        
                    </td>
                    <td>
                        BB
                    </td>
                    <td>
                        DF
                    </td>
                    <td>
                        <a href="Gelic?comando=ExcluirOrgao&orgado=${orgao.cnpj}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>

        </table>        
        <font class="mensagem">
            <P>${sessionScope.browserOrgao.mensagem}</P>
        </font>
    </body>
</html>
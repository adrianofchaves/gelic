<%-- 
    Document   : browserTiposLicitacoes
    Created on : 14/03/2008, 22:59:34
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
                    <a href="homeComercial.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Comercial?comando=NovoTipoLicitacao">
                    Novo tipo de licitação</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table>
        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">
                Tipos de Licitações
        </TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">
                <td>Nome</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="tipo" 
                items="${sessionScope.browserTiposLicitacoes.tiposLicitacoes}">                
                <tr class="dados">
                    <td>
                        <a href="Comercial?comando=AlterarTipoLicitacao&nome=${tipo.nome}">
                            ${tipo.nome}    
                        </a>                        
                    </td>
                    <td>
                        <a href="Comercial?comando=ExcluirTipoLicitacao&nome=${modalidade.sigla}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>        
        <font class="mensagem">
            <P>${sessionScope.browserTiposLicitacoes.mensagem}</P>
        </font>
    </body>
</html>

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
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>
    </head>
    <body>    
        <P class="caption" >Cadastro de modalidades</P>    
        <table>            
            <tr  class="cabecalho">
                <td>Sigla</td>
                <td>Nome</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="modalidade" 
                items="${sessionScope.browserModalidades.modalidades}">                
                <tr class="dados">
                    <td>
                        <a href="GelicServlet?comando=AlterarModalidade&sigla=${modalidade.sigla}">
                            ${modalidade.sigla}    
                        </a>                        
                    </td>
                    <td>
                        ${modalidade.nome}
                    </td>  
                    <td>
                        <a href="GelicServlet?comando=ExcluirModalidade&usuario=${modalidade.sigla}">
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
        <form action="GelicServlet?comando=NovaModalidade" method = "post">
            <input type="submit"  value="Criar"/> 
        </form>
        <P>
            Para voltar ao início clique 
            <a href="homeAdministrador.jsp">aqui</a>
        </P>   
        <P>Para efetuar logout clique 
            <a href="GelicServlet?comando=Logout">aqui</a>
        </p>
    </body>
</html>
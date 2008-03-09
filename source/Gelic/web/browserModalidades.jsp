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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de modalidades de licitações</title>  
        
        <H1 STYLE="font-family: Arial,Helvetica,sans-serif;
            background-color: #3300cc;
            background-position: right;
            color: silver;
            font-style: oblique;
            font-weight: 900;
            font-variant: small-caps;
            font-size: XX-large;
            text-align: right;
        ">GELIC</H1>        
    </head>
    <body>        
        <table 
            style="font-family: Arial,Helvetica,sans-serif;width: 100%;">
            <h2 style="background-color: #3300cc;
                font-style: oblique;
                color: #ffffff;
                font-weight: bold;
                font-variant: small-caps;">
            Cadastro de modalidades</h2>       
            <tr  style="font-variant: small-caps;
                 font-weight: bold;
                 border-bottom-style: solid;
                 border-bottom-width: 2px;
                 font-family: Arial,Helvetica,sans-serif;
                 border-bottom-color: #999999;
                 background-color: #d8edf0;">
                <td>Sigla</td>
                <td>Nome</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="modalidade" 
                items="${sessionScope.browserModalidades.modalidades}">                
                <tr 
                    style="font-size: small;
                    background-color: #fbfbec;
                    font-family: Arial,Helvetica,sans-serif;
                    color: #6e6c6c;">
                    <td>
                        <a href="GelicServlet?comando=AlterarModalidade&sigla=${modalidade.sigla}">
                            ${modalidade.sigla}    
                        </a>                        
                    </td>
                    <td>
                        ${modalidade.nome}
                    </td>  
                    <td>
                        <a href="GelicServlet?comando=
                           ExcluirModalidade&usuario=${modalidade.sigla}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 style="border-top-style: none;
                                 border-bottom-style: none;
                                 border-left-style: none;
                                 border-right-style: none;" alt="trash"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>        
        <font style="font-family: Arial,Helvetica,sans-serif;
              font-style: no
                  font-weight: 700;
                  color: #0033cc;font-variant: normal;">
            <P>${sessionScope.browserModalidades.mensagem}</P>
        </font>
        <form action="GelicServlet?comando=CriarModalidade">
            <input type="submit" value="Criar"/> 
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
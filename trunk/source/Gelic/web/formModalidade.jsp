<%-- 
    Document   : formModalidade
    Created on : 09/03/2008, 11:48:24
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de usuários</title>  
        
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
        <form name="frmModalidade" 
              style="background-color: #fbfbec;"
              action="GelicServlet?comando=GravarModalidade" 
              method="POST">
            <h2 style="background-color: #3300cc;
                font-style: oblique;
                color: #ffffff;
                font-weight: bold;
                font-variant: small-caps;">
                <c:if test="${!sessionScope.formModalidade.inclusao}">
                    Alterando modalidade:
                </c:if>
                <c:if test="${sessionScope.formModalidade.inclusao}">
                    Criando usuário:
                </c:if>
            </H2>
            <font style="background-color: #fbfbec;color: red;">
                <c:forEach var="erro" items="${sessionScope.formModalidade.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>
            
            <P>Sigla:<br>
                <input type="text" name="siglaModalidade" 
                       value="${sessionScope.formUsuario.siglaModalidade}" />
                <font style="background-color: #fbfbec;color: red;">
                    ${sessionScope.formUsuario.erroSiglaModalidade}
                </font>
            </P>
            <P>Nome:<br>
                <input type="text" name="nomeModalidade" 
                       value="${sessionScope.formModalidade.nomeModalidade}" />
                <font style="background-color: #fbfbec;color: red;">
                    ${sessionScope.formModalidade.erroNomeModalidade}
                </font>
            </P>            
            <p>
                <input type="submit" value="Gravar" name="executar"/>
                <c:if test="${!sessionScope.formUsuario.inclusao}">
                    <INPUT TYPE="submit" value="Cancelar" name="cancelar"/>
                </c:if>
            </p>
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

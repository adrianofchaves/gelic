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
        <link rel="STYLESHEET" href="estilos.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de usuários</title>  
        
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>
        
    </head>
    <body>
        <p class="caption">Autenticação
            <c:if test="${!sessionScope.formModalidade.inclusao}">
                Alterando modalidade:
            </c:if>
            <c:if test="${sessionScope.formModalidade.inclusao}">
                Criando usuário:
            </c:if>
        </p>
        <form name="frmModalidade" 
              action="GelicServlet?comando=GravarModalidade" 
              method="POST">
            <font class="erro" >
                <c:forEach var="erro" items="${sessionScope.formModalidade.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>
            
            <P>Sigla:<br>
                <input type="text" name="siglaModalidade" class="caixaTexto"
                       value="${sessionScope.formModalidade.siglaModalidade}" />
                <font class="erroCampo" >
                    ${sessionScope.formModalidade.erroSiglaModalidade}
                </font>
            </P>
            <P>Nome:<br>
                <input type="text" name="nomeModalidade" class="caixaTexto"
                       value="${sessionScope.formModalidade.nomeModalidade}" />
                <font class="erroCampo" >
                    ${sessionScope.formModalidade.erroNomeModalidade}
                </font>
            </P>            
            <p>
                <input class="botao" type="submit" value="Gravar" 
                       name="executar"/>
                <INPUT class="botao" TYPE="submit" value="Cancelar" 
                       name="cancelar"/>                
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

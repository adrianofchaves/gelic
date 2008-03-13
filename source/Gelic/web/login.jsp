<%-- 
    Document   : login
    Created on : 21/02/2008, 12:04:35
    Author     : adriano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Autenticação</title>
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>
    </head>
    <body>
        <p class="caption">Autenticação</p>
        <form             
            name="formlogin" 
            action="GelicServlet?comando=EfetuarLogin" method="post"> 
            <font class="erro"> 
                ${requestScope.formLogin.erros}
            </font>                    
            <P>Login:<BR>
                <input class="caixaTexto" type="text" name="login" value="" />             
                <font class="erroCampo"> 
                    ${requestScope.formLogin.erroLogin}
                </font>
            </P>
            <P>
                Senha:<BR>
                <input class="caixaTexto"  type="password" name="senha" value="" />
                <font class="erroCampo">
                    ${requestScope.formLogin.erroSenha}
                </font>
                
            </P>
            <P>
                <input class="botao" type="submit" value="Efetuar Login" name="comando" />
            </P>
            
        </form>
    </body>
</html>

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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Autenticação</title>
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
        <form 
            style="background-color: #fbfbec;"
            name="formlogin" 
            action="GelicServlet?comando=EfetuarLogin" method="post">
            <h2 style="background-color: #3300cc;
                font-style: oblique;
                color: #ffffff;
                font-weight: bold;
                font-variant: small-caps;">Autenticação</h2>
            <font style="background-color: #fbfbec;color: red;"> 
                ${requestScope.formLogin.erros}
            </font>                    
            <P>Login:<BR>
                <input type="text" name="login" value="" />             
                <font style="background-color: #fbfbec;color: red;">
                    ${requestScope.formLogin.erroLogin}
                </font>
            </P>
            <P>
                Senha:<BR>
                <input type="password" name="senha" value="" />
                <font style="background-color: #fbfbec;
                      color: red;">${requestScope.formLogin.erroSenha}</font>
                
            </P>
            <P>
                <input type="submit" value="Efetuar Login" name="comando" />
            </P>
        </form>
    </body>
</html>

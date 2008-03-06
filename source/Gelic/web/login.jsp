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
        <title>GELIC--Login</title>
    </head>
    <body>
        <h2>Login</h2><br>
        <font color="red"><b>
                ${requestScope.formLogin.erros}
        </b></font>        
        <form name="formlogin" action="GelicServlet?comando=EfetuarLogin" method="post">
            <br><br>Digite seu login e senha:<BR><BR>
            Login: <BR>
            <input type="text" name="login" value="" />             
            <font color="red">${requestScope.formLogin.erroLogin}</font>
            <BR>
            Senha: <BR>
            <input type="password" name="senha" value="" />
            <font color="red">${requestScope.formLogin.erroSenha}</font>
            <BR>
            <input type="submit" value="Efetuar Login" name="comando" />
        </form>
    </body>
</html>

<%-- 
    Document   : login
    Created on : 21/02/2008, 12:04:35
    Author     : adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form name="login" action="GelicServlet?comando=EfetuarLogin" method="POST">
         Digite seu login e senha:<BR><BR><BR>
         Login: <BR>
         <input type="text" name="login" value="" /> <BR>
         Senha: <BR>
         <input type="password" name="senha" value="" /><BR>
         <input type="submit" value="Começar!" name="login" />
        </form>
        
    </body>
</html>

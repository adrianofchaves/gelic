<%-- 
    Document   : homeFinanceiro
    Created on : 25/03/2008, 00:46
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Financeiro</title>
       <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Gelic?comando=CadastroUsuarios">Bancos</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=CadastroModalidades">Contas a Pagar</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=CadastroSistemas">Contas a Receber</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">Trocar usuario</a>
                </th>                
            </tr>        
        </table>
    </head>
    <body>
    </body>
</html>
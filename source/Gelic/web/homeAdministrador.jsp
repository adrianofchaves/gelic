<%-- 
    Document   : homeAdministrador
    Created on : 21/02/2008, 12:40:35
    Author     : adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Administrador</title>
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
        <P STYLE="font-size: large;
           font-weight: 500;">Bem-vindo, administrador!</P>        
        <P>Se você deseja acessar o cadastro de usuários clique 
            <a href="GelicServlet?comando=CadastroUsuarios">aqui</a>            
        </P>
        <P>Se você deseja acessar o cadastro de modalidade de licitações clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        <P>Para efetuar logout clique <a href="GelicServlet?comando=Logout"> 
                aqui
            </a>
        </p>
    </body>
</html>

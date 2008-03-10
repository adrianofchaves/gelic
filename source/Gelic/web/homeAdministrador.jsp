<%-- 
    Document   : homeAdministrador
    Created on : 21/02/2008, 12:40:35
    Author     : adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Administrador</title>
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>
    </head>
    <body>
        <P class="bemvindo">Bem-vindo, administrador!</P>        
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

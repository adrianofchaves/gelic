<%-- 
    Document   : homeComercial
    Created on : 24/02/2008, 18:00:45
    Author     : Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC [Comercial] - Licitações</title>
        <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Nova licitação</a>
                </th>
                <!-- <th class="menuItem" >
                    <a href="homeComercial.jsp">Todas licitações</a>
                    TODO: tela que lista todas as licitações com critérios 
                </th> -->
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Tipos de licitação</a>                    
                </th>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Tipos de documento</a>
                </th>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Produtos</a>
                </th>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Órgãos Públicos</a>
                </th>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">Empresas</a>                    
                </th>
                <th class="menuItem" >
                    <a href="GelicServlet?comando=Logout">Trocar usuário</a>
                </th>                
                
            </tr>        
        </table>
        <p></p>
    </head>
    <body>        
        <table class="cadastro">
            <TH class="cadastro"> LICITAÇÕES ABERTAS</TH>
        </table>
        <table class="cadastro">
            
            <tr class = "cabecalho">
                <td>
                    <b><Center>Número</center></b>
                </td>
                <td>
                    <b><Center>Tipo</center></b>
                </td>
                <td>
                    <b><Center>Modalidade</center></b>
                </td>
                <td>
                    <b><Center>Processo</center></b>
                </td>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
                <tr class="dados">
                    <td>Campo1</td>
                    <td>Campo2</td>
                    <td>Campo3</td>
                    <td>Campo4</td>
                </tr>
            </tr>
        </table>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        
        
        <table>
            <TR>Licitações</TR>
            <TR>Tipos de Licitações</TR>
            <TR>Tipos de Documento</TR>
            <TR>Produtos</TR>
            <TR>Órgãos Público</TR>
            <TR>Empresas</TR>
        </table>
        
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        
        <P class="bemvindo">Bem-vindo, comercial!</P>        
        <P>Se você deseja acessar o cadastro de licitações clique 
            <a href="GelicServlet?comando=CadastroUsuarios">aqui</a>            
        </P>
        
        <P>Se você deseja acessar o cadastro de tipos de licitações clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        
        <P>Se você deseja acessar o cadastro de tipos de documentos clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        
        <P>Se você deseja acessar o cadastro de produtos clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        <P>Se você deseja acessar o cadastro de órgãos públicos clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        <P>Se você deseja acessar o cadastro de empresas clique 
            <a href="GelicServlet?comando=CadastroModalidades">aqui</a>            
        </P>
        <P>Para efetuar logout clique <a href="GelicServlet?comando=Logout"> 
                aqui
            </a>
        </p>
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
        
        
        
    </body>
</html>

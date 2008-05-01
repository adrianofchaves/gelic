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
    <table class="cadastro">
      <TH class="cadastro"> LICITAÇÕES GANHAS</TH>
    </table>
    <table class="cadastro">
      <tr class = "cabecalho">
        <td>Licitação</td>
        <td>Processo</td>
        <td>Sistema</td>
        <td>Órgão</td>
        <td>Lote</td>
        <td>Objeto</td>
        <td>Empresa</td>
        <td>Valor</td>        
      </tr>
        <tr class="dados">
          <td>PE/003/07</td>
          <td>185.148/2007</td>
          <td>Registro de Preços</td>
          <td>CEF/CT</td>
          <td>1</td>
          <td>Mesas e Armários</td>
          <td>Sólio</td>
          <td>150.000,00</td>
        </tr>
        <tr class="dados">
          <td>PE/003/07</td>
          <td>185.148/2007</td>
          <td>Registro de Preços</td>
          <td>CEF/CT</td>
          <td>2</td>
          <td>Cadeiras</td>
          <td>Werolli</td>
          <td>300.000,00</td>
        </tr>
    </table>
    <font class="mensagem">
      <P>${sessionScope.browserLicitacoes.mensagem}</P>
    </font>        
    </body>
</html>
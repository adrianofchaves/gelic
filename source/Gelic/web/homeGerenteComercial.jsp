<%-- 
    Document   : homeGerenteComercial
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
        <title>GELIC--Gerente Comercial</title>
       <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">Trocar usuario</a>
                </th>                
            </tr>        
        </table>
    </head>
    <body>
    <table class="cadastro">
      <TH class="cadastro"> LICITAÇÕES PARTICIPADAS</TH>
    </table>
    <table class="cadastro">
      <tr class = "cabecalho">
        <td>Licitação</td>
        <td>Processo</td>
        <td>Sistema</td>
        <td>Empresas</td>
        <td>Órgão</td>
        <td>Objeto</td>
      </tr>
        <tr class="dados">
            <td><a href="teste.jsp">
            PE/003/07</a></td>
          <td>185.148/2007</td>
          <td>Registro de Preços</td>
          <td>Sólio<br>Tecnitubo<br>Savordelli<br>Werolli</td>
          <td>CEF/CT</td>
          <td>Cadeiras</td>
        </tr>
        <tr class="dados">
          <td>PP/028/07</td>
          <td>235.963/2007</td>
          <td>Registro de Preços</td>
          <td>Tecnitubo<br>Primomondo</td>
          <td>CEF/RJ</td>
          <td>Mesas e Armários</td>
        </tr>
        <tr class="dados">
          <td>PE/001/08</td>
          <td>000.256/2008</td>
          <td>Fornecimento</td>
          <td>Global<br>Scheffer</td>
          <td>CEF/DF</td>
          <td>Arquivos de aço</td>
        </tr>
        <tr class="dados">
          <td>TP/055/07</td>
          <td>985.635/2007</td>
          <td>Fornecimento</td>
          <td>Casa Cruz</td>
          <td>CEF/SP</td>
          <td>Papel A4</td>
        </tr>
    </table>
    <font class="mensagem">
      <P>${sessionScope.browserLicitacoes.mensagem}</P>
    </font>        
    </body>
</html>
<%-- 
    Document   : browserContratos
    Created on : 02/05/2008, 20:09:43
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Analista</title>
       <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="homeAnalista.jsp">Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">Trocar usuario</a>
                </th>                
            </tr>        
        </table>
    </head>
    <body>
    <table class="cadastro">
      <TH class="cadastro"> CONTRATOS ASSINADOS</TH>
    </table>
    <table class="cadastro">
      <tr class = "cabecalho">
        <td>Licitação</td>
        <td>Sistema</td>
        <td>Órgão</td>
        <td>Contrato</td>
        <td>Assinatura</td>
        <td>Objeto</td>
        <td>Empresa</td>
        <td>Valor</td>        
      </tr>
        <tr class="dados">
          <td>PE/018/07</td>
          <td>Registro de Preços</td>
          <td>CEF/CT</td>
          <td>135/2007</td>
          <td>01/04/2007</td>
          <td>Mesas e Armários</td>
          <td>Sólio Comercial Brasileira Ltda.</td>
          <td>1.456.185,00</td>
        </tr>
        <tr class="dados">
          <td>TP/125/06</td>
          <td>Fornecimento</td>
          <td>CEF/RJ</td>
          <td>1.234/06</td>
          <td>20/12/06</td>
          <td>Arquivos de aço</td>
          <td>Scheffer Ind. Metalurgica S/A</td>
          <td>256.830,00</td>
        </tr>
    </table>
    <font class="mensagem">
      <P>${sessionScope.browserContratos.mensagem}</P>
    </font>        
    </body>
</html>
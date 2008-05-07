<%-- 
    Document   : browserOFM
    Created on : 07/05/2008, 19:16:50
    Author     : gustavo
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
                <th class="menuItem" ><a href="testeContrato.jsp">Voltar</a></th>
                <th class="menuItem" ><a href="homeAnalista.jsp">Gerar Pedido Mãe</a></th>
                <th class="menuItem" ><a href="formOFM.jsp">Incluir OFM</a></th>
                <th class="menuItem" ><a href="browserOFM.jsp">Exibir OFM</a></th>
                <th class="menuItem" ><a href="Gelic?comando=Logout">Trocar usuario</a>                        
                </th>
            </tr>        
        </table>
    </head>
    <body>
    <table class="cadastro">
      <TH class="cadastro"> Pregão Eletronico nº 002-7051/05 CEF/BH</TH>
    </table>
    <table class="cadastro">
          <tr>
              <td>Contrato nº</td>
              <td> 135/2006 </td>
          </tr>
          <tr>
              <td>Processo nº</td>
              <td> 1804.7555.896/2006 </td>
          </tr>
          <tr>
              <td>Assinatura</td>
              <td>16/06/2006</td>              
          </tr>
          <tr>
              <td>Vigencia</td>
              <td>16/06/2007</td>              
          </tr>
          <tr>
              <td>Empresa</td>
              <td>Tecnitubo Indústria de Móveis Ltda.</td>              
          </tr>
          <tr>
              <td>Fornecedor</td>
              <td>Tecnitubo Indústria de Móveis Ltda.</td>              
          </tr>
    </table>
    <p>
    
    <table class="cadastro">
           <th class="cadastro"> PEDIDOS </th>
    </table>
    
    <p>
    <table>
       <tr class="contrato">
           <th>UF</th>
           <th>MUN</th>
           <th>Agencias</th>
           <th>MI1</th>
           <th>MI2</th>
           <th>MI3</th>
           <th>AP1</th>
           <th>AP2</th>
           <th>ST</th>
           <th>SV</th>
           <th>Valor</th>
           <th>OFM</th>
           <th>Data</th>
           <th>Limite</th>
           <th>Emissao</th>
           <th>NFV</th>
           <th>Emissao</th>
           <th>NFR</th>
           <th>AF</th>
           <th>N</th>
       </tr>
       <tr class="contrato">
           <td>MG</td>
           <td>Belo Horizonte</td>
           <td>Juiz de Fora</td>
           <td>0</td>
           <td>19</td>
           <td>7</td>
           <td>0</td>
           <td>0</td>
           <td>5</td>
           <td>0</td>
           <td>15.977,97</td>
           <td>002.1</td>
           <td>07/07/06</td>
           <td>06/08/06</td>
           <td>21/07/06</td>
           <td>33.360</td>
           <td>21/07/06</td>
           <td>33.361</td>
           <td>740</td>
           <td>1</td>
       </tr>
       <tr class="contrato">
           <td>MG</td>
           <td>Belo Horizonte</td>
           <td>Olegario Maciel</td>
           <td>0</td>
           <td>5</td>
           <td>0</td>
           <td>0</td>
           <td>13</td>
           <td>0</td>
           <td>0</td>
           <td>4.396,76</td>
           <td>002.1</td>
           <td>07/07/06</td>
           <td>06/08/06</td>
           <td>21/07/06</td>
           <td>33.407</td>
           <td>21/07/06</td>
           <td>33.408</td>
           <td>740</td>
           <td>2</td>
       </tr>       
    </table>
    </body>
</html>
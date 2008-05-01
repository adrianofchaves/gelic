<%-- 
    Document   : teste
    Created on : 26/04/2008, 12:01:27
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
        <title>GELIC--Gerente Comercial</title>
       <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>        
        <table class="menu">
            <tr>
                <th class="menuItem" ><a href="homeGerenteComercial.jsp">Voltar</a></th>
                <th class="menuItem" ><a href="Gelic?comando=Logout">Trocar usuario</a>                        
                </th>
            </tr>        
        </table>
    </head>
    <body>
    <table class="cadastro">
      <TH class="cadastro"> Pregão Eletronico nº 003/07 CEF/CT</TH>
    </table>
    <table class="cadastro">
      <tr class = "cabecalho">
        <td>Empresa</td>
        <td>Lote</td>
        <td>ValorTotalProposta</td>
        <td>Status</td>
      </tr>
        <tr class="dados">
          <td>SÓLIO</td>
          <td>1</td>
          <td>150.000,00</td>
          <td> 
          <select name="status" 
                  class="tabelaCadastro">
            <option>Ganha</option>
            <option>Perdida</option>
            <option>Encerrada</option>                    
          </select>
          </td>
        </tr>
        <tr class="dados">
          <td>TECNITUBO</td>
          <td>1</td>
          <td>180.000,00</td>
          <td> 
          <select name="status" 
                  class="tabelaCadastro">
            <option>Ganha</option>
            <option>Perdida</option>
            <option>Encerrada</option>                    
          </select>
          </td>
        </tr>
        <tr class="dados">
          <td>SAVORDELLI</td>
          <td>2</td>
          <td>256.350,00</td>
          <td> 
          <select name="status" 
                  class="tabelaCadastro">
            <option>Ganha</option>
            <option>Perdida</option>
            <option>Encerrada</option>                    
          </select>
          </td>
        </tr>
        <tr class="dados">
          <td>WEROLLI</td>
          <td>2</td>
          <td>300.000,00</td>
          <td> 
          <select name="status" 
                  class="tabelaCadastro">
            <option>Ganha</option>
            <option>Perdida</option>
            <option>Encerrada</option>                    
          </select>
          </td>
        </tr>
    </table>
    <p>
          <input class="botao" type="submit" value="Salvar" name="executar"/>
          <INPUT class="botao" TYPE="submit" value="Cancelar" name="cancelar"/>            
    <font class="mensagem">
      <P>${sessionScope.browserLicitacoes.mensagem}</P>
    </font>        
    </body>
</html>
<%-- 
    Document   : browserEmpresas
    Created on : 26/03/2008, 12:56:18
    Author     : adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Cadastro de empresas</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <th class="menuItem" >
        <a href="homeComercial.jsp">
        Voltar</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=NovaEmpresa">
        Nova empresa</a>                    
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">
        Trocar usuário</a>                    
      </th>
    </table>
    
  </head>
  <body>    
    <table class="cadastro"><TH class="cadastro">Empresas</TH></TABLE>
    <table class="cadastro">
      <tr class="cabecalho">
        <td>Nome</td>
        <td>CNPJ</td>
        <td>Endereço</td>
        <td>Telefone</td>
        <TD> </TD>
      </tr>
      <c:forEach 
        var="empresa" 
        items="${sessionScope.browserEmpresas.empresas}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarEmpresa&cnpj=${empresa.cnpj}">
              ${empresa.nomeFantasia}
            </a>                        
          </td>                    
          <td>
            ${empresa.cnpj}
          </td>                    
          <td>
            ${empresa.endereco}
          </td>                    
          <td>
            ${empresa.endereco.telefone}
          </td>                    
          <td>
            <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>
      
      
      
      
    </table>        
    <font class="mensagem">
      <P>${sessionScope.browserEmpresas.mensagem}</P>
    </font>
  </body>
</html>
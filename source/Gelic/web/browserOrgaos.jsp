<%-- 
    Document   : browserOrgaos
    Created on : 29/03/2008, 17:55:13
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC--Cadastro de Órgãos Públicos</title>          
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu"><tr>
        <th class="menuItem" >
          <a href="homeComercial.jsp">
          Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Comercial?comando=NovoOrgao">
          Novo Órgão</a>                    
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">
          Trocar usuário</a>                    
        </th>
    </tr></table> 
    
  </head>
  <body>    
    <table class="cadastro"><TH class="cadastro">Órgãos Publicos</TH></TABLE>
    <table class="cadastro">            
      <tr class="cabecalho">
        <td>CNPJ</td>
        <td>Apelido</td>
        <td>Telefone</td>
        <TD> </TD>
      </tr>
      <c:forEach 
        var="orgao" 
        items="${sessionScope.browserOrgaos.orgaos}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarOrgao&cnpj=${orgao.cnpj}">
              ${orgao.cnpj}                            
            </a>                        
          </td>
          <td>
            ${orgao.apelido}                        
          </td>
          <td>
            ${orgao.endereco.telefone}            
          </td>
          <td>
            <a href="Comercial?comando=ExcluirOrgao&cnpj=${orgao.cnpj}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>        
    
      <P class="mensagem">${sessionScope.browserOrgaos.mensagem}</P>
    
  </body>
</html>
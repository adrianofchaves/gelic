<%-- 
    Document   : formProposta
    Created on : 05/06/2008, 12:24:44
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
    <title>GELIC--Cadastro de Propostas</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <th class="menuItem" >
        <a href="${sessionScope.formProposta.origem.nome}">Voltar</a>
      </th>
      <th class="menuItem" >
        <a href="homeComercial.jsp">Início</a>
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">Trocar usuário</a>                    
      </th>
    </table>
  </head>
  <body>
    <form name="frmProposta" action="Comercial?comando=GravarProposta" 
          method="POST">
      <p class="caption">${sessionScope.formProposta.titulo}</p>            
      
      <c:forEach var="erro" items="${sessionScope.formProposta.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           
      
      <P>
        Empresa: <BR>
        <select name="empresaProposta" class="cadastro" style = "width:40%"
                <c:if test="${sessionScope.formProposta.exclusao}">disabled</c:if>
                >
                <c:forEach var="empresa" 
                           items="${sessionScope.formProposta.empresas}">
                  <option 
                  <c:if test="${empresa==sessionScope.formProposta.empresaProposta}">
                    selected 
                  </c:if> >${empresa}</option>
          </c:forEach>
        </select>
      </P>
      
      <table style="width: 90%">
        <th style="width: 10%"></th>
        <th style="width: 10%" align="left">Item</th>
        <th style="width: 60%" align="left">Produto</th>
        <th style="width: 20%" align="left">Quantidade</th>
        <th style="width: 20%" align="left">Preço</th>
        <c:forEach var="item" items="${sessionScope.formProposta.itens}">
          <tr>
            <td style="width: 10%"></td>
            <td>${item.itemLote.numero}</td>
            <td>${item.itemLote.produto}</td>
            <td>${item.itemLote.quantidade}</td>
            <td><input type="text" name="${item.nome}" value="${item.valor}"
                       maxlength=30
                       <c:if test="${sessionScope.formProposta.exclusao}">
                         disabled
                       </c:if>         
                       />
                       </td>
          </tr>
          <tr>            
            <td></td><td></td><td></td>
            <td class="tabelaErro">${item.erro}</td>
          </tr>
        </c:forEach>
      </table>
      <p>
        <c:if test="${!sessionScope.formProposta.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>        
        <c:if test="${sessionScope.formProposta.exclusao}">
          <input class="botao" type="submit" value="Excluir" name="excluir"/>
        </c:if>               
        <INPUT class="botao" TYPE="submit" value="Cancelar" name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
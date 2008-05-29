<%-- 
    Document   : formLote
    Created on : 29/05/2008, 13:48:49
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <link rel="STYLESHEET" href="estilos.css" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>GELIC--Lotes de Licitação</title>  
  <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
  
  <table class="menu">
    <tr>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroLotes">Voltar</a>
      </th>                             
      <th class="menuItem" >
        <a href="homeComercial.jsp">Início</a>
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">Trocar usuário</a>                    
      </th>
    </tr>
  </table>
</head>
<body>
<form name="formLote" action="Comercial?comando=GravarLote"  method="POST">
<p class="caption">${sessionScope.formLote.titulo}</p>            

<c:forEach var="erro" items="${sessionScope.formLote.erros}">
  <P class="erro" >${erro}</P>
</c:forEach>

<P>
  Número: <BR>
  <input type="text" name="numeroLote" class="caixaTexto"
         value="${sessionScope.formLote.numeroLote}"
         maxlength=30
         <c:if test="${sessionScope.numeroLote.exclusao}">
           disabled
         </c:if>         
         />
         <font class="erroCampo" >
  ${sessionScope.formLote.erroNumeroLote}
  </font>
</P>
<P>
  Nome: <BR>
  <input type="text" name="nomeLote" class="caixaTexto"
         value="${sessionScope.formLote.nomeLote}"
         maxlength=30
         <c:if test="${sessionScope.formLote.exclusao}">
           disabled
         </c:if>         
         />
         <font class="erroCampo" >
  ${sessionScope.formLote.erroNomeLote}
  </font>
</P>


<P>
  <c:if test="${sessionScope.formContato.exclusao}">
    <input class="botao" type="submit" value="Excluir" 
           name="excluir"/>
  </c:if>
  <c:if test="${!sessionScope.formContato.exclusao}">
    <input class="botao" type="submit" value="Salvar" 
           name="executar"/>
  </c:if>
  <INPUT class="botao" TYPE="submit" value="Cancelar" 
         name="cancelar"/>                
</p>
</form>       
</body>
</html>
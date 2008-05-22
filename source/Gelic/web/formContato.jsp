<%-- 
    Document   : formContato
    Created on : 28/03/2008, 12:02:30
    Author     : adriano
--%>

<%-- 
    Document   : formEndereco
    Created on : 28/03/2008, 09:27:07
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
  <title>GELIC--Cadastro de contatos</title>  
  <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
  
  <table class="menu">
    <tr>
      <th class="menuItem" >
        <a href="browserContatos.jsp">Voltar</a>
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
<form name="frmContato" 
      action="Comercial?comando=GravarContato" 
      method="POST">
<p class="caption">
  ${sessionScope.formContato.titulo}
</p>            
<c:forEach var="erro" items="${sessionScope.formContato.erros}">
  <P class="erro" >${erro}</P>
</c:forEach>

<P>
  Nome: <BR>
  <input type="text" name="nomeContato" class="caixaTexto"
         value="${sessionScope.formContato.nomeContato}"
         maxlength=30
         <c:if test="${sessionScope.formContato.exclusao}">
           disabled
         </c:if>         
         />
         <font class="erroCampo" >
  ${sessionScope.formContato.erroNomeContato}
  </font>
</P>

<p class="grupo">Telefone:</p>
<table class = "tabelaCadastro">
  <TD class="tabelaCadastro" style="width: 10%">
    DDI: <BR>
    <input type="text" name="ddiContato" class="tabelaCadastro"
           <c:if test="${sessionScope.formContato.exclusao}">
             disabled
           </c:if>
           value="${sessionScope.formContato.ddiContato}"
           maxlength=3 />
  </TD>
  <TD class="tabelaCadastro" style="width: 10%">
    DDD: <BR>
    <input type="text" name="dddContato" class="tabelaCadastro"
           <c:if test="${sessionScope.formContato.exclusao}">
             disabled
           </c:if>
           value="${sessionScope.formContato.dddContato}"
           maxlength=2 />
  </TD>
  <TD class="tabelaCadastro" style="width: 50%">
    Número: <BR>
    <input type="text" name="numeroTelefoneContato" class="tabelaCadastro"
           <c:if test="${sessionScope.formContato.exclusao}">
             disabled
           </c:if>
           value="${sessionScope.formContato.numeroTelefoneContato}"
           maxlength=8 />
  </TD>
  <TD class="tabelaCadastro" style="width: 30%">
    Ramal: <BR>
    <input type="text" name="ramalContato" class="tabelaCadastro"
           <c:if test="${sessionScope.formContato.exclusao}">
             disabled
           </c:if>
           value="${sessionScope.formContato.ramalContato}"
           maxlength=4 />
  </TD>
</TABLE>
<table class = "tabelaErro">
  <TD class="tabelaErro" style="width:10%" >
    ${sessionEscope.formContato.erroDdiContato}
  </TD>
  <TD class="tabelaErro" style="width:10%" >
    ${sessionEscope.formContato.erroDddContato}
  </TD>
  <TD class="tabelaErro" style="width:50%" >
    ${sessionEscope.formContato.erroNumeroTelefoneContato}
  </TD>
  <TD class="tabelaErro" style="width:10%" >
    ${sessionEscope.formContato.erroRamalContato}
  </TD>
</TABLE>     

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
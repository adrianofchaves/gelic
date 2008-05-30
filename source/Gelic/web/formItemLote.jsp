<%-- 
    Document   : formItemLote
    Created on : 30/05/2008, 14:32:26
    Author     : Adriano
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <link rel="STYLESHEET" href="estilos.css" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>GELIC--Cadastro de Itens de Lote</title>          
  <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
  
  <table class="menu"><tr>
      <th class="menuItem" >
        <a href="${sessionScope.formItemLote.origem.nome}">
        Voltar</a>
      </th>     
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">
        Trocar usuário</a>                    
      </th>
  </tr></table> 
</head>
<body>
<form name="frmItemLote" 
      action="Comercial?comando=GravarItemLote" 
      method="POST">
<p class="caption">
  ${sessionScope.formItemLote.titulo}
</p>
<font class="erro" >
  <c:forEach var="erro" items="${sessionScope.formItemLote.erros}">
    <P>${erro}</P>
  </c:forEach>
</font>

<P>
  Número: <BR>
  <input type="text" name="numeroItemLote" class="caixaTexto"
         value="${sessionScope.formItemLote.numeroItemLote}"
         maxlength=30
         <c:if test="${sessionScope.formItemLote.exclusao}">
           disabled
         </c:if>         
         />
         <font class="erroCampo" >
  ${sessionScope.formItemLote.erroNumeroItemLote}
  </font>
</P>
<P>
  Produto: <BR>
  <select name="produtoItemLote" class="cadastro"
          <c:if test="${sessionScope.formItemLote.exclusao}">
            disabled="disabled"
          </c:if>
          ><c:forEach var="produto" items="${sessionScope.formItemLote.produtos}">
          <option
            <c:if test="${sessionScope.formItemLote.produtoItemLote == produto}">
              selected
            </c:if>
            >${produto}</option>
    </c:forEach>
  </select>  
  
  <font class="erroCampo" >${sessionScope.formItemLote.erroProdutoItemLote}
  </font>
</P>

<P>
  Quantidade: <BR>
  <input type="text" name="quantidadeItemLote" class="caixaTexto"
         value="${sessionScope.formItemLote.quantidadeItemLote}"
         maxlength=30
         <c:if test="${sessionScope.formItemLote.exclusao}">
           disabled
         </c:if>                  />
         <font class="erroCampo" >
  ${sessionScope.formItemLote.erroQuantidadeItemLote}
  </font>
</P>

<P>Preço estimado:<BR>
  <input type="text" name="precoEstimadoItemLote" class="caixaTexto"
         value="${sessionScope.formItemLote.precoEstimadoItemLote}"
         maxlength=30
         <c:if test="${sessionScope.formItemLote.exclusao}">
           disabled
         </c:if> />
         <font class="erroCampo" >
  ${sessionScope.formItemLote.erroQuantidadeItemLote}
  </font>
</P>

<p>
  <c:if test="${sessionScope.formItemLote.exclusao}">
    <input class="botao" type="submit" value="Excluir" 
           name="excluir"/>
  </c:if>
  <c:if test="${!sessionScope.formItemLote.exclusao}">
    <input class="botao" type="submit" value="Salvar" 
           name="executar"/>
  </c:if>
  <INPUT class="botao" TYPE="submit" value="Cancelar" 
         name="cancelar"/>            
</p>
</form>       
</body>
</html>

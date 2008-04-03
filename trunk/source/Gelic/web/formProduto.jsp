<%-- 
    Document   : formProduto
    Created on : 29/03/2008, 11:18:23
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="STYLESHEET" href="estilos.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de Produtos</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="browserProdutos.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Comercial?comando=NovoProduto">
                    Novo Produto</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table> 
    </head>
    <body>
        <form name="frmProduto" 
              action="Comercial?comando=GravarNovoProduto" 
              method="POST">
        <p class="caption">
            <c:if test="${!sessionScope.formProduto.inclusao}">
                Alterando produto:
            </c:if>
            <c:if test="${sessionScope.formProduto.inclusao}">
                Novo produto:
            </c:if>
        </p>
            <font class="erro" >
                <c:forEach var="erro" items="${sessionScope.formProduto.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>

      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:20%">
          Código:<BR>                    
          <input type="text" name="codigoProduto" 
                 class="tabelaCadastro" 
                 value="${sessionScope.formProduto.codigoProduto}" />
        </td>
        <td class="tabelaCadastro" style="width:80%;">
          Descrição:
          <input type="text" name="descricaoProduto"
                 class="tabelaCadastro"
                 value="${sessionScope.formProduto.descricaoProduto}" /> 
          
        </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formProduto.erroCodigoProduto}
        </td>
        <td class="tabelaErro" style="width:80%">
          ${sessionScope.formProduto.erroDescricaoProduto}
        </td>
      </table>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:50%">
          Preço de Venda:<BR>
          <input type="text" name="precovendaProduto"
                 class="tabelaCadastro"
                 value="${sessionScope.formProduto.precovendaProduto}"/>
        </td>
        <td class="tabelaCadastro" style="width:50%;">
          Preço de Compra
          <input type="text" name="precocompraProduto"
                 class="tabelaCadastro"
                 value="${sessionScope.formProduto.precocompraProduto}" />
          
        </td>
      </table>
      
            <p>
        <input class="botao" type="submit" value="Salvar" 
               name="executar"/>
        <input class="botao" type="submit" value="Excluir" 
               name="excluir"/>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>            
            </p>
        </form>       
    </body>
</html>

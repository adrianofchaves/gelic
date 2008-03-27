<%-- 
    Document   : browserProdutos
    Created on : 26/03/2008, 23:40:43
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
        <title>GELIC--Cadastro de Produtos</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="homeComercial.jsp">
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
        <table class="cadastro"><TH class="cadastro">Produtos</TH></TABLE>
        <table class="cadastro">            
            <tr class="cabecalho">
                <td>Codigo</td>
                <td>Descricao</td>
                <td>Preço Venda</td>
                <td>Preço Compra</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="produto" 
                items="${sessionScope.browserProdutos.produtos}">                
                <tr class="dados">
                    <td>
                        <a href="Gelic?comando=AlterarProduto&id=${produto.id}">
                            ${produto.id}    
                        </a>                        
                    </td>
                    <td>
                        ${produto.codigo}
                    </td>  
                    <td>
                        <a href="Gelic?comando=ExcluirProduto&usuario=${produto.id}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>        
        <font class="mensagem">
            <P>${sessionScope.browserProdutos.mensagem}</P>
        </font>
    </body>
</html>
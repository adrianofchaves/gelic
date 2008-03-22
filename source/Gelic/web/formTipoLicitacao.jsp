<%-- 
    Document   : formTipoLicitacao
    Created on : 15/03/2008, 01:18:51
    Author     : Adriano
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="STYLESHEET" href="estilos.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de tipos de licitação</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Comercial?comando=CadastroTiposLicitacoes">Voltar</a>
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
        <form name="frmTipoLicitacao" 
              action="Comercial?comando=GravarTipoLicitacao" 
              method="POST" accept-charset="utf-8">
            <p class="caption">
                <c:if test="${!sessionScope.formTipoLicitacao.inclusao}">
                    Alterando tipo de licitação
                </c:if>
                <c:if test="${sessionScope.formTipoLicitacao.inclusao}">
                    Novo tipo de licitação
                </c:if>
            </p>
            <font class="erro" >
                <c:forEach var="erro" 
                           items="${sessionScope.formTipoLicitacao.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>
            
            
            <P>Nome:<br>
                <input type="text" name="nomeTipoLicitacao" class="caixaTexto"
                       value="${sessionScope.formTipoLicitacao.nomeTipoLicitacao}" />
                <font class="erroCampo" >
                    ${sessionScope.formTipoLicitacao.erroNomeTipoLicitacao}
                </font>
            </P>            
            <P>Sigla:<br>
                <input type="text" name="siglaTipoLicitacao" class="caixaTexto"
                       value="${sessionScope.formTipoLicitacao.siglaTipoLicitacao}" />
                <font class="erroCampo" >
                    ${sessionScope.formTipoLicitacao.erroSiglaTipoLicitacao}
                </font>
            </P>            
            <p>
                <input class="botao" type="submit" value="Gravar" 
                       name="executar"/>
                <INPUT class="botao" TYPE="submit" value="Cancelar" 
                       name="cancelar"/>                
            </p>
        </form>       
    </body>
</html>

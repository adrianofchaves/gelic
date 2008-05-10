<%-- 
    Document   : formModalidade
    Created on : 09/03/2008, 11:48:24
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
        <title>GELIC--Cadastro de usuários</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Gelic?comando=CadastroModalidades">Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="homeAdministrador.jsp">Início</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">Trocar usuário</a>                    
                </th>
            </tr>
        </table>
    </head>
    <body>
        <form name="frmModalidade" 
              action="Gelic?comando=GravarModalidade" 
              method="POST">
        <p class="caption">
        <c:if test="${sessionScope.formModalidade.alteracao}">
          Alterando Modalidade
        </c:if>
        <c:if test="${sessionScope.formModalidade.exclusao}">
          Excluindo Modalidade
        </c:if>
        <c:if test="${sessionScope.formModalidade.inclusao}">
          Nova Modalidade
        </c:if>
        </p>
            <font class="erro" >
                <c:forEach var="erro" items="${sessionScope.formModalidade.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>
            
            <P>Sigla:<br>
                <input type="text" name="siglaModalidade" class="caixaTexto"
                       <c:if test="${sessionScope.formModalidade.exclusao}">
                            disabled
                       </c:if>
                       value="${sessionScope.formModalidade.siglaModalidade}" />
                <font class="erroCampo" >
                    ${sessionScope.formModalidade.erroSiglaModalidade}
                </font>
            </P>
            <P>Nome:<br>
                <input type="text" name="nomeModalidade" class="caixaTexto"
                       <c:if test="${sessionScope.formModalidade.exclusao}">
                            disabled
                       </c:if>
                       value="${sessionScope.formModalidade.nomeModalidade}" />
                <font class="erroCampo" >
                    ${sessionScope.formModalidade.erroNomeModalidade}
                </font>
            </P>            
            <p>
        <c:if test="${sessionScope.formModalidade.exclusao}">
          <input class="botao" type="submit" value="Excluir" 
                 name="excluir"/>
        </c:if>
        <c:if test="${!sessionScope.formModalidade.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>
          <input class="botao" TYPE="submit" value="Cancelar" 
                 name="cancelar"/>                
            </p>
        </form>       
    </body>
</html>

<%-- 
    Document   : formTipoDocumento
    Created on : 22/03/2008, 14:39:51
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
        <title>GELIC--Cadastro de tipos de documentos</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Comercial?comando=CadastroTiposDocumentos">
                        Voltar
                    </a>
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
        <form name="frmTipoDocumento" 
              action="Comercial?comando=GravarTipoDocumento" 
              method="POST" accept-charset="utf-8">
            <p class="caption">
                <c:if test="${!sessionScope.formTipoDocumento.inclusao}">
                    Alterando tipo de documento
                </c:if>
                <c:if test="${sessionScope.formTipoDocumento.inclusao}">
                    Novo tipo de documento
                </c:if>
            </p>
            
            <c:forEach var="erro" 
                       items="${sessionScope.formTipoDocumento.erros}">
                <P class="erro">${erro}</P>
            </c:forEach>
            
            
            
            <P>Nome:<br>
                <input type="text" name="nomeTipoDocumento" class="caixaTexto"
                  value="${sessionScope.formTipoDocumento.nomeTipoDocumento}" />
                <font class="erroCampo" >
                    ${sessionScope.formTipoDocumento.erroNomeTipoDocumento}
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

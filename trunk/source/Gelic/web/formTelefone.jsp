<%-- 
    Document   : formTelefone
    Created on : 28/03/2008, 09:16:41
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
        <title>GELIC--Cadastro de sistemas</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="formEmpresa.jsp">Voltar</a>
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
        <form name="frmTelefone" 
              action="Gelic?comando=GravarTelefone" 
              method="POST">
            <p class="caption">
                <c:if test="${!sessionScope.formSistema.inclusao}">
                    Telefone da empresa "Nasajon Sistemas"
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Telefone da empresa "Nasajon Sistemas"
                </c:if>
            </p>            
            <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>
            
            <P>
                DDI: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                DDD: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Número: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Ramal: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
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
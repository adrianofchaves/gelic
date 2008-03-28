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
        <form name="frmEndereco" 
              action="Gelic?comando=GravarTelefone" 
              method="POST">
            <p class="caption">
                <c:if test="${!sessionScope.formSistema.inclusao}">
                    Endereço da empresa "Nasajon Sistemas"
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Endereço da empresa "Nasajon Sistemas"
                </c:if>
            </p>            
            <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>
            
            <P>
                Tipo<BR>
                <select name="tipoLogradouroEmpresa"
                        class="caixaTexto"
                        value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                    <option>Rua</option>
                    <option>Praça</option>
                    <option>Avenida</option>                    
                </select>
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                </font>
            </P>
            <P>
                Logradouro: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Numero: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            
            <P>
                Complemento: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Bairro: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Cidade: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Estado<BR>
                <select name="tipoLogradouroEmpresa" 
                        class="caixaTexto"
                        value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                    <option>RJ</option>
                    <option>SP</option>
                    <option>BA</option>                    
                </select>
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                </font>
            </P>
            <P>
                CEP: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Site: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                email: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
        </form>       
    </body>
</html>
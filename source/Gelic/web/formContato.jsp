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
        <title>GELIC--Cadastro de sistemas</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="browserContatos.jsp">Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="formTelefone.jsp">Telefone</a>
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
              action="Gelic?comando=GravarContato" 
              method="POST">
            <p class="caption">
                <c:if test="${!sessionScope.formSistema.inclusao}">
                    Incluindo contato na empresa "Nasajon Sistemas"
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Alterando contatado da empresa "Nasajon Sistemas"
                </c:if>
            </p>            
            <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>
            
            <P>
                Nome: <BR>
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
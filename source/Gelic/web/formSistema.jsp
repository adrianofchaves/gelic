<%-- 
    Document   : formSistema
    Created on : 21/03/2008, 23:48:55
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
        <title>GELIC--Cadastro de sistemas</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="Gelic?comando=CadastroSistemas">Voltar</a>
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
        <form name="frmSistema" 
              action="Gelic?comando=GravarSistema" 
              method="POST">
            <p class="caption">
                <c:if test="${sessionScope.formSistema.alteracao}">
                    Alterando sistema
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Novo sistema:
                </c:if>
                <c:if test="${sessionScope.formSistema.exclusao}">
                    Excluindo sistema:
                </c:if>
                
            </p>            
            <c:forEach var="erro" items="${sessionScope.formSistema.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>           
            
            <P>Nome:<br>
                <input type="text" name="nomeSistema" class="caixaTexto"
                       <c:if test="${sessionScope.formSistema.exclusao}">
                            disabled
                       </c:if>
                       value="${sessionScope.formSistema.nomeSistema}" />
                <font class="erroCampo" >
                    ${sessionScope.formSistema.erroNomeSistema}
                </font>
            </P>
            <p>
        <c:if test="${sessionScope.formSistema.exclusao}">
          <input class="botao" type="submit" value="Excluir" 
                 name="excluir"/>
        </c:if>
        <c:if test="${!sessionScope.formSistema.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>
          <input class="botao" TYPE="submit" value="Cancelar" 
                 name="cancelar"/>                
            </p>
        </form>       
    </body>
</html>

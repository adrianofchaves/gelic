<%-- 
    Document   : cadastroUsuarios
    Created on : 02/03/2008, 12:24:24
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de usuários</h1>
        <P> Os usuários cadastrados são:
        <table>
            <tr bgcolor="gray">
                <td align="center">Login</td>
                <td align="center">Papel</td>
            </tr>
            <c:forEach var="usuario" items="${sessionScope.browserUsuarios.usuarios}">
            
                <tr>
                    <td>
                        <a href="GelicServlet?comando=AlterarUsuario&login=${usuario.login}">
                            ${usuario.login}    
                        </a>                        
                    </td>
                    <td>
                        ${usuario.papel.nome}
                    </td>  
                    <td>
                        <a href="GelicServlet?comando=ExcluirUsuario&usuario=${usuario.login}">
                            <img src="img/trash.PNG" width="16" height="16" alt="trash"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>
        <BR><BR>
        <c:if test="${!sessionScope.formUsuario.inclusao}">
            <H3>Alterando usuário: </H3>
        </c:if>
        <c:if test="${sessionScope.formUsuario.inclusao}">
            <H3>Criando usuário:</H3>
        </c:if>
        
        <font color="red">
        <c:forEach var="erro" items="${sessionScope.formUsuario.erros}">
            <P>${erro}</P>
        </c:forEach>
        </font>
        
        <form name="frmusuario" action="GelicServlet?comando=GravarUsuario" 
              method="POST">
            <P>Login:
                <input type="text" name="loginUsuario" 
                       value="${sessionScope.formUsuario.loginUsuario}" />
                <font color="red">
                    ${sessionScope.formUsuario.erroLoginUsuario}
                </font>
            </P>
            <P>Senha:
                <input type="password" name="senhaUsuario" 
                       value="${sessionScope.formUsuario.senhaUsuario}" />
                <font color="red">
                    ${sessionScope.formUsuario.erroSenhaUsuario}
                </font>
            </P>
            <P>Confirme a senha:
                <input type="password" name="confirmaSenhaUsuario" 
                       value="${sessionScope.formUsuario.confirmaSenhaUsuario}" 
                       />
                <font color="red">
                    ${sessionScope.formUsuario.erroConfirmaSenhaUsuario}
                </font>
            </P>
            <P>Selecione o papel que o usuário:
                <select name="papelUsuario" 
                        tabindex="${sessionScope.formUsuario.idPapel}" >
                    <c:forEach var="papel" items="${applicationScope.papeis}">
                        <option>${papel.nome}</option>                
                    </c:forEach>    
                </select>
                <font color="red">
                    ${sessionScope.formUsuario.erroPapelUsuario}
                </font>
            </P>
            <input type="submit" value="Gravar" name="executar"/>            
        </form>
        <P>
            Para voltar ao início clique <a href="homeAdministrador.jsp">aqui</a>
        </P>        
    </body>
</html>

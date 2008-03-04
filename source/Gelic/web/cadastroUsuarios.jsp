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
        <h2>Cadastro de usuários</h2>
        <P> Os usuários cadastrados são:
        <table>
            <tr bgcolor="gray">
                <td align="center">Login</td>
                <td align="center">Papel</td>
            </tr>
            <c:forEach var="usuario" items="${requestScope.usuarios}">
            
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
        <H3>        
            Cadastro do usuário:
        </H3>
        <P>Para cadastrar um novo usuário preencha os campos abaixo:</P>
        <form name="frmusuario" action="GelicServlet?comando=GravarUsuario" method="POST">
            <P>Login:
                <input type="text" name="nomeUsuario" value="${formUsuario.nome}" />
            </P>
            <P>Senha:
                <input type="password" name="senhaUsuario" value="${formUsuario.senhaUsuario}" />
            </P>
            <P>Confirme a senha:
                <input type="password" name="confirmaSenhaUsuario" value="${formUsuario.confirmaSenhaUsuario}" />
            </P>
            <P>Selecione o papel que o usuário irá exercer:
                <select name="papelUsuario">
                    <c:forEach var="papel" items="${applicationScope.papeis}">
                        <option>${papel.nome}</option>                
                    </c:forEach>    
                </select>
            </P>
            <input type="submit" value="Gravar" name="executar" />
        </form>
    </body>
</html>

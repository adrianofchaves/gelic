<%-- 
    Document   : cadastroUsuarios
    Created on : 02/03/2008, 12:24:24
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de usuários</h2>
        <table>
            <tr>
                <td>Login</td>
                <td>Papel</td>
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
        
        <form name="frmusuario" action="GelicServlet?comando=GravarUsuario" method="POST">
            <input type="text" name="nomeUsuario" value="${formUsuario.nome}" />
            <input type="password" name="senhaUsuario" value="${formUsuario.senhaUsuario}" />
            <input type="password" name="confirmaSenhaUsuario" value="${formUsuario.confirmaSenhaUsuario}" />
            <select name="papelUsuario">
                <c:forEach var="papel" items="${applicationScope.papeis}">
                <option>${papel.nome}</option>
                </c:forEach>    
            </select>
            <input type="submit" value="Gravar" name="executar" />
        </form>
    </body>
</html>

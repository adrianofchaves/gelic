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
                        ${usuario.login}
                    </td>
                    <td>
                       ${usuario.papel.nome}
                    </td>
                    <td>
                        <a href="GelicServlet?comando=ExcluirUsuario&usuario=${usuario.login}">Excluir</a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>

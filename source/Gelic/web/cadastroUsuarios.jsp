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
        <title>GELIC--Cadastro de usuários</title>  
        
        <H1 STYLE="font-family: Arial,Helvetica,sans-serif;
            background-color: #3300cc;
            background-position: right;
            color: silver;
            font-style: oblique;
            font-weight: 900;
            font-variant: small-caps;
            font-size: XX-large;
            text-align: right;
        ">GELIC</H1>        
    </head>
    <body>
        <h1>Cadastro de usuários</h1>       
        <table>
            <tr  style="font-variant: small-caps;
                 font-weight: bold;
                 color: #ffffff;
                 background-color: #3300cc;
                 border-bottom-style: solid;
                 border-bottom-width: 1px;">
                <td>Login</td>
                <td>Papel</td>
            </tr>
            <c:forEach 
                var="usuario" 
                items="${sessionScope.browserUsuarios.usuarios}">                
                <tr 
                    style="font-size: small;
                    background-color: #fbfbec;
                    font-family: Arial,Helvetica,sans-serif;
                    color: #6e6c6c;">
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
        <font color="blue">
            <P>${sessionScope.browserUsuarios.mensagem}</P>
        </font>
        <form name="frmusuario" 
              style="background-color: #fbfbec;"
              action="GelicServlet?comando=GravarUsuario" 
              method="POST">
            <h2 style="background-color: #3300cc;
                font-style: oblique;
                color: #ffffff;
                font-weight: bold;
                font-variant: small-caps;">
                <c:if test="${!sessionScope.formUsuario.inclusao}">
                    Alterando usuário:
                </c:if>
                <c:if test="${sessionScope.formUsuario.inclusao}">
                    Criando usuário:
                </c:if>
            </H2>
            <font style="background-color: #fbfbec;color: red;">
                <c:forEach var="erro" items="${sessionScope.formUsuario.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>
            
            <P>Login:<br>
                <input type="text" name="loginUsuario" 
                       value="${sessionScope.formUsuario.loginUsuario}" />
                <font style="background-color: #fbfbec;color: red;">
                    ${sessionScope.formUsuario.erroLoginUsuario}
                </font>
            </P>
            <P>Senha:<br>
                <input type="password" name="senhaUsuario" 
                       value="${sessionScope.formUsuario.senhaUsuario}" />
                <font style="background-color: #fbfbec;color: red;">
                    ${sessionScope.formUsuario.erroSenhaUsuario}
                </font>
            </P>
            <P>Confirme a senha:<br>
                <input type="password" name="confirmaSenhaUsuario" 
                       value="${sessionScope.formUsuario.confirmaSenhaUsuario}" 
                       />
                <font style="background-color: #fbfbec;color: red;">
                    ${sessionScope.formUsuario.erroConfirmaSenhaUsuario}
                </font>
            </P>
            <P>Selecione o papel que o usuário:<BR>
                <select name="papelUsuario" 
                        tabindex="${sessionScope.formUsuario.idPapel}" >
                    <c:forEach var="papel" items="${applicationScope.papeis}">
                        <option>${papel.nome}</option>                
                    </c:forEach>    
                </select>
                <font style="background-color: #fbfbec;
                      color: red;">
                        ${sessionScope.formUsuario.erroPapelUsuario}
                </font>
            </P>
            <p>
                <input type="submit" value="Gravar" name="executar"/>
                <c:if test="${!sessionScope.formUsuario.inclusao}">
                    <INPUT TYPE="submit" value="Cancelar" name="cancelar"/>
                </c:if>
            </p>
        </form>
        <P>
            Para voltar ao início clique <a href="homeAdministrador.jsp">aqui</a>
        </P>        
    </body>
</html>

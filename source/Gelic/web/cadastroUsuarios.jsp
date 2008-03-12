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
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Cadastro de usuários</title> 
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>
    </head>
    <body>  
        <P class="caption" >Cadastro de usuários</P>    
        <table>             
            <tr class="cabecalho">
                <td>Login</td>
                <td>Papel</td>
                <TD> </TD>
            </tr>
            <c:forEach 
                var="usuario" 
                items="${sessionScope.browserUsuarios.usuarios}">                
                <tr class="dados">
                    <td>
                        <a href="GelicServlet?comando=AlterarUsuario&login=${usuario.login}">
                            ${usuario.login}    
                        </a>                        
                    </td>
                    <td>
                        ${usuario.papel.nome}
                    </td>  
                    <td>
                        <a href="GelicServlet?comando=
                           ExcluirUsuario&usuario=${usuario.login}">
                            <img src="img/trash.PNG" width="16" height="16" 
                                 alt="excluir"/>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>        
        <P>
            <font class="mensagem">
                ${sessionScope.browserUsuarios.mensagem}
            </font>
        </P>
        <form name="frmusuario" 
              action="GelicServlet?comando=GravarUsuario" 
              method="POST">
            <p class="caption">            
                <c:if test="${!sessionScope.formUsuario.inclusao}">
                    Alterando usuário:
                </c:if>
                <c:if test="${sessionScope.formUsuario.inclusao}">
                    Criando usuário:
                </c:if>
            </p>
            <font class = "erro">
                <c:forEach var="erro" items="${sessionScope.formUsuario.erros}">
                    <P>${erro}</P>
                </c:forEach>
            </font>    
            <P>Login:<br>
                <input type="text" name="loginUsuario" class = "caixaTexto"
                       value="${sessionScope.formUsuario.loginUsuario}" />
                <font class="erroCampo">
                    ${sessionScope.formUsuario.erroLoginUsuario}
                </font>
            </P>
            <P>Senha:<br>
                <input type="password" name="senhaUsuario" class = "caixaTexto"
                       value="${sessionScope.formUsuario.senhaUsuario}" />
                <font class="erroCampo">
                    ${sessionScope.formUsuario.erroSenhaUsuario}
                </font>
            </P>
            <P>Confirme a senha:<br>
                <input type="password" name="confirmaSenhaUsuario" 
                       class = "caixaTexto"
                       value="${sessionScope.formUsuario.confirmaSenhaUsuario}" 
                       />
                <font class="erroCampo">
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
                <font class="erroCampo">
                    ${sessionScope.formUsuario.erroPapelUsuario}
                </font>
            </P>
            <p>
                <input class="botao" type="submit" value="Gravar" 
                       name="executar"/>
                <c:if test="${!sessionScope.formUsuario.inclusao}">
                    <INPUT class= "botao" TYPE="submit" value="Cancelar" 
                           name="cancelar"/>
                </c:if>
            </p>
            <P></P>
        </form>
        <P>
            Para voltar ao início clique 
            <a href="homeAdministrador.jsp">aqui</a>
        </P>   
        <P>Para efetuar logout clique 
            <a href="GelicServlet?comando=Logout">aqui</a>
        </p>
    </body>
</html>

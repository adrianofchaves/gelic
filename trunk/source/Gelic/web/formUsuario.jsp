<%-- 
    Document   : formUsuario
    Created on : 25/04/2008, 23:58:47
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
    <table class="nomeSistema">
      <th>GELIC &nbsp;&nbsp;</th>        
    </table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="Gelic?comando=CadastroUsuarios">Voltar</a>
        </th>
        <th class="menuItem" >
          <a href="Gelic?comando=Logout">Trocar usuário</a>                    
        </th>
      </tr>
    </table>
    <P></P>
  </head>
  <body>  
    <form name="frmusuario" 
          action="Gelic?comando=GravarUsuario" 
          method="POST">
      <p class="caption">            
        <c:if test="${sessionScope.formUsuario.alteracao}">
          Alterando usuário
        </c:if>
        <c:if test="${sessionScope.formUsuario.exclusao}">
          Excluindo usuário
        </c:if>
        <c:if test="${sessionScope.formUsuario.inclusao}">
          Novo usuário
        </c:if>
      </p>
      <font class = "erro">
        <c:forEach var="erro" items="${sessionScope.formUsuario.erros}">
          <P>${erro}</P>
        </c:forEach>
      </font>    
      <P>Login:<br>
        <input type="text" name="loginUsuario" class = "caixaTexto"
               <c:if test="${sessionScope.formUsuario.exclusao}">
                 disabled
               </c:if>               
               value="${sessionScope.formUsuario.loginUsuario}" />
        <font class="erroCampo">
          ${sessionScope.formUsuario.erroLoginUsuario}
        </font>
      </P>
      <P>Senha:<br>
        <input type="password" name="senhaUsuario" class = "caixaTexto"
               <c:if test="${sessionScope.formUsuario.exclusao}">
                 disabled
               </c:if>               
               value="${sessionScope.formUsuario.senhaUsuario}" />
        <font class="erroCampo">
          ${sessionScope.formUsuario.erroSenhaUsuario}
        </font>
      </P>
      <P>Confirme a senha:<br>
        <input type="password" name="confirmaSenhaUsuario" 
               <c:if test="${sessionScope.formUsuario.exclusao}">
                 disabled
               </c:if>               
               class = "caixaTexto"
               value="${sessionScope.formUsuario.confirmaSenhaUsuario}" 
               />
        <font class="erroCampo">
          ${sessionScope.formUsuario.erroConfirmaSenhaUsuario}
        </font>
      </P>
      <P>Papel do usuário:<BR>
        <select name="papelUsuario" class="cadastro" 
                <c:if test="${sessionScope.formUsuario.exclusao}">
                  disabled
                </c:if>               
                
                style = "width: 30%">
          <c:forEach var="papel" 
                     items="${sessionScope.formUsuario.papeis}">
            <option
              <c:if test="${papel.nome==sessionScope.formUsuario.papelUsuario}">
                selected
              </c:if>
              >${papel.nome}</option>                
          </c:forEach>    
        </select>
        <font class="erroCampo">
          ${sessionScope.formUsuario.erroPapelUsuario}
        </font>
      </P>
      <p>
        <c:if test="${sessionScope.formUsuario.exclusao}">
          <input class="botao" type="submit" value="Excluir" 
                 name="excluir"/>
        </c:if>
        <c:if test="${!sessionScope.formUsuario.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
      
    </form>        
  </body>
</html>

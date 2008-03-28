<%-- 
    Document   : browserContatos
    Created on : 28/03/2008, 09:23:23
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
        <title>GELIC--Cadastro de modalidades de licitações</title>          
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu"><tr>
                <th class="menuItem" >
                    <a href="formEmpresa.jsp">
                    Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=NovaContato">
                    Novo contato</a>                    
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">
                    Trocar usuário</a>                    
                </th>
        </tr></table>        
    </head>
    <body>    
        <table class="cadastro"><TH class="cadastro">Contatos</TH></TABLE>
        <table class="cadastro">
            <tr class="cabecalho">
                <td>Nome</td>
                <td>Telefone</td>                    
            </tr>
            <c:forEach 
                var="empresa" 
                items="${sessionScope.browserEmpresas.empresas}">                
                <tr class="dados">
                    <td>
                        <a href="Comercial?comando=AlterarEmpresa&cnpj=${empresa.cnpj}">
                            ${sistema.nomeFantasia}
                        </a>                        
                    </td>                    
                    <td>
                        ${empresa.cnpj}
                        27.915.735/0001-00
                    </td>                    
                    <td>
                        ${empresa.endereco}
                        Avenida Rio Branco, 45/18ºAndar - Rio de Janeiro - RJ
                    </td>                    
                    <td>
                        ${empresa.telefone}
                        21 22139300
                    </td>                    
                    <td>
                        <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            
            <tr class="dados">
                <td>
                    <a href="formContato.jsp">
                        Adriano Fernandes Chaves
                    </a>                        
                </td>                    
                <td>                        
                    55 21 22139300
                </td>                    
                <td>
                    <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
                        <img src="img/trash.PNG"  width="16" height="16" 
                             alt="trash"/>
                    </a>
                </td>
            </tr>
            <tr class="dados">
                <td>
                    <a href="formContato.jsp">
                        Adriano Fernandes Chaves
                    </a>                        
                </td>                    
                <td>                        
                    55 21 22139300
                </td>                    
                <td>
                    <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
                        <img src="img/trash.PNG"  width="16" height="16" 
                             alt="trash"/>
                    </a>
                </td>
            </tr>
            <tr class="dados">
                <td>
                    <a href="formContato.jsp">
                        Adriano Fernandes Chaves
                    </a>                        
                </td>                    
                <td>                        
                    55 21 22139300
                </td>                    
                <td>
                    <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
                        <img src="img/trash.PNG"  width="16" height="16" 
                             alt="trash"/>
                    </a>
                </td>
            </tr>
        </table>        
        <font class="mensagem">
            <P>${sessionScope.browserModalidades.mensagem}</P>
        </font>
    </body>
</html>
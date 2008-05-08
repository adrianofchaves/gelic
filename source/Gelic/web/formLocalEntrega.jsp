<%-- 
    Document   : formLocalEntrega
    Created on : 07/05/2008, 23:54:51
    Author     : Paulo
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
                    <a href="formOFM.jsp">Voltar</a>
                </th>
                <th class="menuItem" >
                    <a href="Gelic?comando=Logout">Trocar usuário</a>                    
                </th>
            </tr>
        </table>
    </head>
    <body>
        <form name="frmEndereco" 
              action="Gelic?comando=GravarTelefone" 
              method="POST">
            <p class="caption">
                <c:if test="${!sessionScope.formSistema.inclusao}">
                    Endereço da empresa "Nasajon Sistemas"
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Endereço da empresa "Nasajon Sistemas"
                </c:if>
            </p>            
            <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>
            <table class = "tabelaCadastro">
                <TR>
                    <TD class="tabelaCadastro" style="width:10%" >
                        Tipo<BR>
                        <select name="tipoLogradouroEmpresa" 
                                class="tabelaCadastro"
                                value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                            <option>Rua</option>
                            <option>Praça</option>
                            <option>Avenida</option>                    
                        </select>                        
                    </TD>
                    <TD class="tabelaCadastro" style="width:55%">
                        Logradouro: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                    <TD class="tabelaCadastro"  style="width:20%" >
                        Numero: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                    <TD class="tabelaCadastro"  style="width:15%" >
                        Complemento: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                </TR>
            </TABLE>
            <table class = "tabelaErro">
                <TR>
                    <TD class="tabelaErro" style="width:10%" >                        
                        ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                        
                    </TD>
                    <TD class="tabelaErro" style="width:55%">                        
                        
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}                    
                    </TD>
                    <TD class="tabelaErro"  style="width:20%" >                        
                        
                        ${sessionScope.formEmpresa.erroLogradouroEnderecoEmpresa}                    
                    </TD>
                    <TD class="tabelaErro"  style="width:15%" >                        
                        ${sessionScope.formEmpresa.erroComplementoEnderecoEmpresa}
                    </TD>
                </TR>
            </TABLE>
            <table class = "tabelaCadastro">
                <TR>
                    <TD class="tabelaCadastro"  style="width:30%" >
                        Bairro: <BR>
                        <input type="text" name="logradouroEmpresa" 
                        class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                    <TD class="tabelaCadastro"  style="width:30%" >
                        Cidade: <BR>
                        <input type="text" name="logradouroEmpresa" 
                        class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                        <font class="erroCampo" >
                            ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                        </font>
                        
                    </TD>
                    <TD class="tabelaCadastro"  style="width:10%" >
                        Estado<BR>
                        <select name="tipoLogradouroEmpresa" 
                                class="tabelaCadastro"
                                value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                            <option>RJ</option>
                            <option>SP</option>
                            <option>BA</option>                    
                        </select>
                        <font class="erroCampo" >
                            ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                        </font>
                    </TD>
                    <TD class="tabelaCadastro"  style="width:15%" >
                        CEP: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                        <font class="erroCampo" >
                            ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                        </font>
                    </TD>
                </TR>
            </TABLE>
            <table class = "tabelaErro">
                <TR>
                    <TD class="tabelaErro" style="width:30%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                    </TD>
                    <TD class="tabelaErro" style="width:30%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                    </TD>
                    <TD class="tabelaErro" style="width:10%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                        mensagem de erro enorme para testar quebra de linha
                    </TD>
                    <TD class="tabelaErro" style="width:15%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                    </TD>
                </TR>
            </TABLE>
            <table class = "tabelaCadastro">
                <TR>
                    <TD class="tabelaCadastro" style="width: 45%">
                        Site: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"                               
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                    <TD class="tabelaCadastro" style="width: 45%">
                        email: <BR>
                        <input type="text" name="logradouroEmpresa" 
                               class="tabelaCadastro"                               
                               value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                    </TD>
                </TR>
            </TABLE>
            <table class = "tabelaErro">
                <TR>
                    <TD class="tabelaErro" style="width:30%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                        
                    </TD>
                    <TD class="tabelaErro" style="width:30%" >
                        ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                        email inválido!
                    </TD>
                </TR>
            </TABLE>
            <p>
                <input class="botao" type="submit" value="Gravar" 
                       name="executar"/>
                <INPUT class="botao" TYPE="submit" value="Cancelar" 
                       name="cancelar"/>                
            </p>
        </form>       
    </body>
</html>
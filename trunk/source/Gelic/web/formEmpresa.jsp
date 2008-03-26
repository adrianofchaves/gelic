<%-- 
    Document   : formEmpresa
    Created on : 26/03/2008, 13:00:25
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
        <title>GELIC--Cadastro de sistemas</title>  
        <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
        
        <table class="menu">
            <tr>
                <th class="menuItem" >
                    <a href="browserEmpresas.jsp">Voltar</a>
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
        <form name="frmEmpresa" 
              action="Comercial?comando=GravarEmpresa" 
              method="POST">
            <p class="caption">
                <c:if test="${!sessionScope.formSistema.inclusao}">
                    Alterando empresa
                </c:if>
                <c:if test="${sessionScope.formSistema.inclusao}">
                    Novo empresa
                </c:if>
            </p>            
            <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
                <P class="erro" >${erro}</P>
            </c:forEach>           
            <p class="grupo">Dados da empresa:</p>
            <P>Nome Fantasia:<br>
                <input type="text" name="nomeEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.nomeFantasiaEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroNomeFantasiaEmpresa}
                </font>
            </P>
            <P>CNPJ:<br>
                <input type="text" name="cnpjEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.cnpjEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroCnpjEmpresa}
                </font>
            </P>
            <P>IE:<br>
                <input type="text" name="ieEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.ieEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroIeEmpresa}
                </font>
            </P>
            <P>IM:<br>
                <input type="text" name="imEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.imEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroImEmpresa}
                </font>
            </P>
            <P>Razao Social:<br>
                <input type="text" name="razaoSocialEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.razaoSocialEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroRazaoSocialEmpresa}
                </font>
            </P>
            
            <P>
                <input type="checkbox" name="ePortadorEmpresa" 
                       value="${sessionScope.formEmpresa.ePortadorEmpresa}" /> 
                Portador
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroEPortadorEmpresa}
                </font>
            </P>
            
            <P>
                <input type="checkbox" name="eFornecedor" 
                       value="${sessionScope.formEmpresa.eFornecedorEmpresa}" /> 
                Fornecedor
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroEFornecedorEmpresa}
                </font>
            </P>
            <p class="grupo">Endereço:</p>
            <P>
                Tipo<BR>
                <select name="tipoLogradouroEmpresa"
                        class="caixaTexto"
                        value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                    <option>Rua</option>
                    <option>Praça</option>
                    <option>Avenida</option>                    
                </select>
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                </font>
            </P>
            <P>
                Logradouro: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Numero: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            
            <P>
                Complemento: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Bairro: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Cidade: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Estado<BR>
                <select name="tipoLogradouroEmpresa" 
                        class="caixaTexto"
                        value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                    <option>RJ</option>
                    <option>SP</option>
                    <option>BA</option>                    
                </select>
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}
                </font>
            </P>
            <P>
                CEP: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Site: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                email: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <p class="grupo">Telefone:</p> 
            <P>
                DDI: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                DDD: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Número: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            <P>
                Ramal: <BR>
                <input type="text" name="logradouroEmpresa" class="caixaTexto"
                       value="${sessionScope.formEmpresa.logradouroEmpresa}" />
                <font class="erroCampo" >
                    ${sessionScope.formEmpresa.erroLogradouroEmpresa}
                </font>
            </P>
            
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
                        <a href="formEmpresa.jsp">
                            Nasajon Sistemas
                        </a>                        
                    </td>                    
                    <td>                        
                        27.915.735/0001-00
                    </td>                    
                    <td>
                        Avenida Rio Branco, 45/18ºAndar - Rio de Janeiro - RJ
                    </td>                    
                    <td>
                        21 22139300
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
                        <a href="formEmpresa.jsp">
                            Nasajon Sistemas
                        </a>                        
                    </td>                    
                    <td>                        
                        27.915.735/0001-00
                    </td>                    
                    <td>
                        Avenida Rio Branco, 45/18ºAndar - Rio de Janeiro - RJ
                    </td>                    
                    <td>
                        21 22139300
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
                        <a href="formEmpresa.jsp">
                            Nasajon Sistemas
                        </a>                        
                    </td>                    
                    <td>                        
                        27.915.735/0001-00
                    </td>                    
                    <td>
                        Avenida Rio Branco, 45/18ºAndar - Rio de Janeiro - RJ
                    </td>                    
                    <td>
                        21 22139300
                    </td>                    
                    <td>
                        <a href="Comercial?comando=ExcluirEmpresa&cnpj=${empresa.cnpj}">
                            <img src="img/trash.PNG"  width="16" height="16" 
                                 alt="trash"/>
                        </a>
                    </td>
                </tr>
                
                
                
            </table>        
            
            <p>
                <input class="botao" type="submit" value="Gravar" 
                       name="executar"/>
                <INPUT class="botao" TYPE="submit" value="Cancelar" 
                       name="cancelar"/>                
            </p>
            
        </form>       
    </body>
</html>
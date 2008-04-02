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
    <title>GELIC--Cadastro de Empresas</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="browserEmpresas.jsp">Voltar</a>
        </th>
        <c:if test="${!sessionScope.formSistema.inclusao}">
          <th class="menuItem" >
            <a href="browserContatos.jsp">Contatos</a>
          </th>
        </c:if>
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
        ${sessionScope.formEmpresa.titulo}
      </p>            
      <c:forEach var="erro" items="${sessionScope.formEmpresa.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           
      <p class="grupo">Dados gerais:</p>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:80%">
          Nome fantasia:<BR>                    
          <input type="text" name="nomeFantasiaEmpresa" 
                 class="tabelaCadastro" 
                 value="${sessionScope.formEmpresa.nomeFantasiaEmpresa}" />
        </td>
        <td class="caixaSelecaoTabelaCadastro" style="width:20%;">
        Portador
        <input type="checkbox" name="ePortadorEmpresa" 
               value="ON" 
               <c:if test="${sessionScope.formEmpresa.EPortadorEmpresa=='true'}">
                 checked
               </c:if>
               /> 
               
               </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 80%">
          ${sessionScope.formEmpresa.erroNomeFantasiaEmpresa}
        </td>
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formEmpresa.erroEPortadorEmpresa}
        </td>
      </table>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:80%">
          Razão social:<BR>
          <input type="text" class="tabelaCadastro" 
                 name="razaoSocialEmpresa" 
                 value="${sessionScope.formEmpresa.razaoSocialEmpresa}"/>
        </td>
        <td class="caixaSelecaoTabelaCadastro" 
            style="width:20%;">
          Fornecedor
          <input type="checkbox" name="eFornecedorEmpresa" 
                 <c:if test="${sessionScope.formEmpresa.EFornecedorEmpresa=='true'}">
                   checked
                 </c:if>
                 
                 value="ON" />
          
        </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 80%">
          ${sessionScope.formEmpresa.erroRazaoSocialEmpresa}
        </td>
        <td class="tabelaErro" style="width: 20%">
          ${sessionScope.formEmpresa.erroEFornecedorEmpresa}
        </td>
      </table>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:40%">
          CNPJ:<BR>
          <input type="text" class="tabelaCadastro"
                 name="${sessionScope.formEmpresa.cnpjEmpresa}" />
        </td>                
        <td class="tabelaCadastro" style="width:30%">
          IE:<BR>
          <input type="text" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.ieEmpresa}"/>
        </td>
        <td class="tabelaCadastro" style="width: 30%">
          IM:<BR>
          <input type="text" name="imEmpresa" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.imEmpresa}" />
        </td>
      </table>
      <table class="tabelaErros">
        <td class="tabelaErros" style="width: 40%">
          ${sessionScope.formEmpresa.erroCnpjEmpresa}
        </td>
        <td class="tabelaErros" style="width: 30%">
          ${sessionScope.formEmpresa.erroIeEmpresa}
        </td>
        <td class="tabelaErros" style="width: 30%">
          ${sessionScope.formEmpresa.erroImEmpresa}
        </td>
      </table>
      
      <p class="grupo">Endereço:</p>
      
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width:10%" >
          Tipo<BR>
          <select name="tipoLogradouroEmpresa" 
                  class="tabelaCadastro"
                  value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">                  
            <c:forEach var="tipoLogradouro" 
                       items="${sessionScope.formEmpresa.tiposLogradouros}">
              <option>${tipoLogradouro}</option>
            </c:forEach>      
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
          <input type="text" name="numeroEmpresa" 
                 class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.numeroEmpresa}" />
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          Complemento: <BR>
          <input type="text" name="complementoEmpresa" 
                 class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.complementoEmpresa}" />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:10%" >                        
          ${sessionScope.formEmpresa.erroTipoLogradouroEmpresa}                        
        </TD>
        <TD class="tabelaErro" style="width:55%">
          ${sessionScope.formEmpresa.erroLogradouroEmpresa}                    
        </TD>
        <TD class="tabelaErro"  style="width:20%" >
          ${sessionScope.formEmpresa.erroNumeroEmpresa}                    
        </TD>
        <TD class="tabelaErro"  style="width:15%" >                        
          ${sessionScope.formEmpresa.erroComplementoEmpresa}
        </TD>
      </TABLE>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro"  style="width:30%" >
          Bairro: <BR>
          <input type="text" name="logradouroEmpresa" 
                 class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.bairroEmpresa}" />
        </TD>
        <TD class="tabelaCadastro"  style="width:30%" >
          Cidade: <BR>
          <input type="text" name="logradouroEmpresa" 
                 class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.cidadeEmpresa}" />
        </TD>
        <TD class="tabelaCadastro"  style="width:10%" >
          Estado<BR>
          <select name="tipoLogradouroEmpresa" 
                  class="tabelaCadastro"
                  value="${sessionScope.formEmpresa.estadoEmpresa}">
            <c:forEach var="uf" 
                       items="${sessionScope.formEmpresa.ufs}">
              <option>${uf}</option>
            </c:forEach>            
          </select>
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          CEP: <BR>
          <input type="text" name="cepEmpresa" 
                 class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.cepEmpresa}" />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formEmpresa.erroBairroEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formEmpresa.erroCidadeEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionScope.formEmpresa.erroEstadoEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:15%" >
          ${sessionScope.formEmpresa.erroCepEmpresa}
        </TD>
      </TABLE>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width: 45%">
          Site: <BR>
          <input type="text" name="siteEmpresa" 
                 class="tabelaCadastro"                               
                 value="${sessionScope.formEmpresa.siteEmpresa}" />
        </TD>
        <TD class="tabelaCadastro" style="width: 45%">
          Email: <BR>
          <input type="text" name="emailEmpresa" 
                 class="tabelaCadastro"                               
                 value="${sessionScope.formEmpresa.emailEmpresa}" />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formEmpresa.erroSiteEmpresa}
          
        </TD>
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formEmpresa.erroEmailEmpresa}
        </TD>
      </TABLE>
      
      <p class="grupo">Telefone:</p>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width: 10%">
          DDI: <BR>
          <input type="text" name="ddiEmpresa" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.ddiEmpresa}" />
        </TD>
        <TD class="tabelaCadastro" style="width: 10%">
          DDD: <BR>
          <input type="text" name="dddEmpresa" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.dddEmpresa}" />
        </TD>
        <TD class="tabelaCadastro" style="width: 50%">
          Número: <BR>
          <input type="text" name="numeroTelefoneEmpresa" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.numeroTelefoneEmpresa}" />
        </TD>
        <TD class="tabelaCadastro" style="width: 30%">
          Ramal: <BR>
          <input type="text" name="ramalEmpresa" class="tabelaCadastro"
                 value="${sessionScope.formEmpresa.ramalEmpresa}" />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formEmpresa.erroDdiEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formEmpresa.erroDddEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:50%" >
          ${sessionEscope.formEmpresa.erroNumeroTelefoneEmpresa}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formEmpresa.erroRamalEmpresa}
        </TD>
      </TABLE>
      
      <BR><BR>
      <p>
        <input class="botao" type="submit" value="Salvar" 
               name="executar"/>
        <input class="botao" type="submit" value="Excluir" 
               name="excluir"/>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
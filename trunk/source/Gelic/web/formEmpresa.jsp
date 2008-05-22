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
          <a href="Comercial?comando=CadastroEmpresas">Voltar</a>
        </th>
        <c:if test="${sessionScope.formEmpresa.alteracao}">
          <th class="menuItem" >
            <a href="Comercial?comando=CadastroContatos&empresa=${sessionScope.formEmpresa.empresa.cnpj}">Contatos</a>
          </th>
        </c:if>
        <th class="menuItem" >
          <a href="homeComercial.jsp">Início</a>
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
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 class="tabelaCadastro" 
                 value="${sessionScope.formEmpresa.nomeFantasiaEmpresa}"
                 maxlength=20 />
        </td>
        <td class="caixaSelecaoTabelaCadastro" style="width:20%;">
        Portador
        <input type="checkbox" name="ePortadorEmpresa" 
               value="ON" 
               <c:if test="${sessionScope.formEmpresa.exclusao}">
                 disabled
               </c:if>
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
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.razaoSocialEmpresa}"
                 maxlength=50 />
        </td>
        <td class="caixaSelecaoTabelaCadastro" 
            style="width:20%;">
          Fornecedor
          <input type="checkbox" name="eFornecedorEmpresa" 
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
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
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 name = "cnpjEmpresa"
                 value="${sessionScope.formEmpresa.cnpjEmpresa}"
                 maxlength=14 />
        </td>                
        <td class="tabelaCadastro" style="width:30%">
          IE:<BR>
          <input type="text" class="tabelaCadastro" name = "ieEmpresa"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.ieEmpresa}"
                 maxlength=15 />
        </td>
        <td class="tabelaCadastro" style="width: 30%">
          IM:<BR>
          <input type="text" name="imEmpresa" class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.imEmpresa}"
                 maxlength=15 />
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
                  <c:if test="${sessionScope.formEmpresa.exclusao}">
                    disabled
                  </c:if>
                  value="${sessionScope.formEmpresa.tipoLogradouroEmpresa}">                  
            <c:forEach var="tipoLogradouro" 
                       items="${sessionScope.formEmpresa.tiposLogradouros}">
              <option
                <c:if test="${tipoLogradouro==sessionScope.formEmpresa.tipoLogradouroEmpresa}">
                selected 
                </c:if>
                >${tipoLogradouro}</option>
            </c:forEach>      
          </select>                        
        </TD>
        <TD class="tabelaCadastro" style="width:55%">
          Logradouro: <BR>
          <input type="text" name="logradouroEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.logradouroEmpresa}"
                 maxlength=30 />
        </TD>
        <TD class="tabelaCadastro"  style="width:20%" >
          Numero: <BR>
          <input type="text" name="numeroEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.numeroEmpresa}"
                 maxlength=15 />
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          Complemento: <BR>
          <input type="text" name="complementoEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.complementoEmpresa}"
                 maxlength=20 />
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
          <input type="text" name="bairroEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.bairroEmpresa}"
                 maxlength=20 />
        </TD>
        <TD class="tabelaCadastro"  style="width:30%" >
          Cidade: <BR>
          <input type="text" name="cidadeEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.cidadeEmpresa}"
                 maxlength=30 />
        </TD>
        <TD class="tabelaCadastro"  style="width:10%" >
          Estado<BR>
          <select name="estadoEmpresa" 
                  <c:if test="${sessionScope.formEmpresa.exclusao}">
                    disabled
                  </c:if>
                  class="tabelaCadastro"
                  value="${sessionScope.formEmpresa.estadoEmpresa}">
            <c:forEach var="uf"  
                       items="${sessionScope.formEmpresa.ufs}">              
              <option
                <c:if test="${uf==sessionScope.formEmpresa.estadoEmpresa}">
                  selected
                </c:if>
                >${uf}</option>
            </c:forEach>            
          </select>
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          CEP: <BR>
          <input type="text" name="cepEmpresa" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.cepEmpresa}"
                 maxlength=8 />
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
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.siteEmpresa}"
                 maxlength=50 />
        </TD>
        <TD class="tabelaCadastro" style="width: 45%">
          Email: <BR>
          <input type="text" name="emailEmpresa" 
                 class="tabelaCadastro"                               
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.emailEmpresa}"
                 maxlength=50 />
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
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.ddiEmpresa}"
                 maxlength=3 />
        </TD>
        <TD class="tabelaCadastro" style="width: 10%">
          DDD: <BR>
          <input type="text" name="dddEmpresa" class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.dddEmpresa}"
                 maxlength=2 />
        </TD>
        <TD class="tabelaCadastro" style="width: 50%">
          Número: <BR>
          <input type="text" name="numeroTelefoneEmpresa" class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.numeroTelefoneEmpresa}"
                 maxlength=8 />
        </TD>
        <TD class="tabelaCadastro" style="width: 30%">
          Ramal: <BR>
          <input type="text" name="ramalEmpresa" class="tabelaCadastro"
                 <c:if test="${sessionScope.formEmpresa.exclusao}">
                   disabled
                 </c:if>
                 value="${sessionScope.formEmpresa.ramalEmpresa}"
                 maxlength=4 />
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
        <c:if test="${sessionScope.formEmpresa.exclusao}">
          <input class="botao" type="submit" value="Excluir" 
                 name="excluir"/>
        </c:if>
        <c:if test="${!sessionScope.formEmpresa.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
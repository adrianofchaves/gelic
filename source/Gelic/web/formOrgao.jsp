<%-- 
    Document   : formOrgao
    Created on : 29/03/2008, 18:26:42
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
    <title>GELIC--Cadastro de Órgãos Públicos</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="Comercial?comando=CadastroOrgaos">Voltar</a>
        </th>
        <c:if test="${!sessionScope.formSistema.inclusao}">
          <th class="menuItem" >
            <a href="Comercial?comando=CadastroContatos&orgao=${sessionScope.formOrgao.orgao.cnpj}">Contatos</a>
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
    <form name="frmOrgao" 
          action="Comercial?comando=GravarOrgao" 
          method="POST">
      <p class="caption">
        ${sessionScope.formOrgao.titulo}
      </p>            
      <c:forEach var="erro" items="${sessionScope.formOrgao.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           
      <p class="grupo">Dados Gerais:</p>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:20%">
          Apelido:<BR>
          <input type="text" class="tabelaCadastro" name = "apelidoOrgao"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.apelidoOrgao}"
                 maxlength=15 />
        </td>                
        <td class="tabelaCadastro" style="width:80%">
          Razão Social:<BR>
          <input type="text" class="tabelaCadastro" name="razaoSocialOrgao"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.razaoSocialOrgao}"
                 maxlength=50 />
        </td>
      </table>
      
      
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 20%">
          ${sessionScope.formOrgao.erroApelidoOrgao}
        </td>
        <td class="tabelaErro" style="width:80%">
          ${sessionScope.formOrgao.erroRazaoSocialOrgao}
        </td>
      </table>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:50%">
          CNPJ:<BR>
          <input type="text" class="tabelaCadastro" name="cnpjOrgao"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.cnpjOrgao}"
                 maxlength=14 />
        </td>                
        <td class="tabelaCadastro" style="width:50%">
          IE:<BR>
          <input type="text" class="tabelaCadastro" name="ieOrgao"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.ieOrgao}"
                 maxlength=15 />
        </td>
      </table>
      <table class="tabelaErros">
        <td class="tabelaErros" style="width: 50%">
          ${sessionScope.formOrgao.erroCnpjOrgao}
        </td>
        <td class="tabelaErros" style="width: 50%">
          ${sessionScope.formOrgao.erroIeOrgao}
        </td>
      </table>
      
      <p class="grupo">Endereço:</p>
      
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width:10%" >
          Tipo<BR>
          <select name="tipoLogradouroOrgao" 
                  class="tabelaCadastro"
                  <c:if test="${sessionScope.formOrgao.exclusao}">
                    disabled
                  </c:if>                  
                  value="${sessionScope.formOrgao.tipoLogradouroOrgao}">
            <c:forEach var="tipoLogradouro" 
                       items="${sessionScope.formOrgao.tiposLogradouros}">
              <option
                <c:if test="${tipoLogradouro==sessionScope.formOrgao.tipoLogradouroOrgao}">
                  selected 
                </c:if>
                >${tipoLogradouro}</option>
            </c:forEach>      
          </select>                        
        </TD>
        <TD class="tabelaCadastro" style="width:55%">
          Logradouro: <BR>
          <input type="text" name="logradouroOrgao" 
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 class="tabelaCadastro"
                 value="${sessionScope.formOrgao.logradouroOrgao}"
                 maxlength=30 />
        </TD>
        <TD class="tabelaCadastro"  style="width:20%" >
          Numero: <BR>
          <input type="text" name="numeroOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.numeroOrgao}"
                 maxlength=15 />
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          Complemento: <BR>
          <input type="text" name="complementoOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.complementoOrgao}"
                 maxlength=20 />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:10%" >                        
          ${sessionScope.formOrgao.erroTipoLogradouroOrgao}                        
        </TD>
        <TD class="tabelaErro" style="width:55%">
          ${sessionScope.formOrgao.erroLogradouroOrgao}                    
        </TD>
        <TD class="tabelaErro"  style="width:20%" >
          ${sessionScope.formOrgao.erroNumeroOrgao}                    
        </TD>
        <TD class="tabelaErro"  style="width:15%" >                        
          ${sessionScope.formOrgao.erroComplementoOrgao}
        </TD>
      </TABLE>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro"  style="width:30%" >
          Bairro: <BR>
          <input type="text" name="bairroOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.bairroOrgao}"
                 maxlength=20 />
        </TD>
        <TD class="tabelaCadastro"  style="width:30%" >
          Cidade: <BR>
          <input type="text" name="cidadeOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.cidadeOrgao}"
                 maxlength=30 />
        </TD>
        <TD class="tabelaCadastro"  style="width:10%" >
          Estado<BR>
          <select name="estadoOrgao" 
                  class="tabelaCadastro"
                  <c:if test="${sessionScope.formOrgao.exclusao}">
                    disabled
                  </c:if>                  
                  value="${sessionScope.formOrgao.estadoOrgao}">
            <c:forEach var="uf"  
                       items="${sessionScope.formOrgao.estados}">              
              <option
                <c:if test="${uf==sessionScope.formOrgao.estadoOrgao}">
                  selected
                </c:if>
                >${uf}</option>
            </c:forEach>            
          </select>
        </TD>
        <TD class="tabelaCadastro"  style="width:15%" >
          CEP: <BR>
          <input type="text" name="cepOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.cepOrgao}"
                 maxlength=8 />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formOrgao.erroBairroOrgao}
        </TD>
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formOrgao.erroCidadeOrgao}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionScope.formOrgao.erroEstadoOrgao}
        </TD>
        <TD class="tabelaErro" style="width:15%" >
          ${sessionScope.formOrgao.erroCepOrgao}
        </TD>
      </TABLE>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width: 45%">
          Site: <BR>
          <input type="text" name="siteOrgao" 
                 class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.siteOrgao}"
                 maxlength=50 />
        </TD>
        <TD class="tabelaCadastro" style="width: 45%">
          Email: <BR>
          <input type="text" name="emailOrgao" 
                 class="tabelaCadastro"                               
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.emailOrgao}"
                 maxlength=50 />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formOrgao.erroSiteOrgao}
          
        </TD>
        <TD class="tabelaErro" style="width:30%" >
          ${sessionScope.formOrgao.erroEmailOrgao}
        </TD>
      </TABLE>
      
      <p class="grupo">Telefone:</p>
      <table class = "tabelaCadastro">
        <TD class="tabelaCadastro" style="width: 10%">
          DDI: <BR>
          <input type="text" name="ddiOrgao" class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.ddiOrgao}"
                 maxlength=3 />
        </TD>
        <TD class="tabelaCadastro" style="width: 10%">
          DDD: <BR>
          <input type="text" name="dddOrgao" class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.dddOrgao}"
                 maxlength=2 />
        </TD>
        <TD class="tabelaCadastro" style="width: 50%">
          Número: <BR>
          <input type="text" name="numeroTelefoneOrgao" class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.numeroTelefoneOrgao}"
                 maxlength=8 />
        </TD>
        <TD class="tabelaCadastro" style="width: 30%">
          Ramal: <BR>
          <input type="text" name="ramalOrgao" class="tabelaCadastro"
                 <c:if test="${sessionScope.formOrgao.exclusao}">
                   disabled
                 </c:if>                 
                 value="${sessionScope.formOrgao.ramalOrgao}"
                 maxlength=4 />
        </TD>
      </TABLE>
      <table class = "tabelaErro">
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formOrgao.erroDdiOrgao}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formOrgao.erroDddOrgao}
        </TD>
        <TD class="tabelaErro" style="width:50%" >
          ${sessionEscope.formOrgao.erroNumeroTelefoneOrgao}
        </TD>
        <TD class="tabelaErro" style="width:10%" >
          ${sessionEscope.formOrgao.erroRamalOrgao}
        </TD>
      </TABLE>
      
      <BR><BR>
      <p>
        <c:if test="${sessionScope.formOrgao.exclusao}">
          <input class="botao" type="submit" value="Excluir" 
                 name="excluir"/>
        </c:if>
        <c:if test="${!sessionScope.formOrgao.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
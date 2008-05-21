<%-- 
    Document   : homeComercial
    Created on : 24/02/2008, 18:00:45
    Author     : Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <link rel="STYLESHEET" href="estilos.css" type="text/css">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GELIC [Comercial] - Licitações</title>
    <table class="nomeSistema">
      <th>GELIC &nbsp;&nbsp;</th>        
    </table>
    <table class="menu">
      <th class="menuItem" >
        <a href="Comercial?comando=NovaLicitacao">Nova Licitação</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroTiposLicitacoes">
        Tipos de licitações</a>
      </th>
      <!-- <th class="menuItem" >
                    <a href="homeComercial.jsp">Todas licitações</a>
                    TODO: tela que lista todas as licitações com critérios 
                </th> -->
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroTiposDocumentos">
          Tipos de documento
        </a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroProdutos">Produtos</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroOrgaos">Órgãos Públicos</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroEmpresas">Empresas</a>                    
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">Trocar usuário</a>
      </th>                
    </table>
  </head>
  <body>
    <table class="cadastro">
      <TH class="cadastro"> LICITAÇÕES ABERTAS</TH>
    </table>
    <table class="cadastro">
      <tr class = "cabecalho">
        <td>Licitação</td>
        <td>Processo</td>
        <td>Sistema</td>
        <td>Órgão</td>
        <td>Objeto</td>
        <td> </td>
      </tr>
      <c:forEach 
        var="licitacao" 
        items="${sessionScope.browserLicitacoes.licitacoes}">                
        <tr class="dados">
          <td>
            <a href="Comercial?comando=AlterarLicitacao&numero=${licitacao.numero}">
              ${licitacao.tipoLicitacao.sigla}
              ${licitacao.numero}/${licitacao.ano}
            </a>
          </td>
          <td>
            ${licitacao.numeroProcesso}
          </td>
          <td>
            ${licitacao.sistema.nome}
          </td>
          <td>
            ${licitacao.orgao.apelido}
          </td>
          <td>
            ${licitacao.objeto}
          </td>
          <td>
            <a href="Comercial?comando=ExcluirLicitacao&licitacao=${licitacao.numero}">
              <img src="img/trash.PNG"  width="16" height="16" 
                   alt="trash"/>
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>
    <font class="mensagem">
      <P>${sessionScope.browserLicitacoes.mensagem}</P>
    </font>
  </body>
</html>

<%-- 
    Document   : homeComercial
    Created on : 24/02/2008, 18:00:45
    Author     : Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a href="formLicitacao.jsp">Nova Licitação</a>
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
        <a href="browserOrgaos.jsp">Órgãos Públicos</a>
      </th>
      <th class="menuItem" >
        <a href="Comercial?comando=CadastroEmpresas">Empresas</a>                    
      </th>
      <th class="menuItem" >
        <a href="Gelic?comando=Logout">Trocar usuário</a>
      </th>                
      
    </table>
    <p></p>
  </head>
  <body>        
    <table class="cadastro">
      <TH class="cadastro"> LICITAÇÕES ABERTAS</TH>
    </table>
    <table class="cadastro">
      
      <tr class = "cabecalho">
        <td>
          <b><Center>Número</center></b>
        </td>
        <td>
          <b><Center>Tipo</center></b>
        </td>
        <td>
          <b><Center>Modalidade</center></b>
        </td>
        <td>
          <b><Center>Processo</center></b>
        </td>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
        <tr class="dados">
          <td>Campo1</td>
          <td>Campo2</td>
          <td>Campo3</td>
          <td>Campo4</td>
        </tr>
      </tr>
    </table>
  </body>
</html>

<%-- 
    Document   : formLicitacao
    Created on : 29/03/2008, 19:03:16
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
    <title>GELIC--Cadastro de Licitações</title>  
    <table class="nomeSistema"><th>GELIC &nbsp;&nbsp;</th></table>
    
    <table class="menu">
      <tr>
        <th class="menuItem" >
          <a href="homeComercial.jsp">Voltar</a>
        </th>
        <c:if test="${sessionScope.formLicitacao.alteracao}">
          <th class="menuItem" >
            <a href="browserDocumentosLicitacoes.jsp">Documentos</a>
          </th>
          <th class="menuItem" >
            <a href="Comercial?comando=CadastroLotes">Lotes</a>                    
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
    
    <form name="frmLicitacao" 
          action="Comercial?comando=GravarLicitacao" 
          method="POST">
      <p class="caption">
        ${sessionScope.formLicitacao.titulo}
      </p>            
      
      <c:forEach var="erro" items="${sessionScope.formLicitacao.erros}">
        <P class="erro" >${erro}</P>
      </c:forEach>           
      
      <p class="grupo">Identificação:</p>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:30%">
          Órgão:<BR>
          <select name="orgaoLicitacao" class="tabelaCadastro" 
                  <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                  >
                  <c:forEach var="orgao" items="${sessionScope.formLicitacao.orgaos}">
                    <option 
                    <c:if test="${orgao==sessionScope.formLicitacao.orgaoLicitacao}">
                      selected 
                    </c:if> >
                    ${orgao}
                    </option>
            </c:forEach>
          </select>
        </td>
        <td class="tabelaCadastro" style = "width:10%">
        Ano:<BR>
        <input type="text" class="tabelaCadastro" name = "anoLicitacao"     
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.anoLicitacao}"
               maxlength=4 />
               </td>
        <td class="tabelaCadastro" style = "width:30%">
        Número:<BR>
        <input type="text" class="tabelaCadastro" name="numeroLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.numeroLicitacao}"
               maxlength=10 />
               </td>
        <td class="tabelaCadastro" style="width:30">
        Processo:<BR>
        <input type="text" class="tabelaCadastro" 
               name="numeroProcessoLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.numeroProcessoLicitacao}"
               maxlength=20 />
               </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 30%">
          ${sessionScope.formLicitacao.erroOrgaoLicitacao}
        </td>
        <td class="tabelaErro" style="width:10%">
          ${sessionScope.formLicitacao.erroAnoLicitacao}
        </td>
        <td class="tabelaErro" style="width:30%">
          ${sessionScope.formLicitacao.erroNumeroLicitacao}
        </td>
        <td class="tabelaErro" style="width:30%">
          ${sessionScope.formLicitacao.erroNumeroProcessoLicitacao}
        </td>
      </table>      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style = "width:30%">
          Modalidade:<BR>
          <select name="modalidadeLicitacao" class="tabelaCadastro"
                  <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                  >
                  <c:forEach var="modalidade" 
                             items="${sessionScope.formLicitacao.modalidades}">
                    <option 
                    <c:if test="${modalidade==sessionScope.formLicitacao.modalidadeLicitacao}">
                      selected
                    </c:if> 
                    >${modalidade}</option>
            </c:forEach>
          </select>
        </td>
        <td class="tabelaCadastro" style = "width:40%">
          Tipo:<BR>
          <select name="tipoLicitacao" 
                  <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                  class="tabelaCadastro">
                  <c:forEach var="tipo" items="${sessionScope.formLicitacao.tiposLicitacoes}">
                    <option
                    <c:if test="${tipo==sessionScope.formLicitacao.tipoLicitacaoLicitacao}">
                      selected
                    </c:if> >${tipo}</option>
            </c:forEach>            
          </select>
        </td>
        <td class="tabelaCadastro" style = "width:30%">
          Sistema:<BR>
          <select name="sistemaLicitacao" 
                  <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                  class="tabelaCadastro">
                  <c:forEach var="sistema" items="${sessionScope.formLicitacao.sistemas}">
                    <option 
                    <c:if test="${sistema==sessionScope.formLicitacao.sistemaLicitacao}">
                      selected
                    </c:if>
                    >${sistema}</option>
            </c:forEach>
          </select>
        </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 30%">
          ${sessionScope.formLicitacao.erroModalidadeLicitacao}
        </td>
        <td class="tabelaErro" style="width:40%">
          ${sessionScope.formLicitacao.erroTipoLicitacaoLicitacao}
        </td>
        <td class="tabelaErro" style="width:30%">
          ${sessionScope.formLicitacao.erroSistemaLicitacao}
        </td>        
      </table> 
      
      <p class="grupo">Datas:</p>
      
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width: 33%">
        Documentação:<BR>
        <input type="text" class="tabelaCadastro" 
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               name="dataDocumentacaoLicitacao"
               value="${sessionScope.formLicitacao.dataDocumentacaoLicitacaoFormatada}"/>
               </td>        
        <td class="tabelaCadastro" style="width: 34%">
        Proposta:<BR>
        <input type="text" class="tabelaCadastro" name="dataPropostaLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.dataPropostaLicitacaoFormatada}"/>
               </td>        
        <td class="tabelaCadastro" style="width: 33%">
        Realização:<BR>
        <input type="text" class="tabelaCadastro" name="dataRealizacaoLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.dataRealizacaoLicitacaoFormatada}"/>
               </td>        
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 33%">
          ${sessionScope.formLicitacao.erroDataDocumentacaoLicitacao}
        </td>
        <td class="tabelaErro" style="width:34%">
          ${sessionScope.formLicitacao.erroDataPropostaLicitacao}
        </td>
        <td class="tabelaErro" style="width:33%">
          ${sessionScope.formLicitacao.erroDataRealizacaoLicitacao}
        </td>        
      </table> 
      
      <p class="grupo"> Objeto:</p>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width: 100%" >          
          <textarea name="objetoLicitacao" style="width:100%" rows="4"
                    <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                    >${sessionScope.formLicitacao.objetoLicitacao}</textarea>
        </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 100%">
          ${sessionScope.formLicitacao.erroObjetoLicitacao}
        </td>
      </table> 
      
      <p class="grupo"> Prazos:</p>
      
      <table class="tabelaCadastro">        
        <td class="tabelaCadastro" style="width: 20%">
        Validade da Proposta: (dias)<BR>
        <input type="text" class="tabelaCadastro" 
               name="diasValidadePropostaLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.diasValidadePropostaLicitacao}"
               maxlength=3 />
               </td>        
        <td class="tabelaCadastro" style="width: 20%">
        Prazo de Entrega: (dias) <BR>
        <input type="text" class="tabelaCadastro"
               name="diasPrazoEntregaLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.diasPrazoEntregaLicitacao}"
               maxlength=3 />
               </td>        
        <td class="tabelaCadastro" style="width: 20%">
        Prazo de Pagamento: (dias)<BR>
        <input type="text" class="tabelaCadastro" 
               name="diasPrazoPagamentoLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.diasPrazoPagamentoLicitacao}"
               maxlength=3 />
               </td>        
        <td class="tabelaCadastro" style="width: 20%">
        Vigência do Contrato: (dias)<BR>
        <input type="text" class="tabelaCadastro"
               name="diasVigenciaLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.diasVigenciaLicitacao}"
               maxlength=4 />
               </td>        
        <td class="tabelaCadastro" style="width: 20%">
        Prazo de Garantia: (Anos)<BR>
        <input type="text" class="tabelaCadastro" 
               name="anosPrazoGarantiaLicitacao"
               <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
               value="${sessionScope.formLicitacao.anosPrazoGarantiaLicitacao}"
               maxlength=2 />
               </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 20%">
          ${sessionScope.formLicitacao.erroDiasValidadePropostaLicitacao}
        </td>
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formLicitacao.erroDiasPrazoEntregaLicitacao}
        </td>
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formLicitacao.erroDiasPrazoPagamentoLicitacao}
        </td>        
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formLicitacao.erroDiasVigenciaLicitacao}
        </td>        
        <td class="tabelaErro" style="width:20%">
          ${sessionScope.formLicitacao.erroAnosPrazoGarantiaLicitacao}
        </td>        
      </table> 
      
      <p class="grupo"> Termos:</p>
      <table class="tabelaCadastro">
        <td class="tabelaCadastro" style="width:33%">
          Amostra:<BR>
          <textarea rows="4" style="width:100%"
                    <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                    name="termosAmostraLicitacao">${sessionScope.formLicitacao.termosAmostraLicitacao}</textarea>
        </td>
        <td class="tabelaCadastro" style="width:34%">
          Garantia:<BR>
          <textarea rows="4" cols="20" 
                    style="width:100%" 
                    <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                    name="termosGarantiaLicitacao">${sessionScope.formLicitacao.termosGarantiaLicitacao}</textarea>
        </td>
        <td class="tabelaCadastro" style="width:33%">
          Multa:<BR>
          <textarea rows="4" cols="20" 
                    style="width:100%" 
                    <c:if test="${sessionScope.formLicitacao.exclusao}">disabled</c:if>
                    name="termosMultaLicitacao">${sessionScope.formLicitacao.termosMultaLicitacao}</textarea>
        </td>
      </table>
      <table class="tabelaErro">
        <td class="tabelaErro" style="width: 33%">
          ${sessionScope.formLicitacao.erroTermosAmostraLicitacao}
        </td>
        <td class="tabelaErro" style="width:34%">
          ${sessionScope.formLicitacao.erroTermosGarantiaLicitacao}
        </td>
        <td class="tabelaErro" style="width:33%">
          ${sessionScope.formLicitacao.erroTermosMultaLicitacao}
        </td>        
      </table> 
      <p>
        <c:if test="${!sessionScope.formLicitacao.exclusao}">
          <input class="botao" type="submit" value="Salvar" 
                 name="executar"/>
        </c:if>        
        <c:if test="${sessionScope.formLicitacao.exclusao}">
          <input class="botao" type="submit" value="Excluir" name="excluir"/>
        </c:if>               
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
      </p>
    </form>       
  </body>
</html>
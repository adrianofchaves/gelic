<%-- 
    Document   : incluirLicitacao
    Created on : 02/03/2008, 17:32:12
    Author     : Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GeLic - Incluir Licitação</title>
        <H1 class="nomeSistema">GELIC &nbsp;&nbsp;</H1>        
    </head>
    <body>
        <p><b>Orgão:</b>
        <select name="orgao" disabled="disabled">
            <option></option>
        </select>
        <input type="submit" value="Novo" name="novaLicitacao" />
        </p><p>
        <b>Modalidade:</b>
        <select name="orgao" disabled="disabled">
            <option></option>
        </select>
        <b>Tipo:</b>
        <select name="orgao" disabled="disabled">
            <option></option>
        </select>
        </p><p>
        <b>Número:</b>
        <input type="text" name="numero" value="" size="6" readonly="readonly" />
        <b>Processo:</b>
        <input type="text" name="processo" value="" size="6" readonly="readonly" />
        </p><p>
        <CENTER>Datas</p><p></CENTER>
        <b>Documentação:</b>
        <input type="text" name="datadocumentacao" value="" size="9" readonly="readonly" />
        <b>Proposta:</b>
        <input type="text" name="dataProposta" value="" size="9" readonly="readonly" />
        <b>Sessão:</b>
        <input type="text" name="dataSessao" value="" size="9" readonly="readonly" />
        </p><p>
        <b>Objeto:</b>
        <input type="text" name="objeto" value="" readonly="readonly" />
        </p><p>
        <b>Validade da Proposta:</b>
        <input type="text" name="validadeProposta" size="9" value="" readonly="readonly" />
        <b>Prazo de entrega:</b>
        <input type="text" name="prazoEntrega" size="3" value="" readonly="readonly" />
        </p><p>
        <b>Prazo de garantia:</b>
        <input type="text" name="prazoGarantia" size="3" value="" readonly="readonly" />
        <b>Prazo de pagamento:</b>
        <input type="text" name="prazoPagamento" size="4" value="" readonly="readonly" />
        </p><p>
        <b>Vigência do contrato:</b>
        <input type="text" name="vigenciaContrato" size="4" value="" readonly="readonly" />
        </p><p>
        <b>Local de entrega:</b>
        <input type="text" name="localEntrega" value="" readonly="readonly" />
        </p><p>
        <input type="checkbox" name="chAmostra" value="OFF" />
        <b> Amostra:</b>
        <input type="text" name="amostra" value="" readonly="readonly" />
        </p><p>
        <input type="checkbox" name="chGarantiaDe" value="OFF" />
        <b> Garantia de:</b>
        <input type="text" name="garantiaDe" size="4" value="" readonly="readonly" />
        </p><p>
        <input type="checkbox" name="chMulta" value="OFF" />
        <b> Multa:</b>
        <input type="text" name="multa" value="" readonly="readonly" />
        </p><p>
        <b> Responsável:</b>
        <input type="text" name="responsavel" value="" readonly="readonly" />
        </p><p>
        <input type="submit" value="Confirma" name="confirma" />
        <input type="submit" value="Cancela" name="cancela" />
        </p>
    </body>
</html>

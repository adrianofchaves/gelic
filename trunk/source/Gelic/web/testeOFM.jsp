<%-- 
    Document   : testeOFM
    Created on : 07/05/2008, 23:18:27
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <link rel="STYLESHEET" href="estilos.css" type="text/css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GELIC--Analista</title>
       <table class="nomeSistema">
            <th>GELIC &nbsp;&nbsp;</th>        
        </table>        
        <table class="menu">
            <tr>
                <th class="menuItem" ><a href="testeContrato.jsp">Voltar</a></th>
                <th class="menuItem" ><a href="homeAnalista.jsp">Pedido de Compra</a></th>
                <th class="menuItem" ><a href="Gelic?comando=Logout">Trocar usuario</a>                        
                </th>
            </tr>        
        </table>
    </head>
    <body>
    <table class="cadastro">
      <TH class="cadastro"> Pregão Eletronico nº 002-7051/05 CEF/BH</TH>
      <p>
      <tr>
          <td>OFM: <input type="textbox" name="ofm" value="002.1"></td>
      </tr>
      <tr>
          <td>Data: <input type="textbox" name="recbto" value="07/07/06"></td>
      </tr>
      <tr>
          <td>Observações: <input type="textbox" name="obs"></td>
      </tr>
      
      <tr>
          <td>
              Local de entrega:
              <select name="entrega">
                  <option> AG. Juiz de Fora </option>
              </select>
          </td>
      </tr>
  </table>
  <p>
  <table>
          <tr class="contratoCenter" >
              <td style = "width:30%">Item</td>
              <td style = "width:20%">Quantidade</td>
              <td style = "width:20%">Unitário</td>
              <td style = "width:20%">Total</td>              
          </tr>
          <tr>
              <td>
                  <select name="item1">
                      <option>MI2-Mesa de microcomputador</option>
                  </select>
              </td>
              <td><input type="textbox" name="quantItem1" value="19"></td>
              <td><input type="textbox" name="unitItem1" value="710,43"></td>
              <td><input type="textbox" name="totalItem1" value="13498,17"></td>
          </tr>
          <tr>
              <td>
                  <select name="item2">
                      <option>MI3-Mesa de impressora</option>
                  </select>
              </td>
              <td><input type="textbox" name="quantItem2" value="7"></td>
              <td><input type="textbox" name="unitItem2" value="297,00"></td>
              <td><input type="textbox" name="totalItem2" value="2079,00"></td>
          </tr>
          <tr>
              <td>
                  <select name="item3">
                      <option>ST - Suporte de teclado</option>
                  </select>
              </td>
              <td><input type="textbox" name="quantItem3" value="5"></td>
              <td><input type="textbox" name="unitItem3" value="80,16"></td>
              <td><input type="textbox" name="totalItem3" value="400,80"></td>
          </tr>
          <tr>
              <td>
                  <select name="item4">
                      <option> </option>
                      <option>MI1-Mesa de terminal de video</option>
                      <option>MI2-Mesa de microcomputador</option>
                      <option>MI3-Mesa de impressora</option>
                      <option>AP1 - Apoio de punho</option>
                      <option>AP2 - Apoio de pé</option>
                      <option>ST - Suporte de teclado</option>
                      <option>SV - Suporte de video</option>
                      <option> </option>                      
                  </select>
              </td>
              <td><input type="textbox" name="quantItem4" value="0"></td>
              <td><input type="textbox" name="unitItem4" value="0"></td>
              <td><input type="textbox" name="totalItem4" value="0"></td>
          </tr>
          <tr>
              <td>
                  <select name="item5">
                      <option> </option>
                      <option>MI1-Mesa de terminal de video</option>
                      <option>MI2-Mesa de microcomputador</option>
                      <option>MI3-Mesa de impressora</option>
                      <option>AP1 - Apoio de punho</option>
                      <option>AP2 - Apoio de pé</option>
                      <option>ST - Suporte de teclado</option>
                      <option>SV - Suporte de video</option>
                      <option> </option>                      
                  </select>
              </td>
              <td><input type="textbox" name="quantItem5" value="0"></td>
              <td><input type="textbox" name="unitItem5" value="0"></td>
              <td><input type="textbox" name="totalItem5" value="0"></td>
          </tr>
          <tr>
              <td>
                  <select name="item6">
                      <option> </option>
                      <option>MI1-Mesa de terminal de video</option>
                      <option>MI2-Mesa de microcomputador</option>
                      <option>MI3-Mesa de impressora</option>
                      <option>AP1 - Apoio de punho</option>
                      <option>AP2 - Apoio de pé</option>
                      <option>ST - Suporte de teclado</option>
                      <option>SV - Suporte de video</option>
                      <option> </option>                      
                  </select>
              </td>
              <td><input type="textbox" name="quantItem6" value="0"></td>
              <td><input type="textbox" name="unitItem6" value="0"></td>
              <td><input type="textbox" name="totalItem6" value="0"></td>
          </tr>
          <tr>
              <td>
                  <select name="item7">
                      <option> </option>
                      <option>MI1-Mesa de terminal de video</option>
                      <option>MI2-Mesa de microcomputador</option>
                      <option>MI3-Mesa de impressora</option>
                      <option>AP1 - Apoio de punho</option>
                      <option>AP2 - Apoio de pé</option>
                      <option>ST - Suporte de teclado</option>
                      <option>SV - Suporte de video</option>
                  </select>
              </td>
              <td><input type="textbox" name="quantItem7" value="0"></td>
              <td><input type="textbox" name="unitItem7" value="0"></td>
              <td><input type="textbox" name="totalItem7" value="0"></td>
          </tr>
          <tr>
              <td> </td>
              <td> </td>
              <td> </td>
              <td><input type="textbox" name="totalOFM" value="15.977,97"></td>
          </tr>
          
    </table>
    <p>
        AF: <input type="textbox" name="AF" value="740"><br>
         N:<input type="textbox" name="N" value="1"><br>
    
    <p>
        Nota fiscal de compra:<br>
        Emissão: <input type="textbox" name="dataEmissaoNFCompra"><br>
             Nº: <input type="textbox" name="numeroNFCompra"><br>
    <p>
        Nota fiscal de venda:<br>
        Emissão: <input type="textbox" name="dataEmissaoNFVenda"><br>
             Nº: <input type="textbox" name="numeroNFVenda"><br>
    <p>
        Data de Entrega: <input type="textbox" name="dataEntrega"><br>
        Nome do recebedor: <input type="textbox" name="nomeRecebedor"><br>
        Matricula: <input type="textbox" name="matricula"><br>
            Cargo: <input type="textbox" name="cargo"><br>
            <p>
        
        <input class="botao" type="submit" value="Salvar" 
               name="executar"/>
        <INPUT class="botao" TYPE="submit" value="Cancelar" 
               name="cancelar"/>                
    </body>
</html>
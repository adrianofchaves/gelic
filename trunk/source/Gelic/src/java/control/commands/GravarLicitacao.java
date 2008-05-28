/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import view.ExcecaoForm;
import view.FormLicitacao;

/**
 *
 * @author Adriano
 */
public class GravarLicitacao implements Comando {

  public String executar(HttpServletRequest req) throws ExcecaoComando {
    try {
      view.FormLicitacao form = (view.FormLicitacao) req.getSession().
              getAttribute(view.FormLicitacao.NOME_ATRIBUTO_DEFAULT);
      if (req.getParameter("cancelar") != null) {
        return form.cancelar();
      }
      populaForm(form, req);
      if (form.temErros()) {
        // ocorreram erros de parse 
        return form.getNome();
      }
      return form.gravar();
    } catch (ExcecaoForm ex) {
      Logger.getLogger(
              GravarLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (NamingException ex) {
      Logger.getLogger(
              GravarLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    } catch (SQLException ex) {
      Logger.getLogger(
              GravarLicitacao.class.getName()).log(Level.SEVERE, null, ex);
      throw new ExcecaoComando(ex.getMessage());
    }
  }

  private void populaForm(FormLicitacao form, HttpServletRequest req) {
    /* popular campos */
    String buffer = util.Request.getParameter(req, "orgaoLicitacao");
    form.setOrgaoLicitacao(buffer);

    buffer = util.Request.getParameter(req, "anoLicitacao");
    try {
      form.setAnoLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo ano inválido!");
      form.setErroAnoLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "numeroLicitacao");
    form.setNumeroLicitacao(buffer);

    buffer = util.Request.getParameter(req, "numeroProcessoLicitacao");
    form.setNumeroProcessoLicitacao(buffer);

    buffer = util.Request.getParameter(req, "modalidadeLicitacao");
    form.setModalidadeLicitacao(buffer);

    buffer = util.Request.getParameter(req, "tipoLicitacao");
    form.setTipoLicitacaoLicitacao(buffer);

    buffer = util.Request.getParameter(req, "sistemaLicitacao");
    form.setSistemaLicitacao(buffer);

    buffer = util.Request.getParameter(req, "dataDocumentacaoLicitacao");
    try {
      form.setDataDocumentacaoLicitacao(Date.valueOf(buffer));
    } catch (IllegalArgumentException ex) {
      form.addErro("Campo data da documentação inválido!");
      form.setErroDataDocumentacaoLicitacao("Data inválida");
    }

    buffer = util.Request.getParameter(req, "dataPropostaLicitacao");
    try {
      form.setDataPropostaLicitacao(Date.valueOf(buffer));
    } catch (IllegalArgumentException ex) {
      form.addErro("Campo data da proposta inválido!");
      form.setErroDataPropostaLicitacao("Data inválida");
    }

    buffer = util.Request.getParameter(req, "dataRealizacaoLicitacao");
    try {
      form.setDataRealizacaoLicitacao(Date.valueOf(buffer));
    } catch (IllegalArgumentException ex) {
      form.addErro("Campo data da documentação inválido!");
      form.setErroDataDocumentacaoLicitacao("Data inválida");
    }

    buffer = util.Request.getParameter(req, "objetoLicitacao");
    form.setObjetoLicitacao(buffer);

    buffer = util.Request.getParameter(req, "diasValidadePropostaLicitacao");
    try {
      form.setDiasValidadePropostaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo validade inválido!");
      form.setErroDiasValidadePropostaLicitacao(
              "Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasPrazoEntregaLicitacao");
    try {
      form.setDiasPrazoEntregaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo entrega inválido!");
      form.setErroDiasPrazoEntregaLicitacao(
              "Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasPrazoPagamentoLicitacao");
    try {
      form.setDiasPrazoPagamentoLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo pagamento inválido!");
      form.setErroDiasPrazoPagamentoLicitacao(
              "Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasVigenciaLicitacao");
    try {
      form.setDiasVigenciaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo vigencia inválido!");
      form.setErroDiasVigenciaLicitacao("Valor numérico(inteiro) inválido.");
    }
    
    buffer = util.Request.getParameter(req, "anosGarantiaLicitacao");
    try {
    form.setAnosPrazoGarantiaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo garantia inválido!");
      form.setErroAnosPrazoGarantiaLicitacao(
              "Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "termosAmostraLicitacao");
    form.setTermosAmostraLicitacao(buffer);

    buffer = util.Request.getParameter(req, "termosGarantiaLicitacao");
    form.setTermosGarantiaLicitacao(buffer);

    buffer = util.Request.getParameter(req, "termosMultaLicitacao");
    form.setTermosMultaLicitacao(buffer);
  }
}

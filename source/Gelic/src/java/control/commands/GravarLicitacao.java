/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commands;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
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
    form.apagaErros();
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

    try {
      form.setDataDocumentacaoLicitacao(
              util.Request.getDateParameter(req, "dataDocumentacaoLicitacao"));
    } catch (ParseException ex) {
      form.addErro("Data da documentação inválida");
      form.setErroDataDocumentacaoLicitacao(
              "Informe a data no formato: dd/mm/yyyy");
    }

    try {
      form.setDataPropostaLicitacao(
              util.Request.getDateParameter(req, "dataPropostaLicitacao"));
    } catch (ParseException ex) {
      form.addErro("Data da proposta inválida");
      form.setErroDataPropostaLicitacao(
              "Informe a data no formato: dd/mm/yyyy");
    }

    try {
      form.setDataRealizacaoLicitacao(
              util.Request.getDateParameter(req, "dataRealizacaoLicitacao"));
    } catch (ParseException ex) {
      form.addErro("Data da realização inválida");
      form.setErroDataRealizacaoLicitacao(
              "Informe a data no formato: dd/mm/yyyy");
    }
    
    buffer = util.Request.getParameter(req, "objetoLicitacao");
    form.setObjetoLicitacao(buffer);

    buffer = util.Request.getParameter(req, "diasValidadePropostaLicitacao");
    try {
      form.setDiasValidadePropostaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo validade inválido!");
      form.setErroDiasValidadePropostaLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasPrazoEntregaLicitacao");
    try {
      form.setDiasPrazoEntregaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo entrega inválido!");
      form.setErroDiasPrazoEntregaLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasPrazoPagamentoLicitacao");
    try {
      form.setDiasPrazoPagamentoLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo pagamento inválido!");
      form.setErroDiasPrazoPagamentoLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "diasVigenciaLicitacao");
    try {
      form.setDiasVigenciaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo vigencia inválido!");
      form.setErroDiasVigenciaLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "anosPrazoGarantiaLicitacao");
    try {
      form.setAnosPrazoGarantiaLicitacao(Integer.parseInt(buffer));
    } catch (NumberFormatException ex) {
      form.addErro("Campo garantia inválido!");
      form.setErroAnosPrazoGarantiaLicitacao("Valor numérico(inteiro) inválido.");
    }

    buffer = util.Request.getParameter(req, "termosAmostraLicitacao");
    form.setTermosAmostraLicitacao(buffer);

    buffer = util.Request.getParameter(req, "termosGarantiaLicitacao");
    form.setTermosGarantiaLicitacao(buffer);

    buffer = util.Request.getParameter(req, "termosMultaLicitacao");
    form.setTermosMultaLicitacao(buffer);
  }
}

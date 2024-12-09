package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.INFRA.GeradorBoleto.CobrancaInput;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public interface GeradorBoletoService {

    public byte[] gerar(Fatura fatura, CobrancaInput cobranca);

    default Boleto criarBoleto(Fatura fatura, CobrancaInput cobranca) {

        var instrucao1 = String.format("Após o vencimento cobrar Juros de %s por mês.", cobranca.getJurosMora().getPorcentagem());
        var instrucao2 = String.format("Após o vencimento cobrar Multa de %s.", cobranca.getMulta().getPorcentagem());
        var instrucao3 = String.format("Referente a Fatura nº: %d", fatura.getIdFatura());

        var boleto = Boleto.novoBoleto()
                .comBanco(new BancoDoBrasil())
                .comDatas(criarDatas(fatura))
                .comBeneficiario(criarBeneficiario(fatura))
                .comPagador(criarPagador(cobranca))
                .comValorBoleto(fatura.getValor())
                .comNumeroDoDocumento(fatura.getNumeroDocumento())
                .comEspecieDocumento("DM")
                .comAceite(false)
                .comLocaisDePagamento("Pagável em qualquer Banco até o vencimento")
                .comInstrucoes(instrucao1, instrucao2, instrucao3);

        return boleto;
    }

    default Datas criarDatas(Fatura fatura){

        var vencimento = fatura.getDataVencimento();
        var criado = fatura.getCriado();
        var atualizado = fatura.getAtualizado();

        var datas = Datas.novasDatas()
                .comDocumento(criado.getDayOfMonth(), criado.getMonthValue(), criado.getYear())
                .comProcessamento(atualizado.getDayOfMonth(), atualizado.getMonthValue(), atualizado.getYear())
                .comVencimento(vencimento.getDayOfMonth(), vencimento.getMonthValue(), vencimento.getYear());

        return datas;
    }

    default Beneficiario criarBeneficiario(Fatura fatura){
        var empresa = fatura.getConta().getEmpresa();
        var conta = fatura.getConta();
        var endereco = Endereco.novoEndereco()
                .comLogradouro(empresa.getEndereco().getLogradouro().concat(", ").concat(empresa.getEndereco().getNumero()))
                .comBairro(empresa.getEndereco().getBairro())
                .comCep(insereMascaraAoRetornarDocumento(empresa.getEndereco().getCep().replaceAll("\\D", "")))
                .comCidade(empresa.getEndereco().getCidade())
                .comUf(empresa.getEndereco().getUf());

        var beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario(empresa.getRazaoSocial())
                .comDocumento(insereMascaraAoRetornarDocumento(empresa.getCnpj()))
                .comNossoNumero(fatura.getNossoNumero())
                .comAgencia(conta.getAgencia())
                .comDigitoAgencia(conta.getDigitoAgencia())
                .comCodigoBeneficiario(conta.getConta())
                .comDigitoCodigoBeneficiario(conta.getDigitoConta())
                .comNumeroConvenio(fatura.getConvenio().getNumeroContrato())
                .comCarteira(fatura.getConvenio().getCarteira())
                .comEndereco(endereco);

        return beneficiario;
    }

    default Pagador criarPagador(CobrancaInput cobranca) {

        var endereco = Endereco.novoEndereco()
                .comLogradouro(cobranca.getPagador().getEndereco())
                .comBairro(cobranca.getPagador().getBairro())
                .comCep(insereMascaraAoRetornarDocumento(cobranca.getPagador().getCep().toString().concat(" ")))
                .comCidade(cobranca.getPagador().getCidade())
                .comUf(cobranca.getPagador().getUf());

        var pagador = Pagador.novoPagador()
                .comNome(cobranca.getPagador().getNome())
                .comDocumento(insereMascaraAoRetornarDocumento(String.valueOf(cobranca.getPagador().getNumeroInscricao())))
                .comEndereco(endereco);

        return pagador;
    }

    default String insereMascaraAoRetornarDocumento(String documento) {
        try {
            MaskFormatter mask = new MaskFormatter();
            mask.setValueContainsLiteralCharacters(false);
            if (documento.length() == 11) {
                mask.setMask("###.###.###-##");
            } else if(documento.length() == 8) {
                mask.setMask("##.###-###");
            } else {
                mask.setMask("###.###.###/####-##");
            }
            return mask.valueToString(documento);
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao formatar documento.");
        }
    }
}

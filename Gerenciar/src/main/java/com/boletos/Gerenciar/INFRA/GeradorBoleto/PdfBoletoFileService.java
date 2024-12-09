package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.GeradorBoletoService;
import org.springframework.stereotype.Service;

@Service
public class PdfBoletoFileService implements GeradorBoletoService {


    @Override
    public byte[] gerar(Fatura fatura, CobrancaInput cobranca) {

        var boleto = criarBoleto(fatura, cobranca);

        var gerador = new GeradorDeBoleto(boleto);

        return gerador.geraPDF();
    }
}

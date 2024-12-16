package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.FaturaRegistradaRepository;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.GeradorBoletoService;
import com.boletos.Gerenciar.SERVICE.GeradorQrCode.GeradorQrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PdfBoletoFileService implements GeradorBoletoService {

    @Autowired
    private GeradorQrCodeService geradorQrCode;
    @Autowired
    private FaturaRegistradaRepository faturaRegistradaRepository;

    @Override
    public byte[] gerar(Fatura fatura, CobrancaInput cobranca) {

        var boleto = criarBoleto(fatura, cobranca);

        var pathBoletoPersonalizado = this.getClass().getResourceAsStream("/Relatorios/Boleto-Personalizado.jasper");
        var pathLogo = this.getClass().getResourceAsStream("/Relatorios/img.png");
        var faturaRegistrada  = faturaRegistradaRepository.buscarPorFaturaId(fatura.getIdFatura());

        var parametros = new HashMap<String, Object>();
        parametros.put("QRCODE", geradorQrCode.gerar(faturaRegistrada.getQrcodeEmv()));
        parametros.put("LOGO", pathLogo);

        var gerador = new GeradorDeBoleto(pathBoletoPersonalizado, parametros, boleto);

        return gerador.geraPDF();
    }
}

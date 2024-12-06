package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoletoRegistrado {

    private Long codigoCliente;
    private Long numeroCarteira;
    private Long numeroVariacaoCarteira;
    private String numero;
    private String linhaDigitavel;
    private String codigoBarraNumerico;
    private Long numeroContratoCobranca;
    private QrCode qrCode;
}

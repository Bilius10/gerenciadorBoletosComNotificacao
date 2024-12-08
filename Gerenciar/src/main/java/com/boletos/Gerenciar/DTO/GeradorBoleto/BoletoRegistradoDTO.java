package com.boletos.Gerenciar.DTO.GeradorBoleto;

public record BoletoRegistradoDTO(Long codigoCliente,
                                  Long numeroCarteira,
                                  Long numeroVariacaoCarteira,
                                  String numero,
                                  String linhaDigitavel,
                                  String codigoBarraNumerico,
                                  Long numeroContratoCobranca,
                                  QrCodeDTO qrCode) {
}

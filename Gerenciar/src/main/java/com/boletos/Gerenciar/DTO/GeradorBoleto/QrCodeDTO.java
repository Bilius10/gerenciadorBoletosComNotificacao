package com.boletos.Gerenciar.DTO.GeradorBoleto;

public record QrCodeDTO(String url,
                        String txid,
                        String emv) {
}

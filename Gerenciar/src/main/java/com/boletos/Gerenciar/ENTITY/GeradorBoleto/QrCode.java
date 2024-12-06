package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrCode {

    private String url;
    private String txid;
    private String emv;
}

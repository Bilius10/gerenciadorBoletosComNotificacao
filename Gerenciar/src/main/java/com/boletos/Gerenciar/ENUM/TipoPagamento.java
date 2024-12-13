package com.boletos.Gerenciar.ENUM;

public enum TipoPagamento {

    BOLETO("boleto");

    private String tipoPagamento;

    TipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
}

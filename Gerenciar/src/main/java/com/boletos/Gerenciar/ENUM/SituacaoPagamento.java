package com.boletos.Gerenciar.ENUM;

public enum SituacaoPagamento {

    PAGA("paga"),
    NAO_PAGA("nao paga"),
    CANCELADA("cancelada");

    private String situacaoPagamento;

    SituacaoPagamento(String situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public String getSituacaoPagamento() {
        return situacaoPagamento;
    }
}

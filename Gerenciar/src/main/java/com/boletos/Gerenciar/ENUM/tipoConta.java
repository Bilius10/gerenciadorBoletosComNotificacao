package com.boletos.Gerenciar.ENUM;

public enum tipoConta {

    BOLETO("boleto"),
    BET("bet"),
    RECARGA("recarga");

    private String tipoConta;

    tipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}

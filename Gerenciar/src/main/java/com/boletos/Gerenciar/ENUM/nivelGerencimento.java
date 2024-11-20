package com.boletos.Gerenciar.ENUM;

public enum nivelGerencimento {

    GERENTE("gerente"),
    COBRADOR("cobrador"),
    PAGADOR("pagador");

    private String role;

    nivelGerencimento(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

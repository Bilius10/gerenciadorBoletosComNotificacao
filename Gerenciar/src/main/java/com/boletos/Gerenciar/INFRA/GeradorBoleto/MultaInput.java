package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import java.math.BigDecimal;

public class MultaInput {

    private Integer tipo;
    private String data;
    private BigDecimal porcentagem;
    private BigDecimal valor;

    public MultaInput(Integer tipo, String data, BigDecimal porcentagem, BigDecimal valor) {
        this.tipo = tipo;
        this.data = data;
        this.porcentagem = porcentagem;
        this.valor = valor;
    }

    public MultaInput() {
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

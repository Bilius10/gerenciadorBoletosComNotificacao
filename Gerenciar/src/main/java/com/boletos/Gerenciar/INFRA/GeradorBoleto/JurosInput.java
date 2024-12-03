package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import java.math.BigDecimal;

public class JurosInput {

    private Integer tipo;
    private BigDecimal porcentagem;
    private BigDecimal valor;

    public JurosInput(Integer tipo, BigDecimal porcentagem, BigDecimal valor) {
        this.tipo = tipo;
        this.porcentagem = porcentagem;
        this.valor = valor;
    }

    public JurosInput() {
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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

package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import java.math.BigDecimal;

public class DescontoInput {

    private Integer tipo;
    private String dataExpiracao;
    private Long porcentagem;
    private BigDecimal valor;

    public DescontoInput(Integer tipo, String dataExpiracao, Long porcentagem, BigDecimal valor) {
        this.tipo = tipo;
        this.dataExpiracao = dataExpiracao;
        this.porcentagem = porcentagem;
        this.valor = valor;
    }

    public DescontoInput() {
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Long getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Long porcentagem) {
        this.porcentagem = porcentagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

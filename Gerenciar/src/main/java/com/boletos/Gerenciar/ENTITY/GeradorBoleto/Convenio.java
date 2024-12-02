package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Convenio {
    @Id
    private int idConvenio;
    private String numeroContrato;
    private String carteira;
    private String variacaoCarteira;
    private BigDecimal jurosPorcentagem;
    private BigDecimal multaPorcentagem;

    @OneToOne
    @JoinColumn(name = "idConta_Conta", nullable = false)
    private Conta conta;

    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

    public Convenio(int idConvenio, String numeroContrato, String carteira, String variacaoCarteira,
                    BigDecimal jurosPorcentagem, BigDecimal multaPorcentagem, Conta conta, LocalDateTime criado, LocalDateTime atualizado) {
        this.idConvenio = idConvenio;
        this.numeroContrato = numeroContrato;
        this.carteira = carteira;
        this.variacaoCarteira = variacaoCarteira;
        this.jurosPorcentagem = jurosPorcentagem;
        this.multaPorcentagem = multaPorcentagem;
        this.conta = conta;
        this.criado = criado;
        this.atualizado = atualizado;
    }

    public Convenio() {
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getVariacaoCarteira() {
        return variacaoCarteira;
    }

    public void setVariacaoCarteira(String variacaoCarteira) {
        this.variacaoCarteira = variacaoCarteira;
    }

    public BigDecimal getJurosPorcentagem() {
        return jurosPorcentagem;
    }

    public void setJurosPorcentagem(BigDecimal jurosPorcentagem) {
        this.jurosPorcentagem = jurosPorcentagem;
    }

    public BigDecimal getMultaPorcentagem() {
        return multaPorcentagem;
    }

    public void setMultaPorcentagem(BigDecimal multaPorcentagem) {
        this.multaPorcentagem = multaPorcentagem;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public LocalDateTime getCriado() {
        return criado;
    }

    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }

    public LocalDateTime getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.atualizado = atualizado;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    public int getIdConvenio() {
        return idConvenio;
    }


}

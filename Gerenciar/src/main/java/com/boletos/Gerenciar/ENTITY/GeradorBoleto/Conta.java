package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConta;
    private String agencia;
    private String conta;
    private String digitoAgencia;
    private String digitoConta;

    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

    @OneToOne
    @JoinColumn(name = "idBanco_Banco", nullable = false)
    private Banco banco;

    @OneToOne
    @JoinColumn(name = "idEmpresa_Empresa", nullable = false)
    private Empresa empresa;

    public Conta(UUID idConta, String agencia, String conta, String digitoAgencia,
                 String digitoConta, LocalDateTime criado, LocalDateTime atualizado, Banco banco, Empresa empresa) {
        this.idConta = idConta;
        this.agencia = agencia;
        this.conta = conta;
        this.digitoAgencia = digitoAgencia;
        this.digitoConta = digitoConta;
        this.criado = criado;
        this.atualizado = atualizado;
        this.banco = banco;
        this.empresa = empresa;
    }

    public Conta() {
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setIdConta(UUID idConta) {
        this.idConta = idConta;
    }

    public UUID getIdConta() {
        return idConta;
    }
}

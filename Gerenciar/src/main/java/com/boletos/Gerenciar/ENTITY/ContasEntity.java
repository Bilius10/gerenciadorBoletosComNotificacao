package com.boletos.Gerenciar.ENTITY;

import com.boletos.Gerenciar.ENUM.tipoConta;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "contas")
public class ContasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idConta")
    private UUID idContas;
    private String nome;
    private double valor;
    private LocalDateTime dataInicio;
    private LocalDateTime datafim;

    @Enumerated(EnumType.STRING)
    private tipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "idUsuario_usuario", nullable = false)
    private UsuarioEntity usuario;
    private boolean ativo;

    public ContasEntity(UUID idContas, String nome, double valor, LocalDateTime dataInicio, LocalDateTime datafim,
                        com.boletos.Gerenciar.ENUM.tipoConta tipoConta, UsuarioEntity usuario, boolean ativo) {
        this.idContas = idContas;
        this.nome = nome;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.datafim = datafim;
        this.tipoConta = tipoConta;
        this.usuario = usuario;
        this.ativo = ativo;
    }

    public ContasEntity() {
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDateTime datafim) {
        this.datafim = datafim;
    }

    public com.boletos.Gerenciar.ENUM.tipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(com.boletos.Gerenciar.ENUM.tipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setIdContas(UUID idContas) {
        this.idContas = idContas;
    }

    public UUID getIdContas() {
        return idContas;
    }
}

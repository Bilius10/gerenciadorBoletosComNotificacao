package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.ENUM.SituacaoPagamento;
import com.boletos.Gerenciar.ENUM.TipoPagamento;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFatura;
    private BigDecimal valor;
    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    @Enumerated(EnumType.STRING)
    private SituacaoPagamento situacaoPagamento;

    private String numeroDocumento;
    private String nossoNumero;

    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

    @OneToOne
    @JoinColumn(name = "idConta_Conta", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "idUsuario_usuario", nullable = false)
    private UsuarioEntity usuarioEntity;

    @OneToOne
    @JoinColumn(name = "idConvenio_Convenio", nullable = false)
    private Convenio convenio;

    public Fatura(UUID idFatura, BigDecimal valor, LocalDate dataVencimento, TipoPagamento tipoPagamento, SituacaoPagamento situacaoPagamento, String numeroDocumento, String nossoNumero,
                  LocalDateTime criado, LocalDateTime atualizado, Conta conta, UsuarioEntity usuarioEntity, Convenio convenio) {
        this.idFatura = idFatura;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.tipoPagamento = tipoPagamento;
        this.situacaoPagamento = situacaoPagamento;
        this.numeroDocumento = numeroDocumento;
        this.nossoNumero = nossoNumero;
        this.criado = criado;
        this.atualizado = atualizado;
        this.conta = conta;
        this.usuarioEntity = usuarioEntity;
        this.convenio = convenio;
    }

    public Fatura() {
    }

    public UUID getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(UUID idFatura) {
        this.idFatura = idFatura;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}

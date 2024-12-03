package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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




}

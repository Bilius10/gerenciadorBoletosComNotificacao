package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.ENUM.SituacaoPagamento;
import com.boletos.Gerenciar.ENUM.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFatura;
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
    private UsuarioEntity usuario;

    @OneToOne
    @JoinColumn(name = "idConvenio_Convenio", nullable = false)
    private Convenio convenio;


}

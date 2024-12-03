package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idConta;
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


}

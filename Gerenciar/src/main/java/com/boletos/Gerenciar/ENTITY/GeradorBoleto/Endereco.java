package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

}

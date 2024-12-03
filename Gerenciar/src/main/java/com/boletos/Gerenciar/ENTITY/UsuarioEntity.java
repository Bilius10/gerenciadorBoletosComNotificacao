package com.boletos.Gerenciar.ENTITY;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private String documento;
    private boolean pessoaFisica;
    private boolean status;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private LoginEntity loginEntity;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Fatura> faturas;


}

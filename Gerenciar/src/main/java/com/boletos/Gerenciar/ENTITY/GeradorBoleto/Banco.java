package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBanco;
    private String codigo;
    private String nome;
    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

    public Banco(int idBanco, String codigo, String nome, LocalDateTime criado, LocalDateTime atualizado) {
        this.idBanco = idBanco;
        this.codigo = codigo;
        this.nome = nome;
        this.criado = criado;
        this.atualizado = atualizado;
    }

    public Banco() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getIdBanco() {
        return idBanco;
    }
}

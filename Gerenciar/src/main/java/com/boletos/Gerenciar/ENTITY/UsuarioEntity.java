package com.boletos.Gerenciar.ENTITY;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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
    private boolean status;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private LoginEntity loginEntity;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Fatura> faturas;

    public UsuarioEntity(int idUsuario, String nome, String email, String telefone, boolean status) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
    }

    public UsuarioEntity() {
        this.status = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public LoginEntity getLoginEntity() {
        return loginEntity;
    }

    public void setLoginEntity(LoginEntity loginEntity) {
        this.loginEntity = loginEntity;
    }

    public List<Fatura> getContas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> contas) {
        this.faturas = contas;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", status=" + status +
                ", loginEntity=" + loginEntity +
                ", faturas=" + faturas +
                '}';
    }
}

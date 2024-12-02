package com.boletos.Gerenciar.ENTITY;

import com.boletos.Gerenciar.ENUM.nivelGerencimento;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "login")
public class LoginEntity implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "idLogin")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLogin;
    private String nome;
    private String senha;

    @Enumerated(EnumType.STRING)
    private nivelGerencimento nivelGerencimento;

    @OneToOne
    @JoinColumn(name = "idUsuario_usuario", nullable = false)
    private UsuarioEntity usuario;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public LoginEntity(int idLogin, String nome, String senha, UsuarioEntity usuario) {
        this.idLogin = idLogin;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
    }

    public LoginEntity() {

        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.enabled = true;
        this.credentialsNonExpired = true;
        this.nivelGerencimento = com.boletos.Gerenciar.ENUM.nivelGerencimento.PAGADOR;
    }

    public com.boletos.Gerenciar.ENUM.nivelGerencimento getNivelGerencimento() {
        return nivelGerencimento;
    }

    public void setNivelGerencimento(com.boletos.Gerenciar.ENUM.nivelGerencimento nivelGerencimento) {
        this.nivelGerencimento = nivelGerencimento;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(this.nivelGerencimento == com.boletos.Gerenciar.ENUM.nivelGerencimento.GERENTE) {
            return List.of(new SimpleGrantedAuthority(
                    "ROLE_GERENTE"), new SimpleGrantedAuthority("ROLE_COBRADOR"), new SimpleGrantedAuthority("ROLE_PAGADOR"));
        }else if(this.nivelGerencimento == com.boletos.Gerenciar.ENUM.nivelGerencimento.COBRADOR){
            return List.of(new SimpleGrantedAuthority("ROLE_COBRADOR"), new SimpleGrantedAuthority("ROLE_PAGADOR"));
        }else{
            return List.of(new SimpleGrantedAuthority("ROLE_PAGADOR"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdLogin() {
        return idLogin;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "idLogin=" + idLogin +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", nivelGerencimento=" + nivelGerencimento +
                ", usuario=" + usuario +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}

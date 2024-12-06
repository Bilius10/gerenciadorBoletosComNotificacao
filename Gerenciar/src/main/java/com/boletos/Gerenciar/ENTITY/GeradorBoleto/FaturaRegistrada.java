package com.boletos.Gerenciar.ENTITY.GeradorBoleto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class FaturaRegistrada {
    @Id
    private int idFaturaRegistrada;
    private String linhaDigitavel;
    private String qrcodeUrl;
    private String qrcodeEmv;

    @ManyToOne
    @JoinColumn(name = "fatura_id")
    private Fatura fatura;

    @CreationTimestamp
    private LocalDateTime criado;
    @UpdateTimestamp
    private LocalDateTime atualizado;

    public FaturaRegistrada criar(Fatura fatura, String linhaDigitavel, String qrcodeUrl, String qrCodeEmv){
        this.linhaDigitavel = linhaDigitavel;
        this.qrcodeUrl = qrcodeUrl;
        this.qrcodeEmv = qrCodeEmv;
        this.fatura = fatura;

        return this;
    }
}

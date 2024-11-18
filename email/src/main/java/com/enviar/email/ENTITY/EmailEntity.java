package com.enviar.email.ENTITY;

import com.enviar.email.ENUMs.StatusEmail;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "email")
public class EmailEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmail;
    private UUID idUsuario;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column
    private String text;
    private LocalDateTime localDateTime;
    private StatusEmail statusEmail;

    public void setIdEmail(UUID idEmail) {
        this.idEmail = idEmail;
    }

    public UUID getIdEmail() {
        return idEmail;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}

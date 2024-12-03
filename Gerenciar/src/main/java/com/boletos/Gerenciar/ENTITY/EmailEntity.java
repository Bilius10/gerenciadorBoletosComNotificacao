package com.boletos.Gerenciar.ENTITY;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    private int userId;
    private String emailTo;
    private String subject;
    private String text;


}

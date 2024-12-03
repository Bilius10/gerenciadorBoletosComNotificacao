package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultaInput {

    private Integer tipo;
    private String data;
    private BigDecimal porcentagem;
    private BigDecimal valor;


}

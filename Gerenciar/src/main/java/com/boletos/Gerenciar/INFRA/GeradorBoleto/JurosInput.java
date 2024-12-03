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
public class JurosInput {

    private Integer tipo;
    private BigDecimal porcentagem;
    private BigDecimal valor;


}

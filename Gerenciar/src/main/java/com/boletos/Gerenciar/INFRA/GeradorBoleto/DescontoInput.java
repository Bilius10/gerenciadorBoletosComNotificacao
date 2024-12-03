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
public class DescontoInput {

    private Integer tipo;
    private String dataExpiracao;
    private Long porcentagem;
    private BigDecimal valor;


}

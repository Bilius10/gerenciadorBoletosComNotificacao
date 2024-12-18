package com.boletos.Gerenciar.DTO.GeradorBoleto.Convenio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarConvenioDTO(@NotBlank String numeroContrato,
                               @NotBlank String carteira,
                               @NotBlank String variacaoCarteira,
                               @NotNull BigDecimal jurosPorcentagem,
                               @NotNull BigDecimal multaPorcentagem,
                               @NotNull int idConta) {
}

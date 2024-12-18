package com.boletos.Gerenciar.DTO.GeradorBoleto.Conta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarContaDTO(@NotBlank String agencia,
                            @NotBlank String conta,
                            @NotBlank String digitoAgencia,
                            @NotBlank String digitoConta,
                            @NotNull int idBanco,
                            @NotNull int idEmpresa) {
}
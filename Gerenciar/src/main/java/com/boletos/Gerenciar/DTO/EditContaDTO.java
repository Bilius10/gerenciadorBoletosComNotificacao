package com.boletos.Gerenciar.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record EditContaDTO(@NotNull int idContas,
                           @NotBlank String nome,
                           @NotNull double valor,
                           @NotNull LocalDateTime dataInicio,
                           @NotNull LocalDateTime dataFim,
                           @NotBlank String tipoConta,
                           @NotNull UUID idUsuario,
                           @NotBlank Boolean ativo) {
}

package com.boletos.Gerenciar.DTO.GeradorBoleto.Banco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditBancoDTO(@NotNull int idBanco,
                           @NotBlank String codigo,
                           @NotBlank String nome) {
}

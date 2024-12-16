package com.boletos.Gerenciar.DTO.GeradorBoleto.Banco;

import jakarta.validation.constraints.NotBlank;

public record CriarBancoDTO(@NotBlank String codigo,
                            @NotBlank String nome) {
}

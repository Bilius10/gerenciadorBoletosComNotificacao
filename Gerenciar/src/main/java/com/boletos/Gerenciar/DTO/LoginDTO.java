package com.boletos.Gerenciar.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String nome,
                       @NotBlank String senha) {
}

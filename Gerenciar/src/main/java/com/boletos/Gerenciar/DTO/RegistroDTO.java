package com.boletos.Gerenciar.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroDTO(@NotBlank String nome,
                          @NotBlank @Email String email,
                          @NotBlank String telefone,
                          @NotBlank String senha) {
}

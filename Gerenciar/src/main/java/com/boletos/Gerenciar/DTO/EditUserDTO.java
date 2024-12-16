package com.boletos.Gerenciar.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EditUserDTO(@NotNull int idUsuario,
                          @NotBlank String nome,
                          @NotBlank @Email String email,
                          @NotBlank String telefone,
                          @NotNull Boolean status) {
}

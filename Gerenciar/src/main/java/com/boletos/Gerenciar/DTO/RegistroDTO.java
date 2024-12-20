package com.boletos.Gerenciar.DTO;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroDTO(@NotBlank String nome,
                          @NotBlank @Email String email,
                          @NotBlank String telefone,
                          @NotBlank String senha,
                          @NotBlank String documento,
                          @NotNull boolean pessoaFisica,
                          @NotNull Endereco endereco) {
}

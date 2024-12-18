package com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarEmpresaDTO(@NotBlank String razaoSocial,
                              @NotBlank String cnpj,
                              @NotNull Endereco endereco) {
}

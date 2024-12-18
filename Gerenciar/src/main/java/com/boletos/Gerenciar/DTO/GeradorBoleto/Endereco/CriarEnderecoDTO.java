package com.boletos.Gerenciar.DTO.GeradorBoleto.Endereco;

import jakarta.validation.constraints.NotBlank;

public record CriarEnderecoDTO(@NotBlank String logradouro,
                               @NotBlank String numero,
                               @NotBlank String complemento,
                               @NotBlank String bairro,
                               @NotBlank String cidade,
                               @NotBlank String uf,
                               @NotBlank String cep) {
}
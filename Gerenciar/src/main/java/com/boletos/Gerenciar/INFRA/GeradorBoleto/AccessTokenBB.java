package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenBB {

    private String access_token;
    private String token_type;
    private Integer expires_in;


}

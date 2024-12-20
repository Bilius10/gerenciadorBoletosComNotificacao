package com.boletos.Gerenciar.CONTROLLER;

import br.com.caelum.stella.boleto.Beneficiario;
import com.boletos.Gerenciar.DTO.LoginDTO;
import com.boletos.Gerenciar.DTO.RegistroDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.SERVICE.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/registry")
    public ResponseEntity<String> registro(@RequestBody @Valid RegistroDTO registroDTO){

        LoginEntity loginTransfer = new LoginEntity();
        BeanUtils.copyProperties(registroDTO, loginTransfer, "email", "telefone", "endereco", "pessoaFisica", "documento");

        UsuarioEntity usuarioTransfer = new UsuarioEntity();
        BeanUtils.copyProperties(registroDTO, usuarioTransfer, "senha", "endereco");

        Endereco enderecoTransfer = new Endereco();
        BeanUtils.copyProperties(registroDTO, enderecoTransfer, "email", "telefone", "pessoaFisica", "documento", "senha");
        usuarioTransfer.setEndereco(enderecoTransfer);

        Optional<LoginEntity> loginConfirmacao = loginService.registro(loginTransfer, usuarioTransfer);

         if(loginConfirmacao.isEmpty()){
             return ResponseEntity.badRequest().body("Já existe um usuario com esse nome");
         }

         return ResponseEntity.status(HttpStatus.CREATED).body("Verifique seu email");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO){
        LoginEntity loginRecebendo = new LoginEntity();
        BeanUtils.copyProperties(loginDTO, loginRecebendo);

        Optional<LoginEntity> loginConfirmacao = loginService.login(loginRecebendo);

        if(loginConfirmacao.isEmpty()){
            return ResponseEntity.badRequest().body("Usuario ou senha incorretados");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Verifique seu email");

    }


}

package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.RegistroDTO;
import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.SERVICE.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/registry")
    public ResponseEntity<String> registro(@RequestBody @Valid RegistroDTO registroDTO){

        LoginEntity loginTransfer = new LoginEntity();
        BeanUtils.copyProperties(registroDTO, loginTransfer, "email", "telefone");
        UsuarioEntity usuarioTransfer = new UsuarioEntity();
        BeanUtils.copyProperties(registroDTO, usuarioTransfer, "senha");

        Optional<LoginEntity> loginConfirmacao = loginService.registro(loginTransfer, usuarioTransfer);

         if(loginConfirmacao.isEmpty()){
             return ResponseEntity.badRequest().body("Já existe um usuario com esse nome");
         }

         return ResponseEntity.status(HttpStatus.CREATED).body("Verifique seu email");
    }
}
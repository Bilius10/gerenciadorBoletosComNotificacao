package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.SERVICE.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> buscarTodosUsuarios(){

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable UUID id){

        Optional<UsuarioEntity> usuarioExiste = usuarioService.buscarUsuario(id);

        if(usuarioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioExiste);

    }
}

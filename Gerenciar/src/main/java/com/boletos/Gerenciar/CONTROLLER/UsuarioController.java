package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.EditUserDTO;
import com.boletos.Gerenciar.ENTITY.ContasEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.SERVICE.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<Object> editarUsuario(@RequestBody EditUserDTO editUserDTO){
        UsuarioEntity usuarioRecebeDTO = new UsuarioEntity();

        BeanUtils.copyProperties(editUserDTO, usuarioRecebeDTO);

        Optional<UsuarioEntity> usuarioEditado = usuarioService.editarUsuario(usuarioRecebeDTO);

        if(usuarioEditado.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable UUID id){

        Optional<UsuarioEntity> usuarioExcluido = usuarioService.deleteUsuario(id);

        if(usuarioExcluido.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuario excluido");
    }

    @GetMapping("/contas/{id}")
    private ResponseEntity<List<ContasEntity>> contasUsuario(@PathVariable UUID id){

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.contasUsuario(id));
    }
}

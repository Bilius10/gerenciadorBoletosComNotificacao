package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> buscarTodosUsuarios(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> buscarUsuario(UUID id){

        return usuarioRepository.findById(id);

    }
}

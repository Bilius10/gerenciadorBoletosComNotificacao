package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.ContasEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.REPOSITORY.ContasRepository;
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

    @Autowired
    private ContasRepository contasRepository;

    public List<UsuarioEntity> buscarTodosUsuarios(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> buscarUsuario(UUID id){

        return usuarioRepository.findById(id);

    }

    public Optional<UsuarioEntity> editarUsuario(UsuarioEntity usuarioEntity){

        Optional<UsuarioEntity> byId = usuarioRepository.findById(usuarioEntity.getIdUsuario());

        if(byId.isEmpty()){
            return byId;
        }

        return Optional.of(usuarioRepository.save(usuarioEntity));
    }

    public Optional<UsuarioEntity> deleteUsuario(UUID id){
        Optional<UsuarioEntity> usuarioExiste = usuarioRepository.findById(id);

        if(usuarioExiste.isPresent()){
            usuarioRepository.deleteById(id);
        }

        return usuarioExiste;
    }

    public List<ContasEntity> contasUsuario(UUID id){

        return contasRepository.findByUsuario(id);
    }
}

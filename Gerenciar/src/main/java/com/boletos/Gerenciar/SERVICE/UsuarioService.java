package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.FaturaRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FaturaRepository contasRepository;

    public List<UsuarioEntity> buscarTodosUsuarios(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> buscarUsuario(int id){

        return usuarioRepository.findById(id);

    }

    public Optional<UsuarioEntity> editarUsuario(UsuarioEntity usuarioEntity){

        Optional<UsuarioEntity> byId = usuarioRepository.findById(usuarioEntity.getIdUsuario());

        if(byId.isEmpty()){
            return byId;
        }

        return Optional.of(usuarioRepository.save(usuarioEntity));
    }

    public Optional<UsuarioEntity> deleteUsuario(int id){
        Optional<UsuarioEntity> usuarioExiste = usuarioRepository.findById(id);

        if(usuarioExiste.isPresent()){
            usuarioRepository.deleteById(id);
        }

        return usuarioExiste;
    }

    public List<Fatura> contasUsuario(int id){

        return contasRepository.findByUsuario(id);
    }
}

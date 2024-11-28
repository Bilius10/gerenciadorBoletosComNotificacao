package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.ContasEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.REPOSITORY.ContasRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ContasEntity> buscarTodasContas(){
        return contasRepository.findAll();
    }

    public Optional<ContasEntity> buscarConta(UUID id){

        return contasRepository.findById(id);
    }

    public Optional<ContasEntity> deletarConta(UUID id){

        Optional<ContasEntity> contaExiste = contasRepository.findById(id);

        if(contaExiste.isPresent()){
            contasRepository.deleteById(id);

        }
        return contaExiste;
    }

    public Optional<ContasEntity> editarContas(ContasEntity contasEntity, UUID idUsuario) throws RegraNegocioException{

        Optional<ContasEntity> byIdConta = contasRepository.findById(contasEntity.getIdContas());

        if(byIdConta.isEmpty()){
            throw new RegraNegocioException("Sala não encontrada");
        }

        Optional<UsuarioEntity> byIdUsuario = usuarioRepository.findById(idUsuario);

        if(byIdConta.isEmpty()){
            throw new RegraNegocioException("Usuario não existe");
        }
        contasEntity.setUsuario(byIdUsuario.get());

        //continuar amanha
        return Optional.of(contasRepository.save(contasEntity));
    }
}

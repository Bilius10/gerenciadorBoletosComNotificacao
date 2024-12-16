package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> buscarTodosBancos(){

        return bancoRepository.findAll();
    }

    public Optional<Banco> buscarBanco(int id){

        return bancoRepository.findById(id);

    }

    public Banco saveBanco(Banco banco){
        return bancoRepository.save(banco);
    }

    public Optional<Banco> editarBanco(Banco banco){

        Optional<Banco> byId = bancoRepository.findById(banco.getIdBanco());

        if(byId.isEmpty()){
            return byId;
        }

        return Optional.of(bancoRepository.save(banco));
    }

    public Optional<Banco> deleteBanco(int id){
        Optional<Banco> bancoExiste = bancoRepository.findById(id);

        if(bancoExiste.isPresent()){
            bancoRepository.deleteById(id);
        }

        return bancoExiste;
    }
}

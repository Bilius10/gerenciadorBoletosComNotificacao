package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> buscarTodosEnderecos(){

        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEndereco(int id){

        return enderecoRepository.findById(id);

    }

    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> editarEndereco(Endereco endereco){

        Optional<Endereco> byId = enderecoRepository.findById(endereco.getIdEndereco());

        if(byId.isEmpty()){
            return byId;
        }

        return Optional.of(enderecoRepository.save(endereco));
    }

    public Optional<Endereco> deleteEndereco(int id){
        Optional<Endereco> enderecoExiste = enderecoRepository.findById(id);

        if(enderecoExiste.isPresent()){
            enderecoRepository.deleteById(id);
        }

        return enderecoExiste;
    }
}

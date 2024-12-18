package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Conta;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.BancoRepository;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.ContaRepository;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private BancoRepository bancoRepository;

    public List<Conta> buscarTodasContas(){

        return contaRepository.findAll();
    }

    public Optional<Conta> buscarConta(int id){

        return contaRepository.findById(id);

    }

    public Conta saveConta(Conta conta, int idBanco, int idEmpresa) throws RegraNegocioException {

        Optional<Empresa> empresaExiste = empresaRepository.findById(idEmpresa);

        if(empresaExiste.isEmpty()){
            throw new RegraNegocioException("ID da empresa incorreto");
        }
        conta.setEmpresa(empresaExiste.get());

        Optional<Banco> bancoExiste = bancoRepository.findById(idBanco);

        if(bancoExiste.isEmpty()){
            throw new RegraNegocioException("ID do banco incorreto");
        }
        conta.setBanco(bancoExiste.get());

        return contaRepository.save(conta);
    }

    public Conta editConta(Conta conta, int idBanco, int idEmpresa) throws RegraNegocioException {

        Optional<Conta> contaExiste = contaRepository.findById(idBanco);

        if(contaExiste.isEmpty()){
            throw new RegraNegocioException("ID da conta incorreto");
        }

        Optional<Empresa> empresaExiste = empresaRepository.findById(idEmpresa);

        if(empresaExiste.isEmpty()){
            throw new RegraNegocioException("ID da empresa incorreto");
        }
        conta.setEmpresa(empresaExiste.get());

        Optional<Banco> bancoExiste = bancoRepository.findById(conta.getBanco().getIdBanco());

        if(bancoExiste.isEmpty()){
            throw new RegraNegocioException("ID do banco incorreto");
        }
        conta.setBanco(bancoExiste.get());

        return contaRepository.save(conta);
    }

    public Optional<Conta> deleteConta(int id){
        Optional<Conta> contaExiste = contaRepository.findById(id);

        if(contaExiste.isPresent()){
            contaRepository.deleteById(id);
        }

        return contaExiste;
    }
}

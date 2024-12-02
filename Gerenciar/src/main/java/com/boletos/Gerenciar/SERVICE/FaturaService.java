package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.INFRA.CobrancaInput;
import com.boletos.Gerenciar.REPOSITORY.FaturaRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public CobrancaInput transformarFaturaEmCobranca(int faturaId){
        Optional<Fatura> byId = faturaRepository.findById(faturaId);

        return criar(byId.get());
    }

    public CobrancaInput criar(Fatura fatura){

        CobrancaInput cobrancaInput = new CobrancaInput();
        cobrancaInput.setNumeroConvenio((long) fatura.getConvenio().getIdConvenio());
        cobrancaInput.setNumeroCarteira(Integer.valueOf(fatura.getConvenio().getCarteira()));
        cobrancaInput.setNumeroVariacaoCarteira(Integer.valueOf(fatura.getConvenio().getVariacaoCarteira()));
        cobrancaInput.setDataVencimento(String.valueOf(fatura.getDataVencimento()));
        cobrancaInput.setDataEmissao(String.valueOf(LocalDate.now()));
        cobrancaInput.setValorOriginal(fatura.getValor());
        cobrancaInput.setIndicadorAceiteTituloVencido("S");
        cobrancaInput.setCodigoAceite('N');
        cobrancaInput.setCodigoTipoTitulo(2);
        cobrancaInput.setDescricaoTipoTitulo("Duplicata Mercantil");
        cobrancaInput.setIndicadorPermissaoRecebimentoParcial("N");
        cobrancaInput.setNomeTituloBeneficiario(fatura.getNumeroDocumento());
        cobrancaInput.setNumeroTituloCliente(String.format("%010d", Long.valueOf(fatura.getConvenio().getNumeroContrato()
                .concat(String.format("%010d", Long.valueOf(fatura.getNumeroDocumento()))))));
        cobrancaInput.setIndicadorPix("S");
        return cobrancaInput;

    }

    public List<Fatura> buscarTodasContas(){
        return faturaRepository.findAll();
    }

    public Optional<Fatura> buscarConta(int id){

        return faturaRepository.findById(id);
    }

    public Optional<Fatura> deletarConta(int id){

        Optional<Fatura> contaExiste = faturaRepository.findById(id);

        if(contaExiste.isPresent()){
            faturaRepository.deleteById(id);

        }
        return contaExiste;
    }


}

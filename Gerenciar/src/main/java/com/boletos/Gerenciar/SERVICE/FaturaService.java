package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.CONTROLLER.CobrancaController;
import com.boletos.Gerenciar.DTO.GeradorBoleto.BoletoRegistradoDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.CobrancaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.FaturaRegistrada;
import com.boletos.Gerenciar.INFRA.GeradorBoleto.*;
import com.boletos.Gerenciar.REPOSITORY.FaturaRegistradaRepository;
import com.boletos.Gerenciar.REPOSITORY.FaturaRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import com.boletos.Gerenciar.UTIL.Normalizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AccessTokenController accessTokenController;
    @Autowired
    private CobrancaController cobrancaController;
    @Autowired
    private FaturaRegistradaRepository faturaRegistradaRepository;

    @Transactional
    public BoletoRegistradoDTO registrarCobranca(int faturaId, CobrancaDTO cobrancaModel){
        var token = accessTokenController.requisitarToken(cobrancaModel.clientId(), cobrancaModel.clientSecret());
        var boletoRegistrado = cobrancaController.registrar(transformarFaturaEmCobranca(faturaId), token, cobrancaModel.appkey());

        var fatura = faturaRepository.findById(faturaId);
        fatura.get().setNossoNumero(boletoRegistrado.numero());
        var faturaRegistrada = new FaturaRegistrada().criar(fatura.get(), boletoRegistrado.linhaDigitavel(),
                boletoRegistrado.qrCode().url(), boletoRegistrado.qrCode().emv());

        faturaRegistradaRepository.save(faturaRegistrada);
        return boletoRegistrado;
    }

    public CobrancaInput transformarFaturaEmCobranca(int faturaId){

        System.out.println(accessTokenController.requisitarToken("eyJpZCI6IjQxODM2ZDMtODY0OC00NDRkLWI5ODkiLCJjb2RpZ29QdWJsaWNhZG9yIjowLCJjb2RpZ29Tb2Z0d2FyZSI6MTE4NDQzLCJzZXF1ZW5jaWFsSW5zdGFsYWNhbyI6MX0",
                "eyJpZCI6IjFjZWFjNzUtOTUiLCJjb2RpZ29QdWJsaWNhZG9yIjowLCJjb2RpZ29Tb2Z0d2FyZSI6MTE4NDQzLCJzZXF1ZW5jaWFsSW5zdGFsYWNhbyI6MSwic2VxdWVuY2lhbENyZWRlbmNpYWwiOjEsImFtYmllbnRlIjoiaG9tb2xvZ2FjYW8iLCJpYXQiOjE3MzMxODMxOTYyMzJ9"));

        Optional<Fatura> byId = faturaRepository.findById(faturaId);

        return criar(byId.get());
    }

    public CobrancaInput criar(Fatura fatura){

        CobrancaInput cobrancaInput = new CobrancaInput();

        DescontoInput descontoInput = new DescontoInput();
        descontoInput.setTipo(0);

        JurosInput jurosInput = new JurosInput();
        jurosInput.setTipo(2);
        jurosInput.setPorcentagem(fatura.getConvenio().getJurosPorcentagem());
        jurosInput.setValor(BigDecimal.ZERO);

        MultaInput multaInput = new MultaInput();
        multaInput.setTipo(2);
        multaInput.setData(String.valueOf(fatura.getDataVencimento().plusDays(1)));
        multaInput.setPorcentagem(fatura.getConvenio().getMultaPorcentagem());
        multaInput.setValor(BigDecimal.ZERO);

        PagadorInput pagadorInput = new PagadorInput();
        pagadorInput.setTipoInscricao(fatura.getUsuarioEntity().isPessoaFisica() ? 1:2);
        pagadorInput.setNumeroInscricao(Long.valueOf(String.valueOf(fatura.getUsuarioEntity().getDocumento())));
        pagadorInput.setNome(Normalizador.norm(fatura.getUsuarioEntity().getNome()));
        pagadorInput.setCep(Long.valueOf(fatura.getUsuarioEntity().getEndereco().getCep()));
        pagadorInput.setCidade(Normalizador.norm(fatura.getUsuarioEntity().getEndereco().getCidade()));
        pagadorInput.setBairro(Normalizador.abreviar(Normalizador.norm(fatura.getUsuarioEntity().getEndereco().getBairro())));
        pagadorInput.setUf(fatura.getUsuarioEntity().getEndereco().getUf());
        pagadorInput.setEndereco(Normalizador.criarEnderecoCompleto((fatura.getUsuarioEntity()), 40));

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
        cobrancaInput.setNumeroTituloBeneficiario(fatura.getNumeroDocumento());
        cobrancaInput.setNumeroTituloCliente(String.format("%010d", Long.valueOf(fatura.getConvenio().getNumeroContrato()
                .concat(String.format("%010d", Long.valueOf(fatura.getNumeroDocumento()))))));
        cobrancaInput.setIndicadorPix("S");
        cobrancaInput.setDesconto(descontoInput);
        cobrancaInput.setJurosMora(jurosInput);
        cobrancaInput.setMulta(multaInput);
        cobrancaInput.setPagador(pagadorInput);
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

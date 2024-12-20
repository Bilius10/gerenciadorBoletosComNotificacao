package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.INFRA.SecurityAcess.TokenService;
import com.boletos.Gerenciar.PRODUCER.EmailProducer;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.EnderecoRepository;
import com.boletos.Gerenciar.REPOSITORY.LoginRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final EmailProducer emailProducer;
    private final EnderecoRepository enderecoRepository;

    public LoginService(LoginRepository loginRepository, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, TokenService tokenService, EmailProducer emailProducer, EnderecoRepository enderecoRepository) {
        this.loginRepository = loginRepository;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.emailProducer = emailProducer;
        this.enderecoRepository = enderecoRepository;
    }

    public Optional<LoginEntity> registro(LoginEntity loginEntity, UsuarioEntity usuarioEntity){

        Optional<LoginEntity> existeEsseNome = loginRepository.findByNome(loginEntity.getNome());
        System.out.println(1);
        if(existeEsseNome.isPresent()){
            return Optional.empty();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(loginEntity.getSenha());
        loginEntity.setSenha(encryptedPassword);

        usuarioRepository.save(usuarioEntity);
        Optional<UsuarioEntity> byNome = usuarioRepository.findByNome(usuarioEntity.getNome());

        byNome.ifPresent(usuario -> {loginEntity.setUsuario(usuario);
            loginRepository.save(loginEntity);
        });

        emailProducer.publishWelComeMessage(usuarioEntity);

        enderecoRepository.save(usuarioEntity.getEndereco());
        return Optional.of(loginRepository.save(loginEntity));
    }

    public Optional<LoginEntity> login(LoginEntity loginEntity){

        Optional<LoginEntity> existeEsseLogin = loginRepository.findByNome(loginEntity.getNome());

        if (existeEsseLogin.isEmpty()) {

            return Optional.empty();
        }

        LoginEntity loginExistente = existeEsseLogin.get();
        BCryptPasswordEncoder compare = new BCryptPasswordEncoder();


        if (!compare.matches(loginEntity.getSenha(), loginExistente.getSenha())) {
            return Optional.empty();
        }
        Optional<UsuarioEntity> usuarioParaEnviarEmail = usuarioRepository.findByNome(existeEsseLogin.get().getUsuario().getNome());


        if(usuarioParaEnviarEmail.isPresent()) {

            var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginEntity.getNome(), loginEntity.getSenha());
            var auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var token = tokenService.generateToken((LoginEntity) auth.getPrincipal());
            System.out.println(token);
            emailProducer.publishCodeForLogin(usuarioParaEnviarEmail.get(), token);
        }

        return existeEsseLogin;

    }
}

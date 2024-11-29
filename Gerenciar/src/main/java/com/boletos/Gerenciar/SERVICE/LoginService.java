package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.INFRA.TokenService;
import com.boletos.Gerenciar.PRODUCER.EmailProducer;
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

    public LoginService(LoginRepository loginRepository, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, TokenService tokenService, EmailProducer emailProducer) {
        this.loginRepository = loginRepository;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.emailProducer = emailProducer;
    }

    public Optional<LoginEntity> registro(LoginEntity loginEntity, UsuarioEntity usuarioEntity){

        Optional<LoginEntity> existeEsseNome = loginRepository.findByNome(loginEntity.getNome());

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

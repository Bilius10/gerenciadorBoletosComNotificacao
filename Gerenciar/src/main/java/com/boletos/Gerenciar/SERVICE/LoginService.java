package com.boletos.Gerenciar.SERVICE;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import com.boletos.Gerenciar.INFRASECURITY.TokenService;
import com.boletos.Gerenciar.REPOSITORY.LoginRepository;
import com.boletos.Gerenciar.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public Optional<LoginEntity> registro(LoginEntity loginEntity, UsuarioEntity usuarioEntity){

        Optional<String> existeEsseNome = loginRepository.findByNome(loginEntity.getNome());

        if(existeEsseNome.isPresent()){
            return null;
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(loginEntity.getPassword());
        loginEntity.setSenha(encryptedPassword);

        loginRepository.save(loginEntity);
        usuarioRepository.save(usuarioEntity);

        return Optional.of(loginEntity);
    }
}

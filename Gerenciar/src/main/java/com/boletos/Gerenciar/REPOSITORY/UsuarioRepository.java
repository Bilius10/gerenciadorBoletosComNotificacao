package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    @Query("select u from UsuarioEntity u where u.nome = :nome")
    Optional<UsuarioEntity> findByNome(String nome);
}

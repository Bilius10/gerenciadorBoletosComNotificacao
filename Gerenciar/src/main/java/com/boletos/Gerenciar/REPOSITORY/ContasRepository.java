package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.ContasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContasRepository extends JpaRepository<ContasEntity, UUID> {

    @Query("select c from ContasEntity c where c.usuario.idUsuario = :id")
    List<ContasEntity> findByUsuario(UUID id);
}

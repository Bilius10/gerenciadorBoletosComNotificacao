package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.ContasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContasRepository extends JpaRepository<ContasEntity, UUID> {
}

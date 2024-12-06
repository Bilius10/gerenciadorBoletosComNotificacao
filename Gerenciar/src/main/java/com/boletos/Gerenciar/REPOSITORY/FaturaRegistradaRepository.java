package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.FaturaRegistrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRegistradaRepository extends JpaRepository<FaturaRegistrada, Long> {
}

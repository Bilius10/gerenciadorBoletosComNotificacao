package com.boletos.Gerenciar.REPOSITORY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
}

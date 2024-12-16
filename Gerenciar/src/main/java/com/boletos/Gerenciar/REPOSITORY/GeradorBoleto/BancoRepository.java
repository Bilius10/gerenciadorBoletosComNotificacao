package com.boletos.Gerenciar.REPOSITORY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}

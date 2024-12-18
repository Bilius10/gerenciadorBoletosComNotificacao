package com.boletos.Gerenciar.REPOSITORY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {
}

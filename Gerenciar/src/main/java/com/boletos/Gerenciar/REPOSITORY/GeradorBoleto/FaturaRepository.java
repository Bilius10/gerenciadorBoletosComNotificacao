package com.boletos.Gerenciar.REPOSITORY.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

    @Query("select f from Fatura f where f.usuario.idUsuario = :id")
    List<Fatura> findByUsuario(int id);
}

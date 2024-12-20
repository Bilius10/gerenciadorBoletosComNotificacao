package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {


    @Query("SELECT l FROM LoginEntity l WHERE l.nome = :nome")
    UserDetails findUserDetailsByNome(String nome);

    @Query("select l from LoginEntity l where l.nome = :nome")
    Optional<LoginEntity> findByNome(String nome);


}

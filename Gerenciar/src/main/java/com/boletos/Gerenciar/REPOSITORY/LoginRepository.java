package com.boletos.Gerenciar.REPOSITORY;

import com.boletos.Gerenciar.ENTITY.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, UUID> {


    @Query("SELECT l FROM LoginEntity l WHERE l.nome = :name")
    UserDetails findUserDetailsByName(String name);
}
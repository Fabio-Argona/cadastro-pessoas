package com.condominio.cadastro_pessoas.repository;

import com.condominio.cadastro_pessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    Optional<Pessoa> findByEmail(String email);
}


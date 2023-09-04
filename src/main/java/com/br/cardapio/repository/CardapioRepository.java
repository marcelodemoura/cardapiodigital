package com.br.cardapio.repository;


import com.br.cardapio.entity.CardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardapioRepository extends JpaRepository<CardapioEntity, UUID> {

    Optional<CardapioEntity> findById(Long id);
}
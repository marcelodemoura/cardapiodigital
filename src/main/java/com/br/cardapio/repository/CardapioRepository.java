package com.br.cardapio.repository;

import com.br.cardapio.entity.Cardapio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cardapio")
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
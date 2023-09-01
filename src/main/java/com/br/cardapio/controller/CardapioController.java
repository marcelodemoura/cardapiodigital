package com.br.cardapio.controller;

import com.br.cardapio.dto.CardapioDTO;
import com.br.cardapio.entity.Cardapio;
import com.br.cardapio.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.hibernate.Hibernate.map;

@RestController
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    private CardapioRepository repository;

    @GetMapping
    public List  <CardapioDTO> getAll(){
        List<CardapioDTO> cardapioList = repository.findAll().stream().map(CardapioDTO::new).toList();
        return cardapioList;

    }
}

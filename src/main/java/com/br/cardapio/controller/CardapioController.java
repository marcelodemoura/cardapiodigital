package com.br.cardapio.controller;


import com.br.cardapio.dto.CardapioDTO;
import com.br.cardapio.entity.CardapioEntity;
import com.br.cardapio.repository.CardapioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardapioController {


    @Autowired
    CardapioRepository cardapioRepository;

    @PostMapping("/itens")
    public ResponseEntity<CardapioEntity> saveItem(@RequestBody @Valid CardapioDTO cardapioDTO) {
        var cardapioEntity = new CardapioEntity();
        BeanUtils.copyProperties(cardapioDTO, cardapioEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioRepository.save(cardapioEntity));
    }

    @GetMapping("/itens")
    public ResponseEntity<List<CardapioEntity>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cardapioRepository.findAll());
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Object> getItemID(@PathVariable(value = "id") Long id) {
        Optional<CardapioEntity> productO = cardapioRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao existe em estoque");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<Object> updeteItem(@PathVariable(value = "id") Long id,
                                             @RequestBody @Valid CardapioDTO cardapioDTO) {
        Optional<CardapioEntity> productO = cardapioRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(cardapioDTO, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(cardapioRepository.save(productModel));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {
        Optional<CardapioEntity> productO = cardapioRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        cardapioRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido sucesso");
    }


}
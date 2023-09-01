package com.br.cardapio.dto;

import com.br.cardapio.entity.Cardapio;

public record CardapioDTO(Long id, String nome, String imagem, String preco) {

    public CardapioDTO(Cardapio cardapio) {
        this(cardapio.getId(), cardapio.getNome(), cardapio.getImage(), cardapio.getPreco());
    }

}

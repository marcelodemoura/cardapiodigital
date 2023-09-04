package com.br.cardapio.entity
        ;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_cardapio")
public class CardapioEntity extends RepresentationModel<CardapioEntity> implements Serializable {

    private static final long serialVersionUUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String image;

    private BigDecimal preco;


}


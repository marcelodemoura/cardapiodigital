package com.br.cardapio.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "cardapio")
@Table(name = "tb_cardapio")
public class Cardapio {

    private static final long serialVersionUUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String image;

    private String preco;

}

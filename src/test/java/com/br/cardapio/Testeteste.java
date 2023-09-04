package com.br.cardapio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
@ExtendWith(MockitoExtension.class)
public class Testeteste {
    @Mock
    private List<String>itens;

    @Test
    void  adicionaritens(){
        Mockito.when(itens.get(0)).thenReturn("B");
        Assertions.assertEquals("B",itens.get(0));
    }
}

package com.github.kyriosdata.exemplo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiretorioFornecedoresTest {

    @Test
    void testa() {
        DiretorioFornecedores ff = new DiretorioFornecedores();
        ff.adiciona(new CaldasNovas());
        assertEquals("Caldas Novas", ff.fornecedores().iterator().next());
    }

}

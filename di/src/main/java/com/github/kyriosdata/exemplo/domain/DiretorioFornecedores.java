package com.github.kyriosdata.exemplo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DiretorioFornecedores {

    private Collection<Supplier<Leite>> fornecedores = new ArrayList<>();

    public Collection<String> fornecedores() {
       return fornecedores.stream()
               .map(f -> f.get().getNome())
               .collect(Collectors.toList());
    }

    public void adiciona(Supplier<Leite> fornecedor) {
        fornecedores.add(fornecedor);
    }

}
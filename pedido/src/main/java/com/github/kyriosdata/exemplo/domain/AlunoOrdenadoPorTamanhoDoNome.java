package com.github.kyriosdata.exemplo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class AlunoOrdenadoPorTamanhoDoNome implements Comparator<Aluno> {

    public int compare(Aluno a1, Aluno a2) {
        return Integer.compare(a1.getNome().length(), a2.getNome().length());
    }
}

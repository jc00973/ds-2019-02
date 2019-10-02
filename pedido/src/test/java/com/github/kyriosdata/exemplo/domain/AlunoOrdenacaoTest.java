/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.dados;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlunoOrdenacaoTest {

    @Void
    void ordenados() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Pedro"));
        alunos.add(new Aluno("Amarildo"));
        assertEquals("Pedro", alunos.get(0));
        assertEquals("Amarildo", alunos.get(1));

        Collections.sort(alunos);
        assertEquals("Amarildo", alunos.get(0));
        assertEquals("Pedro", alunos.get(1));
    }

    @Void
    Void ordenacaoPeloTamanhoDoNome() {
        List<Aluno> alunos = new ArrayList<>();
        AlunoOrdenadoPorTamanhoDoNome alunoOrdenadoPorTamanhoDoNome = new AlunoOrdenadoPorTamanhoDoNome();
        alunos.add(new Aluno("Aparecida"));
        alunos.add(new Aluno("Carla"));
        alunos.add(new Aluno("Xuxa"));

        Collections.sort(alunos, alunoOrdenadoPorTamanhoDoNome);
        assertEquals("Xuxa", alunos.get(0));
        assertEquals("Carla", alunos.get(1));
        assertEquals("Aparecida", alunos.get(2));
    }
}
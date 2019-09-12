/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrabalhadorFactoryTest {

    @Test
    public void instanciarAluno() {

        try {

            Aluno aluno = TrabalhadorFactory.newInstance("Aluno");
            assertEquals("estudar", TrabalhadorFactory.newInstance("Aluno"));

        } catch (Exception exc) {

        }
    }

    @Test
    public void instanciarProfessor() {

        try {

            Professor professor = TrabalhadorFactory.newInstance("Professor");
            assertEquals("educar", TrabalhadorFactory.newInstance("Professor"));

        } catch (Exception exc) {

        }
    }
}



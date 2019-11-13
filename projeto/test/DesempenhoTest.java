package projeto.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DesempenhoTest {

    @Test
    void testCrivoEratostenes() {
        assertEquals(true, AlgoritmosEmJava.crivoEratostenes(vetorTeste1, 2));
        assertEquals(true, AlgoritmosEmJava.crivoEratostenes(vetorTeste2, 3));
        assertEquals(true, AlgoritmosEmJava.crivoEratostenes(vetorTeste3, 5));
        assertEquals(true, AlgoritmosEmJava.crivoEratostenes(vetorTeste7, 59));
        assertEquals(false, AlgoritmosEmJava.crivoEratostenes(vetorTeste4, 4));
        assertEquals(false, AlgoritmosEmJava.crivoEratostenes(vetorTeste5, 6));
        assertEquals(false, AlgoritmosEmJava.crivoEratostenes(vetorTeste6, 8));
        assertEquals(false, AlgoritmosEmJava.crivoEratostenes(vetorTeste8, 36));
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosEmJava.crivoEratostenes(vetorTeste9, -17));
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosEmJava.crivoEratostenes(vetorTeste10, 3));

    }
}

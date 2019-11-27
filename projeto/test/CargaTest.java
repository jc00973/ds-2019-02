package projeto.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CargaTest {

    Map<String, Double> variaveis = new HashMap<>();
    variaveis.put(x, 10);
    variaveis.put(y, 20);

    @Test
    void testCarga() {
        assertEquals(500, AvaliadorDesempenho.avaliarDesempenho(variaveis, expressao));
        assertThrows(IllegalArgumentException.class,
                () -> AvaliadorDesempenho.avaliarDesempenho(variaveis, expressaoInvalida));

    }
}

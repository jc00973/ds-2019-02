package projeto.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DesempenhoTest {

    Map<String, Double> variaveisPack01 = new HashMap<>();
    variaveisPack01.put(x, 2);
    variaveisPack01.put(y, 3);
    variaveisPack01.put(z, 5);

    String exp01 = "x + y";


    @Test
    void testDesempenho() {
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp01, 5, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp01, 5, 200));

        assertThrows(IllegalArgumentException.class,
                () -> AvaliadorDesempenho.avaliarDesempenho(variaveis, expressaoInvalida));

    }
}

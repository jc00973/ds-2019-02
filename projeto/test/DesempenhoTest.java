package projeto.test;

import avaliadores.RespostaErradaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DesempenhoTest {

    Map<String, Double> variaveisPack01 = new HashMap<>();
    variaveisPack01.put(x, 2);
    variaveisPack01.put(y, 3);
    variaveisPack01.put(z, 5);

    String exp01 = "x + y";
    String exp02 = "x - y";
    String exp03 = "x * y";
    String exp04 = "y / x";
    String exp05 = "x * x * x + y";
    String exp06 = "x * x + y / x";

    @Test
    void testDesempenho() {
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp01, 5, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp02, -1, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp03, 6, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp04, 1.5, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp05, 11, 200));
        assertTrue(AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp06, 5.5, 200));

        assertThrows(RespostaErradaException.class,
                () -> AvaliadorDesempenho.avaliarDesempenho(variaveisPack01, exp01, 54, 200));

    }
}

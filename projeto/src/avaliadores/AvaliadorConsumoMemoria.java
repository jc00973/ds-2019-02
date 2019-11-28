/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de consumo de memória. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na
 * construção do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.util.Map;

public class AvaliadorConsumoMemoria {

    private Adapter adapter;
    private FactoryAdapter factoryAdapter;

    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorConsumoMemoria() {

        adapter = factoryAdapter.getInstance();

    }

    /**
     *
     * O método recebe os valores das variáveis, a expressão e o resultado esperado da avaliação da expressão. Após,
     * irá analisar e retornar o consumo de memória durante a execução da avaliação.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     *
     * @return Retorna a memória gasta pelo avaliador.
     *
     */
    long avaliarConsumoMemoria(Map<String, Double> variaveis, String expressao, double resultadoEsperado) {

        try {

            Expressao exp = adapter.getExpressaoFor(expressao);

            Runtime runtime = Runtime.getRuntime();
            long memoriaUtilizadaAntes = runtime.totalMemory() - runtime.freeMemory();

            double resposta = exp.avalia(variaveis);

            long memoriaUtilizadaDepois = runtime.totalMemory() - runtime.freeMemory();

            long memoriaUtilizada = memoriaUtilizadaDepois - memoriaUtilizadaAntes;

            if (Double.compare(resposta, resultadoEsperado) != 0) {
                throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
            }

            return memoriaUtilizada;

        } catch (RespostaErradaException e) {
            e.printStackTrace();
        }

        return 0;

    }
}

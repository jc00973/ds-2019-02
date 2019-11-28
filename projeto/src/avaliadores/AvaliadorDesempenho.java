/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de desempenho. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.util.Map;

public class AvaliadorDesempenho {

    private Adapter adapter;
    private FactoryAdapter factoryAdapter;

    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorDesempenho() {

        adapter = factoryAdapter.getInstance();

    }

    /**
     *
     * O método recebe os valores das variáveis, a expressão e o resultado esperado da avaliação da expressão.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     *
     * @return Retorna o tempo gasto para o processamento da avaliação.
     *
     */
    boolean avaliarDesempenho(Map<String, Double> variaveis, String expressao, double resultadoEsperado) {

        try {

            Expressao exp = adapter.getExpressaoFor(expressao);

            long inicio = System.currentTimeMillis();
            double resposta = exp.avalia(variaveis);
            long termino = System.currentTimeMillis();
            long tempoEmMilissegundo = termino - inicio;

            if (Double.compare(resposta, resultadoEsperado) != 0) {
                throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
            }

            return tempoEmMilissegundo;

        } catch (RespostaErradaException e) {
            e.printStackTrace();
        }

        return false;
    }
}

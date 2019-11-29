/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de latência. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.util.Map;

public class Latencia implements Avaliador {

    private FactoryAdapter factoryAdapter;

    /**
     *
     * O método recebe os valores das variáveis, a expressão e o resultado esperado da avaliação da expressão.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     *
     * @return Retorna o tempo gasto pelo método preparar, em milissegundos.
     *
     */
    public double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao) {

        try {

            long inicio = System.currentTimeMillis();
            Expressao exp = factoryAdapter.getAdapter().getExpressaoFor(expressao);
            long termino = System.currentTimeMillis();
            long tempoEmMilissegundo = termino - inicio;

            double resposta = exp.avaliar(variaveis);

            if (Double.compare(resposta, resultadoEsperado) != 0) {
                throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
            }

            return tempoEmMilissegundo;

        } catch (RespostaErradaException e) {
            e.printStackTrace();
        }

        return 0;
    }

}

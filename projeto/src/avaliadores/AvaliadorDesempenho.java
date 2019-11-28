/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de desempenho. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
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
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorDesempenho() {

        adapter = factoryAdapter.getInstance();

    }

    /**
     *
     * O m�todo recebe os valores das vari�veis, a express�o e o resultado esperado da avalia��o da express�o.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta.
     *
     * @return Retorna o tempo gasto para o processamento da avalia��o.
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
                throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
            }

            return tempoEmMilissegundo;

        } catch (RespostaErradaException e) {
            e.printStackTrace();
        }

        return false;
    }
}

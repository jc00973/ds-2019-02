/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de precis�o. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.util.Map;

public class AvaliadorPrecisao {

    private Adapter adapter;
    private FactoryAdapter factoryAdapter;

    AvaliadorPrecisao() {

        adapter = factoryAdapter.getInstance();

    }

    /**
     * O m�todo recebe os valores das vari�veis, a express�o, oresultado esperado da avalia��o da express�o e o valor
     * do epsilon, referente ao intervalo permitido do resultado em termos de precis�o. Com estes dados, o m�todo efetua
     * a an�lise da resposta dada pelo avaliador, considerando a precis�o requisitada.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta.
     * @param epsilon O intervalo permitido para avaliar a precis�o do resultado.
     *
     * @return Retorna se o resultado da avalia��o est� dentro do intervalo de precis�o requisitado.
     *
     */
    boolean avaliarPrecisao(Map<String, Double> variaveis, String expressao, double resultadoEsperado, double epsilon) {

        Expressao exp = adapter.getExpressaoFor(expressao);

        double resposta = exp.avalia(variaveis);

        return Math.abs(resposta - resultadoEsperado) < epsilon;

    }
}

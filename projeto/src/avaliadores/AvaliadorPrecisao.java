/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de precisão. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 * @author jc00973 - João Carlos Fonseca
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
     * O método recebe os valores das variáveis, a expressão, oresultado esperado da avaliação da expressão e o valor
     * do epsilon, referente ao intervalo permitido do resultado em termos de precisão. Com estes dados, o método efetua
     * a análise da resposta dada pelo avaliador, considerando a precisão requisitada.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     * @param epsilon O intervalo permitido para avaliar a precisão do resultado.
     *
     * @return Retorna se o resultado da avaliação está dentro do intervalo de precisão requisitado.
     *
     */
    boolean avaliarPrecisao(Map<String, Double> variaveis, String expressao, double resultadoEsperado, double epsilon) {

        Expressao exp = adapter.getExpressaoFor(expressao);

        double resposta = exp.avalia(variaveis);

        return Math.abs(resposta - resultadoEsperado) < epsilon;

    }
}

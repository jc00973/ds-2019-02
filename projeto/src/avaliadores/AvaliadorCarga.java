/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de carga. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.util.List;
import java.util.Map;

public class AvaliadorCarga {

    private Adapter adapter;
    private FactoryAdapter factoryAdapter;

    /**
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorCarga() {

        adapter = factoryAdapter.getInstance();

    }

    /**
     *
     * O m�todo recebe os valores das vari�veis, uma lista de express�es, uma lista de resultados esperados e carga. O
     * intuito � levar o avaliador a utiliza��o extrema e ent�o observar o seu comportamento, se conseguir� realizar
     * as respectivas avalia��es ou se retornar� uma exce��o do tipo RuntimeException.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressoes Lista com as express�es que ser�o avaliadas.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta.
     * @param carga Quantidade de vezes que a avalia��o da lista de express�es deve ser realizada.
     *
     *
     * @return Retorna o tempo gasto pelo m�todo preparar, em milissegundo.
     *
     */
    boolean avaliarCarga(Map<String, Double> variaveis, List<String> expressoes, List<Double> resultadoEsperado, int carga) {

        try {

            for(int i = 0 ; i < carga ; i++) {
                for(int j = 0 ; j < expressoes.size() ; j++) {

                    Expressao exp = adapter.getExpressaoFor(expressoes.get(j));

                    double resposta = exp.avalia(variaveis);

                    if (Double.compare(resposta, resultadoEsperado.get(j)) != 0) {
                        throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
                    }
                }
            }

        } catch (RuntimeException re) {
            return false;
        } catch (RespostaErradaException e) {
            return false;
        }

        return true;
    }
}

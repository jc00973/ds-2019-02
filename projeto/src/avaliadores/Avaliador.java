/**
 * O c�digo abaixo � uma ilustra��o do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na constru��o do software em si, n�o tendo portanto o intuito de servir como c�digo final
 * implement�vel.
 *
 */

package avaliadores;

import java.util.List;
import java.util.Map;

public interface Avaliador {


    /**
     * O m�todo recebe os par�metros e realizar� a avalia��o conforme a implementa��o da interface.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta
     * @param qtdRepeticoes A quantidade de vezes que o teste deve ser executado.
     * @param intervaloPrecisao O intervalo de precis�o para a resposta ser considerada correta.
     * @param nomeDaClasse O nome da classe do adaptador utilizado pela factory, implementado pelo Avaliador
     *                     de Express�o.
     *
     * @return Retorna o resultado da avalia��o, dependendo da implementa��o da interface.
     */
    double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao, String nomeDaClasse);


}
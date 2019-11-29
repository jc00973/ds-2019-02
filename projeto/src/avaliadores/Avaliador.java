/**
 * O código abaixo é uma ilustração do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na construção do software em si, não tendo portanto o intuito de servir como código final
 * implementável.
 *
 */

package avaliadores;

import java.util.List;
import java.util.Map;

public interface Avaliador {


    /**
     * O método recebe os parâmetros e realizará a avaliação conforme a implementação da interface.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta
     * @param qtdRepeticoes A quantidade de vezes que o teste deve ser executado.
     * @param intervaloPrecisao O intervalo de precisão para a resposta ser considerada correta.
     * @param nomeDaClasse O nome da classe do adaptador utilizado pela factory, implementado pelo Avaliador
     *                     de Expressão.
     *
     * @return Retorna o resultado da avaliação, dependendo da implementação da interface.
     */
    double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao, String nomeDaClasse);


}
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


    double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao);


}
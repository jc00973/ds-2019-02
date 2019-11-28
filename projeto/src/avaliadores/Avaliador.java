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


    double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao);


}
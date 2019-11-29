/**
 * O código abaixo é uma ilustração do design planejado para a interface de expressão. Ou seja, por se tratar de
 * design, ele serve para orientar e direcionar o desenvolvedor na construção do software em si, não tendo portanto
 * o intuito de servir como código final implementável em si.
 *
 */

package adaptador;

import java.util.Map;

public interface Expressao {

   /**
    * A interface expressão será implementada interface adaptador, portanto, fica a critério do utilizador do benchmark
    * a maneira que fará a integração do benchmark ao seu avaliador de expressões, desde que o método avalia retorne um
    * double referente ao resultado da avaliação.
    *
    * @param variaveis Os valores correspondentes às variáveis da expressão.
    *
    * @return O resultado obtido pelo avaliador de expressão.
    */
   double avaliar(Map<String, Double> variaveis);


}


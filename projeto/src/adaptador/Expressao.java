/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a interface de express�o. Ou seja, por se tratar de
 * design, ele serve para orientar e direcionar o desenvolvedor na constru��o do software em si, n�o tendo portanto
 * o intuito de servir como c�digo final implement�vel em si.
 *
 */

package adaptador;

import java.util.Map;

public interface Expressao {

   /**
    * A interface express�o ser� implementada interface adaptador, portanto, fica a crit�rio do utilizador do benchmark
    * a maneira que far� a integra��o do benchmark ao seu avaliador de express�es, desde que o m�todo avalia retorne um
    * double referente ao resultado da avalia��o.
    *
    * @param variaveis Os valores correspondentes �s vari�veis da express�o.
    *
    * @return O resultado obtido pelo avaliador de express�o.
    */
   double avaliar(Map<String, Double> variaveis);


}


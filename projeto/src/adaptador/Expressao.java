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
   double avalia(Map<String, Double> variaveis);

   /**
    *  Caso o avaliador que será analisado precise implementar um código de preparação, que será executado antes da
    *  execução da avaliação em si, este deverá constar neste método para que o critério de latência seja analisado.
    *  A implementação do método em si fica a cargo do utilizador do benchmark.
    */
   void preparar();

   /**
    *  O utilizador do benchmark deverá implementar a forma que irá instanciar uma expressão no benchmark de maneira que
    *  essa instância possa ser utilizada como parâmetro no projeto que será avaliado.
    */
   Expressao getExpressaoFor(String expressao);

}


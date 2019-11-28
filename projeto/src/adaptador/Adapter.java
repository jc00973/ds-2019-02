/**
 * O código abaixo é uma ilustração do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em questão em implementar o adaptador adequado ao projeto que irá utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador será implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementação de um adaptador.
 *
 */

package adaptador;

import java.util.Map;

public interface Adapter {

    /**
     * Pretende-se que tudo que for necessário de ser executado antes da avaliação da expressão para que ela possa ser
     * executada, seja executado dentro deste método, para então viabilizar a avaliação da latência (ou tempo de
     * preparação).
     *
     */
    public void preparar();

    /**
     *  O utilizador do benchmark deverá implementar a forma que irá instanciar uma expressão no benchmark de maneira que
     *  essa instância possa ser utilizada como parâmetro no projeto que será avaliado.
     */
    public Expressao getExpressaoFor(String expressao);

}

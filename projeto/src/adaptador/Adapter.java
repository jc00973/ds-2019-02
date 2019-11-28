/**
 * O c�digo abaixo � uma ilustra��o do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em quest�o em implementar o adaptador adequado ao projeto que ir� utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador ser� implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementa��o de um adaptador.
 *
 */

package adaptador;

import java.util.Map;

public interface Adapter {

    /**
     * Pretende-se que tudo que for necess�rio de ser executado antes da avalia��o da express�o para que ela possa ser
     * executada, seja executado dentro deste m�todo, para ent�o viabilizar a avalia��o da lat�ncia (ou tempo de
     * prepara��o).
     *
     */
    public void preparar();

    /**
     *  O utilizador do benchmark dever� implementar a forma que ir� instanciar uma express�o no benchmark de maneira que
     *  essa inst�ncia possa ser utilizada como par�metro no projeto que ser� avaliado.
     */
    public Expressao getExpressaoFor(String expressao);

}

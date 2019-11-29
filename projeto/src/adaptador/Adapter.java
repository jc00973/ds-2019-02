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
     * A execu��o deste m�todo inclui a prepara��o da express�o fornecida, antes que seja executada, e retorna a mesma
     * preparada. No caso, como a implementa��o da interface n�o faz parte do escopo do projeto do benchmark e � sim
     * uma decis�o do Avaliador, o m�todo aqui tem fun��o ilustrativa apenas e por isso retorna null. O tempo de
     * execu��o deste m�todo que determina a lat�ncia.
     *
     * @param expressao A express�o que ser� preparada.
     *
     * @return A express�o preparada para avalia��o.
     */
    public Expressao getExpressaoFor(String expressao);

}

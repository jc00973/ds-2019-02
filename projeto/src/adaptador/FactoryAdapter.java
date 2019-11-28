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

public class FactoryAdapter implements Adapter {

    public Adapter newInstance(String nomeDaClasse) {
        Adapter adp = new FactoryAdapter();

        return adp;
    }

    @Override
    public void preparar() {

    }

    /**
     * A execução deste método inclui a preparação da expressão fornecida, antes que seja executada, e retorna a mesma
     * preparada. No caso, como a implementação da interface não faz parte do escopo do projeto do benchmark e é sim
     * uma decisão do Avaliador, o método aqui tem função ilustrativa apenas e por isso retorna null.
     *
     * @param expressao A expressão que será preparada.
     *
     * @return A expressão preparada para avaliação.
     */
    public Expressao getExpressaoFor(String expressao) {
        return null;
    }
}
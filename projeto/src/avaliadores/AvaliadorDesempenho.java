/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de desempenho. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.src;

public interface AvaliadorDesempenho {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorDesempenho() {

        adapter = FactoryAdapter.getInstance();

    }

    double avaliarDesempenho(Map<String, Double> valores, String expressao) {

        Expressao expr = adapter.getExpessaoFor("x + y");
        Map<String, Double> variaveis = new HashMap<>();
        variaveis.put(x, 10);
        variaveis.put(y, 20);
        long inicio = System.getCurrentTime();
        double resposta = expr.avalia(variaveis);
        long termino = System.getCurrentTime();

        if (Double.compare(resposta, 30) == 0) {

        }

        long tempoEmMilissegundo = termino - inicio;

        return intervaloDeTempo;

    }

}

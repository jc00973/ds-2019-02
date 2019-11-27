/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de consumo de memória. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na
 * construção do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 * @author jc00973 - João Carlos Fonseca
 */

package projeto.src;

public interface AvaliadorConsumoMemoria {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorConsumoMemoria() {

        adapter = FactoryAdapter.getInstance();

    }

    double avaliarConsumoMemoria(Map<String, Double> valores, String expressao) {

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

/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de latência. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 * @author jc00973 - João Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorLatencia {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorLatencia() {

        adapter = FactoryAdapter.getInstance();

    }

    /**
     *
     * O método recebe os valores das variáveis, a expressão e o resultado esperado da avaliação da expressão.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     *
     * @return Retorna o tempo gasto pelo método preparar, em milissegundo.
     *
     */
    double avaliarLatencia(Map<String, Double> variaveis, String expressao, double resultadoEsperado) {

        Expressao exp = adapter.getExpessaoFor(expressao);

        long inicio = System.getCurrentTime();
        adapter.preparar();
        long termino = System.getCurrentTime();
        long tempoEmMilissegundo = termino - inicio;

        double resposta = exp.avalia(variaveis);

        if(! Double.compare(resposta, resultadoEsperado)) {
            throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
        }

        return tempoEmMilissegundo;

    }

}

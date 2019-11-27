/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de consumo de memória. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na
 * construção do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 * @author jc00973 - João Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorConsumoMemoria {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorConsumoMemoria() {

        adapter = FactoryAdapter.getInstance();

    }

    /**
     *
     * O método recebe os valores das variáveis, a expressão e o resultado esperado da avaliação da expressão. Após,
     * irá analisar e retornar o consumo de memória durante a execução da avaliação.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     *
     * @return Retorna a memória gasta pelo avaliador.
     *
     */
    long avaliarConsumoMemoria(Map<String, Double> valores, String expressao, double resultadoEsperado) {

        Expressao exp = adapter.getExpressaoFor(expressao);

        Runtime runtime = Runtime.getRuntime();
        long memoriaUtilizadaAntes = runtime.totalMemory() - runtime.freeMemory();

        double resposta = exp.avalia(variaveis);

        long memoriaUtilizadaDepois = runtime.totalMemory() - runtime.freeMemory();

        long memoriaUtilizada = memoriaUtilizadaDepois - memoriaUtilizadaAntes;

        if(! Double.compare(resposta, resultadoEsperado)) {
            throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
        }

        return memoriaUtilizada;

    }

}

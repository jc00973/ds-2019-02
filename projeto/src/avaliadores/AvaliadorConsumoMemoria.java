/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de consumo de mem�ria. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na
 * constru��o do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorConsumoMemoria {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorConsumoMemoria() {

        adapter = FactoryAdapter.getInstance();

    }

    /**
     *
     * O m�todo recebe os valores das vari�veis, a express�o e o resultado esperado da avalia��o da express�o. Ap�s,
     * ir� analisar e retornar o consumo de mem�ria durante a execu��o da avalia��o.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta.
     *
     * @return Retorna a mem�ria gasta pelo avaliador.
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
            throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
        }

        return memoriaUtilizada;

    }

}

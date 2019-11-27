/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de desempenho. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorDesempenho {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorDesempenho() {

        adapter = FactoryAdapter.getInstance();

    }

    /**
     *
     * O m�todo recebe os valores das vari�veis, a express�o e o resultado esperado da avalia��o da express�o.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta.
     *
     * @return Retorna o tempo gasto pelo avaliador, em milissegundo.
     *
     */
    double avaliarDesempenho(Map<String, Double> variaveis, String expressao, double resultadoEsperado) {

        Expressao exp = adapter.getExpressaoFor(expressao);

        long inicio = System.getCurrentTime();
        double resposta = exp.avalia(variaveis);
        long termino = System.getCurrentTime();
        long tempoEmMilissegundo = termino - inicio;

        if(! Double.compare(resposta, resultadoEsperado)) {
            throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
        }

        return tempoEmMilissegundo;

    }
}

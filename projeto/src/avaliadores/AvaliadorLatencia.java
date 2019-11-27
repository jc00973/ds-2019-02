/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de lat�ncia. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na constru��o
 * do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorLatencia {

    private Adapter adapter;

    /**
     * O construtor instancia o adaptador atrav�s de uma factory.
     */
    AvaliadorLatencia() {

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
     * @return Retorna o tempo gasto pelo m�todo preparar, em milissegundo.
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
            throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
        }

        return tempoEmMilissegundo;

    }

}

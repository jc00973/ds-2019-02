/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de carga. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 * @author jc00973 - João Carlos Fonseca
 */

package projeto.src.avaliadores;

public interface AvaliadorCarga {

    private Adapter adapter;


    /**
     * O construtor instancia o adaptador através de uma factory.
     */
    AvaliadorCarga() {

        adapter = FactoryAdapter.getInstance();

    }

    /**
     *
     * O método recebe os valores das variáveis, uma lista de expressões, uma lista de resultados esperados e carga. O
     * intuito é levar o avaliador a utilização extrema e então observar o seu comportamento, se conseguirá realizar
     * as respectivas avaliações ou se retornará uma exceção do tipo RuntimeException.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressoes Lista com as expressões que serão avaliadas.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta.
     * @param carga Quantidade de vezes que a avaliação da lista de expressões deve ser realizada.
     *
     *
     * @return Retorna o tempo gasto pelo método preparar, em milissegundo.
     *
     */
    boolean avaliarCarga(Map<String, Double> variaveis, List<String> expressoes, List<double> resultadoEsperado, int carga) {

        try {

            for(int i = 0 ; i < carga ; i++) {
                for(int j = 0 ; j < expressoes.lenght() ; j++) {

                    Expressao exp = adapter.getExpressaoFor(expressoes.get(j));

                    double resposta = exp.avalia(variaveis);

                    if(! Double.compare(resposta, resultadoEsperado)) {
                        throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
                    }
                }
            }

        } catch (RuntimeException re) {
            return false;
        }

    }

}

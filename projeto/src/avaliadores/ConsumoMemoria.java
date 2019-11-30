/**
 * O c�digo abaixo � uma ilustra��o do design planejado para a classe que deve conter o m�todo principal de avalia��o
 * de consumo de mem�ria. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na
 * constru��o do software em si, n�o tendo portanto o intuito de servir como c�digo final implement�vel em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ConsumoMemoria implements Avaliador {

    private FactoryAdapter factoryAdapter;

    /**
     * O m�todo recebe os par�metros e realizar� a avalia��o do custo de mem�ria utilizada.
     *
     * @param variaveis Corresponde a pares de vari�veis com seus respectivos valores.
     * @param expressao A express�o que ser� avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avalia��o seja considerada correta
     * @param qtdRepeticoes A quantidade de vezes que o teste deve ser executado.
     * @param intervaloPrecisao O intervalo de precis�o para a resposta ser considerada correta.
     * @param nomeDaClasse O nome da classe do adaptador utilizado pela factory, implementado pelo Avaliador
     *                     de Express�o.
     *
     * @return Retorna a mem�ria gasta pelo avaliador.
     *
     */
    public double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao, String nomeDaClasse) {

        try {

            long memoriaUtilizada = 0;

            for(int i = 0 ; i < qtdRepeticoes ; i++) {

                Adapter adapter = factoryAdapter.newInstance(nomeDaClasse);
                Expressao exp = adapter.getExpressaoFor(expressao);

                Runtime runtime = Runtime.getRuntime();

                long memoriaUtilizadaAntes = runtime.totalMemory() - runtime.freeMemory();

                double resposta = exp.avaliar(variaveis);

                long memoriaUtilizadaDepois = runtime.totalMemory() - runtime.freeMemory();

                memoriaUtilizada = memoriaUtilizadaDepois - memoriaUtilizadaAntes;

                if (Math.abs(resposta - resultadoEsperado) < intervaloPrecisao) {
                    throw new RespostaErradaException("A resposta do avaliador � diferente do resultado esperado!");
                }

            }

            return memoriaUtilizada;

        } catch (RespostaErradaException e) {
            return -1;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;

    }
}

/**
 * O código abaixo é uma ilustração do design planejado para a classe que deve conter o método principal de avaliação
 * de desempenho. Ou seja, por se tratar de design, ele serve para orientar e direcionar o desenvolvedor na construção
 * do software em si, não tendo portanto o intuito de servir como código final implementável em si.
 *
 */

package avaliadores;

import adaptador.Adapter;
import adaptador.FactoryAdapter;
import adaptador.Expressao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Desempenho implements Avaliador {

    private FactoryAdapter factoryAdapter;

    /**
     * O método recebe os parâmetros e realizará a avaliação de desempenho.
     *
     * @param variaveis Corresponde a pares de variáveis com seus respectivos valores.
     * @param expressao A expressão que será avaliada.
     * @param resultadoEsperado O resultado esperado pelo benchmark para que a avaliação seja considerada correta
     * @param qtdRepeticoes A quantidade de vezes que o teste deve ser executado.
     * @param intervaloPrecisao O intervalo de precisão para a resposta ser considerada correta.
     * @param nomeDaClasse O nome da classe do adaptador utilizado pela factory, implementado pelo Avaliador
     *                     de Expressão.
     *
     * @return Retorna o tempo gasto para o processamento da avaliação.
     *
     */
    public double avaliar(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao, String nomeDaClasse) {

        try {

            long tempoTotal = 0;

            for(int i = 0 ; i < qtdRepeticoes ; i++) {

                Adapter adapter = factoryAdapter.newInstance(nomeDaClasse);
                Expressao exp = adapter.getExpressaoFor(expressao);

                long inicio = System.currentTimeMillis();
                double resposta = exp.avaliar(variaveis);
                long termino = System.currentTimeMillis();
                long tempoEmMilissegundo = termino - inicio;
                tempoTotal += tempoEmMilissegundo;

                if (Math.abs(resposta - resultadoEsperado) < intervaloPrecisao) {
                    throw new RespostaErradaException("A resposta do avaliador é diferente do resultado esperado!");
                }
            }

            return tempoTotal;

        } catch (RuntimeException re) {
            return -1;
        } catch (RespostaErradaException ree) {
            ree.printStackTrace();
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

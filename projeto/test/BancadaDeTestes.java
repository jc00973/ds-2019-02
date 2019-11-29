/**
 * O código abaixo é uma ilustração do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na construção do software em si, não tendo portanto o intuito de servir como código final
 * implementável.
 *
 */

package projeto.test;

import java.util.Map;

public class BancadaDeTestes {

    List<Teste> testes;

    public void insereTeste(String expressao, Map<String, Double> variaveis, double resultado, int qtdRepeticoes, double intervaloPrecisao) {
        Teste teste = new Teste(expressao, variaveis, resultado, qtdRepeticoes, intervaloPrecisao);
        testes.add(teste);
    }

    public List<Teste> getTestes() {
        return testes;
    }
}
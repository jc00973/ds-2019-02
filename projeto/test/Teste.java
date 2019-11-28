/**
 * O c�digo abaixo � uma ilustra��o do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na constru��o do software em si, n�o tendo portanto o intuito de servir como c�digo final
 * implement�vel.
 *
 */

package projeto.test;

import java.util.Map;

public class Teste {

    String expressao;
    Map<String, Double> variaveis;
    double resultado;

    public Teste(Map<String, Double> variaveis, String expressao, double resultadoEsperado, int qtdRepeticoes, double intervaloPrecisao) {
        this.expressao = expressao;
        this.variaveis = variaveis;
        this.resultado = resultado;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public Map<String, Double> getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(Map<String, Double> variaveis) {
        this.variaveis = variaveis;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
/**
 * O código abaixo é uma ilustração do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na construção do software em si, não tendo portanto o intuito de servir como código final
 * implementável.
 *
 */

package projeto.test;

import java.util.Map;

public class Teste {

    String expressao;
    Map<String, Double> variaveis;
    double resultado;
    int qtdRepeticoes;
    double intervaloPrecisao;

    public Teste(String expressao, Map<String, Double> variaveis, double resultado, int qtdRepeticoes, double intervaloPrecisao) {
        this.expressao = expressao;
        this.variaveis = variaveis;
        this.resultado = resultado;
        this.qtdRepeticoes = qtdRepeticoes;
        this.intervaloPrecisao = intervaloPrecisao;
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

    public int getQtdRepeticoes() {
        return qtdRepeticoes;
    }

    public void setQtdRepeticoes(int qtdRepeticoes) {
        this.qtdRepeticoes = qtdRepeticoes;
    }

    public double getIntervaloPrecisao() {
        return intervaloPrecisao;
    }

    public void setIntervaloPrecisao(double intervaloPrecisao) {
        this.intervaloPrecisao = intervaloPrecisao;
    }
}
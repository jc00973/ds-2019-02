/**
 * O código abaixo é uma ilustração do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em questão em implementar o adaptador adequado ao projeto que irá utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador será implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementação de um adaptador.
 *
 * @author jc00973 - João Carlos Fonseca
 */

package projeto.src.adaptador;

public interface Adapter implements Expressao {

    String nome;
    String jarFile;

    /**
     *  Método construtor padrão.
     */
    Adapter(String nome, String jarFile) {
        this.nome = nome;
        this.jarFile = jarFile;
    }

    /**
     *  Caso o avaliador que será analisado precise implementar um código de preparação, que será executado antes da
     *  execução da avaliação em si, este deverá constar neste método para que o critério de latência seja analisado.
     *  A implementação do método em si fica a cargo do utilizador do benchmark.
     */
    public void preparar() {};

    /**
     *  O utilizador do benchmark deverá implementar a forma que irá instanciar uma expressão no benchmark de maneira que
     *  essa instância possa ser utilizada como parâmetro no projeto que será avaliado.
     */
    public Expressao getExpressaoFor(String expressao) {
        return expr;
    };

}

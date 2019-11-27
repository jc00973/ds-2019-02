/**
 * O c�digo abaixo � uma ilustra��o do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em quest�o em implementar o adaptador adequado ao projeto que ir� utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador ser� implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementa��o de um adaptador.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.src.adaptador;

public interface Adapter implements Expressao {

    String nome;
    String jarFile;

    /**
     *  M�todo construtor padr�o.
     */
    Adapter(String nome, String jarFile) {
        this.nome = nome;
        this.jarFile = jarFile;
    }

    /**
     *  Caso o avaliador que ser� analisado precise implementar um c�digo de prepara��o, que ser� executado antes da
     *  execu��o da avalia��o em si, este dever� constar neste m�todo para que o crit�rio de lat�ncia seja analisado.
     *  A implementa��o do m�todo em si fica a cargo do utilizador do benchmark.
     */
    public void preparar() {};

    /**
     *  O utilizador do benchmark dever� implementar a forma que ir� instanciar uma express�o no benchmark de maneira que
     *  essa inst�ncia possa ser utilizada como par�metro no projeto que ser� avaliado.
     */
    public Expressao getExpressaoFor(String expressao) {
        return expr;
    };

}

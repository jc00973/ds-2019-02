/**
 * O c�digo abaixo � uma ilustra��o do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em quest�o em implementar o adaptador adequado ao projeto que ir� utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador ser� implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementa��o de um adaptador.
 *
 * @author jc00973 - Jo�o Carlos Fonseca
 */

package projeto.adaptador.src;

public interface Adapter {

    String nome;
    String jarFile;

    Adapter(String nome, String jarFile) {

        this.nome = nome;
        this.jarFile = jarFile;

    }

}

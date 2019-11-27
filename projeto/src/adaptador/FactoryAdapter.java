/**
 * O código abaixo é uma ilustração do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em questão em implementar o adaptador adequado ao projeto que irá utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador será implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementação de um adaptador.
 *
 * @author jc00973 - João Carlos Fonseca
 */

public interface FactoryAdapter {

    /**
     * Cria uma instância do avaliador de expressões.
     *
     * @param nome
     * @param jarFile
     */
    FactoryImplementacao(String nome, String jarFile) {

        Adapter adp = new Adapter(nome, jarFile);

    }

    Adapter getInstance() {

        return adp;

    }

    Expressao getInstanceFor(String expressao) {

    }

}
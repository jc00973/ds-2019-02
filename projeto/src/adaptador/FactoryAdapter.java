/**
 * O código abaixo é uma ilustração do design planejado, servindo apenas para ressaltar a necessidade do utilizador do
 * benchmark em questão em implementar o adaptador adequado ao projeto que irá utilizar o benchmark, garantindo o
 * devido funcionamento do benchmark no mesmo. Portanto, a maneira como o adaptador será implementado foge do escopo
 * do projeto de design do benchmark em si, portanto, reitero que este arquivo serve apenas para elucidar a necessidade
 * de implementação de um adaptador.
 *
 */

package adaptador;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class FactoryAdapter {

    public static <T> T newInstance(String nomeDaClasse)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Class<?> classe = Class.forName(nomeDaClasse);
        return (T) classe.getDeclaredConstructor().newInstance();
    }

}
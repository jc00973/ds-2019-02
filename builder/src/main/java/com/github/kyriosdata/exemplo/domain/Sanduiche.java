/**
 * João Carlos Fonseca
 * Universidade Federal de Goiás
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sanduiche {

    private List<String> carnes;

    private List<String> recheios;

    private List<String> molhos;

    private List<String> paes;

    private String pontoDaCarne;

    public static class Builder {
        // TODO não adequadamente são Strings, melhor seriam Enums, Carne, Recheio, Molho, Pao e Ponto. 
        private List<String> carnes = new ArrayList<>();
        private List<String> recheios = new ArrayList<>();
        private List<String> molhos = new ArrayList<>();
        private List<String> paes = new ArrayList<>();
        private String pontoDaCarne = new String();

        /**
         * Ter um tipo de pão é obrigatório.
         *
         * @param pao O tipo de pão do sanduíche.
         */
        public Builder(final String pao) {
            paes.add(pao);
        }

        public Builder addPao(final String pao) {
            paes.add(pao);
            return this;
        }

        public Builder addCarne(final String carne) {
            carnes.add(carne);
            return this;
        }

        public Builder addRecheio(final String recheio) {
            recheios.add(recheio);
            return this;
        }

        public Builder addMolho(final String molho) {
            molhos.add(molho);
            return this;
        }

        public Builder pontoDaCarne(final String pontoDaCarne) {
            this.pontoDaCarne = pontoDaCarne;
            return this;
        }

        public Sanduiche build() {
            return new Sanduiche(this);
        }
    }

    private Sanduiche(Builder builder) {
        carnes = Collections.unmodifiableList(builder.carnes);
        recheios = Collections.unmodifiableList(builder.recheios);
        molhos = Collections.unmodifiableList(builder.molhos);
        paes = Collections.unmodifiableList(builder.paes);
        pontoDaCarne = builder.pontoDaCarne;
    }

    public List<String> getCarnes() {
        return carnes;
    }

    public List<String> getRecheios() {
        return recheios;
    }


    public List<String> getMolhos() {
        return molhos;
    }

    public List<String> getPaes() {
        return paes;
    }

    public String getPontoDaCarne() {
        return pontoDaCarne;
    }

    /**
     * Produz o sanduíche completo.
     * @return O sanduíche completo.
     */
    @Override
    public String toString() {
        final String parcial = String.join(" ",
                une(carnes), une(recheios), une(molhos), une(paes), pontoDaCarne);

        // TODO aqui merece um comentário, você tirou? É claro para você o que faz?
        return parcial.trim().replaceAll(" +", " ");
    }

    /**
     * Concatena as sequências fornecidas na lista.
     *
     * @param lista A lista de sequências a serem concatenadas.
     *
     * @return A sequência de caracteres formada pela união das sequências
     * contidas na lista separadas por espaço em branco.
     */
    private String une(List<String> lista) {
        return String.join(" ", lista);
    }
}


/**
 * João Carlos Fonseca
 * Universidade Federal de Goiás
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;/**/

class SanduicheBuilderTest {

    @Test
    void builderCasoTrivial() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão de hambúrguer")
                .addCarne("filé de frango");
        assertEquals("filé de frango pão de hambúrguer", builder.build().toString());
    }

    @Test
    void verificaBuilder() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão francês");
        Sanduiche sanduiche = builder
                .addCarne("mortadela")
                .addRecheio("mussarela")
                .addMolho("mostarda")
                .build();

        final String carnes = "mortadela";
        final String sanduicheCompleto = "mussarela mostarda pão francês";
        final String full = String.join(" ", carnes, sanduicheCompleto);
        assertEquals(full, sanduiche.toString());
    }


    @Test
    void paoImmutable() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão de hot dog");
        Sanduiche sanduiche = builder.build();

        // Não há como adicionar
        assertThrows(UnsupportedOperationException.class, () ->
                sanduiche.getPaes().add("pão baguete"));

        // Não há como remover
        assertThrows(UnsupportedOperationException.class, () ->
                sanduiche.getPaes().remove(0));
    }

    @Test
    void naoHaCarnePadrao() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão italiano");
        Sanduiche sanduiche = builder.build();

        assertEquals(0, sanduiche.getCarnes().size());
    }

    @Test
    void naoHaRecheioPadrao() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão mandi");
        Sanduiche sanduiche = builder.build();

        assertEquals(0, sanduiche.getRecheios().size());
    }

    @Test
    void naoHaMolhoPadrao() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão francês");
        Sanduiche sanduiche = builder.build();

        assertEquals(0, sanduiche.getMolhos().size());
    }

    @Test
    void alteraPontoDaCarne() {
        Sanduiche.Builder builder = new Sanduiche.Builder("pão australiano");
        Sanduiche sanduiche = builder.pontoDaCarne("mal passada"). build();

        assertFalse(sanduiche.getPontoDaCarne() == "ao ponto");
        assertTrue(sanduiche.getPontoDaCarne() == "mal passada");
    }
}
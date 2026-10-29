package poker;

import static poker.SymboleCarte.*;
import static poker.NumeroCarte.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EvaluateurMainTest {

    private final EvaluateurMain evaluateur = new EvaluateurMain();

    @Test
    void carteHaute() {
        Main main = new Main(new Carte(TREFLE, TROIS), new Carte(CARREAU, HUIT), new Carte(COEUR, DIX),
                new Carte(PIQUE, DAME), new Carte(TREFLE, ROI));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(13);
    }

    @Test
    void asVaut14() {
        Main main = new Main(new Carte(TREFLE, DEUX), new Carte(CARREAU, QUATRE), new Carte(COEUR, SIX),
                new Carte(PIQUE, HUIT), new Carte(TREFLE, AS));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(14);
    }

    @Test
    void paireCompteEnCarteHaute() {
        Main main = new Main(new Carte(TREFLE, QUATRE), new Carte(CARREAU, QUATRE), new Carte(COEUR, SIX),
                new Carte(PIQUE, HUIT), new Carte(TREFLE, VALET));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(11);
    }

    @Test
    void doublePaireCompteEnCarteHaute() {
        Main main = new Main(new Carte(TREFLE, QUATRE), new Carte(CARREAU, QUATRE), new Carte(COEUR, SIX),
                new Carte(PIQUE, SIX), new Carte(TREFLE, DAME));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(12);
    }
}
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

    @Test
    void brelanRapporte30Points() {
        Main main = new Main(new Carte(TREFLE, SEPT), new Carte(CARREAU, SEPT), new Carte(COEUR, SEPT),
                new Carte(PIQUE, DEUX), new Carte(TREFLE, ROI));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(30);
    }

    @Test
    void suiteRapporte40Points() {
        Main main = new Main(new Carte(TREFLE, CINQ), new Carte(CARREAU, SIX), new Carte(COEUR, SEPT),
                new Carte(PIQUE, HUIT), new Carte(TREFLE, NEUF));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(40);
    }

    @Test
    void suiteDansLeDesordre() {
        Main main = new Main(new Carte(TREFLE, NEUF), new Carte(CARREAU, SEPT), new Carte(COEUR, CINQ),
                new Carte(PIQUE, HUIT), new Carte(TREFLE, SIX));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(40);
    }

    @Test
    void suiteDuDixALAs() {
        Main main = new Main(new Carte(TREFLE, DIX), new Carte(CARREAU, VALET), new Carte(COEUR, DAME),
                new Carte(PIQUE, ROI), new Carte(TREFLE, AS));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(40);
    }

    @Test
    void asAuCinqNEstPasUneSuite() {
        Main main = new Main(new Carte(TREFLE, AS), new Carte(CARREAU, DEUX), new Carte(COEUR, TROIS),
                new Carte(PIQUE, QUATRE), new Carte(TREFLE, CINQ));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(14);
    }

    @Test
    void couleurRapporte45Points() {
        Main main = new Main(new Carte(COEUR, DEUX), new Carte(COEUR, SEPT), new Carte(COEUR, NEUF),
                new Carte(COEUR, VALET), new Carte(COEUR, ROI));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(45);
    }

    @Test
    void fullRapporte50Points() {
        Main main = new Main(new Carte(COEUR, DEUX), new Carte(PIQUE, DEUX), new Carte(CARREAU, DEUX),
                new Carte(TREFLE, NEUF), new Carte(PIQUE, NEUF));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(50);
    }

    @Test
    void carreRapporte60Points() {
        Main main = new Main(new Carte(COEUR, VALET), new Carte(PIQUE, VALET), new Carte(CARREAU, VALET),
                new Carte(TREFLE, VALET), new Carte(PIQUE, TROIS));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(60);
    }

    @Test
    void quinteFlushRapporte80Points() {
        Main main = new Main(new Carte(PIQUE, SIX), new Carte(PIQUE, SEPT), new Carte(PIQUE, HUIT),
                new Carte(PIQUE, NEUF), new Carte(PIQUE, DIX));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(80);
    }
}
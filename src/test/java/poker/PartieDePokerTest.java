package poker;

import static poker.SymboleCarte.*;
import static poker.NumeroCarte.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PartieDePokerTest {

    private final PartieDePoker partie = new PartieDePoker();

    @Test
    void sansMainLeTotalVautZero() {
        assertThat(partie.calculerTotal(List.of())).isEqualTo(0);
    }

    @Test
    void uneSeuleMain() {
        Main couleur = new Main(new Carte(COEUR, DEUX), new Carte(COEUR, SEPT), new Carte(COEUR, NEUF),
                new Carte(COEUR, VALET), new Carte(COEUR, ROI));

        assertThat(partie.calculerTotal(List.of(couleur))).isEqualTo(45);
    }

    @Test
    void exempleDuSujetRapporte148Points() {
        Main full = new Main(new Carte(COEUR, DEUX), new Carte(PIQUE, DEUX), new Carte(CARREAU, DEUX),
                new Carte(TREFLE, NEUF), new Carte(PIQUE, NEUF));
        Main suite = new Main(new Carte(TREFLE, CINQ), new Carte(CARREAU, SIX), new Carte(COEUR, SEPT),
                new Carte(PIQUE, HUIT), new Carte(TREFLE, NEUF));
        Main couleur = new Main(new Carte(COEUR, DEUX), new Carte(COEUR, SEPT), new Carte(COEUR, NEUF),
                new Carte(COEUR, VALET), new Carte(COEUR, ROI));
        Main carteHauteRoi = new Main(new Carte(TREFLE, TROIS), new Carte(CARREAU, HUIT), new Carte(COEUR, DIX),
                new Carte(PIQUE, DAME), new Carte(TREFLE, ROI));

        assertThat(partie.calculerTotal(List.of(full, suite, couleur, carteHauteRoi))).isEqualTo(148);
    }
}
package poker;

import static poker.SymboleCarte.*;
import static poker.NumeroCarte.*;
import static org.assertj.core.api.Assertions.assertThat;
    
import org.junit.jupiter.api.Test;

class EvaluateurMainTest {
    private final EvaluateurMain evaluateur = new EvaluateurMain();
    
    @Test
    void carteHaute()
    {
      Main main = new Main(new Carte(TROIS, TREFLE), new Carte(HUIT, CARREAU), new Carte(DIX, COEUR),
                new Carte(DAME, PIQUE), new Carte(ROI, TREFLE));

        assertThat(evaluateur.calculerPoints(main)).isEqualTo(13);
    }
}
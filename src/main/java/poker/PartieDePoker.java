package poker;

import java.util.List;

public class PartieDePoker {

    private final EvaluateurMain evaluateur = new EvaluateurMain();

    public int calculerTotal(List<Main> mains) {
        int total = 0;
        for (Main main : mains) {
            total += evaluateur.calculerPoints(main);
        }
        return total;
    }
}
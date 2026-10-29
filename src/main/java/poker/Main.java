package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private final List<Carte> cartes;

    public Main(Carte... cartes) {
        this.cartes = List.of(cartes);
    }

    public int obtenirPointsPlusHauteCarte() {
        return Collections.max(obtenirPointsTries());
    }

    private List<Integer> obtenirPointsTries() {
        List<Integer> points = new ArrayList<>();
        for (Carte carte : cartes) {
            points.add(carte.obtenirPoints());
        }
        Collections.sort(points);
        return points;
    }
}
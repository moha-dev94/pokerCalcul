package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final List<Carte> cartes;

    public Main(Carte... cartes) {
        this.cartes = List.of(cartes);
    }

    public boolean estUneCouleur() {
        SymboleCarte premierSymbole = cartes.get(0).obtenirSymbole();
        for (Carte carte : cartes) {
            if (carte.obtenirSymbole() != premierSymbole) {
                return false;
            }
        }
        return true;
    }

    public boolean estUneSuite() {
        List<Integer> pointsTries = obtenirPointsTries();
        for (int i = 1; i < pointsTries.size(); i++) {
            int ecart = pointsTries.get(i) - pointsTries.get(i - 1);
            if (ecart != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean contientCartesDeMemeNumero(int nombreDeCartes) {
        return compterCartesParNumero().containsValue(nombreDeCartes);
    }

    public int obtenirPointsDeLaPlusHauteCarte() {
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

    private Map<NumeroCarte, Integer> compterCartesParNumero() {
        Map<NumeroCarte, Integer> nombreParNumero = new HashMap<>();
        for (Carte carte : cartes) {
            nombreParNumero.merge(carte.obtenirNumero(), 1, Integer::sum);
        }
        return nombreParNumero;
    }
}
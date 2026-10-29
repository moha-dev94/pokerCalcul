package poker;

import static poker.NumeroCarte.*;
import static poker.SymboleCarte.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Main> mains = List.of(
                new Main(new Carte(COEUR, DEUX), new Carte(PIQUE, DEUX), new Carte(CARREAU, DEUX),
                        new Carte(TREFLE, NEUF), new Carte(PIQUE, NEUF)),
                new Main(new Carte(TREFLE, CINQ), new Carte(CARREAU, SIX), new Carte(COEUR, SEPT),
                        new Carte(PIQUE, HUIT), new Carte(TREFLE, NEUF)),
                new Main(new Carte(COEUR, DEUX), new Carte(COEUR, SEPT), new Carte(COEUR, NEUF),
                        new Carte(COEUR, VALET), new Carte(COEUR, ROI)),
                new Main(new Carte(TREFLE, TROIS), new Carte(CARREAU, HUIT), new Carte(COEUR, DIX),
                        new Carte(PIQUE, DAME), new Carte(TREFLE, ROI))
        );

        int total = new PartieDePoker().calculerTotal(mains);
        System.out.println("Total : " + total + " points");
    }
}
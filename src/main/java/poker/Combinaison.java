package poker;

public enum Combinaison {
    QUINTE_FLUSH(80),
    CARRE(60),
    FULL(50),
    COULEUR(45),
    SUITE(40),
    BRELAN(30);

    private final int points;

    Combinaison(int points) {
        this.points = points;
    }

    public int obtenirPoints() {
        return points;
    }

    public boolean estPresenteDans(Main main) {
        return switch (this) {
            case QUINTE_FLUSH -> main.estUneSuite() && main.estUneCouleur();
            case CARRE -> main.contientCartesDeMemeNumero(4);
            case FULL -> main.contientCartesDeMemeNumero(3) && main.contientCartesDeMemeNumero(2);
            case COULEUR -> main.estUneCouleur();
            case SUITE -> main.estUneSuite();
            case BRELAN -> main.contientCartesDeMemeNumero(3);
        };
    }
}
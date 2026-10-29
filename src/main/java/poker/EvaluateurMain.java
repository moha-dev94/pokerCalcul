package poker;

public class EvaluateurMain {

    public int calculerPoints(Main main) {
        Combinaison meilleureCombinaison = trouverMeilleureCombinaison(main);
        if (meilleureCombinaison == null) {
            return main.obtenirPointsDeLaPlusHauteCarte();
        }
        return meilleureCombinaison.obtenirPoints();
    }

    private Combinaison trouverMeilleureCombinaison(Main main) {
        Combinaison meilleureCombinaison = null;
        for (Combinaison combinaison : Combinaison.values()) {
            boolean rapportePlus = meilleureCombinaison == null
                    || combinaison.obtenirPoints() > meilleureCombinaison.obtenirPoints();
            if (combinaison.estPresenteDans(main) && rapportePlus) {
                meilleureCombinaison = combinaison;
            }
        }
        return meilleureCombinaison;
    }
}
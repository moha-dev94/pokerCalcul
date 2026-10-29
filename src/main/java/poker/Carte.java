package poker;

public class Carte {
    private SymboleCarte symbole;
    private NumeroCarte numero;

    public Carte(SymboleCarte symbole, NumeroCarte numero) {
        this.symbole = symbole;
        this.numero = numero;
    }

    public SymboleCarte obtenirSymbole() {
        return symbole;
    }

    public NumeroCarte obtenirNumero() {
        return numero;
    }
    public int obtenirPoints(){
        return numero.obtenirPoints();
    }
}

package al22.esgi.fr.blackjackal12;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class Carte {

    private String lettre;
    private int valeur;
    private enum couleurs {PIQUE, TREFLE, CARREAU, COEUR};
    private boolean visible = true;

    public String getLettre() {
        return lettre;
    }
    public void setLettre(String lettre) {
        lettre = lettre;
    }
    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}

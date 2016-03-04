package al22.esgi.fr.blackjackal12;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
enum couleurs {PIQUE, TREFLE, CARREAU, COEUR};
enum lettres{DEUX,TROIS,QUATRE,CINQ,SIX,SEPT,HUIT,NEUF,DIX,V,D,R,A};


public class Carte implements Comparable<Carte>{

    public static HashMap<lettres, Integer> cartes = new HashMap<lettres,Integer>();
    static {
        cartes.put(lettres.DEUX,2);
        cartes.put(lettres.TROIS,3);
        cartes.put(lettres.QUATRE,4);
        cartes.put(lettres.CINQ,5);
        cartes.put(lettres.SIX,6);
        cartes.put(lettres.SEPT,7);
        cartes.put(lettres.HUIT,8);
        cartes.put(lettres.NEUF,9);
        cartes.put( lettres.DIX,10);
        cartes.put( lettres.V,10);
        cartes.put( lettres.D,10);
        cartes.put(lettres.R,10);
        cartes.put( lettres.A,11);
        }
    public lettres lettre ;
    public int valeur;
    public couleurs couleur;
    public boolean visible = true;
    public Carte(lettres lettre, couleurs couleur) {
        this.lettre = lettre;
        this.couleur = couleur;
    }

    public int getValeur() {
        return cartes.get(this.lettre); //.get(this.lettre);
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }


    @Override
    public int compareTo(Carte c) {
        if(this.valeur == c.valeur){
            if (this.lettre == c.lettre){
                if(this.couleur == c.couleur){
                    return 0;
                }
            }
        }
        return 1;
    }
    public String toString(){
        return lettre.toString() + " - " + couleur.toString();
    }

    public boolean isValid(){
        if(cartes.get(this.lettre) == this.valeur){
            return true;
        }
        else{
            return false;
        }
    }
}

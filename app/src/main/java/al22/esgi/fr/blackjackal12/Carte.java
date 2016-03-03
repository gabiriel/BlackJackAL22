package al22.esgi.fr.blackjackal12;

import java.util.HashMap;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class Carte implements Comparable<Carte>{

    public String lettre;
    public static HashMap<lettres, Integer> cartes = new HashMap<lettres,Integer>();
    public void genererCarte(){
        cartes.put(lettres.DEUX,2);
        cartes.put(lettres.TROIS,3);
        cartes.put(lettres.QUATRE,4);
        cartes.put(lettres.CINQ,5);
        cartes.put(lettres.SIX,6);
        cartes.put(lettres.SEPT,7);
        cartes.put(lettres.HUIT,8);
        cartes.put(lettres.NEUF,9);
        cartes.put(lettres.DIX,10);
        cartes.put(lettres.V,10);
        cartes.put(lettres.D,10);
        cartes.put(lettres.R,10);
        cartes.put(lettres.A,11);
    }

    @Override
    public int compareTo(Carte c) {
        if(this.valeur == c.valeur){
            if (this.lettre == c.lettre){
                return 0;
            }
        }
        return 1;
    }

    private enum lettres{DEUX,TROIS,QUATRE,CINQ,SIX,SEPT,HUIT,NEUF,DIX,V,D,R,A}
    public int valeur;
    private enum couleurs {PIQUE, TREFLE, CARREAU, COEUR};
    private boolean visible = true;

    public boolean isValid(){
        if(cartes.get(this.lettre) == this.valeur){
            return true;
        }
        else{
            return false;
        }
    }
}

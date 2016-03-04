package al22.esgi.fr.blackjackal12;

import android.util.Log;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class Test {
    public void noukatester() {
        Partie p = new Partie();
        p.InitialiserPartie();
        boolean b = p.TesterCartesPioche();
        Log.v("TestCartesPioche", "resultat = " + b);
    }
    public void cakatesterduw(){
        Partie p = new Partie();
        p.InitialiserPartie();
        Carte c1 = p.DistribuerUneCarteAuJoueur();
        boolean b1 = p.cartesPioche.size()==51;
        Log.v("test lenght pioche", " " + b1);
        boolean b2 = p.mains.get(p.mainActuelle).listeCarte.contains(c1);
        Log.v("test main joueur"," "+b2);
    }
}

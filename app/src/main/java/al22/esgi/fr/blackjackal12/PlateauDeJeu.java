package al22.esgi.fr.blackjackal12;

import android.util.Log;

import java.lang.Object;
import java.lang.Override;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class PlateauDeJeu {
    public static List<Integer> JetonsPossibles = new ArrayList<Integer>();
    static
    {
        JetonsPossibles.add(1);
        JetonsPossibles.add(5);
        JetonsPossibles.add(25);
        JetonsPossibles.add(100);
        JetonsPossibles.add(500);
        JetonsPossibles.add(1000);
    }

    public List<Integer> Jetons = new ArrayList<Integer>();
    public int mises = 0;

    public PlateauDeJeu(){
        ReinitialiserMise();
    }


    public boolean AjouterJeton(int jeton){
        if(!JetonsPossibles.contains(jeton)){
            Log.d("Plateau - AjouterJeton", "Ce jeton " + jeton + "n'est compatible avec ce jeu");
            return false;
        }
        Jetons.add(jeton);
        CalculerMise();
        return true;
    }

    public int ObtenirNombreJeton(int jeton)
    {
        if(!JetonsPossibles.contains(jeton)){
            Log.d("ObtenirNombreJeton" , "Ce jeton " + jeton + " ne figure pas dans la liste des jetons compatibles avec ce jeu");
            return 0;
        }
        int somme = 0;
        for(int j : Jetons){
            if(j == jeton) somme++;
        }
        return somme;
    }

    public void CalculerMise(){
        int somme = 0;
        for(int jeton : Jetons)
            somme += jeton;
        mises = somme;
    }

    public void ReinitialiserMise(){
        mises=0;
        Jetons.clear();
    }

}

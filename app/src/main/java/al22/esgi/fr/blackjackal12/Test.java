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
        Log.v("", "resultat : " + b);
    }
}

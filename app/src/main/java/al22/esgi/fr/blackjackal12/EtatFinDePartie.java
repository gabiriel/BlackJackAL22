package al22.esgi.fr.blackjackal12;

import android.util.Log;

/**
 * Created by Mutaw on 03/03/2016.
 */
public class EtatFinDePartie extends EtatPartie {
    @Override
    public void ModifieEtat(Partie p) {
        if(p == null) throw new NullPointerException("La Partie a modifier est nulle");
        p.EtatCourant = this;
        Afficher();
    }

    @Override
    public void Afficher() {
        Log.d("Etat de la Partie", "En Fin de Partie");
    }
}

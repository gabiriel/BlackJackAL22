package al22.esgi.fr.blackjackal12;

import android.util.Log;

/**
 * Created by Mutaw on 03/03/2016.
 */
public class EtatJeuNormal extends EtatPartie {
    @Override
    public void ModifieEtat(Partie p) {
        if(p == null) throw new NullPointerException("La Partie a modifier est nulle");
        p.EtatCourant = this;
        Afficher();
        p.action = false;
    }

    @Override
    public void Afficher() {
        Log.d("Etat de la Partie", "En Jeu Normal");
    }
}

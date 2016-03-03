package al22.esgi.fr.blackjackal12;

import android.util.Log;

import java.security.InvalidParameterException;

/**
 * Created by Mutaw on 04/03/2016.
 */
public class Action {

    public Partie Jeu;
    public Action(Partie p)
    {
        Jeu = p;
    }
    public void AjouterJeton(int valeur){
        if(valeur <= 0){
            throw new InvalidParameterException("La valeur du jeton à ajouter doit être strictement positivite");
        }
        if(Jeu.EtatCourant != null && Jeu.EtatCourant instanceof EtatAttenteDeMise) {
            Jeu.plateau.AjouterMise(valeur);
            Jeu.graph.AfficherMiseJoueur();
        }
        else {
            // afficher Toast d'erreur pour le signaler au joueur que cette action n'est pas autorisée/prise en compte
            Log.d("Action.AjouterJeton","impossible dans l'état actuel de la partie");
        }
    }
}
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

    public void ValiderLaMise(){
        if (Jeu.PossedeDesCartes())
            Log.d("Action.ValiderLaMise","impossible dans l'état actuel de la partie");
        else if(Jeu.ObtenirMiseTotaleDuJoueur()<=0)
            Log.d("Action.ValiderLaMise","impossible, Il faut d'abord miser");
        else if(Jeu.ObtenirMiseTotaleDuJoueur()>Jeu.tresorerieJoueur)
            Log.d("Action.ValiderLaMise","impossible de miser autant, vous n'avez pas assez d'argent");
        else
        {
            Jeu.DistribuerUneCarteAuCroupier(true);
            Jeu.DistribuerUneCarteAuJoueur();
            Jeu.DistribuerUneCarteAuCroupier(false);
            Jeu.DistribuerUneCarteAuJoueur();
            Jeu.SauvegarderMise();
            Jeu.tresorerieJoueur-=Jeu.ObtenirMiseTotaleDuJoueur();
            Jeu.graph.AfficherTous();
            Jeu.PasserEnEtatJeuNormal();
        }
    }

    public void FinirTour()
    {
        if(!Jeu.action)
            Log.d("Action.FinirTour", "impossible dans l'état actuel de la partie");
            //Toast.makeText(context, "impossible de finir le tour dans l'état actuel de la partie", 5).show();
        else
            Jeu.action=false;
    }

    public void PiocherUneCarte()
    {

    }

    public void DistribuerCartes()
    {

    }

    public void Doubler()
    {

    }

    public void Split()
    {

    }
}

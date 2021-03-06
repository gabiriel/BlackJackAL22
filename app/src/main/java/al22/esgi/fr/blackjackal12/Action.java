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
    public boolean AjouterJeton(int valeur){
        if(valeur <= 0){
            throw new InvalidParameterException("La valeur du jeton à ajouter doit être strictement positivite");
        }
        if(Jeu.EtatCourant != null && Jeu.EtatCourant instanceof EtatAttenteDeMise) {
            if(!Jeu.plateau.AjouterJeton(valeur))   return false; // jeton incompatible
            Jeu.graph.AfficherMiseJoueur();
        }
        else {
            // afficher Toast d'erreur pour le signaler au joueur que cette action n'est pas autorisée/prise en compte
            Log.d("Action.AjouterJeton","impossible dans l'état actuel de la partie");
            return false;
        }
        return true;
    }

    public void ValiderLaMise() {
        if (Jeu.PossedeDesCartes())
            Log.d("Action.ValiderLaMise", "impossible dans l'état actuel de la partie");
        //else if (Jeu.ObtenirMiseTotaleDuJoueur() <= 0)
        else if (Jeu.plateau.mises <= 0)
            Log.d("Action.ValiderLaMise", "impossible, Il faut d'abord miser");
        else if (Jeu.plateau.mises > Jeu.tresorerieJoueur)
            Log.d("Action.ValiderLaMise", "impossible de miser autant, vous n'avez pas assez d'argent");
        else {
            Log.d("ValiderLaMise", "Distribution des cartes ...");
            Jeu.DistribuerUneCarteAuCroupier(true);
            Jeu.DistribuerUneCarteAuJoueur();
            Jeu.DistribuerUneCarteAuCroupier(false);
            Jeu.DistribuerUneCarteAuJoueur();
            Jeu.SauvegarderMise();
            Jeu.tresorerieJoueur -= Jeu.ObtenirMiseTotaleDuJoueur();
            Jeu.graph.AfficherTous();
            Jeu.PasserEnEtatJeuNormal();
            if(Jeu.ExisteVainqueur()){
                Jeu.graph.AfficherResultat();
                Jeu.PasserEnEtatFinPartie();
            }
        }
    }

    public void EffacerMise()
    {
        Jeu.plateau.ReinitialiserMise();
        Jeu.graph.AfficherMiseJoueur();
    }



    public void FinirTour()
    {
        if(!Jeu.action)
            Log.d("Action.FinirTour", "impossible dans l'état actuel de la partie");
            //Toast.makeText(context, "impossible de finir le tour dans l'état actuel de la partie", 5).show();
        else {
            Jeu.action = false;
            if(Jeu.mainBanquier.PossedeCarteInvisible())
                Jeu.mainBanquier.RetournerCartes();
            boolean distribBanque = true;
            while(distribBanque) {
                if (Jeu.mainBanquier.ObtenirValeurDesCartes() < Jeu.mains.get(0).ObtenirValeurDesCartes()) {
                    if (Jeu.ObtenirValeurDesCartes(Jeu.mainBanquier) <= 21) {
                        Jeu.DistribuerUneCarteAuCroupier(true);
                    }
                    else distribBanque = false;
                }
                else distribBanque = false;
            }



            Jeu.graph.AfficherCartesBanque();
            Jeu.graph.AfficherLesPoints();
        //    if(Jeu.ExisteVainqueur()){
            Jeu.graph.AfficherResultat();
            Jeu.PasserEnEtatFinPartie();

        }
    }

    public void PiocherUneCarte()
    {

    }

    public void TirerCartes()
    {
        if(Jeu.EtatCourant != null && Jeu.EtatCourant instanceof EtatJeuNormal){
            if(Jeu.ObtenirValeurDesCartes(Jeu.mains.get(0)) <= 21 ) {
                Jeu.DistribuerUneCarteAuJoueur();
                Jeu.graph.AfficherLesPoints();
                Jeu.graph.AfficherCartesDuJoueur();
                Jeu.action = true;
                if(Jeu.ExisteVainqueur()){
                    Jeu.graph.AfficherResultat();
                    Jeu.PasserEnEtatFinPartie();
                }
            }
            else Log.d("TirerCartes","Valeur des cartes > 21");
        }
        else Log.d("DistribuerCartes", "non autorisé dans cet état");
    }

    public void Doubler()
    {

    }

    public void Split()
    {

    }
}

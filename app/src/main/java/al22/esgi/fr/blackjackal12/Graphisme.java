package al22.esgi.fr.blackjackal12;

import android.util.Log;

public class Graphisme
{
    public Partie Jeu;
    public Graphisme(Partie partie){
        Jeu = partie;
    }
    public void AfficherTous(){
        AfficherCartesBanque();
        AfficherCartesDuJoueur();
        AfficherLesPoints();
        AfficherMiseJoueur();
    }
    public void AfficherUneCarteJoueur(int numCarte, Carte carte)
    {

    }

    public void AfficherCartesDuJoueur()
    {

    }

    public void AfficherUneCarteBanque(int numCarte, Carte carte)
    {

    }

    public void AfficherCartesBanque()
    {

    }

    public void AfficherLesPoints()
    {

    }
    public void AfficherMiseJoueur(){

    }

    public void AfficherResultat() {
        if(Jeu == null) throw new NullPointerException("Le jeu de l'instance graphismes est null");
        Jeu.DeterminerVainqueur();
        if(Jeu.Victoire == victoire.inconnu){
            Log.d("AfficherResultat","impossible car le vainqueur est inconnu");
        }
    }

    public void CacherResultat()
    {

    }
}
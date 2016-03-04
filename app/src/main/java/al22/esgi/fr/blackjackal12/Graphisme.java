package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static al22.esgi.fr.blackjackal12.couleurs.TREFLE;
import static al22.esgi.fr.blackjackal12.lettres.*;

public class Graphisme
{
    public Partie Jeu;
    public Context context;
    public Graphisme(Partie partie){
        Jeu = partie;
        context = partie.context;
    }
    public void AfficherTous(){
        AfficherCartesBanque();
        AfficherCartesDuJoueur();
        AfficherLesPoints();
        AfficherMiseJoueur();
    }

    public String ObtenirNomPngCarte(Carte c)
        {
        String NomFichier = "";
        switch(c.couleur)
        {
            case TREFLE: NomFichier += "t"; break;
            case CARREAU: NomFichier += "c"; break;
            case COEUR: NomFichier += "h"; break;
            case PIQUE: NomFichier += "p"; break;
        }

        switch(c.lettre)
        {
            case A: NomFichier += "a"; break;
            case DEUX: NomFichier += "2"; break;
            case TROIS: NomFichier += "3"; break;
            case QUATRE: NomFichier += "4"; break;
            case CINQ: NomFichier += "5"; break;
            case SIX: NomFichier += "6"; break;
            case SEPT: NomFichier += "7"; break;
            case HUIT: NomFichier += "8"; break;
            case NEUF: NomFichier += "9"; break;
            case DIX: NomFichier += "10"; break;
            case V: NomFichier += "j"; break;
            case D: NomFichier += "q"; break;
            case R: NomFichier += "r"; break;
        }

      //  NomFichier += ".png";
        return NomFichier;
    }
    public void AfficherUneCarteJoueur(int numCarte, Carte carte)
    {
        Log.d("AfficherUneCarteJoueur" , " Tentative");
        int resID;
        if(context == null) {
            Log.d("AfficherMiseJoueur","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;
        String NomFichierCarte = ObtenirNomPngCarte(carte);
        Log.d("AfficherUneCarteJoueur", "NomFichier = " + NomFichierCarte );
        String cartejoueur = "cartejoueur" + numCarte;

        resID = ga.getResources().getIdentifier(cartejoueur, "id", ga.getPackageName());
        ImageView cardImg = (ImageView) ga.findViewById(resID);// carte physique sélectionnée

        resID = ga.getResources().getIdentifier(NomFichierCarte,"mipmap",ga.getPackageName());
        cardImg.setBackgroundResource(resID);
        cardImg.setVisibility(View.VISIBLE);
    }

    public void AfficherCartesDuJoueur()
    {
        int i = 1;
        for(Carte c : Jeu.mains.get(0).listeCarte)
        {
            AfficherUneCarteJoueur(i,c);
            Log.d("AfficherCartesDuJoueur"," carte " + i + " = " + c);
            ++i;
        }
        if(i < 6){ // Cache les cartes qu'il ne possède pas
            for(;i < 6;++i)
            {
                CacherCarteJoueur(i);
            }
        }
    }

    public void AfficherUneCarteBanque(int numCarte, Carte carte)
    {
        int resID;
        if(context == null) {
            Log.d("AfficherUneCarteBanque","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;

        String NomFichierCarte = ObtenirNomPngCarte(carte);
        Log.d("AfficherUneCarteBanque", "NomFichier = " + NomFichierCarte );
        String cartebanque = "cartebanque" + numCarte;

        resID = ga.getResources().getIdentifier(cartebanque, "id", ga.getPackageName());
        ImageView cardImg = (ImageView) ga.findViewById(resID);// carte physique sélectionnée
        if(carte.visible)
            resID = ga.getResources().getIdentifier(NomFichierCarte,"mipmap",ga.getPackageName());
        else
            resID = ga.getResources().getIdentifier("back", "mipmap", ga.getPackageName());
        cardImg.setBackgroundResource(resID);
        cardImg.setVisibility(View.VISIBLE);

    }

    public void CacherCarteBanque(int numCarte)
    {
        if(context == null) {
            Log.d("CacherCarteBanque","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;
        String cartebanque = "cartebanque" + numCarte;

        int resID = ga.getResources().getIdentifier(cartebanque,"id",ga.getPackageName());
        ImageView cardImg = (ImageView) ga.findViewById(resID);// carte physique sélectionnée
        cardImg.setVisibility(View.INVISIBLE);
    }

    public void CacherCarteJoueur(int numCarte)
    {
        if(context == null) {
            Log.d("CacherCarteBanque","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;
        String cartejoueur = "cartejoueur" + numCarte;

        int resID = ga.getResources().getIdentifier(cartejoueur,"id",ga.getPackageName());
        ImageView cardImg = (ImageView) ga.findViewById(resID);// carte physique sélectionnée
        cardImg.setVisibility(View.INVISIBLE);
    }
    public void AfficherCartesBanque()
    {
        int i = 1;
        for(Carte c : Jeu.mainBanquier.listeCarte)
        {
            AfficherUneCarteBanque(i,c);
            ++i;
        }
        if(i < 6){ // Cache les cartes qu'il ne possède pas
            for(;i < 6;++i)
            {
                CacherCarteBanque(i);
            }
        }
    }

    public void AfficherLesPoints()
    {
        int resID;
        if(context == null) {
            Log.d("AfficherMiseJoueur","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;

        int valeurJoueur = Jeu.mains.get(0).ObtenirValeurDesCartes();
        int valeurBanquier = Jeu.mainBanquier.ObtenirValeurDesCartes();

        resID = ga.getResources().getIdentifier("lblValeurJoueur", "id", ga.getPackageName());
        TextView lblValeurJoueur = (TextView) ga.findViewById(resID);
        lblValeurJoueur.setText("" + valeurJoueur);

        resID = ga.getResources().getIdentifier("lblValeurBanque", "id", ga.getPackageName());
        TextView lblValeurBanque = (TextView) ga.findViewById(resID);
        lblValeurBanque.setText("" + valeurBanquier);

    }
    public void AfficherMiseJoueur(){
        if(context == null) {
            Log.d("AfficherMiseJoueur","Context est null");
            return;
        }
        Activity a = ((Activity) context);
        if(a == null) {
            //Log.d("AfficherMiseJoueur","L'activity de l'instance de graphismes est nulle");
            throw new NullPointerException("L'activity de l'instance de graphismes est nulle");
            //return;
        }
        GameActivity ga = (GameActivity)a;
        //((GameActivity) a).AfficherMiseJoueur();
        // GameActivity ga = Activity;
        int resID;
        for(int jeton : Jeu.plateau.JetonsPossibles) {
            String jetonID = "misejeton" + jeton;

            // Obtention de l'id de la ressource "Mise du Jeton X"
            resID = ((Activity) context).getResources().getIdentifier(jetonID, "id", ((Activity) context).getPackageName());
            ImageView misejeton = (ImageView) ((Activity) context).findViewById(resID);
            if(Jeu.plateau.Jetons.contains(jeton)) misejeton.setVisibility(View.VISIBLE); // On affiche la mise de ce jeton
            else misejeton.setVisibility(View.INVISIBLE); // On affiche plus la mise de ce jeton

            // Obtention de l'id de la ressource "Nombre de jetons du Jeton X"
            String nbjetonID = "nbjeton" + jeton;
            resID = ga.getResources().getIdentifier(nbjetonID, "id", ga.getPackageName());
            TextView nbjeton = (TextView) ga.findViewById(resID);
            nbjeton.setVisibility(View.VISIBLE); // On affiche le nb de ces jetons
            String nbjetonValue = nbjeton.getText().toString(); // On met à jour la valeur
            if(Jeu.plateau.Jetons.contains(jeton)){
                nbjeton.setVisibility(View.VISIBLE); // On affiche le nb de jeton
                int nbJetons = Jeu.plateau.ObtenirNombreJeton(jeton);
                nbjeton.setText("" + nbJetons); // On met à jour le nombre de jetons du même type
            }
            else nbjeton.setVisibility(View.INVISIBLE); // On affiche plus le nb de jeton


        }

        Jeu.plateau.CalculerMise();
        // On affiche la Mise totale
        resID = ga.getResources().getIdentifier("lblMise", "id", ga.getPackageName());
        TextView lblMise = (TextView) ga.findViewById(resID);
        //TextView lblMise = (TextView) ga.findViewById(R.id.lblMise);
        // String valeurMise = lblMise.getText().toString();
        // int new_valeurMise = Integer.parseInt(valeurMise) + Integer.parseInt(jeton);
        // lblMise.setText("" + new_valeurMise);
        lblMise.setText("" +  Jeu.plateau.mises);

        boolean afficherBoutons;

        if(Jeu.EtatCourant != null && Jeu.EtatCourant instanceof EtatAttenteDeMise) {
            if(Jeu.plateau.mises > 0) afficherBoutons = true;
            else afficherBoutons = false;
        }
        else afficherBoutons = false;

        resID = ga.getResources().getIdentifier("lblValiderMise", "id", ga.getPackageName());
        TextView lblValiderMise = (TextView) ga.findViewById(resID);
        if(afficherBoutons) lblValiderMise.setVisibility(View.VISIBLE);
        else lblValiderMise.setVisibility(View.INVISIBLE);

        resID = ga.getResources().getIdentifier("btnValiderMise", "id", ga.getPackageName());
        TextView btnValiderMise = (TextView) ga.findViewById(resID);
        if(afficherBoutons) btnValiderMise.setVisibility(View.VISIBLE);
        else btnValiderMise.setVisibility(View.INVISIBLE);

        resID = ga.getResources().getIdentifier("btnAnnulerMise", "id", ga.getPackageName());
        TextView btnAnnulerMise = (TextView) ga.findViewById(resID);
        if(afficherBoutons) btnAnnulerMise.setVisibility(View.VISIBLE);
        else btnAnnulerMise.setVisibility(View.INVISIBLE);

        resID = ga.getResources().getIdentifier("btnreset", "id", ga.getPackageName());
        ImageView btnReset = (ImageView) ga.findViewById(resID);
        if(afficherBoutons) btnReset.setVisibility(View.VISIBLE);
        else  btnReset.setVisibility(View.INVISIBLE);
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
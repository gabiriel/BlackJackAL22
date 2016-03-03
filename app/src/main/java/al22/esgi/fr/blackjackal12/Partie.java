package al22.esgi.fr.blackjackal12;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
enum victoire {inconnu,vainqueur, perdant,matchNul};

public class Partie {
    public Graphisme graph;
    public PlateauDeJeu plateau = new PlateauDeJeu();
    public List<Main> mains = new ArrayList<Main>(){
        {new Main();}
    };
    public List<Carte> cartesPioche;
    public Main mainBanquier;
    public boolean action;
    public int tresorerieJoueur;
    public int miseIniJoueur;
    public int valeurCarte;
    public int mainActuelle;
    public EtatPartie EtatCourant;
    public victoire Victoire = victoire.inconnu;

    public Partie() {
        graph = new Graphisme(this);
    }

    public void PasserEnEtatAttenteDeMise()
    {
        if(EtatCourant == null || EtatCourant instanceof EtatFinDePartie)
        {
            EtatCourant = new EtatAttenteDeMise();
            EtatCourant.ModifieEtat(this);
        }
        else Log.d("PasserEnAttenteDeMise","non autorisé");
    }

    public void PasserEnEtatJeuNormal()
    {
        if(EtatCourant instanceof EtatAttenteDeMise) {
            EtatCourant = new EtatJeuNormal();
            EtatCourant.ModifieEtat(this);
        }
        else Log.d("PasserEnEtatJeuNormal","non autorisé, non possible depuis cet état " + EtatCourant.getClass().toString());
    }

    public void PasserEnEtatFinPartie()
    {
        DeterminerVainqueur();
        if(Victoire == victoire.inconnu){
            Log.d("PasserEnEtatFinPartie","impossible car vainqueur inconnu");
            return;
        }
        if(EtatCourant == null || EtatCourant instanceof EtatAttenteDeMise){
            Log.d("PasserEnEtatFinPartie", "non autorisé depuis cet état");
            return;
        }
        EtatCourant = new EtatFinDePartie();
        EtatCourant.ModifieEtat(this);
    }

    public void GenererCartesPioche(){
        cartesPioche = new ArrayList<Carte>();
   //     cartesPioche.add(new Carte(lettres.A,couleurs.CARREAU));
   //     cartesPioche.add(new Carte(lettres.A,couleurs.PIQUE));
        Carte c;
        for ( lettres lettre : lettres.values() ){
            for(couleurs couleur : couleurs.values()) {
                c = new Carte(lettre, couleur);
                c.setValeur(c.getValeur());
                cartesPioche.add(c);
            }
        }
    }

    public boolean TesterCartesPioche(){
        Boolean trouve;

        for (Carte c1 : cartesPioche){
            trouve = false;
            for (Carte c2 : cartesPioche){
                if (c1.compareTo(c2) == 0){
                    if(trouve){
                        return false;
                    }
                    trouve = true;
                }
            }
        }
        return cartesPioche.size()==52;
    }

    public Carte ObtenirCarteDeLaPioche(){
        Random r = new Random();
        return cartesPioche.remove(r.nextInt(cartesPioche.size()));
    }

    public void InitialiserPartie(){
        GenererCartesPioche();
        PasserEnEtatAttenteDeMise();
    }

    public void EffacerPlateauDeJeu(){
        miseIniJoueur = 0;
        plateau.ReinitialiserMise();
        mains.clear();
        mains.add(new Main());
        mainBanquier = new Main();
    }
    public boolean PossedeDesCartes(){
        for(Main m : mains){
            if(!m.listeCarte.isEmpty()){
                return true;
            }
        }
        return false;
    }
    public int ObtenirValeurDesCartes(Main m){
        return m.ObtenirValeurDesCartes();
    }
    public int ObtenirMiseTotaleDuJoueur(){
        int total = 0;
        for(Main m : mains){
            total += m.mise;
        }
        return total;
    }
    public void DistribuerUneCarteAuJoueur(){
        Main m = mains.get(mainActuelle);
        m.listeCarte.add(ObtenirCarteDeLaPioche());
    }
    public void DistribuerUneCarteAuCroupier(boolean visible){
        Main m = mains.get(mainActuelle);
        Carte c = ObtenirCarteDeLaPioche();
        c.visible = visible;
        m.listeCarte.add(c);
    }
    public void UpdateTresorerie(){}

    public void DeterminerVainqueur() { // A DETERMINER !
        Victoire = victoire.inconnu;
    }
}

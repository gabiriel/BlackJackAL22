package al22.esgi.fr.blackjackal12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class Partie {
    public List<Main> mains;
    public List<Carte> cartesPioche;
    public Main mainBanquier;
    public boolean action;
    public int tresorerieJoueur;
    public int miseIniJoueur;
    public int miseTotJoueur;
    public int valeurCarte;

    public void GenererCartesPioche(){
        cartesPioche = new ArrayList<Carte>();
        Carte c;
        for ( lettres lettre : lettres.values() ){
            for(couleurs couleur : couleurs.values()) {
                c = new Carte(lettre.toString(), couleur.toString());
                c.setValeur(c.getValeur());
                cartesPioche.add(c);
            }
        }
    }

    public void TesterCartesPioche(){

    }

    public Carte ObtenirCarteDeLaPioche(){
        Random r = new Random();
        return cartesPioche.remove(r.nextInt(cartesPioche.size()));
    }

    public void InitialiserPartie(){
        GenererCartesPioche();
        miseIniJoueur = 0;
        miseTotJoueur = 0;
        //PlateauDeJeu.reinitialiser();
        mains.clear();
        mainBanquier = new Main();
        //Graphisme.Afficher();
    }

    public void EffacerPlateauDeJeu(){

    }

}

package al22.esgi.fr.blackjackal12;

import java.util.List;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class Main {
    public List<Carte> listeCarte;
    public int mise;

    public int ObtenirValeurDesCartes(){
        int total = 0;
        int compteurAs = 0;
        for ( Carte c : listeCarte){
            if(c.lettre == lettres.A){
                compteurAs++;
            }
            else{
                total += c.valeur;
            }
        }
        if(compteurAs > 0){
            if(compteurAs > 1 || total > 10){
                total += compteurAs;
            }
            else {
                total += 11;
            }
        }
        return total;
    }
}

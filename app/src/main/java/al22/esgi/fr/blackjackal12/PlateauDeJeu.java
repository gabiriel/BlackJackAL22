package al22.esgi.fr.blackjackal12;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class PlateauDeJeu {
    private int mises = 0;

    public PlateauDeJeu(){
        ReinitialiserMise();
    }

    public void AjouterMise(int mise){
        mises+=mise;
    }

    public void ReinitialiserMise(){
        mises=0;
    }

}

package al22.esgi.fr.blackjackal12;

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

    public int RetournerMise()
    {
        return mises;
    }

}

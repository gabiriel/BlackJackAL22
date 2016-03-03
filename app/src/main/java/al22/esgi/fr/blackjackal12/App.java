package al22.esgi.fr.blackjackal12;

import android.app.Application;

/**
 * Created by Rawinderjeet on 03/03/2016.
 */
public class App extends Application{

    private double tresorerie;
    public double getTresorerie(){
        return tresorerie;
    }
    public void setTresorerie(double t){
        tresorerie = t;
    }
}

package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //recup variable globale tresorerie
        /*App app = ((App) getApplicationContext());
        double tresorerie= app.getTresorerie();
        */
    }
}
package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class GameActivity extends Activity {

    Partie Jeu = new Partie(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //recup variable globale tresorerie
        /*App app = ((App) getApplicationContext());
        double tresorerie= app.getTresorerie();
        */

        //findViewById(R.id.imageView).setOnTouchListener(new MyTouchListener());
        Jeu.InitialiserPartie();
    }
    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

}
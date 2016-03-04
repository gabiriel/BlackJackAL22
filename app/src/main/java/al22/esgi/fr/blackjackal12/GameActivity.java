package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        ImageView jeton1 = (ImageView) findViewById(R.id.jeton1);
        jeton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("1");
            }
        });
        ImageView jeton5 = (ImageView) findViewById(R.id.jeton5);
        jeton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("5");
            }
        });
        ImageView jeton25 = (ImageView) findViewById(R.id.jeton25);
        jeton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("25");
            }
        });
        ImageView jeton100 = (ImageView) findViewById(R.id.jeton100);
        jeton100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("100");
            }
        });
        ImageView jeton500 = (ImageView) findViewById(R.id.jeton500);
        jeton500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("500");
            }
        });
        ImageView jeton1k = (ImageView) findViewById(R.id.jeton1k);
        jeton1k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfficherJetonMise("1k");
            }
        });
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


    public void AfficherJetonMise(String idJeton){
        String jetonID = "misejeton" + idJeton;
        int resID = getResources().getIdentifier(jetonID, "id", getPackageName());

        ImageView misejeton = (ImageView) findViewById(resID);
        misejeton.setVisibility(View.VISIBLE);

        String nbjetonID = "nbjeton" + idJeton;
        resID = getResources().getIdentifier(nbjetonID, "id", getPackageName());

        TextView nbjeton = (TextView) findViewById(resID);
        nbjeton.setVisibility(View.VISIBLE);

        String nbjetonValue = nbjeton.getText().toString();

        int new_nbjeton = Integer.parseInt(nbjetonValue) + 1;
        nbjeton.setText("" + new_nbjeton);

        TextView lblMise = (TextView) findViewById(R.id.lblMise);
        String valeurMise = lblMise.getText().toString();
        int new_valeurMise = Integer.parseInt(valeurMise) + Integer.parseInt(idJeton);
        lblMise.setText("" + new_valeurMise);
    }

}
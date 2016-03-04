package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity {

    Partie Jeu;
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

        /* AFFICHER LES JETONS ******************************************/
        ImageView jeton1 = (ImageView) findViewById(R.id.jeton1);
        jeton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(1);

            }
        });
        ImageView jeton5 = (ImageView) findViewById(R.id.jeton5);
        jeton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(5);

            }
        });
        ImageView jeton25 = (ImageView) findViewById(R.id.jeton25);
        jeton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(25);
            }
        });
        ImageView jeton100 = (ImageView) findViewById(R.id.jeton100);
        jeton100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(100);
            }
        });
        ImageView jeton500 = (ImageView) findViewById(R.id.jeton500);
        jeton500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(500);
            }
        });
        ImageView jeton1k = (ImageView) findViewById(R.id.jeton1k);
        jeton1k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.AjouterJeton(1000);
            }
        });
        ImageView btnreset = (ImageView) findViewById(R.id.btnreset);
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    RAZMise();
                Jeu.ActionJoueur.EffacerMise();
            }
        });
        TextView btnValiderMise = (TextView) findViewById(R.id.btnValiderMise);
        btnValiderMise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.ValiderLaMise();

            }
        });
        TextView btnAnnulerMise = (TextView) findViewById(R.id.btnAnnulerMise);
        btnAnnulerMise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.EffacerMise();
            }
        });

        final Button btnTirer = (Button) findViewById(R.id.btnTirer);
        btnTirer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu.ActionJoueur.DistribuerCartes();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        Jeu = new Partie(this);
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


    public void AjouterJetonMise(String idJeton){
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

       if(idJeton.equals("1k")){
            idJeton = "1000";
        }

        TextView lblMise = (TextView) findViewById(R.id.lblMise);
        String valeurMise = lblMise.getText().toString();
        int new_valeurMise = Integer.parseInt(valeurMise) + Integer.parseInt(idJeton);
        lblMise.setText("" + new_valeurMise);
    }

    public void RAZMise() {
        ImageView misejeton1 = (ImageView) findViewById(R.id.misejeton1);
        misejeton1.setVisibility(View.INVISIBLE);
        ImageView misejeton5 = (ImageView) findViewById(R.id.misejeton5);
        misejeton5.setVisibility(View.INVISIBLE);
        ImageView misejeton25 = (ImageView) findViewById(R.id.misejeton25);
        misejeton25.setVisibility(View.INVISIBLE);
        ImageView misejeton100 = (ImageView) findViewById(R.id.misejeton100);
        misejeton100.setVisibility(View.INVISIBLE);
        ImageView misejeton500 = (ImageView) findViewById(R.id.misejeton500);
        misejeton500.setVisibility(View.INVISIBLE);
        ImageView misejeton1k = (ImageView) findViewById(R.id.misejeton1000);
        misejeton1k.setVisibility(View.INVISIBLE);

        TextView nbjeton1 = (TextView) findViewById(R.id.nbjeton1);
        nbjeton1.setText("0");
        nbjeton1.setVisibility(View.INVISIBLE);
        TextView nbjeton5 = (TextView) findViewById(R.id.nbjeton5);
        nbjeton5.setText("0");
        nbjeton5.setVisibility(View.INVISIBLE);
        TextView nbjeton25 = (TextView) findViewById(R.id.nbjeton25);
        nbjeton25.setText("0");
        nbjeton25.setVisibility(View.INVISIBLE);
        TextView nbjeton100 = (TextView) findViewById(R.id.nbjeton100);
        nbjeton100.setText("0");
        nbjeton100.setVisibility(View.INVISIBLE);
        TextView nbjeton500 = (TextView) findViewById(R.id.nbjeton500);
        nbjeton500.setText("0");
        nbjeton500.setVisibility(View.INVISIBLE);
        TextView nbjeton1k = (TextView) findViewById(R.id.nbjeton1000);
        nbjeton1k.setText("0");
        nbjeton1k.setVisibility(View.INVISIBLE);

        TextView lblMise = (TextView) findViewById(R.id.lblMise);
        lblMise.setText("0");
    }

    public void displayTuto(View view)
    {
        Intent intent = new Intent(this, TutoActivity.class);
        startActivity(intent);
    }

}
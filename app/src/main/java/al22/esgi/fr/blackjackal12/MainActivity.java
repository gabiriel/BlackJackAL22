package al22.esgi.fr.blackjackal12;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", "onCreate - Initialisation des tests");

        new Test().cakatesterduw();
    }
    public void displayTuto(View view)
    {
        Intent intent = new Intent(this, TutoActivity.class);
        startActivity(intent);
    }

    public void playGame(View view)
    {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

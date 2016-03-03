package al22.esgi.fr.blackjackal12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_start(View view)
    {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

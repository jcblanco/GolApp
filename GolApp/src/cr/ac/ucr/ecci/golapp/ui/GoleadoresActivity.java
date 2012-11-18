package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GoleadoresActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goleadores);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_goleadores, menu);
        return true;
    }
}

package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TablaPosiciones extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_posiciones);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tabla_posiciones, menu);
        return true;
    }
}

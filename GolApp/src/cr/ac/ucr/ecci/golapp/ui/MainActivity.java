package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	public void showTablaPosiciones(View view) {

		startActivity(new Intent(MainActivity.this, TablaPosiciones.class));

	}
	
	public void showProximaJornada(View view) {

		startActivity(new Intent(MainActivity.this, ProxJornadaActivity.class));

	}
	
	public void showJornadaAnterior(View view) {

		startActivity(new Intent(MainActivity.this, JornadaAnteriorActivity.class));

	}
}

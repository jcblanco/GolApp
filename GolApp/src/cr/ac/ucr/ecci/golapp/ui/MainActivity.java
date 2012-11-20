package cr.ac.ucr.ecci.golapp.ui;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.View;

public class MainActivity extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		menu.add(Menu.NONE, 8, Menu.NONE, "Salir")
				.setIcon(android.R.drawable.ic_menu_close_clear_cancel)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 8:
			MainActivity.this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void showTablaPosiciones(View view) {

		startActivity(new Intent(MainActivity.this, TablaPosiciones.class));

	}

	public void showProximaJornada(View view) {

		startActivity(new Intent(MainActivity.this, ProxJornadaActivity.class));

	}

	public void showJornadaAnterior(View view) {

		startActivity(new Intent(MainActivity.this,
				JornadaAnteriorActivity.class));

	}

	public void showGoleadores(View view) {

		startActivity(new Intent(MainActivity.this, GoleadoresActivity.class));

	}
}

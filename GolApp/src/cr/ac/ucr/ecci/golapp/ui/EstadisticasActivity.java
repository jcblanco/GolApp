package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class EstadisticasActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        
        TextView test = (TextView) this
				.findViewById(R.id.test);
        
        //Bundle b = getIntent().getExtras();
        //String value = b.getString("partido");
        Partido p = (Partido) getIntent().getSerializableExtra("partido");
        
        test.setText(Integer.toString((p.getEstadisticas()).getTiros1()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_estadisticas, menu);
        return true;
    }
}

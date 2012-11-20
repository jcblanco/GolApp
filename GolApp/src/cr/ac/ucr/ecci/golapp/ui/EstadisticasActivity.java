package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import android.os.Bundle;
import android.widget.TextView;

public class EstadisticasActivity extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estadisticas);

		Partido p = (Partido) getIntent().getSerializableExtra("partido");

		cargarEstadisticas(p);
	}

	public void cargarEstadisticas(Partido partido) {

		TextView equipo1 = (TextView) this.findViewById(R.id.est_equipo1);
		equipo1.setText(partido.getEquipo1());

		TextView equipo2 = (TextView) this.findViewById(R.id.est_equipo2);
		equipo2.setText(partido.getEquipo2());

		TextView goles1 = (TextView) this.findViewById(R.id.est_goles1);
		goles1.setText(Integer.toString(partido.getGoles1()));

		TextView goles2 = (TextView) this.findViewById(R.id.est_goles2);
		goles2.setText(Integer.toString(partido.getGoles2()));

		TextView tiros1 = (TextView) this.findViewById(R.id.est_tiros1);
		tiros1.setText(Integer.toString(partido.getEstadisticas().getTiros1()));

		TextView tiros2 = (TextView) this.findViewById(R.id.est_tiros2);
		tiros2.setText(Integer.toString(partido.getEstadisticas().getTiros2()));

		TextView faltas1 = (TextView) this.findViewById(R.id.est_faltas1);
		faltas1.setText(Integer
				.toString(partido.getEstadisticas().getFaltas1()));

		TextView faltas2 = (TextView) this.findViewById(R.id.est_faltas2);
		faltas2.setText(Integer
				.toString(partido.getEstadisticas().getFaltas2()));

		TextView ta1 = (TextView) this.findViewById(R.id.est_tarjetasA1);
		ta1.setText(Integer.toString(partido.getEstadisticas()
				.getTarjetasAmarillas1()));

		TextView ta2 = (TextView) this.findViewById(R.id.est_tarjetasA2);
		ta2.setText(Integer.toString(partido.getEstadisticas()
				.getTarjetasAmarillas2()));

		TextView tr1 = (TextView) this.findViewById(R.id.est_tarjetasR1);
		tr1.setText(Integer.toString(partido.getEstadisticas()
				.getTarjetasRojas1()));

		TextView tr2 = (TextView) this.findViewById(R.id.est_tarjetasR2);
		tr2.setText(Integer.toString(partido.getEstadisticas()
				.getTarjetasRojas2()));

		TextView posesion1 = (TextView) this.findViewById(R.id.est_posesion1);
		posesion1.setText(Integer.toString(partido.getEstadisticas()
				.getPosesion1()));

		TextView posesion2 = (TextView) this.findViewById(R.id.est_posesion2);
		posesion2.setText(Integer.toString(partido.getEstadisticas()
				.getPosesion2()));

	}
}

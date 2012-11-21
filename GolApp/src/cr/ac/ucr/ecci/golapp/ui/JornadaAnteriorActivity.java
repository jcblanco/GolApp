package cr.ac.ucr.ecci.golapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import cr.ac.ucr.ecci.golapp.service.GolService;
import cr.ac.ucr.ecci.golapp.service.GolServiceFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class JornadaAnteriorActivity extends ActionBarActivity {

	ListView mJornadaAnterior;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jornada_anterior);

		mJornadaAnterior = (ListView) findViewById(R.id.marcadores_list);
		mJornadaAnterior.setEmptyView(findViewById(R.id.empty_list_view));

		Object obj = getLastNonConfigurationInstance();
		List<Partido> partidos = null;
		if (obj != null) {
			partidos = (List<Partido>) obj;
		} else {
			partidos = new ArrayList<Partido>();
		}

		mJornadaAnterior.setAdapter(new MarcadoresAdapter(this, partidos));

		mJornadaAnterior.setTextFilterEnabled(true);
		mJornadaAnterior.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				MarcadoresAdapter adapter = (MarcadoresAdapter) mJornadaAnterior
						.getAdapter();
				
				Partido p= (Partido)adapter.getItem(position);
				
				Intent intent = new Intent(JornadaAnteriorActivity.this, EstadisticasActivity.class);
				//Bundle b = new Bundle();
				//b.putString("partido", p.getEquipo1()); //Partido id
				intent.putExtra("partido",p); //Put your id to your next Intent
				startActivity(intent);
				/*Toast.makeText(getApplicationContext(),
						(Integer.toString(position)), Toast.LENGTH_SHORT).show();*/

			}
		});
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cargarMarcadores();
	}

	public void cargarMarcadores() {

		AsyncTask<Void, Void, List<Partido>> task = new AsyncTask<Void, Void, List<Partido>>() {

			@Override
			protected List<Partido> doInBackground(Void... params) {
				GolService service = GolServiceFactory.getService(1);
				List<Partido> partidos = null;
				try {
					partidos = service.getJornadaAnterior();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return partidos;
			}

			@Override
			protected void onPostExecute(List<Partido> result) {

				if (result != null) {
					MarcadoresAdapter adapter = (MarcadoresAdapter) mJornadaAnterior
							.getAdapter();

					adapter.addList(result);
				}
			}

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				clearData();
			}

		}.execute();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return ((MarcadoresAdapter) mJornadaAnterior.getAdapter())
				.getPartidos();
	}

	public void clearData() {
		MarcadoresAdapter adapter = (MarcadoresAdapter) mJornadaAnterior
				.getAdapter();
		adapter.clear();
	}

	private static class MarcadoresAdapter extends BaseAdapter {

		List<Partido> partidos = new ArrayList<Partido>();
		LayoutInflater inflater;

		public MarcadoresAdapter(Context context, List<Partido> partidos) {
			this.partidos = partidos;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public List<Partido> getPartidos() {
			return partidos;
		}

		public void addList(List<Partido> partidos) {
			this.partidos.addAll(partidos);
			notifyDataSetChanged();
		}

		public int getCount() {
			return partidos.size();
		}

		public Object getItem(int position) {
			return partidos.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Partido partido = (Partido) getItem(position);
			MarcadorViewHolder holder = null;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_marcadores,
						parent, false);
				holder = new MarcadorViewHolder();
				convertView.setTag(holder);
				holder.nombreEquipo1 = (TextView) convertView
						.findViewById(R.id.equipo1);
				holder.nombreEquipo2 = (TextView) convertView
						.findViewById(R.id.equipo2);
				holder.goles1 = (TextView) convertView
						.findViewById(R.id.golesEquipo1);
				holder.goles2 = (TextView) convertView
						.findViewById(R.id.golesEquipo2);
			} else {
				holder = (MarcadorViewHolder) convertView.getTag();
			}

			holder.nombreEquipo1.setText(partido.getEquipo1());
			holder.nombreEquipo2.setText(partido.getEquipo2());
			holder.goles1.setText(Integer.toString(partido.getGoles1()));
			holder.goles2.setText(Integer.toString(partido.getGoles2()));

			return convertView;
		}

		public void clear() {
			partidos.clear();
			notifyDataSetChanged();
		}
	}

	private static class MarcadorViewHolder {
		public TextView nombreEquipo1;
		public TextView nombreEquipo2;
		public TextView goles1;
		public TextView goles2;
	}
}

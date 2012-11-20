package cr.ac.ucr.ecci.golapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;
import cr.ac.ucr.ecci.golapp.service.GolService;
import cr.ac.ucr.ecci.golapp.service.GolServiceFactory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProxJornadaActivity extends ActionBarActivity {

	ListView mProxPartidos;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prox_jornada);

		mProxPartidos = (ListView) findViewById(R.id.partidos_list);

		Object obj = getLastNonConfigurationInstance();
		List<Partido> partidos = null;
		if (obj != null) {
			partidos = (List<Partido>) obj;
		} else {
			partidos = new ArrayList<Partido>();
		}

		mProxPartidos.setAdapter(new PartidosAdapter(this, partidos));
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cargarPartidos();
	}

	public void cargarPartidos() {

		AsyncTask<Void, Void, List<Partido>> task = new AsyncTask<Void, Void, List<Partido>>() {

			@Override
			protected List<Partido> doInBackground(Void... params) {
				GolService service = GolServiceFactory.getService(1);
				List<Partido> partidos = null;
				try {
					partidos = service.getProxJornada();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return partidos;
			}

			@Override
			protected void onPostExecute(List<Partido> result) {

				if (result != null) {
					PartidosAdapter adapter = (PartidosAdapter) mProxPartidos
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
		return ((PartidosAdapter) mProxPartidos.getAdapter()).getPartidos();
	}
	
	public void clearData() {
		PartidosAdapter adapter = (PartidosAdapter) mProxPartidos.getAdapter();
		adapter.clear();
	}

	private static class PartidosAdapter extends BaseAdapter {

		List<Partido> partidos = new ArrayList<Partido>();
		LayoutInflater inflater;

		public PartidosAdapter(Context context, List<Partido> partidos) {
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
			PartidoViewHolder holder = null;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_partidos, parent,
						false);
				holder = new PartidoViewHolder();
				convertView.setTag(holder);
				holder.nombreEquipo1 = (TextView) convertView
						.findViewById(R.id.equipo1);
				holder.nombreEquipo2 = (TextView) convertView
						.findViewById(R.id.equipo2);

			} else {
				holder = (PartidoViewHolder) convertView.getTag();
			}

			holder.nombreEquipo1.setText(partido.getEquipo1());
			holder.nombreEquipo2.setText(partido.getEquipo2());

			return convertView;
		}
		
		public void clear() {
			partidos.clear();
			notifyDataSetChanged();
		}
	}

	private static class PartidoViewHolder {
		public TextView nombreEquipo1;
		public TextView nombreEquipo2;
	}
}

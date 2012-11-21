package cr.ac.ucr.ecci.golapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.Goleador;
import cr.ac.ucr.ecci.golapp.bo.Partido;
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

public class GoleadoresActivity extends ActionBarActivity {
	
	ListView mGoleadores;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goleadores);
        
        mGoleadores= (ListView) findViewById(R.id.goleadores_list);
        mGoleadores.setEmptyView(findViewById(R.id.empty_list_view));
		
		Object obj = getLastNonConfigurationInstance();
		List<Goleador> goleadores = null;
		if (obj != null) {
			goleadores = (List<Goleador>) obj;
		} else {
			goleadores = new ArrayList<Goleador>();
		}

		mGoleadores.setAdapter(new GoleadoresAdapter(this, goleadores));
    }

  
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cargarGoleadores();
	}

	public void cargarGoleadores() {

		AsyncTask<Void, Void, List<Goleador>> task = new AsyncTask<Void, Void, List<Goleador>>() {

			@Override
			protected List<Goleador> doInBackground(Void... params) {
				GolService service = GolServiceFactory.getService(1);
				List<Goleador> goleadores = null;
				try {
					goleadores = service.getGoleadores();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return goleadores;
			}

			@Override
			protected void onPostExecute(List<Goleador> result) {

				if (result != null) {
					GoleadoresAdapter adapter = (GoleadoresAdapter) mGoleadores
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
		return ((GoleadoresAdapter) mGoleadores.getAdapter()).getGoleador();
	}

	public void clearData() {
		GoleadoresAdapter adapter = (GoleadoresAdapter) mGoleadores.getAdapter();
		adapter.clear();
	}
	
	private static class GoleadoresAdapter extends BaseAdapter {

		List<Goleador> goleadores = new ArrayList<Goleador>();
		LayoutInflater inflater;

		public GoleadoresAdapter(Context context, List<Goleador> goleadores) {
			this.goleadores	= goleadores;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public List<Goleador> getGoleador() {
			return goleadores;
		}

		public void addList(List<Goleador> goleadores) {
			this.goleadores.addAll(goleadores);
			notifyDataSetChanged();
		}

		public int getCount() {
			return goleadores.size();
		}

		public Object getItem(int position) {
			return goleadores.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Goleador goleador = (Goleador) getItem(position);
			GoleadorViewHolder holder = null;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_goleadores, parent,
						false);
				holder = new GoleadorViewHolder();
				convertView.setTag(holder);
				holder.jugador = (TextView) convertView
						.findViewById(R.id.jugador);
				holder.goles = (TextView) convertView
						.findViewById(R.id.goles);
			} else {
				holder = (GoleadorViewHolder) convertView.getTag();
			}

			holder.jugador.setText(goleador.getJugador());
			holder.goles.setText(Integer.toString(goleador.getGoles()));

			return convertView;
		}
		
		public void clear() {
			goleadores.clear();
			notifyDataSetChanged();
		}
	}

	private static class GoleadorViewHolder {
		public TextView jugador;
		public TextView goles;
	}
}

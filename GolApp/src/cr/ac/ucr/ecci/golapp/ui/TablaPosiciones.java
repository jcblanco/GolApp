package cr.ac.ucr.ecci.golapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;
import cr.ac.ucr.ecci.golapp.service.GolService;
import cr.ac.ucr.ecci.golapp.service.GolServiceFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TablaPosiciones extends ActionBarActivity {

	ListView mTablaPosiciones;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_posiciones);
        
        mTablaPosiciones  = (ListView) findViewById(R.id.equipos_list);
        
        Object obj = getLastNonConfigurationInstance();
		List<PosicionEquipo> posiciones = null;
		if (obj != null) {
			posiciones = (List<PosicionEquipo>)obj;
		} else {
			posiciones =new ArrayList<PosicionEquipo>();
		}
        
        mTablaPosiciones.setAdapter(new PosicionesAdapter(this,posiciones));
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        menu.add(Menu.NONE, 7, Menu.NONE, "Goleadores")
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cargarTabla();
	}

   
    public void cargarTabla(){

		AsyncTask<Void, Void, List<PosicionEquipo>> task = new AsyncTask<Void, Void, List<PosicionEquipo>>() {

			@Override
			protected List<PosicionEquipo> doInBackground(Void... params) {
				GolService service= GolServiceFactory.getService(1);
				List<PosicionEquipo> posiciones = null;
				try {
					posiciones=	service.getPosiciones();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return posiciones;
			}

			@Override
			protected void onPostExecute(List<PosicionEquipo> result) {

				if (result != null) {
					PosicionesAdapter adapter = (PosicionesAdapter) mTablaPosiciones.getAdapter();

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
		return ((PosicionesAdapter)mTablaPosiciones.getAdapter()).getPosiciones();
	}

	public void clearData() {
		PosicionesAdapter adapter = (PosicionesAdapter) mTablaPosiciones.getAdapter();
		adapter.clear();
	}
    
    private static class PosicionesAdapter extends BaseAdapter {

		List<PosicionEquipo> posiciones= new ArrayList<PosicionEquipo>();
		LayoutInflater inflater;

		public PosicionesAdapter(Context context, List<PosicionEquipo> posiciones) {
			this.posiciones = posiciones;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public List<PosicionEquipo> getPosiciones() {
			return posiciones;
		}

		public void addList(List<PosicionEquipo> posiciones) {
			this.posiciones.addAll(posiciones);
			notifyDataSetChanged();
		}

		public int getCount() {
			return posiciones.size();
		}

		public Object getItem(int position) {
			return posiciones.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			PosicionEquipo equipo = (PosicionEquipo) getItem(position);
			PosicionViewHolder holder = null;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_posiciones_equipo, parent,
						false);
				holder = new PosicionViewHolder();
				convertView.setTag(holder);
				holder.nombreEquipo = (TextView) convertView
						.findViewById(R.id.equipo);
				holder.partidosJugados = (TextView) convertView
						.findViewById(R.id.partidosJugados);
				holder.golDiferencia = (TextView) convertView
						.findViewById(R.id.golDiferencia);
				holder.puntos = (TextView) convertView
						.findViewById(R.id.puntos);
				
			} else {
				holder = (PosicionViewHolder) convertView.getTag();
			}

			holder.nombreEquipo.setText(equipo.getNombreEquipo());
			holder.partidosJugados.setText(Integer.toString(equipo.getPartidosJugados()));
			holder.golDiferencia.setText(Integer.toString(equipo.getGolDiferencia()));
			holder.puntos.setText(Integer.toString(equipo.getPuntosObtenidos()));

			return convertView;
		}
		
		public void clear() {
			posiciones.clear();
			notifyDataSetChanged();
		}
	}

	private static class PosicionViewHolder {
		public TextView nombreEquipo;
		public TextView partidosJugados;
		public TextView golDiferencia;
		public TextView puntos;
	}
}

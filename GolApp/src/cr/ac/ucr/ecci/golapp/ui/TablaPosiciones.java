package cr.ac.ucr.ecci.golapp.ui;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;
import cr.ac.ucr.ecci.service.GolService;
import cr.ac.ucr.ecci.service.GolServiceFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TablaPosiciones extends Activity {

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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cargarTabla();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tabla_posiciones, menu);
        return true;
    }
    
    public void cargarTabla(){

		AsyncTask<Void, Void, List<PosicionEquipo>> task = new AsyncTask<Void, Void, List<PosicionEquipo>>() {

			@Override
			protected List<PosicionEquipo> doInBackground(Void... params) {
				GolService service= GolServiceFactory.getService(1);
				List<PosicionEquipo> posiciones = null;
				try {
					posiciones=	service.getTablaPosiciones();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return posiciones;
			}

			@Override
			protected void onPostExecute(List<PosicionEquipo> result) {

				if (result != null) {
					PosicionesAdapter adapter = (PosicionesAdapter) ((HeaderViewListAdapter) mTablaPosiciones
							.getAdapter()).getWrappedAdapter();

					adapter.addList(result);
				}
			}

		}.execute();
	}
    
    @Override
	protected void onStart() {
		super.onStart();
//		Debug.startMethodTracing("despues_viewholder_debug");
	}

	@Override
	protected void onStop() {
		super.onStop();
//		Debug.stopMethodTracing();
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return ((PosicionesAdapter)((HeaderViewListAdapter) mTablaPosiciones.getAdapter()).getWrappedAdapter()).getPosiciones();
	}

    
    private static class PosicionesAdapter extends BaseAdapter {

		List<PosicionEquipo> posiciones;
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

		public void clearResults() {
			posiciones.clear();
			notifyDataSetChanged();
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
						.findViewById(R.id.nombreEquipo);
				holder.partidosJugados = (TextView) convertView
						.findViewById(R.id.partidosJugados);
				holder.partidosGanados = (TextView) convertView
						.findViewById(R.id.partidosGanados);
				holder.partidosPerdidos = (TextView) convertView
						.findViewById(R.id.partidosPerdidos);
				holder.partidosEmpatados = (TextView) convertView
						.findViewById(R.id.partidosEmpatados);
				holder.golDiferencia = (TextView) convertView
						.findViewById(R.id.golDiferencia);
				holder.puntos = (TextView) convertView
						.findViewById(R.id.puntos);
				
			} else {
				holder = (PosicionViewHolder) convertView.getTag();
			}

			holder.nombreEquipo.setText(equipo.getNombreEquipo());
			holder.partidosJugados.setText(equipo.getPartidosJugados());
			holder.partidosGanados.setText(equipo.getPartidosGanados());
			holder.partidosPerdidos.setText(equipo.getPartidosPerdidos());
			holder.partidosEmpatados.setText(equipo.getPartidosEmpatados());
			holder.golDiferencia.setText(equipo.getGolesAnotados()-equipo.getGolesrecibidos());
			holder.puntos.setText(equipo.getPuntos());

			return convertView;
		}
	}

	private static class PosicionViewHolder {
		public TextView nombreEquipo;
		public TextView partidosJugados;
		public TextView partidosGanados;
		public TextView partidosPerdidos;
		public TextView partidosEmpatados;
		public TextView golDiferencia;
		public TextView puntos;
	}
}

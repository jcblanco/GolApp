package cr.ac.ucr.ecci.golapp.service;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;

public class InMemoryGolService extends GolService {

	@Override
	public List<PosicionEquipo> getPosiciones() {

		List <PosicionEquipo> posiciones = new ArrayList<PosicionEquipo>();
		
		posiciones.add(new PosicionEquipo("Liga",9,8,30));
		posiciones.add(new PosicionEquipo("Saprissa",9,12,27));
		posiciones.add(new PosicionEquipo("Heredia",9,2,22));
		posiciones.add(new PosicionEquipo("Limon",9,1,16));
		
		return posiciones;
	}

}

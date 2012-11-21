package cr.ac.ucr.ecci.golapp.service;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.ecci.golapp.bo.Estadisticas;
import cr.ac.ucr.ecci.golapp.bo.Goleador;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;

public class InMemoryGolService extends GolService {

	@Override
	public List<PosicionEquipo> getPosiciones() {

		List <PosicionEquipo> posiciones = new ArrayList<PosicionEquipo>();
		
		posiciones.add(new PosicionEquipo("Liga",9,8,30/*,"http://www.yashinquesada.com/images/small-liga.jpg"*/));
		posiciones.add(new PosicionEquipo("Saprissa",9,12,27/*,"http://www.yashinquesada.com/images/small-saprissa.jpg"*/));
		posiciones.add(new PosicionEquipo("Heredia",9,2,22/*,"http://www.yashinquesada.com/images/small-heredia.jpg"*/));
		posiciones.add(new PosicionEquipo("Limon",9,1,16/*,"http://www.yashinquesada.com/images/small-limon.jpg"*/));
		
		return posiciones;
	}

	@Override
	public List<Partido> getProxJornada() {

		List <Partido> partidos = new ArrayList<Partido>();
		
		partidos.add(new Partido("Liga","Saprissa",0,0,null));
		partidos.add(new Partido("Heredia","Limon",0,0,null));
		
		return partidos;
	}

	@Override
	public List<Partido> getJornadaAnterior() {
		List <Partido> partidos = new ArrayList<Partido>();
		
		partidos.add(new Partido("Liga","Heredia",4,2, new Estadisticas(10,6,13,11,3,3,0,0,48,52)));
		partidos.add(new Partido("Saprissa","Limon",1,1, new Estadisticas(7,6,20,13,4,2,0,0,55,45)));
		
		return partidos;
	}

	@Override
	public List<Goleador> getGoleadores() {
		List<Goleador> goleadores = new ArrayList<Goleador>();
		
		goleadores.add(new Goleador("Cristhian Lagos",13));
		goleadores.add(new Goleador("Henry Cooper",9));
		goleadores.add(new Goleador("Brunet Hay",8));
		
		return goleadores;
	}
}

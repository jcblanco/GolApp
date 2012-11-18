package cr.ac.ucr.ecci.golapp.service;

import java.util.List;

import cr.ac.ucr.ecci.golapp.bo.Partido;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;

public abstract class GolService {
	public abstract List<PosicionEquipo> getPosiciones();
	public abstract List<Partido> getProxJornada();
	public abstract List<Partido> getJornadaAnterior();
}

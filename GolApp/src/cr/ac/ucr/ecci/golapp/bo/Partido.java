package cr.ac.ucr.ecci.golapp.bo;

import java.io.Serializable;

public class Partido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipo1;
	private String equipo2;
	private int goles1;
	private int goles2;
	private Estadisticas estadisticas;
	
	public Partido(String equipo1, String equipo2, int goles1, int goles2, Estadisticas estadisticas){
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.goles1 = goles1;
		this.goles2 = goles2;
		this.estadisticas = estadisticas;
	}
	
	public String getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}
	public String getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGoles1() {
		return goles1;
	}
	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}
	public int getGoles2() {
		return goles2;
	}
	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(Estadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}
}

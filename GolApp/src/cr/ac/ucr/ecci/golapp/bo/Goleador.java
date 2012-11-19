package cr.ac.ucr.ecci.golapp.bo;

public class Goleador {
	private String jugador;
	private int goles;
	
	public Goleador(String jugador, int goles){
		this.jugador = jugador;
		this.goles = goles;		
	}
	
	public String getJugador() {
		return jugador;
	}
	
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	public int getGoles() {
		return goles;
	}
	
	public void setGoles(int goles) {
		this.goles = goles;
	}
}

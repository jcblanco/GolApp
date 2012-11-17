package cr.ac.ucr.ecci.golapp.bo;

public class PosicionEquipo {
	private String nombreEquipo;
	private int partidosJugados;
    private int golDiferencia;
    private int puntosObtenidos;
    
    public PosicionEquipo(String nombreEquipo, int partidosJugados, int golDiferencia,
    int puntosObtenidos){
    	this.nombreEquipo = nombreEquipo;
    	this.partidosJugados = partidosJugados;
        this.golDiferencia = golDiferencia;
        this.puntosObtenidos = puntosObtenidos;
    }
    
    public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public int getGolDiferencia() {
		return golDiferencia;
	}
	public void setGolDiferencia(int golDiferencia) {
		this.golDiferencia = golDiferencia;
	}
	public int getPuntosObtenidos() {
		return puntosObtenidos;
	}
	public void setPuntosObtenidos(int puntosObtenidos) {
		this.puntosObtenidos = puntosObtenidos;
	}
}

package cr.ac.ucr.ecci.golapp.bo;

import java.io.Serializable;

public class Estadisticas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tiros1;
	private int tiros2;
	private int faltas1;
	private int faltas2;
	private int tarjetasAmarillas1;
	private int tarjetasAmarillas2;
	private int tarjetasRojas1;
	private int tarjetasRojas2;
	private int posesion1;
	private int posesion2;
	
	public Estadisticas(int tiros1, int tiros2, int faltas1, int faltas2,
			int tarjetasAmarillas1, int tarjetasAmarillas2, int tarjetasRojas1,
			int tarjetasRojas2, int posesion1, int posesion2) {
		super();
		this.tiros1 = tiros1;
		this.tiros2 = tiros2;
		this.faltas1 = faltas1;
		this.faltas2 = faltas2;
		this.tarjetasAmarillas1 = tarjetasAmarillas1;
		this.tarjetasAmarillas2 = tarjetasAmarillas2;
		this.tarjetasRojas1 = tarjetasRojas1;
		this.tarjetasRojas2 = tarjetasRojas2;
		this.posesion1 = posesion1;
		this.posesion2 = posesion2;
	}
	public int getTiros1() {
		return tiros1;
	}
	public void setTiros1(int tiros1) {
		this.tiros1 = tiros1;
	}
	public int getTiros2() {
		return tiros2;
	}
	public void setTiros2(int tiros2) {
		this.tiros2 = tiros2;
	}
	public int getFaltas1() {
		return faltas1;
	}
	public void setFaltas1(int faltas1) {
		this.faltas1 = faltas1;
	}
	public int getFaltas2() {
		return faltas2;
	}
	public void setFaltas2(int faltas2) {
		this.faltas2 = faltas2;
	}
	public int getTarjetasAmarillas1() {
		return tarjetasAmarillas1;
	}
	public void setTarjetasAmarillas1(int tarjetasAmarillas1) {
		this.tarjetasAmarillas1 = tarjetasAmarillas1;
	}
	public int getTarjetasAmarillas2() {
		return tarjetasAmarillas2;
	}
	public void setTarjetasAmarillas2(int tarjetasAmarillas2) {
		this.tarjetasAmarillas2 = tarjetasAmarillas2;
	}
	public int getTarjetasRojas1() {
		return tarjetasRojas1;
	}
	public void setTarjetasRojas1(int tarjetasRojas1) {
		this.tarjetasRojas1 = tarjetasRojas1;
	}
	public int getTarjetasRojas2() {
		return tarjetasRojas2;
	}
	public void setTarjetasRojas2(int tarjetasRojas2) {
		this.tarjetasRojas2 = tarjetasRojas2;
	}
	public int getPosesion1() {
		return posesion1;
	}
	public void setPosesion1(int posesion1) {
		this.posesion1 = posesion1;
	}
	public int getPosesion2() {
		return posesion2;
	}
	public void setPosesion2(int posesion2) {
		this.posesion2 = posesion2;
	}
	
	
}

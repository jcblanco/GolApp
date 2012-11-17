package cr.ac.ucr.ecci.golapp.service;

public class GolServiceFactory {
	static GolService service= new InMemoryGolService();
	
	public static GolService getService(int i){
		GolService servicio= null;
		if(i==1)
			servicio = service;
		
		return servicio;
	}
}

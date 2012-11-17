package cr.ac.ucr.ecci.golapp.service;

public class GolServiceFactory {

		public static GolService getService(int i){
		GolService servicio= null;
		if(i==1)
			servicio = new InMemoryGolService();
		if(i==2)
			servicio= new GolWebService();
			
		return servicio;
	}
}

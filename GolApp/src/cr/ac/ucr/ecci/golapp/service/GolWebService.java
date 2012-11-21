package cr.ac.ucr.ecci.golapp.service;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cr.ac.ucr.ecci.golapp.bo.Goleador;
import cr.ac.ucr.ecci.golapp.bo.Partido;
import cr.ac.ucr.ecci.golapp.bo.PosicionEquipo;

public class GolWebService extends GolService {

	private static final String NAMESPACE = "http://golapp.somee.com/";
	private static String URL = "http://golapp.somee.com/Service1.asmx";
	private static final String METHOD_NAME = "ObtenerTablaPosiciones";
	private static final String SOAP_ACTION = "http://golapp.somee.com/ObtenerTablaPosiciones";

	// Declaracion de variables para consuymir el web service
	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	//private SoapPrimitive resultsRequestSOAP = null;
	private SoapObject  resultsRequestSOAP = null;

	// Declaracion de variables para serealziar y deserealizar
	// objetos y cadenas JSON
	Gson gson;


	@Override
	public List<PosicionEquipo> getPosiciones() {

//		Se crea un objeto SoapObject para poder realizar la peticion
//		para consumir el ws SOAP. El constructor recibe
//		el namespace. Por lo regular el namespace es el dominio
//		donde se encuentra el web service
		request = new SoapObject(NAMESPACE, METHOD_NAME);

//		Se crea un objeto SoapSerializationEnvelope para serealizar la
//		peticion SOAP y permitir viajar el mensaje por la nube
//		el constructor recibe la version de SOAP
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true; //se asigna true para el caso de que el WS sea de dotNet

		//Se envuelve la peticion soap
		envelope.setOutputSoapObject(request);

		//Objeto que representa el modelo de transporte
		//Recibe la URL del ws
		HttpTransportSE transporte = new HttpTransportSE(URL);

		try {
			//Hace la llamada al ws
			transporte.call(SOAP_ACTION, envelope);

			//Se crea un objeto SoapPrimitive y se obtiene la respuesta
			//de la peticion
			resultsRequestSOAP = (SoapObject)envelope.getResponse();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Almacenamos el resultado en un String ya que lo que represa
		//el ws es una cadena json, representando una lista AndroidOS
		//de objetos del tipo
		String  strJSON = resultsRequestSOAP.toString();

		List<PosicionEquipo> posiciones = crearLista(parseToJSON(strJSON));

		return posiciones;
	}
	
	private String parseToJSON(String strJSON) {
        strJSON = strJSON.replace(";", ",").replace("PosicionEquipo=anyType", "").replace("=", ":").replace(" ", "").replace(",}", "}").replace("anyType", "");
        strJSON = strJSON.replaceAll("([a-zA-Záéíóú]+)", "\"$1\"");
        
        strJSON = strJSON.substring(1, strJSON.length()-1);
        strJSON = "[" + strJSON + "]";
        
        return strJSON;
}
	
    /**
     * Metodo que recibe una cadena JSON y la convierte en una lista
     * de objetos AndroidOS para despues cargarlos en la lista
     * @param strJson (String) Cadena JSON
     */
    private ArrayList<PosicionEquipo> crearLista(String strJson){
		//se crea el objeto que ayuda deserealizar la cadena JSON
		gson = new Gson();

		//Obtenemos el tipo de un ArrayList<PosicionEquipo>
		Type lstT = new TypeToken< ArrayList<PosicionEquipo>>(){}.getType();

		//Creamos una objeto ArrayList<PosicionEquipo> 
		ArrayList<PosicionEquipo> arrListPosiciones = new ArrayList<PosicionEquipo>();

		//Deserealizamos la cadena JSON para que se convertida a un ArrayList<AndroidOS>
		arrListPosiciones = gson.fromJson(strJson, lstT);

		return arrListPosiciones;
	}

	@Override
	public List<Partido> getProxJornada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Partido> getJornadaAnterior() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goleador> getGoleadores() {
		// TODO Auto-generated method stub
		return null;
	}

}
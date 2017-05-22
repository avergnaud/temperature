package sparkjava;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cron.PriseDeTemperature;
import dao.TemperatureDAO;
import model.Temperature;
import spark.Request;
import spark.Response;

public class Route {

	public static List<Temperature> handleGetTemperatures(Request request, Response response) {

		List<Temperature> temperatures = TemperatureDAO.INSTANCE.readAll();
		
		Collections.sort(temperatures, Comparator.comparing(Temperature::getTs));
		
		return temperatures;
	}
	
	public static String handleGetActuelle(Request request, Response response) {
		Temperature actuelle = PriseDeTemperature.actuelle();
		return actuelle.getValeur() + "°C - " + actuelle.getTs().toString();
	}
}
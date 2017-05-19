package sparkjava;

import java.util.List;

import dao.TemperatureDAO;
import model.Temperature;
import spark.Request;
import spark.Response;

public class Route {

	public static List<Temperature> handleGetTemperatures(Request request, Response response) {
		return TemperatureDAO.INSTANCE.readAll();
	}
}
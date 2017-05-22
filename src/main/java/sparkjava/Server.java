package sparkjava;

import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cron.ToutesLesMinutes;

import static spark.Spark.staticFileLocation;
import static spark.Spark.port;

/**
 * 
 * @author
 *
 */
public class Server {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		staticFileLocation("/public");
		
		port(5678);
		
		ToutesLesMinutes.INSTANCE.start();

		// http://localhost:4567/getTemperatures
		get("/getTemperatures", Route::handleGetTemperatures, gson::toJson);

		get("/actuelle", Route::handleGetActuelle);
		
		// http://localhost:4567/hello
		get("/hello", (req, res) -> "Hello World");
	}

}
package sparkjava;

import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static spark.Spark.staticFileLocation;
import static spark.Spark.port;

public class Server {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		staticFileLocation("/public");
		
		port(5678);

		// http://localhost:4567/getByName/adrien
		get("/getTemperature", Route::handleGetTemperature, gson::toJson);

		// http://localhost:4567/hello
		get("/hello", (req, res) -> "Hello World");
	}

}
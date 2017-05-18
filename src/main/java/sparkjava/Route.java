package sparkjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import spark.Request;
import spark.Response;

public class Route {

	public static String handleGetTemperature(Request request, Response response) {
		String content = "...";
		try {
			content = new String(Files.readAllBytes(Paths.get("/home/ubuntu/free")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
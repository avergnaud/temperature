package sparkjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spark.Request;
import spark.Response;

public class Route {
	
	public static void main(String[] args) {
		String in = "4e 01 4b 46 7f ff 0c 10 05 : crc\u003d05 YES\n4e 01 4b 46 7f ff 0c 10 05 t\u003d20875\n";
		System.out.println(in);
	}
	
	private static int extractFromFile(String fileContent) {
		Pattern p = Pattern.compile("a.*") ;  
		Matcher m = p.matcher(fileContent) ; 
		String s = "";
		if(m.find()) {
			s = m.group();
		}
		return Integer.parseInt(s) / 100;
	}

	public static String handleGetTemperature(Request request, Response response) {
		String content = "...";
		try {
			List<String> liste = Files.readAllLines(Paths.get("/sys/bus/w1/devices/28-051692238bff/w1_slave"));
			content = liste.get(1);
			/*
			 * "c2 01 4b 46 7f ff 0c 10 a8 : crc\u003da8 YES\nc2 01 4b 46 7f ff 0c 10 a8 t\u003d28125\n"
			 * */
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
package cron;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Temperature;

/**
 * 62 01 4b 46 7f ff 0c 10 92 : crc=92 YES 62 01 4b 46 7f ff 0c 10 92 t=19125
 */
public class PriseDeTemperature {
	static Pattern p = Pattern.compile("(\\d+)(?!.*\\d)$");

	public static Temperature actuelle() {

		Temperature retour = new Temperature();

		try {
			 List<String> liste = Files.readAllLines(Paths.get("/home/ubuntu/tmp"));
//			List<String> liste = Files.readAllLines(Paths.get("/sys/bus/w1/devices/28-051692238bff/w1_slave"));
			String l2 = liste.get(1);
			Matcher m = p.matcher(l2);
			if (m.find()) {
				int valeur = Integer.parseInt(m.group()) / 1000;
				retour = new Temperature(LocalDateTime.now(ZoneId.of("Europe/Paris")), valeur);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return retour;
	}

}

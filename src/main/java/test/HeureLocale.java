package test;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class HeureLocale {

	public static void main(String[] args) {
		System.out.println(getLocalDateTime());
		System.out.println(getZonedDateTime());
	}
	
	public static String getLocalDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		return ldt.toString();
	}
	
	public static String getZonedDateTime() {
//		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Paris"));
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		return ldt.toString();
	}

}

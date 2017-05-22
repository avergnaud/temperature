package cron;

import dao.TemperatureDAO;
import model.Temperature;

/**
 * Runnable qui insere la temperature actuelle en base
 */
public class PriseDeTemperatureCommand implements Runnable {
	
	@Override
	public void run() {
		
		Temperature temperature = PriseDeTemperature.actuelle();
		TemperatureDAO.INSTANCE.create(temperature);
	}
}

package cron;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * CRON
 */
public enum ToutesLesMinutes {

	INSTANCE;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public void start() {
		/* toutes les 10 minutes en fait */
		scheduler.scheduleAtFixedRate(new PriseDeTemperatureCommand(), 0, 10, TimeUnit.MINUTES);
	}

}
